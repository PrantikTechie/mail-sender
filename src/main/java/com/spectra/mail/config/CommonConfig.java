package com.spectra.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CommonConfig {
	
	@Bean(name = "Bean1")
	@Lazy
	public Bean1 beanDef1() {
		System.out.println("#### Bean 1");
		return new Bean1();
	}
}
