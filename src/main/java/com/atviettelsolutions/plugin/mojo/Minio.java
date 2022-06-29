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

@Mojo(name = "addMinio")
public class Minio extends AbstractMojo {
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
        try {
            String server = prompter.prompt("Please enter your server", "https://host:port");
            String access_key = prompter.prompt("Please enter your access-key", "<your access key>");
            String secret_key = prompter.prompt("Please enter your secret-key", "<your secret key>");
            String bucket = prompter.prompt("Please enter your bucket", "<your bucket>");
            String auto_create_bucket = prompter.prompt("Please enter your auto-create-bucket", "true");
            GenHelper.genDependency(project,"com.atviettelsolutions","vts-kit-ms-minio-integrated","1.0.0");
            Map map=new HashMap();
            map.put("server", server);
            map.put("access-key", access_key);
            map.put("secret-key", secret_key);
            map.put("bucket", bucket);
            map.put("auto-create-bucket", auto_create_bucket);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-local.yml", "minio", map);
            GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-docker.yml", "minio", map);
        } catch (Exception e) {
            getLog().info(e.toString());
        }finally {
            getLog().info("Read details in https://github.com/vts-contributor/vts-kit-ms-minio-integrated");
        }
    }

}
