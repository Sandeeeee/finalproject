package com.eeit44.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eeit44.finalproject.model.ChatList;
import com.eeit44.finalproject.model.ChatMessage;
import com.eeit44.finalproject.model.Messages;
import com.eeit44.finalproject.model.MessagesRepository;

@RestController
public class DataController {
	
	@Autowired
	MessagesRepository messagesRepository;
	
	
	@RequestMapping("/getChatData")
	public @ResponseBody ChatList getChatData(String sender ,String receiver) {
		//http://localhost:3000/getChatData?receiver=1&sender=2
		ChatList chatList = new ChatList();

		List<Messages> messageList = messagesRepository.findChatMessageBySenderIdAndRecevierId(Integer.valueOf(sender), Integer.valueOf(receiver));
        
		List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
		for(Messages msg : messageList) {
			ChatMessage cm = ChatMessage.builder().sender(String.valueOf(msg.getSenderId()))
					.receiver(String.valueOf(msg.getReceiverId())).content(msg.getText()).build();		
			chatMessageList.add(cm);
		}
		
		chatList.setChatlist(chatMessageList);
		return chatList;
		
		
		
		
	}
}
