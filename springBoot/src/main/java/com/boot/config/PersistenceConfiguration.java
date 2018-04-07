package com.boot.config;

import javax.activation.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {

	
	@Bean // @Bean tells in spring boot that the return values of this method which is a data
		  // source need to be set up and stored as spring bean in the spring context
	@ConfigurationProperties(prefix = "spring.datasource") // @ConfigurationProperties is tells the data source builder to use the
															// connection and pulling propertied located in the
															// application.properties file where the properties begin
															// with the prefix spring.datasource
	@Primary// this makes following DB as default DB on event of multiple DB's 
	public DataSource dataSource() {
		return (DataSource) DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource.flyway")// find the properties in datasource.flyway prefix in application.properties file
	@FlywayDataSource
	public DataSource flywayDataSource() {
		return (DataSource) DataSourceBuilder.create().build();
	}

}
