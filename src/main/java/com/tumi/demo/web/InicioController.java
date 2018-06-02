package com.tumi.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping("/")
	public String inicio() {
		
		return "home";  // en templates/home.html
	}

}
