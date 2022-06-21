package com.atviettelsolutions.plugin.mojo;

import com.atviettelsolutions.plugin.help.WriteFileToTemp;
import com.atviettelsolutions.plugin.help.antlr.JDLLexer;
import com.atviettelsolutions.plugin.help.antlr.JDLParser;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.github.javaparser.StaticJavaParser.parse;


@Mojo(name = "Parser")
public class TestParser extends AbstractMojo {
    /**
     * @parameter default-value="${project}"
     * @required
     */
    @Parameter(defaultValue="${project}", required=true)
    private MavenProject project;

    @Parameter( defaultValue = "${project.basedir}", readonly = true )
    private File baseDir;

    @Parameter( defaultValue = "${project.groupId}", readonly = true )
    private String groupId;

    private String packed;
    private VelocityEngine velocityEngine;
    String classPathResourceDTO = "template/DTO.java.vm";
    String classPathResourceEntity = "template/Entity.java.vm";

    String classPathResourceRepository = "template/Repository.java.vm";

    public TestParser() {
        this.velocityEngine=new VelocityEngine();
        velocityEngine.setProperty("file.resource.loader.path", "");
        velocityEngine.init();
    }

    public CompilationUnit createDTO(String dtoName,CompilationUnit cu,List<FieldDeclaration> field) throws IOException {

        Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(dtoName);
        ClassOrInterfaceDeclaration AST=classAST.get();
        field.forEach(e->{
            String fileName=e.getVariables().get(0).getName().toString();
            if(!(AST.getFieldByName(fileName).isPresent())){
                AST.getMembers().add(e);
            }
        });
        return cu;
//        writeCodeToFile(cu.toString(),dtoPath);
    }
    public Template template(String classPathResource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream(classPathResource);
        WriteFileToTemp toTemp =new WriteFileToTemp();
        File tempFile=toTemp.write(inputStream);
        return velocityEngine.getTemplate(tempFile.getPath());
    }

    public void writeCodeToFile(String code, String path) throws IOException {
        FileOutputStream outStream = new FileOutputStream(path);
        byte[] strToBytes = code.getBytes();
        outStream.write(strToBytes);
    }

    public VelocityContext setContext(VelocityContext context,String type, List<String> data){
        switch (type){
            case "DTO":
                context.put("package", groupId);
                context.put("dtoName", data.get(0));
            case "ENTITY":
                context.put("package", groupId);
                context.put("entityName", data.get(0));
        }
        return context;
    }
    public Template loadTemplate(String type) throws IOException {
        Template t=null;
        switch (type){
            case "DTO":
                t=template(classPathResourceDTO);
            case "ENTITY":
                t=template(classPathResourceEntity);
        }
        return t;
    }
    public CompilationUnit loadCompilationUnit(String sourcePath, String type, List<String> data) throws IOException {
        Path path = Paths.get(sourcePath);
        CompilationUnit cu = null;
        String code="";
        if(!Files.exists(path)){
            VelocityContext context=setContext(new VelocityContext(), type, data);
            Template t=loadTemplate(type);
            StringWriter writer = new StringWriter();
            t.merge( context, writer );
            code = writer.toString();
            cu= parse(code);
        }else {
            FileInputStream fileInputStream= new FileInputStream(sourcePath);
            cu = parse(fileInputStream);
        }
        return cu;
    }
    public void createDTOs(List<JDLParser.Dto_declarationContext> dto) throws IOException {
        for (int i = 0; i < dto.size(); i++) {
            List<JDLParser.Dto_fieldContext> fieldList = dto.get(i).dto_list().dto_field();
            List<FieldDeclaration> list = new LinkedList<>();
            String dtoName = dto.get(i).dto_list().ID().getText();
            String dtoPath=baseDir.toString().concat("/src/main/java/"+packed+"/dto/"+dtoName+".java");
            List<String> data=new LinkedList<>();
            data.add(dtoName);
            CompilationUnit compilationUnit=loadCompilationUnit(dtoPath, "DTO", data);
            for (int j = 0; j < fieldList.size(); j++) {
                String name = fieldList.get(i).ID().getText();
                String type = fieldList.get(i).type().getText();
                String require = fieldList.get(i).REQUIRE() == null ? "" : fieldList.get(i).REQUIRE().getText();
                FieldDeclaration fieldDeclaration =
                        new FieldDeclaration()
                                .addVariable(new VariableDeclarator(new ClassOrInterfaceType(type), name));
                if (require.equals("require")) {
                    if (type.equals("String")) {
                        NormalAnnotationExpr normalAnnotationExpr = new NormalAnnotationExpr();
                        normalAnnotationExpr.setName("NotEmpty");
                        normalAnnotationExpr.addPair("message", "\"" + name + " must not empty" + "\"");
                        fieldDeclaration.addAnnotation(normalAnnotationExpr);
                        compilationUnit.addImport("javax.validation.constraints.NotEmpty");
                    } else {
                        fieldDeclaration.addAnnotation("NotNull");
                        compilationUnit.addImport("javax.validation.constraints.NotNull");
                    }
                }
                list.add(fieldDeclaration);
            }
            CompilationUnit code=createDTO(dtoName, compilationUnit, list);
            writeCodeToFile(code.toString(),dtoPath);
        }
    }

    public void createEntitys(List<JDLParser.Entity_declarationContext> entity) throws IOException {
        for (int i = 0; i < entity.size(); i++) {
            JDLParser.Entity_declarationContext ele=entity.get(i);
            String entity_name = ele.ID().getText();
            List<JDLParser.Entity_fieldContext> fieldList=ele.entity_body()!= null?ele.entity_body().entity_field(): new LinkedList<>();
            String entityPath=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+entity_name+".java");
            List<String> data=new LinkedList<>();
            data.add(entity_name);
            CompilationUnit compilationUnit=loadCompilationUnit(entityPath,"ENTITY", data);
            CompilationUnit code=createEntity(entity_name, compilationUnit, fieldList);
            writeCodeToFile(code.toString(),entityPath);
            createRepository(entity_name);
        }
    }

    public CompilationUnit createEntity(String name, CompilationUnit cu, List<JDLParser.Entity_fieldContext> fieldList) throws IOException {
        Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(name);
        ClassOrInterfaceDeclaration AST=classAST.get();
        fieldList.forEach(e->{
            String fieldType=e.type().getText();
            String fieldName=e.ID().getText();
            List<JDLParser.Entity_validateContext> entity_validateContexts=e.entity_validate();
            if(!(AST.getFieldByName(fieldName).isPresent())){
                FieldDeclaration fieldDeclaration=new FieldDeclaration()
                        .addVariable(new VariableDeclarator(new ClassOrInterfaceType(fieldType), fieldName));
                for (int i = 0; i < entity_validateContexts.size(); i++) {
                    switch (entity_validateContexts.get(i).getText()){
                        case "require":
                            fieldDeclaration.addAnnotation("NotNull");
                            cu.addImport("javax.validation.constraints.NotNull");
                    }
                }
                AST.getMembers().add(fieldDeclaration);
            }
        });
        return cu;
    }

    public void createOneToOneRelationship(JDLParser.RelationshipContext relationshipContext) throws IOException {
        List<JDLParser.Relationsip_listContext> relationship_list=relationshipContext.relationsip_list();
        for (int i = 0; i < relationship_list.size(); i++) {
            String tableFrom=relationship_list.get(i).relation_ele(0).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyFrom=relationship_list.get(i).relation_ele(0).relation_ele_body();
            String relationNameFrom=relation_ele_bodyFrom!=null?
                    relation_ele_bodyFrom.ID().getText(): StringUtils.uncapitalize(tableFrom);
            String requireFrom=relation_ele_bodyFrom!=null && relation_ele_bodyFrom.REQUIRE()!=null?
                    relation_ele_bodyFrom.REQUIRE().getText(): null;
            String tableTo=relationship_list.get(i).relation_ele(1).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyTo=relationship_list.get(i).relation_ele(1).relation_ele_body();
            String relationNameTo=relation_ele_bodyTo!=null?
                    relation_ele_bodyTo.ID().getText(): StringUtils.uncapitalize(tableTo);
            String requireTo=relation_ele_bodyTo!=null && relation_ele_bodyTo.REQUIRE()!=null?
                    relation_ele_bodyTo.REQUIRE().getText(): null;
            //create From
            String pathTableFrom=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableFrom+".java");
            CompilationUnit cu=loadCompilationUnit(pathTableFrom, null, null);
            if(cu!=null){
                Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(tableFrom);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameFrom).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType(tableTo),relationNameTo));
                    if(requireTo!=null){
                        NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                        normalAnnotationExpr.setName("OneToOne");
                        normalAnnotationExpr.addPair("optional", String.valueOf(false));
                        fieldDeclaration.addAnnotation(normalAnnotationExpr);
                    }
                    AST.getMembers().add(fieldDeclaration);
                    cu.addImport("javax.persistence.OneToOne");
                }
            }
            writeCodeToFile(cu.toString(),pathTableFrom);
            //create To
            String pathTableTo=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableTo+".java");
            CompilationUnit cu1 = loadCompilationUnit(pathTableTo, null, null);
            if(cu1!=null){
                Optional<ClassOrInterfaceDeclaration> classAST=cu1.getClassByName(tableTo);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameTo).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType(tableFrom),relationNameFrom));
                    if(requireFrom!=null){
                        NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                        normalAnnotationExpr.setName("OneToOne");
                        normalAnnotationExpr.addPair("optional", String.valueOf(false));
                        fieldDeclaration.addAnnotation(normalAnnotationExpr);
                    }
                    AST.getMembers().add(fieldDeclaration);
                    cu1.addImport("javax.persistence.OneToOne");
                }
            }
            writeCodeToFile(cu1.toString(),pathTableTo);
        }
    }
    public void createOneToManyRelationship(JDLParser.RelationshipContext relationshipContext) throws IOException {
        List<JDLParser.Relationsip_listContext> relationship_list=relationshipContext.relationsip_list();
        JDLParser.Relation_typeContext relation_type=relationshipContext.relation_type();
        for (int i = 0; i < relationship_list.size(); i++) {
            String tableFrom = relationship_list.get(i).relation_ele(0).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyFrom = relationship_list.get(i).relation_ele(0).relation_ele_body();
            String relationNameFrom = relation_ele_bodyFrom != null ?
                    relation_ele_bodyFrom.ID().getText() : StringUtils.uncapitalize(tableFrom);
            String requireFrom = relation_ele_bodyFrom != null && relation_ele_bodyFrom.REQUIRE() != null ?
                    relation_ele_bodyFrom.REQUIRE().getText() : null;
            String tableTo = relationship_list.get(i).relation_ele(1).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyTo = relationship_list.get(i).relation_ele(1).relation_ele_body();
            String relationNameTo = relation_ele_bodyTo != null ?
                    relation_ele_bodyTo.ID().getText() : StringUtils.uncapitalize(tableTo);
            String requireTo = relation_ele_bodyTo != null && relation_ele_bodyTo.REQUIRE() != null ?
                    relation_ele_bodyTo.REQUIRE().getText() : null;

            String pathTableFrom=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableFrom+".java");
            Path path = Paths.get(pathTableFrom);
            CompilationUnit cu = null;
            String code="";
            if(Files.exists(path)){
                FileInputStream fileInputStream= new FileInputStream(pathTableFrom);
                cu = parse(fileInputStream);
                Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(tableFrom);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameFrom).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType("Set<"+tableTo+">"),relationNameTo));
                    NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                    normalAnnotationExpr.setName("OneToMany");
                    normalAnnotationExpr.addPair("mappedBy", "\""+relationNameFrom+"\"");
                    if(requireTo!=null){
                        normalAnnotationExpr.addPair("optional", String.valueOf(false));
                    }
                    fieldDeclaration.addAnnotation(normalAnnotationExpr);
                    AST.getMembers().add(fieldDeclaration);
                    cu.addImport("javax.persistence.OneToMany");
                }
            }
            code=cu.toString();
            writeCodeToFile(code,pathTableFrom);
            //create To
            String pathTableTo=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableTo+".java");
            Path pathTo = Paths.get(pathTableTo);
            CompilationUnit cu1 = null;
            String code1="";
            if(Files.exists(pathTo)){
                FileInputStream fileInputStream= new FileInputStream(pathTableTo);
                cu1 = parse(fileInputStream);
                Optional<ClassOrInterfaceDeclaration> classAST=cu1.getClassByName(tableTo);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameTo).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType(tableFrom),relationNameFrom));
                    NormalAnnotationExpr manyToOne=new NormalAnnotationExpr();
                    manyToOne.setName("ManyToOne");
                    if(requireFrom!=null){
                        manyToOne.addPair("optional", String.valueOf(false));
                    }
                    fieldDeclaration.addAnnotation(manyToOne);
                    NormalAnnotationExpr joinColumn=new NormalAnnotationExpr();
                    joinColumn.setName("JoinColumn");
                    joinColumn.addPair("name", "\""+StringUtils.uncapitalize(tableFrom)+"_id"+ "\"");
                    fieldDeclaration.addAnnotation(joinColumn);
                    AST.getMembers().add(fieldDeclaration);
                    cu1.addImport("javax.persistence.ManyToOne");
                }
            }
            code1=cu1.toString();
            writeCodeToFile(code1,pathTableTo);
        }
    }
    public void createManyToOneRelationship(JDLParser.RelationshipContext relationshipContext){

    }
    public void createManyToManyRelationship(JDLParser.RelationshipContext relationshipContext) throws IOException {
        List<JDLParser.Relationsip_listContext> relationship_list=relationshipContext.relationsip_list();
        JDLParser.Relation_typeContext relation_type=relationshipContext.relation_type();
        for (int i = 0; i < relationship_list.size(); i++) {
            String tableFrom = relationship_list.get(i).relation_ele(0).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyFrom = relationship_list.get(i).relation_ele(0).relation_ele_body();
            String relationNameFrom = relation_ele_bodyFrom != null ?
                    relation_ele_bodyFrom.ID().getText() : StringUtils.uncapitalize(tableFrom);
            String requireFrom = relation_ele_bodyFrom != null && relation_ele_bodyFrom.REQUIRE() != null ?
                    relation_ele_bodyFrom.REQUIRE().getText() : null;
            String tableTo = relationship_list.get(i).relation_ele(1).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyTo = relationship_list.get(i).relation_ele(1).relation_ele_body();
            String relationNameTo = relation_ele_bodyTo != null ?
                    relation_ele_bodyTo.ID().getText() : StringUtils.uncapitalize(tableTo);
            String requireTo = relation_ele_bodyTo != null && relation_ele_bodyTo.REQUIRE() != null ?
                    relation_ele_bodyTo.REQUIRE().getText() : null;

            String pathTableFrom=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableFrom+".java");
            Path path = Paths.get(pathTableFrom);
            CompilationUnit cu = null;
            String code="";
            if(Files.exists(path)){
                FileInputStream fileInputStream= new FileInputStream(pathTableFrom);
                cu = parse(fileInputStream);
                Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(tableFrom);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameFrom).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType("Set<"+tableTo+">"),relationNameTo));
                    NormalAnnotationExpr manyToMany=new NormalAnnotationExpr();
                    manyToMany.setName("ManyToMany");
                    if(requireTo!=null){
                        manyToMany.addPair("optional", String.valueOf(false));
                    }
                    fieldDeclaration.addAnnotation(manyToMany);
                    NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                    normalAnnotationExpr.setName("JoinTable");
                    normalAnnotationExpr.addPair("joinColumns"," @JoinColumn(name = \""+StringUtils.uncapitalize(tableFrom)+"_id" +"\")");
                    normalAnnotationExpr.addPair("inverseJoinColumns", " @JoinColumn(name = \""+StringUtils.uncapitalize(tableTo)+"_id"  +"\")");
                    fieldDeclaration.addAnnotation(normalAnnotationExpr);
                    AST.getMembers().add(fieldDeclaration);
                    cu.addImport("javax.persistence.ManyToMany");
                    cu.addImport("javax.persistence.JoinTable");
                    cu.addImport("javax.persistence.JoinColumn");
                    cu.addImport("java.util.Set");
                }
            }
            code=cu.toString();
            writeCodeToFile(code,pathTableFrom);
            //create To
            String pathTableTo=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableTo+".java");
            Path pathTo = Paths.get(pathTableTo);
            CompilationUnit cu1 = null;
            String code1="";
            if(Files.exists(pathTo)){
                FileInputStream fileInputStream= new FileInputStream(pathTableTo);
                cu1 = parse(fileInputStream);
                Optional<ClassOrInterfaceDeclaration> classAST=cu1.getClassByName(tableTo);
                ClassOrInterfaceDeclaration AST=classAST.get();
                if(!AST.getFieldByName(relationNameTo).isPresent()){
                    FieldDeclaration fieldDeclaration=new FieldDeclaration();
                    fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType("Set<"+tableFrom+">"),relationNameFrom));
                    NormalAnnotationExpr manyToMany=new NormalAnnotationExpr();
                    manyToMany.setName("ManyToMany");
                    manyToMany.addPair("mappedBy", "\""+relationNameTo+"\"");
                    if(requireTo!=null){
                        manyToMany.addPair("optional", String.valueOf(false));
                    }
                    fieldDeclaration.addAnnotation(manyToMany);
                    AST.getMembers().add(fieldDeclaration);
                    cu1.addImport("javax.persistence.ManyToMany");
                    cu1.addImport("java.util.Set");
                }
            }
            code1=cu1.toString();
            writeCodeToFile(code1,pathTableTo);
        }
    }
    //create relationship
    public void relation(JDLParser.RelationshipContext relationshipContext, String type) throws IOException {
        List<JDLParser.Relationsip_listContext> relationship_list=relationshipContext.relationsip_list();
        JDLParser.Relation_typeContext relation_type=relationshipContext.relation_type();
        for (int i = 0; i < relationship_list.size(); i++){
            String tableFrom = relationship_list.get(i).relation_ele(0).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyFrom = relationship_list.get(i).relation_ele(0).relation_ele_body();
            String relationNameFrom = relation_ele_bodyFrom != null ?
                    relation_ele_bodyFrom.ID().getText() : StringUtils.uncapitalize(tableFrom);
            String requireFrom = relation_ele_bodyFrom != null && relation_ele_bodyFrom.REQUIRE() != null ?
                    relation_ele_bodyFrom.REQUIRE().getText() : null;
            String tableTo = relationship_list.get(i).relation_ele(1).ID().getText();
            JDLParser.Relation_ele_bodyContext relation_ele_bodyTo = relationship_list.get(i).relation_ele(1).relation_ele_body();
            String relationNameTo = relation_ele_bodyTo != null ?
                    relation_ele_bodyTo.ID().getText() : StringUtils.uncapitalize(tableTo);
            String requireTo = relation_ele_bodyTo != null && relation_ele_bodyTo.REQUIRE() != null ?
                    relation_ele_bodyTo.REQUIRE().getText() : null;
            String pathTableFrom=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableFrom+".java");
            CompilationUnit cu=loadCompilationUnit(pathTableFrom, null, null);
            switch (type){
                case "OneToOne":
                    if(cu!=null){
                        Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(tableFrom);
                        ClassOrInterfaceDeclaration AST=classAST.get();
                        if(!AST.getFieldByName(relationNameFrom).isPresent()){
                            FieldDeclaration fieldDeclaration=new FieldDeclaration();
                            fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType(tableTo),relationNameTo));
                            NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                            normalAnnotationExpr.setName("OneToOne");
                            if(requireTo!=null){
                                normalAnnotationExpr.addPair("optional", String.valueOf(false));
                                fieldDeclaration.addAnnotation(normalAnnotationExpr);
                            }
                            AST.getMembers().add(fieldDeclaration);
                            cu.addImport("javax.persistence.OneToOne");
                        }
                    }
                    writeCodeToFile(cu.toString(),pathTableFrom);

                    String pathTableTo=baseDir.toString().concat("/src/main/java/"+packed+"/domain/"+tableTo+".java");
                    CompilationUnit cu1 = loadCompilationUnit(pathTableTo, null, null);
                    if(cu1!=null){
                        Optional<ClassOrInterfaceDeclaration> classAST=cu1.getClassByName(tableTo);
                        ClassOrInterfaceDeclaration AST=classAST.get();
                        if(!AST.getFieldByName(relationNameTo).isPresent()){
                            FieldDeclaration fieldDeclaration=new FieldDeclaration();
                            fieldDeclaration.addVariable(new VariableDeclarator(new ClassOrInterfaceType(tableFrom),relationNameFrom));
                            if(requireFrom!=null){
                                NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                                normalAnnotationExpr.setName("OneToOne");
                                normalAnnotationExpr.addPair("optional", String.valueOf(false));
                                fieldDeclaration.addAnnotation(normalAnnotationExpr);
                            }
                            AST.getMembers().add(fieldDeclaration);
                            cu1.addImport("javax.persistence.OneToOne");
                        }
                    }
                    writeCodeToFile(cu1.toString(),pathTableTo);
                case "OneToMany":
                case "ManyToOne":
                case "ManyToMany":
            }
        }
    }
    public  void createRelationShip(List<JDLParser.RelationshipContext> relationship) throws IOException {
        for (int i = 0; i < relationship.size(); i++) {
            JDLParser.RelationshipContext relationshipContext=relationship.get(i);
            JDLParser.Relation_typeContext relation_type=relationshipContext.relation_type();
            for (int j = 0; j < relationshipContext.relationsip_list().size(); j++) {
                relation(relationshipContext, relation_type.getText());
            }
        }
    }

    public void createRepository(String name) throws IOException {
        String pathRepo=baseDir.toString().concat("/src/main/java/"+packed+"/repository/"+name+"Repository.java");
        Path path = Paths.get(pathRepo);
        CompilationUnit cu = null;
        String code="";
        if(!Files.exists(path)){
            Template t=template(classPathResourceRepository);
            StringWriter writer = new StringWriter();
            VelocityContext context = new VelocityContext();
            context.put("package", groupId);
            context.put("name", name);
            t.merge( context, writer );
            code = writer.toString();
        }
        writeCodeToFile(code,pathRepo);
    }

    public JDLParser.ProgramContext ParserJDL(String path) throws IOException {
        JDLLexer jdlLexer = new JDLLexer(CharStreams.fromPath(Paths.get(path)));
        CommonTokenStream commonTokenStream=new CommonTokenStream(jdlLexer);
        JDLParser jdlParser=new JDLParser(commonTokenStream);
        return jdlParser.program();
    }
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            //Read data
            packed=groupId.replace(".","/");
            String path=project.getBasedir()+"/.vtskit/configuration/vts.VDL";

            JDLParser.ProgramContext programContext=ParserJDL(path);
            List<JDLParser.Dto_declarationContext> dto=programContext.dto_declaration();
            List<JDLParser.Entity_declarationContext> entity=programContext.entity_declaration();
            List<JDLParser.RelationshipContext> relationship=programContext.relationship();

//            createDTOs(dto);
            createEntitys(entity);
            createRelationShip(relationship);

        }catch (Exception e){
            getLog().info(e);
        }
    }
}
