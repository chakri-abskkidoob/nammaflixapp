package com.nammaflix.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class NammaflixConfiguration {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers("/getusers", "/getallmovies").authenticated()
		.antMatchers("/getallcategories").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}

}
