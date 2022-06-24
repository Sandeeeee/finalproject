package com.eeit44.finalproject.service;

import java.io.File;
import java.util.List;

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

//	public File fileUpload(File file) {
//		return messagesDao.fileUpload(file);
//	}
	
	
	

	@Override
	public List<Messages> queryLastMessage(int senderId) {
		return messagesDao.queryLastMessage(senderId);
	}
	
	@Override
	public void deleteMessage(int receiverId) {
		messagesDao.deleteByReceiverId(receiverId);
		
	}

	@Override
	public List<Messages> queryMessage(int senderId) {
		// TODO Auto-generated method stub
		return null;
	}
}
