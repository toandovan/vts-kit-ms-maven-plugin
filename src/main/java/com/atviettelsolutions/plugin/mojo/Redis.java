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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Mojo(name = "addRedis")
public class Redis extends AbstractMojo {
    /**
     * @parameter default-value="${project}"
     * @required
     */

    @Component
    private Prompter prompter;
    @Parameter(defaultValue="${project}", required=true)
    private MavenProject project;

    /**
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try{
            String query = "Cluster Node (Y/N)";
            String answer = prompter.prompt( query, "N" );
            GenHelper.genDependency(project,"com.atviettelsolutions","vts-kit-ms-redis-cache","1.0.0");
            if("N".equals(answer)){
                String host = prompter.prompt("Please enter your host", "localhost");
                String port = prompter.prompt("Please enter your host", "6379");
                Map map=new HashMap();
                map.put("host", host);
                map.put("port", port);
                GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-local.yml", "redis", map);
                GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-docker.yml", "redis", map);
            }else{
                String nodeList = prompter.prompt("Please enter  List node(host:port;....)", "");
                String maxRedirects = prompter.prompt("Please enter maxRedirects", "1");
                Map map=new HashMap();
                Map map1=new HashMap();
                map1.put("maxRedirects", maxRedirects);
                map1.put("nodes",parserNodeList(nodeList));
                map.put("cluster", map1);
                GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-local.yml", "redis", map);
                GenHelper.genProperties(project.getBasedir()+"/src/main/resources/application-docker.yml", "redis", map);
            }
        }catch (Exception e) {
            getLog().info(e.toString());
        }finally {
            getLog().info("Read details in https://github.com/vts-contributor/vts-kit-ms-redis-cache");
        }
    }
    public ArrayList parserNodeList(String nodeList){
        ArrayList arrayList=new ArrayList();
        if(nodeList!=null&&!nodeList.isEmpty())
        {
            String[] strings=nodeList.split(";");
            System.out.printf(String.valueOf(strings.length));
            for (int i = 0; i < strings.length; i++) {
                String[] hostPost=strings[i].split(":");
                arrayList.add(hostPost[0]+":"+hostPost[1]);
            }
        }
        return arrayList;
    }
}
