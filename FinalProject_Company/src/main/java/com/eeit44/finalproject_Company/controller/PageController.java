package com.eeit44.finalproject_Company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
		
	@GetMapping("/deletePage")
	public String deleteMessagePage() {
		return "deletePageCompany";
	}
	
	@GetMapping("/queryMessages")
	public String queryMessagePage() {
		return "queryMessagePageCompany";
	}
	
	
}
