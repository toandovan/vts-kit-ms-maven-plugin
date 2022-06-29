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

@Mojo(name = "addMaria")
public class Maria extends AbstractMojo {
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
            String url = prompter.prompt("Please enter your url (jdbc:mariadb://localhost:3306/your-database)", "jdbc:mariadb://localhost:3306/your-database");
            String username = prompter.prompt("Please enter your username", "<your access key>");
            String password = prompter.prompt("Please enter your password", "<your secret key>");
            GenHelper.genDependency(project,"com.atviettelsolutions","vts-kit-ms-maria-data","1.0.0");
            Map map=new HashMap();
            Map map1=new HashMap();
            map1.put("url", "jdbc:mariadb://localhost:3306/your-database");
            map1.put("username", username);
            map1.put("password", password);
            map.put("datasource",map1);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-local.yml", "mariadb", map);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-docker.yml", "mariadb", map);
        }catch (Exception e) {
            getLog().info(e.toString());
        }finally {
            getLog().info("Read details in https://github.com/vts-contributor/vts-kit-ms-maria-data");
        }
    }
}
