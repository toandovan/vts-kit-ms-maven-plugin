package com.atviettelsolutions.plugin.mojo;

import com.atviettelsolutions.plugin.help.GenHelper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Mojo(name = "deployDockerCompose")
public class DockerDeployment extends AbstractMojo {
    /**
     * @parameter default-value="${project}"
     * @required
     */
    @Parameter(defaultValue="${project}", required=true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            String artifactId=project.getArtifactId();
            String imagePrefix=project.getProperties().contains("docker.imagePrefix")&&!project.getProperties().get("docker.imagePrefix").toString().equals("")?project.getProperties().get("docker.imagePrefix").toString()+"/":"";
            String version=project.getVersion();
            String port="8080";
            File temp=GenHelper.replace("@", "<AtSignCharacter>", project.getBasedir()+"/src/main/resources/application.yml");
            try(InputStream inputStream = new FileInputStream(temp)){
                Yaml yaml = new Yaml();
                Map<String, Map<String, Object>> data=yaml.load(inputStream);
                port=data.get("server").get("port").toString();
            }
            Map<String, Object> map=new LinkedHashMap();
            Map mapLv1=new LinkedHashMap();
            Map mapLv2=new LinkedHashMap();
            Map mapLv3=new LinkedHashMap();
            mapLv1.put(artifactId, mapLv2);
            mapLv2.put("image", imagePrefix+artifactId+":"+version);
            mapLv2.put("container_name", artifactId);
            mapLv2.put("restart", "always");
            mapLv3.put("POSTGRES_PASSWORD","123456");
            mapLv2.put("environment",mapLv3);
            ArrayList<String> list=new ArrayList();
            list.add(port+":"+port);
            mapLv2.put("ports",list);
            map.put("version", "3.8");
            map.put("services", mapLv1);
            String directory=project.getBasedir()+"/.vtskit/deployment/";
            String path=project.getBasedir()+"/.vtskit/deployment/docker-compose.yml";
            File theDir = new File(directory);
            Path of = Paths.get(path);
            if (!Files.exists(of)){
                if(!theDir.exists()){
                    theDir.mkdirs();
                }
                Files.createFile(of);
                GenHelper.genDocker(path,  map);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
