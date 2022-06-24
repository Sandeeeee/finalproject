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

/**
 * Created by rajeevkumarsingh on 24/07/17.
 */
@Controller
public class ChatController {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	@Autowired
	MessagesService messagesService;
	
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
    	System.out.println(chatMessage.getReceiver() );
    	//http://localhost:3000/chatroom?receiver=1&sender=2
    	String channel = "";
    	if(chatMessage.getSender().compareTo(chatMessage.getReceiver())==1) {
    		channel = chatMessage.getReceiver() + ":" +  chatMessage.getSender();
    	}else {
    		channel = chatMessage.getSender() + ":" + chatMessage.getReceiver()   ;
    	}
    	
    	Messages msg = Messages.builder().senderId(Integer.valueOf(chatMessage.getSender()))
    			.receiverId(Integer.valueOf(chatMessage.getReceiver())).created(new Date())
    			.text(chatMessage.getContent()).build();
    	messagesService.insertMessage(msg);
    	
    	
    	System.out.println("/topic/public/"+channel );
		simpMessagingTemplate.convertAndSend("/topic/public/"+channel, chatMessage);
     //http://localhost:3000/chatroom?r=1&s=2
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

}
