package com.nisum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.nisum.service.impl.UserAuthenticationService;


/*
 * Note: you must set true prePostEnabled=true for enabling the method
 * level security.
 * 
 * otherwise, method level security is not enabled.
 * 
 * To enable, @Secured annotation, you must enable it on @EnableGlobalMethodSecurity.
 */
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true) //for enabling method level security
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	UserAuthenticationService userAuthService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/login","/sample","/example","/h2-console").permitAll()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/").hasAnyRole("USER")
			.anyRequest().authenticated();
		http.logout().logoutSuccessUrl("/login");
		http.formLogin().loginPage("/login")
		.usernameParameter("name")
		.passwordParameter("password");	
		http.exceptionHandling().accessDeniedPage("/403");//accessDeniedHandler(accessDeniedHandler);
		//for h2-console, otherwise, endup in Lynx is not setup yet
		http.headers().frameOptions().disable(); //or u can use http.headers().frameOptions().sameOrigin()
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthService);
	}

	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("dinesh").password("dinesh").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN"); //"USER","ADMIN"
	}*/
	
}
