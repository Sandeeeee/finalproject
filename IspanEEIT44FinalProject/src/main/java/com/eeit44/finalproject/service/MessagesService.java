package com.eeit44.finalproject.service;

import java.util.List;

import com.eeit44.finalproject.model.Messages;


public interface MessagesService {

	Messages insertMessage (Messages messages);

	List<Messages> queryMessage (int senderId);
	
	List<Messages> queryLastMessage (int senderId);

	void deleteMessage (int receiverId);

	
}
