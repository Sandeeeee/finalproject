package com.eeit44finalproject.messages.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController_company {
		
	@GetMapping("/loginAdmin")
	public String loginPageAdmin() {
		return "/loginAdmin";
	}
	
	@GetMapping("/loginCompany")
	public String loginPageCompany() {
		return "/loginCompany";
	}
	
	@GetMapping("/loginStudent")
	public String loginPageStudent() {
		return "/loginStudent";
	}
	
	@GetMapping("/deletePageAdmin")
	public String deleteMessagePageAdmin() {
		return "deletePageAdmin";
	}
	
	@GetMapping("/queryMessages")
	public String queryMessagePageAdmin() {
		return "chatPageAdmin";
	}
	
	@GetMapping("/deletePageCompany")
	public String deleteMessagePageCompany() {
		return "deletePageCompany";
	}
	
	@GetMapping("/queryMessagesCompany")
	public String queryMessagePageCompany() {
		return "queryMessagePageCompany";
	}
	
	
}
