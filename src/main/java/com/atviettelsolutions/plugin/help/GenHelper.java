package com.atviettelsolutions.plugin.help;

import org.apache.commons.collections.keyvalue.DefaultKeyValue;
import org.apache.maven.project.MavenProject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class GenHelper {
    public static void copyContent(File original, File copied) throws IOException {
        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream(original));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(copied))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
            out.close();
        }
    }
    public static File replace(String stringToReplace, String replaceWith, String path) throws IOException {
        File tempFile = File.createTempFile("gen", "test");
        BufferedReader in = new BufferedReader(new FileReader(path));
        BufferedWriter out = new BufferedWriter(new FileWriter(tempFile.getPath()));
        String line;
        while((line=in.readLine())!=null)  {
            if (line.contains(stringToReplace))
                line = line.replace(stringToReplace, replaceWith);
            out.write(line);
            out.newLine();
        }
        in.close();
        out.close();
        return  tempFile;
    }
    public static void genDependency(MavenProject project, String groupId, String artifactId, String version) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        File pom=project.getModel().getPomFile();
        //parser pom file
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(pom);
        Element root = doc.getDocumentElement();
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("dependencies");
        Element dependency = doc.createElement("dependency");
        Element groupIdElement = doc.createElement("groupId");
        groupIdElement.appendChild(doc.createTextNode(groupId));
        Element artifactIdElement = doc.createElement("artifactId");
        artifactIdElement.appendChild(doc.createTextNode(artifactId));
        Element versionElement = doc.createElement("version");
        versionElement.appendChild(doc.createTextNode(version));
        dependency.appendChild(groupIdElement);
        dependency.appendChild(artifactIdElement);
        dependency.appendChild(versionElement);
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode=nList.item(i);
            String parent=nNode.getParentNode().getNodeName();
            if(!parent.equals("dependencyManagement")
                    &&parent.equals("project")){
                NodeList n=nNode.getChildNodes();
                int count=0;
                Boolean duplicate=false;
                for (int j = 0; j < n.getLength(); j++) {
                    if(n.item(j).getNodeName().equals("dependency")){
                        NodeList childDependency=n.item(j).getChildNodes();
                        for (int k = 0; k < childDependency.getLength(); k++) {
                            if(!childDependency.item(k).getNodeName().equals("#text")) {
                                NodeList nodeK = childDependency.item(k).getChildNodes();
                                for (int l = 0; l < nodeK.getLength(); l++) {
                                    if (nodeK.item(l).getNodeValue().equals(artifactId)) {
                                        duplicate = true;
                                        break;
                                    }
                                }
                                if (duplicate == true) {
                                    break;
                                }
                            }
                        }
                        if(duplicate==true){
                            break;
                        }
                    }

                }
                if(!duplicate){
                    nNode.insertBefore(dependency,nNode.getLastChild());
                }
                break;
            }
        }
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        String xmlString = writer.getBuffer().toString();
        StreamSource src = new StreamSource(new StringReader(xmlString.replaceAll("[ \\r\\n]+", " ").replace("> <","><")));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(src, new StreamResult("pom.xml"));
    }
    public static void genProperties(String path, String key, Map object) throws IOException {
        File temp=GenHelper.replace("@", "<AtSignCharacter>", path);
        try(InputStream inputStream = new FileInputStream(temp)){
            DumperOptions options = new DumperOptions();
            options.setIndent(2);
            options.setPrettyFlow(true);
//            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setCanonical(false);
            options.setExplicitStart(false);
            Representer representer = new Representer();
//            representer.addClassTag(MinioObject.class, Tag.MAP);
            Yaml yaml = new Yaml(representer,options);
            Map<String, Map<String, Object>> data;
            data=yaml.load(inputStream);
            if(data==null){
                data=new HashMap<>();
                Map<String, Object> map=new HashMap<>();
                map.put(key,object);
                data.put("vtskit",map);
            }if(!data.containsKey("vtskit")){
                Map<String, Object> map=new HashMap<>();
                map.put(key,object);
                data.put("vtskit",map);
            }else{
                data.get("vtskit").put(key,object);
            }
            FileWriter writer = new FileWriter(new File(path));
            yaml.dump(data, writer);
            writer.close();
            File temp1=GenHelper.replace("<AtSignCharacter>", "@",path);
            GenHelper.copyContent(new File(temp1.getPath()), new File(path));
            temp1.delete();
            temp.delete();
        }
    }

    public static void genDocker(String path, Map<String,Object> object) throws IOException {
        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        options.setCanonical(false);
        options.setExplicitStart(false);
        Representer representer = new Representer();
        Yaml yaml = new Yaml(representer,options);
        Map<String, Object> data;
        data=object;
        FileWriter writer = new FileWriter(path);
        yaml.dump(data, writer);
        writer.close();
    }
}
