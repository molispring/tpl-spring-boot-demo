package com.yonyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ServletComponentScan
public class Application{
	
    public static void main(String[] args) {
    	SpringApplication app = new SpringApplication(Application.class);
    	Environment environment = app.run(args).getEnvironment();
    }
    
}