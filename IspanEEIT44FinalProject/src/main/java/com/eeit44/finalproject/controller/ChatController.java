package com.eeit44.finalproject.controller;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
	//@SendTo("/topic/public/1234")22
	public void sendMessage(HttpServletRequest request,@Payload ChatMessage chatMessage) {
		String receiverId = (String)request.getSession().getAttribute("receiver");
		Messages mes = Messages.builder().receiverId(Integer.valueOf(receiverId)).
				senderId(Integer.valueOf(chatMessage.getSender())).created(new Date()).text(chatMessage.getContent()).build();
		messagesService.insertMessage(mes);
		simpMessagingTemplate.convertAndSend("/topic/public/1234", chatMessage);
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public/1234")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// Add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
