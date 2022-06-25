package com.eeit44.finalproject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.eeit44.finalproject.model.ChatMessage;
import com.eeit44.finalproject.model.Messages;
import com.eeit44.finalproject.service.MessagesService;

@Controller
public class ChatController {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	MessagesService messagesService;
	
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
    	System.out.println(chatMessage.getReceiverId() );
    	//http://localhost:3000/chatroom?receiver=1&sender=2
    	//取參數值，組成URL
    	String topic = "";
    	if(chatMessage.getSenderId().compareTo(chatMessage.getReceiverId())==1) {
    		topic = chatMessage.getReceiverId() + ":" +  chatMessage.getSenderId();
    	}else {
    		topic = chatMessage.getSenderId() + ":" + chatMessage.getReceiverId()   ;
    	}
    	
    	Messages msg = Messages.builder().senderId(Integer.valueOf(chatMessage.getSenderId()))
    			.receiverId(Integer.valueOf(chatMessage.getReceiverId())).created(new Date())
    			.text(chatMessage.getContent()).channel(chatMessage.getChannel()).build();
    	messagesService.insertMessage(msg);
    	
    	
    	//選擇Topic
    	System.out.println("/topic/public/"+topic );
		simpMessagingTemplate.convertAndSend("/topic/public/"+topic, chatMessage);
     //http://localhost:3000/chatroom?r=1&s=2
    }


}
