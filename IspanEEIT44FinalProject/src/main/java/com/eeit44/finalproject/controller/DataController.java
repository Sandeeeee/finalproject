package com.eeit44.finalproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eeit44.finalproject.model.ChatList;
import com.eeit44.finalproject.model.ChatMessage;

@RestController
public class DataController {

	@RequestMapping("/getChatData")
	public @ResponseBody ChatList getChatData(String sender ,String receiver) {
		//http://localhost:3000/getChatData?receiver=1&sender=2
		ChatList lll = new ChatList();

        ChatMessage chatMessage = new ChatMessage();
        
        chatMessage.setSender("1");
        chatMessage.setReceiver("2");
        chatMessage.setContent("sssssssss");
        lll.chatlist.add(chatMessage);
        lll.chatlist.add(chatMessage);
		
		return lll;
		
		
		
		
	}
}
