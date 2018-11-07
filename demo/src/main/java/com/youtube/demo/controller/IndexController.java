package com.youtube.demo.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan("com.youtube.demo")
public class IndexController {

	@RequestMapping("/")
	public String redirectIndex() {
		
		return "index";
		
	}
	
	
}
