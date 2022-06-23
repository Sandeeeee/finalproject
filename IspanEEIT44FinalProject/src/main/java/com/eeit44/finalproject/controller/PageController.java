package com.eeit44.finalproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@GetMapping("/chatpage")
	public String chat() {
		return "chat";
	}

	@GetMapping("/fileUpload")
	public String fileUpload() {
		return "fileUpload";
	}

	@RequestMapping("/chatroom")
	public String viewHomePage(HttpServletRequest request, Model model, String sender, String receiver) {
		System.out.println(sender+" "+sender);
		request.getSession().setAttribute("sender",sender);
		request.getSession().setAttribute("receiver",receiver);
		return "chatroom";
	}

	@RequestMapping("/hello")
	public String hello(Model model) {

		return "hello";
	}

}
