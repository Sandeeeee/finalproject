package com.eeit44finalproject.messages.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.eeit44finalproject.messages.model.Messages;



public interface MessagesService {


	//-------------Admin--------------------------Admin--------------------------Admin-------------
	List<Messages> queryAllMessagesAdmin();

	Page<Messages> findAllMessageByPageAdmin(Integer pageNumber);
	
	List<Messages> findChatMessageBySenderIdAndRecevierIdAdmin(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);

	void deleteByMessageIdAdmin (String messageId);
	
	void deletedChatMessageBySenderIdAndRecevierIdAdmin(@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
	
	
	//-------------Company---------------------Company--------------------Company------------
	
	List<Messages> queryAllMessagesCompany(@Param(value = "senderId") String senderId);

//	Page<Messages> findAllMessageByPage(Integer pageNumber);
	
	List<Messages> findChatMessageByRecevierIdCompany(
			@Param(value = "senderId") String senderId,
			@Param(value = "receiverId") String receiverId);
	
	
	void deletedChatMessageByRecevierIdCompany(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId);
}
