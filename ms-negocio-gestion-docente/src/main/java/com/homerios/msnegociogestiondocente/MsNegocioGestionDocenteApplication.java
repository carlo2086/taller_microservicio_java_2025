package com.homerios.msnegociogestiondocente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionDocenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionDocenteApplication.class, args);
	}

}
