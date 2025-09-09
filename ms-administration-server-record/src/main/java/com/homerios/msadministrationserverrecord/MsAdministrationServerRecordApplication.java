package com.homerios.msadministrationserverrecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class MsAdministrationServerRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministrationServerRecordApplication.class, args);
	}

}
