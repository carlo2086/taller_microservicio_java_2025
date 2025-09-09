package com.homerios.msadministrationgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsAdministrationGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministrationGatewayApplication.class, args);
	}

}
