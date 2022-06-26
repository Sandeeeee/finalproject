package com.eeit44.finalproject.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.eeit44.finalproject.model.Messages;


public interface MessagesService {
//
//	Messages insertMessage (Messages messages);
//
//	
//	
//	List<Messages> queryLastMessage (int senderId);
//
	void deleteByMessageId (int messageId);

	List<Messages> queryAllMessages();

	Page<Messages> findByPage(Integer pageNumber);

	
}
