package com.eeit44.finalproject.service;

import com.eeit44.finalproject.model.Messages;


public interface MessagesService {

	Messages insertMessage (Messages messages);

	void deleteMessage (int receiverId);

	
}
