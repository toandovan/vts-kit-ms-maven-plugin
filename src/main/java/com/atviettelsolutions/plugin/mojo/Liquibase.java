package com.atviettelsolutions.plugin.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Mojo(name="liquibase")
public class Liquibase extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        //run bat file
        //
        try {

            Runtime.getRuntime().exec("mvn.cmd liquibase:diff");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
