package com.nisum.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * @author dineshdontha
 *
 */
@Configuration
//@EnableWebMvc
//@WebAppConfiguration("webapp")
public class WebMvcConfig  extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewNames("jsp/*");
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	//Configure the thymeleaf view resolvers for html
	
	@Bean("templateResolver")
	public TemplateResolver templateResolver(){
		
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		
		templateResolver.setPrefix("/WEB-INF/views/html/");
		templateResolver.setSuffix(".html");
		templateResolver.setOrder(2);
		templateResolver.setTemplateMode("HTML5");
		
		return templateResolver;
	}
	
	@Bean("templateEngine")
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		Set<IDialect> dialects = new HashSet<>();
		dialects.add(new LayoutDialect());
		dialects.add(new SpringSecurityDialect());
		templateEngine.setAdditionalDialects(dialects);
		
		
		//templateEngine.setDialect(new SpringStandardDialect()); //one sec.standard dialect must be there.
		//templateEngine.setDialect(securityDialect()); //added security dialect to spring template engine
		//templateEngine.addDialect(new SpringSecurityDialect());
		return templateEngine;
	}
	
	/*@Bean //Standard dialect is enough
	public SpringSecurityDialect securityDialect(){
		return new SpringSecurityDialect();
	}
	*/
	@Bean
	public ViewResolver thymeleafViewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		return viewResolver;
	}

	/*@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	*/

}
