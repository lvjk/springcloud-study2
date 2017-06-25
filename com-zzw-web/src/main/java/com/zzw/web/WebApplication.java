package com.zzw.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类.shiro模块不支持devtools
 * System.setProperty("spring.devtools.restart.enabled","false");
 * 
 * @author 草原狼
 * @version v.0.1
 */
@SpringBootApplication
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
