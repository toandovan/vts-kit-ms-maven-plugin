package com.atviettelsolutions.plugin.mojo;

import com.atviettelsolutions.plugin.help.WriteFileToTemp;
import com.atviettelsolutions.plugin.help.antlr.JDLLexer;
import com.atviettelsolutions.plugin.help.antlr.JDLParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
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

@Mojo(name = "entityV2")
public class EntityV2 extends AbstractMojo {
    @Parameter(defaultValue="${project}", required=true)
    private MavenProject project;
    @Parameter( defaultValue = "${project.basedir}", readonly = true )
    private File baseDir;
    @Parameter( defaultValue = "${project.groupId}", readonly = true )
    private String groupId;

    String classPathResourceDTO = "template/DTO.java.vm";
    String classPathResourceEntity = "template/Entity.java.vm";
    private VelocityEngine velocityEngine;
    public EntityV2() {
        this.velocityEngine=new VelocityEngine();
        velocityEngine.setProperty("file.resource.loader.path", "");
        velocityEngine.init();
    }
    public JDLParser.ProgramContext handleInput(String path) throws IOException {
        JDLLexer jdlLexer = new JDLLexer(CharStreams.fromPath(Paths.get(path)));
        CommonTokenStream commonTokenStream=new CommonTokenStream(jdlLexer);
        JDLParser jdlParser=new JDLParser(commonTokenStream);
        return jdlParser.program();
    }
    public void writeCodeToFile(String code, String path) throws IOException {
        FileOutputStream outStream = new FileOutputStream(path);
        byte[] strToBytes = code.getBytes();
        outStream.write(strToBytes);
    }
    public Template loadTemplate(String classPathResource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream(classPathResource);
        WriteFileToTemp toTemp =new WriteFileToTemp();
        File tempFile=toTemp.write(inputStream);
        return velocityEngine.getTemplate(tempFile.getPath());
    }
    public CompilationUnit loadCompilationUnit(String sourcePath, String classPathResource,VelocityContext data) throws IOException {
        Path path = Paths.get(sourcePath);
        CompilationUnit cu = null;
        String code="";
        if(!Files.exists(path)){
            FileInputStream fileInputStream= new FileInputStream(sourcePath);
            cu = parse(fileInputStream);
        }else{
            Template t=loadTemplate(classPathResource);
            StringWriter writer = new StringWriter();
            t.merge( data, writer );
            code = writer.toString();
            cu= parse(code);
        }
        return cu;
    }
    public void handleDTO(List<JDLParser.Dto_declarationContext> dto, String groupId){
        dto.stream().forEach(dtoEle->{
            List<JDLParser.Dto_fieldContext> fieldList = dtoEle.dto_list().dto_field();
            List<FieldDeclaration> fieldDeclarations = new LinkedList<>();
            String dtoName=dtoEle.dto_list().ID().getText();
            String outPutPath=baseDir.toString().concat("/src/main/java/"+groupId.replace(".","/")+"/dto/"+dtoName+".java");
            try {
                VelocityContext context=new VelocityContext();
                context.put("package", groupId);
                context.put("dtoName", dtoName);
                CompilationUnit compilationUnit=loadCompilationUnit(outPutPath,classPathResourceDTO,context );
                //get field list
                for (int i = 0; i < fieldList.size(); i++) {
                    String name = fieldList.get(i).ID().getText();
                    String type = fieldList.get(i).type().getText();
                    String require = fieldList.get(i).REQUIRE() == null ? "" : fieldList.get(i).REQUIRE().getText();
                    FieldDeclaration fieldDeclaration =
                            new FieldDeclaration()
                                    .addVariable(new VariableDeclarator(new ClassOrInterfaceType(type), name));
                    if ("require".equals(require)) {
                        if ("String".equals(type)) {
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
                    fieldDeclarations.add(fieldDeclaration);
                }
                CompilationUnit code=createDTO(dtoName, compilationUnit, fieldDeclarations);
                writeCodeToFile(code.toString(),outPutPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
    }

    public void handleEntity(List<JDLParser.Entity_declarationContext> entity, String groupId){
        entity.stream().forEach(ele->{
            String entity_name = ele.ID().getText();
            List<JDLParser.Entity_fieldContext> fieldList=ele.entity_body()!= null?ele.entity_body().entity_field(): new LinkedList<>();
            String entityPath=baseDir.toString().concat("/src/main/java/"+groupId.replace(".","/")+"/domain/"+entity_name+".java");
            VelocityContext context=new VelocityContext();
            context.put("package", groupId);
            context.put("entityName", entity_name);
            try {
                CompilationUnit compilationUnit=loadCompilationUnit(entityPath,classPathResourceEntity,context);
                CompilationUnit code=createEntity(entity_name, compilationUnit, fieldList);
                writeCodeToFile(code.toString(),entityPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public CompilationUnit createEntity(String name, CompilationUnit cu, List<JDLParser.Entity_fieldContext> fieldList) throws IOException {
        Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(name);
        ClassOrInterfaceDeclaration AST=classAST.get();
        fieldList.forEach(e->{
            String fieldType=e.type().getText();
            String fieldName=e.ID().getText();
            List<JDLParser.Entity_validateContext> entity_validateContexts=e.entity_validate();
            if(!AST.getFieldByName(fieldName).isPresent()){
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

    public void handleService(){

    }
    public void handleRepository(){

    }
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            String path=project.getBasedir()+"/.vtskit/configuration/vts.VDL";
            JDLParser.ProgramContext programContext=handleInput(path);
            List<JDLParser.Dto_declarationContext> dto=programContext.dto_declaration();
            List<JDLParser.Entity_declarationContext> entity=programContext.entity_declaration();
            List<JDLParser.RelationshipContext> relationship=programContext.relationship();
            handleDTO(dto,groupId);

        } catch (IOException e) {
            getLog().info(e);
        }
    }
}
