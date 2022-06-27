package com.eeit44.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit44.finalproject.model.Messages;
import com.eeit44.finalproject.model.MessagesRepository;

@Service
@Transactional
public class MessagesServiceImpl implements MessagesService{
	
	@Autowired
	private MessagesRepository messagesDao;
	
	@Override
	public Messages insertMessage (Messages messages) {
		return messagesDao.save(messages);
	}

//	@Override
//	public void deleteMessage(int receiverId) {
//		messagesDao.deleteByReceiverId(receiverId);
//		
//	}

}
