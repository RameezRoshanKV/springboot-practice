package com.springboot.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeUtil {
	
	@Bean
	public void name() {
		System.out.println("Hey u have init an bean method!!");
	}

	
}
