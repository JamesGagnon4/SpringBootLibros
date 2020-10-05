package com.howtodoinjava.app.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
    @Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
		ds.setUsername("sa");
		ds.setPassword("password");

		return ds;
	}

	@Bean
	public BookDao getBookDao() {
		return new BookDaoImp(getDataSource());
	}
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp(getDataSource());
	}


}
