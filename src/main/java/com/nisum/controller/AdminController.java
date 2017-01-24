package com.nisum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

	@RequestMapping("/admin/greet")
	@ResponseBody
	public String greetAdmin(){
		return "Greet Admin";
	}
}
