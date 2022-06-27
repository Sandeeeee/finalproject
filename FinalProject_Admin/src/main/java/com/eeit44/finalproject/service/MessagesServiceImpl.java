package com.eeit44.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit44.finalproject.model.Messages;
import com.eeit44.finalproject.model.MessagesRepository;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService{
	
	@Autowired
	private MessagesRepository messagesDao;
	
	public List<Messages> queryAllMessages() {
		return messagesDao.queryAllMessages();
	}
	
	public List<Messages> findChatMessageBySenderIdAndRecevierId(
			@Param(value = "senderId") String senderId
			,@Param(value = "receiverId") String receiverId){
		return messagesDao.findChatMessageBySenderIdAndRecevierId(senderId, receiverId);
	}	

	public void deleteByMessageId(String messageId) {
		messagesDao.deleteByMessageId(messageId);
		
	}

	
	public void deletedChatMessageBySenderIdAndRecevierId(String senderId, String receiverId) {
		messagesDao.deletedChatMessageBySenderIdAndRecevierId(senderId, receiverId);
	}

	//以分頁方式查詢 所有資料
	public Page<Messages> findAllMessageByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC,"created");
		Page<Messages> page= messagesDao.findAll(pgb);
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		return page;
	}

	}

	
	

	
	


	
