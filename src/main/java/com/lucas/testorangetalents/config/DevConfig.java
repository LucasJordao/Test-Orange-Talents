package com.lucas.testorangetalents.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucas.testorangetalents.services.instantiates.DevInstantiateService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DevInstantiateService dev;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiate() {
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dev.instantiate();
		return true;
	}
	
}
