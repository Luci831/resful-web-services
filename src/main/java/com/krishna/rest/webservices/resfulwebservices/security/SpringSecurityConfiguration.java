package com.krishna.rest.webservices.resfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpFilter;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
	//	1. All req should be authenticated
		
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
	     
	//	2. If a req is not authenticated then a web page is thrown as a response
		http.httpBasic(withDefaults());
		
	//	3. CSRF check-->POST,PUT
		
		http.csrf().disable();
		
		return http.build();
	}
	

}
