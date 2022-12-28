package com.spectra.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(servers = {@Server(url = "${server.servlet.context-path}")})
public class MailSenderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailSenderServiceApplication.class, args);
	}

}
