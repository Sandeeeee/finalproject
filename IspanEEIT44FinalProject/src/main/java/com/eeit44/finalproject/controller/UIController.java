package com.eeit44.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

	@RequestMapping("/chatroom")
	public String viewHomePage(Model model,String sender,String receiver) {
		
		System.out.println(sender+" "+receiver );
		model.addAttribute("sender", sender);
		model.addAttribute("receiver", receiver);
	
		return "chatroom";
	}
	

}
