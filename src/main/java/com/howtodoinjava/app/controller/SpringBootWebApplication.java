package com.howtodoinjava.app.controller;

import org.jboss.jandex.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.FROM;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer implements CommandLineRunner{




	//bookJdbcRepository repository;
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}
	@Autowired

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);

	}
	@Autowired
	JdbcTemplate jdbcTemplate;


	public void run(String... strings) throws Exception {


        //Delete random Null value that inserts into H2
		jdbcTemplate.update("DELETE FROM CART WHERE bid = '1'" );
	}
}
