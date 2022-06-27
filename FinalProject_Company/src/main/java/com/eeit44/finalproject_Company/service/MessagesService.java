package com.eeit44.finalproject_Company.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.eeit44.finalproject_Company.model.Messages;


public interface MessagesService {

	List<Messages> queryAllMessages(@Param(value = "senderId") String senderId);

//	Page<Messages> findAllMessageByPage(Integer pageNumber);
	
	List<Messages> findChatMessageByRecevierId(
			@Param(value = "senderId") String senderId,
			@Param(value = "receiverId") String receiverId);
	
	
	void deletedChatMessageByRecevierId(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}
