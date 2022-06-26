package com.eeit44.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	

//	@Override
//	public List<Messages> queryLastMessage(int senderId) {
//		return messagesDao.queryLastMessage(senderId);
//	}
//	

	public void deleteByMessageId(int messageId) {
		messagesDao.deleteByMessageId(messageId);
		
	}

	


	//以分頁方式查詢所有資料
	public Page<Messages> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC,"created");
		Page<Messages> page= messagesDao.findAll(pgb);
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getNumber());
		return page;
	}
	
	
	
	}


	
