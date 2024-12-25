package com.klef.jfsd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CmsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsProjectApplication.class, args);
		System.out.println("CMS Project is Running");
	}

}
