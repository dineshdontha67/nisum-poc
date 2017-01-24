package com.nisum.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nisum.custom.exceptions.NoUserFoundException;

@Controller
public class SampleController {
	
	@RequestMapping("/")
	//@ResponseBody
	public String getGreetings(){
		//return "Happy New Year";
		return "user";
	}
	
	@RequestMapping(path={"/login"})
	public String home(){
		return "login";
	}
	
	@RequestMapping(value="/register")
	public String register(){
		//System.out.println("register.....***");
		return "jsp/register";
	}
	
	@RequestMapping(value="/sample")
	public String sampleHtml(){
		return "sample";
	}
	
	@RequestMapping(value="/usererror")
	public String sampleControllerAdvice(){
		throw new NoUserFoundException();		
	}
	
	@RequestMapping(value="/example")
	@PreAuthorize("hasRole('ADMIN')")
	public String sampleRouting(){
		return "example";	
	}
	
	/*@RequestMapping(value="/about")
	public String getAbout(){
		return "about";
	}*/
}
