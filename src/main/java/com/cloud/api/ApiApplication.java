package com.cloud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import java.util.Scanner;

/**
 * @author HP
 */
@SpringBootApplication
public class ApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	@Bean
	public HttpFirewall allowUrlSemicolonHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowSemicolon(true);
		return firewall;
	}
}
