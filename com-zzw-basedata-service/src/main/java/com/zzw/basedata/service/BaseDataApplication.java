package com.zzw.basedata.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 基础数据服务启动类
 * @author 草原狼
 * @date 2017-6-26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BaseDataApplication {
	public static void main(String[] args) {
		SpringApplication.run(BaseDataApplication.class, args);
	}
}
