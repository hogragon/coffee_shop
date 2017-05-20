package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "home";
	}
        
        @GetMapping("/createPerson")
	public String addPersonPage() {
		return "addPerson";
	}
        
        @PostMapping("/createPerson")
	public String addPersonPagePost() {
		return "addPerson";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
}
