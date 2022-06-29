package com.atviettelsolutions.plugin.mojo;

import com.atviettelsolutions.plugin.help.GenHelper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.components.interactivity.Prompter;

import java.util.HashMap;
import java.util.Map;

@Mojo(name = "addMongo")
public class Mongo extends AbstractMojo {
    @Component
    private Prompter prompter;

    /**
     * @parameter default-value="${project}"
     * @required
     */
    @Parameter(defaultValue="${project}", required=true)
    private MavenProject project;

    /**
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            String host = prompter.prompt("Please enter your uri", "mongodb://localhost:27017");
            String database = prompter.prompt("Please enter your database", "testDB");
            GenHelper.genDependency(project,"com.atviettelsolutions","vts-kit-ms-mongo-data","1.0.0");
            Map map=new HashMap();
            map.put("uri", host);
            map.put("database", database);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-local.yml", "mongodb", map);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-docker.yml", "mongodb", map);
        }catch (Exception e) {
            getLog().info(e.toString());
        }finally {
            getLog().info("Read details in https://github.com/vts-contributor/vts-kit-ms-mongo-data");
        }
    }
}
