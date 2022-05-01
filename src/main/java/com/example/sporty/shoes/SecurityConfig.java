package com.example.sporty.shoes;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	     @Autowired
	    private DataSource dataSource;
	     
	    @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder authentication) throws Exception {
	        authentication.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	            .dataSource(dataSource)
	            .usersByUsernameQuery("select username, password, enabled from users where username=?")
	            .authoritiesByUsernameQuery("select username, role from users where username=?")
	        ;
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	// TODO Auto-generated method stub
	    	http.authorizeRequests()
	            .antMatchers("/new").permitAll()
	    	    .antMatchers("/edit/*", "/delete/*").permitAll()
	    	    .anyRequest().authenticated()
	    	    .and()
	    	    .formLogin().permitAll()
	    	    .and()
	    	    .logout().permitAll()
	    	    .and()
	    	    .exceptionHandling().accessDeniedPage("/404") ;
	    }
	}

