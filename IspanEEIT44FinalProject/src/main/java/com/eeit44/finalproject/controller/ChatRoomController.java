package com.eeit44.finalproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {
	@GetMapping("/openChatRoom")
	public String chat() {
		return "chat";
	}

}
