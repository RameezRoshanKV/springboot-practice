package com.springboot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Demo api documentation",version = "1.6.9"))
public class SpringbootpraticeApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringbootpraticeApplication.class, args);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
		
	}
	

}
