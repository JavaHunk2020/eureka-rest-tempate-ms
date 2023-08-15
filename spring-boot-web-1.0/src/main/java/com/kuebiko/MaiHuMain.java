package com.kuebiko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MaiHuMain {

	public static void main(String[] args) {
		SpringApplication.run(MaiHuMain.class, args);
	}
}
