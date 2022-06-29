package com.eeit44finalproject.messages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit44finalproject.messages.model.Messages;
import com.eeit44finalproject.messages.model.MessagesRepository;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService{
	
	@Autowired
	private MessagesRepository messagesDao;
	
	//-------------Admin--------------------------Admin--------------------------Admin-------------
	public List<Messages> queryAllMessagesAdmin() {
		return messagesDao.queryAllMessagesAdmin();
	}
	
	public List<Messages> findChatMessageBySenderIdAndRecevierIdAdmin(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId){
		return messagesDao.findChatMessageBySenderIdAndRecevierIdAdmin(senderId, receiverId);
	}	

	public void deleteByMessageIdAdmin(String messageId) {
		messagesDao.deleteByMessageIdAdmin(messageId);
		
	}

	
	public void deletedChatMessageBySenderIdAndRecevierIdAdmin(String senderId, String receiverId) {
		messagesDao.deletedChatMessageBySenderIdAndRecevierIdAdmin(senderId, receiverId);
	}

	//以分頁方式查詢 所有資料
	public Page<Messages> findAllMessageByPageAdmin(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC,"created");
		Page<Messages> page= messagesDao.findAll(pgb);  
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		return page;
	}

	
	
	
	//-------------Company---------------------Company--------------------Company------------
	
	public List<Messages> queryAllMessagesCompany(@Param(value = "senderId") String senderId) {
		return messagesDao.queryAllMessagesCompany(senderId);
	}

	public List<Messages> findChatMessageByRecevierIdCompany(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId){
		return messagesDao.findChatMessageByRecevierIdCompany(senderId, receiverId);
	}	
	
	public void deletedChatMessageByRecevierIdCompany(String senderId, String receiverId) {
		messagesDao.deletedChatMessageByRecevierIdCompany(senderId, receiverId);
	}

	

	
	}

	
	

	
	


	
