package com.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

	@Bean
	public ModelMapper modelmapper() {
		
		return new ModelMapper();
	}
}
