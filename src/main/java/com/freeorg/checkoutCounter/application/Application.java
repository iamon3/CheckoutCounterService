package com.freeorg.checkoutCounter.application;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

//import com.freeorg.checkoutCounter.controller.CheckoutCounterController;

@SpringBootApplication
@ComponentScan(basePackages={"com.freeorg.checkoutCounter"})
@EntityScan("com.freeorg.checkoutCounter.domain")
@EnableJpaRepositories("com.freeorg.checkoutCounter.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");	  
	    return registration;
	}
	
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("org.h2.Driver");
	    dataSource.setUrl("jdbc:h2:~/myDB;MV_STORE=false");
	    dataSource.setUsername("sa");
	    dataSource.setPassword("");

	    // schema init
	    Resource initSchema = new ClassPathResource("schema-h2.sql");
	    Resource initData = new ClassPathResource("data-h2.sql");
	    DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
	    DatabasePopulatorUtils.execute(databasePopulator, dataSource);

	    return dataSource;
	}
}