package com.springboot.repository;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

	@Bean(name = "passoutDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.second")
	DataSource getPassoutDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "passoutTemplate")
	JdbcTemplate getPassoutTemplate(@Qualifier("passoutDataSource") DataSource ds) throws SQLException {
		return new JdbcTemplate(ds);
	}
	
	@Bean(name = "studentsDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.first")
	DataSource getStudentDataSource() {

		System.out.println("method init using Bean!!");
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "studentsTemplate")
	JdbcTemplate getStudentTemplate(@Qualifier("studentsDataSource") DataSource ds) throws SQLException {
		
		return new JdbcTemplate(ds);
	}

}
