package com.Test.SampleProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

	
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
	http.authorizeHttpRequests().antMatchers("/getTestPage").permitAll().anyRequest().authenticated();
		
	}
	
	
	
	
}
