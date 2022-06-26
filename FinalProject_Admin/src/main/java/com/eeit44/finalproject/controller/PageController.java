package com.eeit44.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


		
	@GetMapping("/deletePage")
	public String deleteMessagePage() {
		return "deletePageAdmin";
	}
	
}
