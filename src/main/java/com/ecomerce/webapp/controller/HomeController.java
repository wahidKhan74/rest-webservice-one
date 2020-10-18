package com.ecomerce.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/webapione")
public class HomeController {
	
	@GetMapping()
	public String helloSpringSec() {
		return "Hello Spring Security";
	}
}
