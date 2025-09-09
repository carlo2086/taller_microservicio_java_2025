package com.homerios.msadministrationserverconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsAdministrationServerConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministrationServerConfigurationApplication.class, args);
	}

}
