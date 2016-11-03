package com.klb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.klb.dataservice.DataAcccessImpl;
import com.klb.service.MessagesServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.klb"})
public class SpringConfiguration {
	@Bean
	public MessagesServiceImpl messagesService() {
		return new MessagesServiceImpl();
	}
	@Bean
	public DataAcccessImpl dataAcccessImpl() {
		return new DataAcccessImpl();
	}
	
}
