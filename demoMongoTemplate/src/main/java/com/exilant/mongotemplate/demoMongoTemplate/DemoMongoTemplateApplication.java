package com.exilant.mongotemplate.demoMongoTemplate;

import java.util.Date;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.appsdeveloperblog.mongotemplatedemo.controller.PersionNotFoundException;
import com.appsdeveloperblog.mongotemplatedemo.model.Person;

import com.mongodb.MongoClient;

@SpringBootApplication
@ControllerAdvice//to control exception
@ComponentScan(basePackages= {"com.appsdeveloperblog.mongotemplatedemo.*"})
@Configuration
public class DemoMongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoTemplateApplication.class, args);
		
	}
	
	
	
	@Bean
	public MongoTemplate getMongoTemplate()
	{
		System.out.println("getMongoTemplate() called");
		MongoClient mc= new MongoClient("localhost",27015);
		
		return new MongoTemplate(mc, "persondb");
	}
	

	@ExceptionHandler(PersionNotFoundException.class)
	public ResponseEntity<Object> userNOtFoundExcption(Exception ex,WebRequest req)
	{
	
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}
