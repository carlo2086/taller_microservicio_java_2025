package com.homerios.msnegociogestionsemestre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsNegocioGestionSemestreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionSemestreApplication.class, args);
	}

}
