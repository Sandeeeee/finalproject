package com.eeit44.finalproject.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.eeit44.finalproject.model.Messages;


public interface MessagesService {

	List<Messages> queryAllMessages();

	Page<Messages> findAllMessageByPage(Integer pageNumber);
	
	List<Messages> findChatMessageBySenderIdAndRecevierId(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);

	void deleteByMessageId (String messageId);
	
	void deletedChatMessageBySenderIdAndRecevierId(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}
