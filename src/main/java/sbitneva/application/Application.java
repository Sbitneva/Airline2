package sbitneva.application;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import sbitneva.config.ApplicationConfiguration;

import java.io.File;

public class Application {

    private static Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String... args)  throws Exception {




        String webappDirLocation = "src/main/webapp";
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        StandardContext ctx = (StandardContext) tomcat.addWebapp(
                "",
                new File(webappDirLocation).getAbsolutePath()
        );

        ctx.setParentClassLoader(Application.class.getClassLoader());
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}