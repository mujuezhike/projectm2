package com.mujuezhike.projectm.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//import core.data.DruidStatFilter;
//import core.data.DruidStatViewServlet;

/**
 * 容器中的spring启动类
 * @author mujuezhike
 * @date   20170927
 */
@SpringBootApplication
@ServletComponentScan
public class SpringBootWebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
    	
        SpringApplication.run(SpringBootWebApplication.class, args);
        
    }

}
