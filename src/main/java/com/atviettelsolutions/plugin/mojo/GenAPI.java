package com.atviettelsolutions.plugin.mojo;

import com.atviettelsolutions.plugin.help.WriteFileToTemp;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.VoidType;
import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.javaparser.StaticJavaParser.parse;

@Mojo(name = "generateNewAPI")
public class GenAPI extends AbstractMojo {
    @Parameter( defaultValue = "${project.basedir}", readonly = true )
    private File baseDir;
    @Parameter( defaultValue = "${project.groupId}", readonly = true )
    private String groupId;
    private String packed;
    private VelocityEngine velocityEngine;
    String classPathResourceDTO = "template/DTO.java.vm";
    public GenAPI() {
        this.velocityEngine=new VelocityEngine();
        velocityEngine.setProperty("file.resource.loader.path", "");
        velocityEngine.init();
    }
    public void createDTO(String dtoName, List<FieldDeclaration> field) throws IOException {
        String dtoPath=baseDir.toString().concat("/src/main/java/"+packed+"/dto/"+dtoName+".java");
        Path path = Paths.get(dtoPath);
        CompilationUnit cu = null;
        String code="";
        if(!Files.exists(path)){
            Template t=template(classPathResourceDTO);
            StringWriter writer = new StringWriter();
            VelocityContext context = new VelocityContext();
            context.put("package", groupId);
            context.put("dtoName", dtoName);
            t.merge( context, writer );
            code = writer.toString();
            cu = parse(code);
        }else {
            FileInputStream fileInputStream= new FileInputStream(dtoPath);
            cu = parse(fileInputStream);
        }
        Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(dtoName);
        ClassOrInterfaceDeclaration AST=classAST.get();
        field.forEach(e->{
            if(!AST.getMembers().contains(e)){
                AST.getMembers().add(e);
            }
        });
        code=cu.toString();
        writeCodeToFile(code,dtoPath);
    }
    public void createDTOs(JSONArray data) throws IOException {
        for (int i = 0; i < data.size(); i++){
            JSONObject jsonObject = (JSONObject) data.get(i);
            String dtoName=jsonObject.containsKey("name")?jsonObject.get("name").toString():null;
            JSONArray jsonArray=jsonObject.containsKey("field")? (JSONArray) jsonObject.get("field"):null;
            if(!(dtoName==null) && !(jsonArray ==null)){
                List<FieldDeclaration> list=new LinkedList<>();
                jsonArray.forEach(e->{
                    JSONObject field=(JSONObject) e;
                    Boolean require=field.containsKey("require")&&field.get("require").equals(true)?true:false;
                    FieldDeclaration fieldDeclaration=
                            new FieldDeclaration()
                                    .addVariable(new VariableDeclarator(new ClassOrInterfaceType(field.get("type").toString()), field.get("name").toString()));
                    if(require){
                        if(field.get("type").equals("String")){
                            NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                            normalAnnotationExpr.setName("NotEmpty");
                            normalAnnotationExpr.addPair("message","\""+field.get("name").toString()+" must not empty"+"\"");
                            fieldDeclaration.addAnnotation(normalAnnotationExpr);
                        }else {
                            fieldDeclaration.addAnnotation("NotNull");
                        }
                    }
                    list.add(fieldDeclaration);
                });
                createDTO(dtoName,list);
            }
        }
    }
    public void writeCodeToFile(String code, String path) throws IOException {
        FileOutputStream outStream = new FileOutputStream(path);
        byte[] strToBytes = code.getBytes();
        outStream.write(strToBytes);
    }
    public Template template(String classPathResource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream(classPathResource);
        WriteFileToTemp toTemp =new WriteFileToTemp();
        File tempFile=toTemp.write(inputStream);
        return velocityEngine.getTemplate(tempFile.getPath());
    }
    public void createServiceInterface(String serviceName, String functionName,NodeList parameter, String response) throws IOException {
        String servicePath=baseDir.toString().concat("/src/main/java/"+packed+"/service/"+serviceName+".java");
        Path pathService = Paths.get(servicePath);
        String code="";
        CompilationUnit cu=null;
        //case server interface exist
        if(Files.exists(pathService)){
            FileInputStream fileInputStream= new FileInputStream(servicePath);
            cu = parse(fileInputStream);
        }
        //case new
        else{
            cu=new CompilationUnit();
            cu.addInterface(serviceName);
            cu.setPackageDeclaration(groupId+".service");
        }
        Optional<ClassOrInterfaceDeclaration> classAST=cu.getInterfaceByName(serviceName);
        ClassOrInterfaceDeclaration AST=classAST.get();
        //new function
        if(AST.getMethodsByName(functionName).isEmpty()) {
            MethodDeclaration methodDeclaration = new MethodDeclaration();
            methodDeclaration.setName(functionName);
            methodDeclaration.setType(response);
            methodDeclaration.setParameters(parameter);
            methodDeclaration.removeBody();
            AST.getMembers().add(methodDeclaration);
        }
        //import
        cu.addImport(groupId+".dto.*");

        code=cu.toString();
        writeCodeToFile(code,servicePath);
    }
    public void createServiceImpl(String serviceName, String functionName, NodeList parameter, String response) throws IOException {
        String serviceImplPath=baseDir.toString().concat("/src/main/java/"+packed+"/service/impl/"+serviceName+"Impl.java");
        Path pathServiceImpl = Paths.get(serviceImplPath);
        String code="";
        CompilationUnit cu=null;
        Optional<ClassOrInterfaceDeclaration> classAST=null;
        if(Files.exists(pathServiceImpl)){
            FileInputStream fileInputStream= new FileInputStream(serviceImplPath);
            cu = parse(fileInputStream);
            classAST=cu.getClassByName(serviceName+"Impl");
        }else {
            cu=new CompilationUnit();
            cu.addClass(serviceName+"Impl");
            classAST=cu.getClassByName(serviceName+"Impl");
            cu.setPackageDeclaration(groupId+".service.impl");
            classAST.get().addImplementedType(serviceName);
            classAST.get().addAnnotation("Service");
        }
        cu.addImport("org.springframework.stereotype.Service");
        cu.addImport(groupId+".service."+serviceName);
        cu.addImport(groupId+".dto.*");
        ClassOrInterfaceDeclaration AST=classAST.get();
        if(AST.getMethodsByName(functionName).isEmpty()){
            MethodDeclaration methodDeclaration=new MethodDeclaration();
            methodDeclaration.setName(functionName);
            methodDeclaration.setType(response);
            methodDeclaration.setPublic(true);
            methodDeclaration.setParameters(parameter);
            Expression expression=new AssignExpr(new NameExpr(response+" result"),new NameExpr("new "+response+"()"),AssignExpr.Operator.ASSIGN);
            ReturnStmt node=new ReturnStmt("result");
            BlockStmt blockStmt=new BlockStmt();
            blockStmt.addStatement(expression);
            blockStmt.addStatement(node);
            methodDeclaration.setBody(blockStmt);
            methodDeclaration.addAnnotation("Override");
            AST.getMembers().add(methodDeclaration);
        }
        code=cu.toString();
        writeCodeToFile(code,serviceImplPath);
    }
    public void createService(String serviceName, String functionName, NodeList parameter, String response) throws IOException {
        createServiceInterface(serviceName, functionName, parameter, response);
        createServiceImpl(serviceName, functionName,parameter, response);
    }
    public void importHandle(CompilationUnit cu, Set<String> importDeclaration){
//        Node.BreadthFirstIterator iterator = new Node.BreadthFirstIterator(cu);
//        while (iterator.hasNext()) {
//            System.out.println("* " + iterator.next());
//            String name=iterator.next().getParsed().name();
//            ImportTool importTool=new ImportTool();
//        }
        importDeclaration.forEach(e->{
            cu.addImport(e);
        });
    }
    public void addField(ClassOrInterfaceDeclaration AST, String fieldType, Modifier.Keyword keyword){
        Modifier modifier=new Modifier(keyword);
        NodeList<Modifier> modifiers=new NodeList<>(modifier);
        String fieldName=StringUtils.uncapitalize(fieldType);
        FieldDeclaration fieldDeclaration=
                new FieldDeclaration(modifiers, new ClassOrInterfaceType(fieldType),fieldName);
//        fieldDeclaration.addAnnotation("Autowired");
        System.out.printf(String.valueOf(AST.getFieldByName(fieldName).equals(Optional.empty())));
        if(AST.getFieldByName(fieldName).equals(Optional.empty())){
            AST.getMembers().add(0,fieldDeclaration);
            MethodDeclaration methodDeclaration=new MethodDeclaration();
            com.github.javaparser.ast.body.Parameter param=new com.github.javaparser.ast.body.Parameter(new ClassOrInterfaceType(fieldType+"Impl"),fieldName);
            methodDeclaration.setParameters(new NodeList<>(param));
            BlockStmt blockStmt=new BlockStmt();
            Expression expression=new AssignExpr(new NameExpr("this."+fieldName),new NameExpr(fieldName),AssignExpr.Operator.ASSIGN);
            blockStmt.addStatement(expression);
            methodDeclaration.setBody(blockStmt);
            methodDeclaration.setType(new VoidType());
            methodDeclaration.setName("set"+fieldType);
            methodDeclaration.addAnnotation("Autowired");
            AST.getMembers().add(methodDeclaration);
        }
    }
    public List<String> parseURL(String URL){
        String stringPattern="(\\{)(\\w*)(\\})";
        Pattern pattern= Pattern.compile(stringPattern);
        Matcher matcher=pattern.matcher(URL);
        List<String> listMatches = new ArrayList<String>();
        while(matcher.find())
        {
            listMatches.add(matcher.group());
        }
        return listMatches;
    }
    public String getAPIName(String URL){
        String[] parts = URL.split("/");
        String stringPattern="(\\{)(\\w*)(\\})";
        for(int i=parts.length-1; i>=0;i-- ){
            if(!parts[i].matches(stringPattern)){
                return parts[i];
            }
        }
        return "";
    }
    public void createAPI(JSONObject jsonObject) throws IOException {
        //prepare data
        String controller=jsonObject.containsKey("controllerClass")?jsonObject.get("controllerClass").toString():"";
        String URL=jsonObject.containsKey("URL")?jsonObject.get("URL").toString():"";
        String method=jsonObject.containsKey("method")?jsonObject.get("method")+"Mapping":"";
        String service=jsonObject.containsKey("serviceClass")?jsonObject.get("serviceClass").toString():"";
        String paramType=jsonObject.containsKey("requestBody")?jsonObject.get("requestBody").toString():"";
        String response=jsonObject.containsKey("responseBody")?jsonObject.get("responseBody").toString():"Object";
        String apiName=getAPIName(URL);
        //prepare data
        NodeList listParameterForController=new NodeList();
        List listArgumentForService=new ArrayList();
        NodeList listParameterForService=new NodeList();
        Set controllerImport= new HashSet();
        parseURL(URL).forEach(e->{
            String param=e.replace("{","").replace("}","");
            com.github.javaparser.ast.body.Parameter parameter=new com.github.javaparser.ast.body.Parameter(new ClassOrInterfaceType("String"),param);
            com.github.javaparser.ast.body.Parameter parameterForService=new com.github.javaparser.ast.body.Parameter(new ClassOrInterfaceType("String"),param);
            parameter.addAnnotation("PathVariable");
            controllerImport.add("org.springframework.web.bind.annotation.PathVariable");
            listArgumentForService.add(param);
            listParameterForController.add(parameter);
            listParameterForService.add(parameterForService);
        });
        //check require data
        if(controller.isEmpty()||URL.isEmpty()||method.isEmpty() ||service.isEmpty()){
            getLog().info("Have an error syntax in API");
        }else{
            String controllerPath=baseDir.toString().concat("/src/main/java/"+packed+"/controller/"+controller+".java");
            FileInputStream fileInputStream=null;
            Path path = Paths.get(controllerPath);
            String code="";
            String paramName= StringUtils.uncapitalize(paramType);
            CompilationUnit cu = null;
            ClassOrInterfaceDeclaration AST;
            //case controller exist
            if(Files.exists(path)){
                fileInputStream=new FileInputStream(controllerPath);
                cu = parse(fileInputStream);
                Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(controller);
                AST=classAST.get();
            }
            //case new controller
            else{
                cu=new CompilationUnit();
                cu.addClass(controller);
                cu.setPackageDeclaration(groupId+".controller");
                Optional<ClassOrInterfaceDeclaration> classAST=cu.getClassByName(controller);
                AST=classAST.get();
                AST.addExtendedType("BaseRestController");
                AST.addAnnotation("RestController");
                AST.addAnnotation("RequestMapping");
            }
            //get class controller

            //check api exist
            if(AST.getMethodsByName(apiName).isEmpty() && !apiName.isEmpty()){
                MethodDeclaration methodDeclaration=new MethodDeclaration();
                methodDeclaration.setName(apiName);
                methodDeclaration.setType("ResponseEntity<Object>");
                methodDeclaration.setPublic(true);
                NormalAnnotationExpr normalAnnotationExpr=new NormalAnnotationExpr();
                normalAnnotationExpr.setName(method);
                normalAnnotationExpr.addPair("path",'\"'+URL+'\"');
                methodDeclaration.addAnnotation(normalAnnotationExpr);
                if(paramType!=""){
                    controllerImport.add(groupId+".dto."+paramType);
                    com.github.javaparser.ast.body.Parameter param=new com.github.javaparser.ast.body.Parameter(new ClassOrInterfaceType(paramType),paramName);
                    com.github.javaparser.ast.body.Parameter temp=new com.github.javaparser.ast.body.Parameter(new ClassOrInterfaceType(paramType),paramName);;
                    temp.addAnnotation("Valid");
                    temp.addAnnotation("RequestBody");
                    controllerImport.add("javax.validation.Valid");
                    controllerImport.add("org.springframework.web.bind.annotation.RequestBody");
                    listParameterForController.add(temp);
                    listArgumentForService.add(paramName);
                    listParameterForService.add(param);
                }
                methodDeclaration.setParameters(listParameterForController);
                String argumentForService="";
                for (int j = 0; j < listArgumentForService.size(); j++){
                    argumentForService=argumentForService+listArgumentForService.get(j);
                    if(j<listArgumentForService.size()-1){
                        argumentForService=argumentForService+",";
                    }
                }
                String returnString="RestUtils.responseOk("+StringUtils.uncapitalize(service)+"."+apiName+"("+argumentForService+")"+")";
                Node node=new ReturnStmt(returnString);
                NodeList nodeList=new NodeList<>(node);
                BlockStmt blockStmt=new BlockStmt(nodeList);
                methodDeclaration.setBody(blockStmt);
                addField(AST,service,Modifier.Keyword.PRIVATE );
                //import handle
                controllerImport.add(groupId+".service."+service);
                controllerImport.add(groupId+".service.impl."+service+"Impl");
                controllerImport.add("org.springframework.web.bind.annotation.*");
                controllerImport.add("org.springframework.beans.factory.annotation.Autowired");
                controllerImport.add("org.springframework.http.ResponseEntity");
                controllerImport.add("com.viettel.vtskit.common.utils.RestUtils");
                controllerImport.add("com.viettel.vtskit.common.rest.BaseRestController");
                importHandle(cu, controllerImport);
                AST.getMembers().add(methodDeclaration);
                //create service
                createService(service,apiName,listParameterForService, response);
            }else {
                getLog().info("API "+apiName+ " is exist ....");
            }
            code = cu.toString();
            writeCodeToFile(code,controllerPath);
        }
    }
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            packed=groupId.replace(".","/");

            //read data from json file
            String jsonPath=System.getProperties().containsKey("apiConfiguration")?baseDir.toString().concat("/.vtskit/configuration/"+System.getProperty("apiConfiguration")+".json"):"";
            jsonPath=System.getProperties().containsKey("filePath")?System.getProperty("filePath"):jsonPath;
            JSONParser parser = new JSONParser();
            JSONObject data= (JSONObject) parser.parse(
                        new FileReader(jsonPath));
            //create DTO
            JSONArray DTOs = data.containsKey("DTOs") ?(JSONArray) data.get("DTOs"):null;
            if(!(DTOs ==null)){
                createDTOs(DTOs);
            }
            //create API
            JSONArray APIs = data.containsKey("APIs") ?(JSONArray) data.get("APIs"):null;
            if(!(APIs==null)){
                for (int i = 0; i < APIs.size(); i++) {
                    JSONObject jsonObject = (JSONObject) APIs.get(i);
                    createAPI(jsonObject);
                }
            }
        }catch (Exception e){
            getLog().info(e.toString());
        }
    }
}