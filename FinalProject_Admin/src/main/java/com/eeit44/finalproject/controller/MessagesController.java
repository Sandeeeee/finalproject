package com.eeit44.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eeit44.finalproject.model.Messages;
import com.eeit44.finalproject.service.MessagesService;

//MessageController

@Controller
public class MessagesController {

	@Autowired
	private MessagesService msgService;

	//localhost:8080/login跳轉至帶全部訊息之畫面
	@GetMapping("/login")
	public ModelAndView login (ModelAndView mav,Model model,HttpServletRequest request, 
			@RequestParam ("userId") Integer userId,
			@RequestParam ("password") String password,
			@RequestParam(name="p",defaultValue = "1")Integer pageNumber) 
			{
		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("password",  password);
		
		Integer userIdFromSession = (Integer) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");
		
		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password",passwordFromSession);

//		List<Messages> newMessage = msgService.queryAllMessages();
//		System.out.println(newMessage);
		
		
		Page<Messages> page = msgService.findByPage(pageNumber);
		
		mav.getModel().put("page", page);  
		 
//		mav.getModel().put("newMessage", newMessage);  
		mav.setViewName("chatPageAdmin");
		return mav;
//		return "chatPageAdmin";
		
  
		
		
		
	}
	
	//localhost:8080/queryAllMessages 可察看全部訊息
	@GetMapping("/queryAllMessages")
	@ResponseBody
	public ModelAndView queryAllMessages (Model model,ModelAndView mav,HttpServletRequest request) {
		Integer userIdFromSession = (Integer) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");
		
		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password",passwordFromSession);

		List<Messages> newMessage = msgService.queryAllMessages();
		System.out.println(newMessage);
		
		 
		mav.getModel().put("newMessage", newMessage);  
		mav.setViewName("chatPageAdmin");
		return mav;
		
	}
	
	
	
//	
//	@GetMapping("/queryLastMessage/{senderId}")
//	@ResponseBody
//	public List<Messages> queryLastMessage (@PathVariable ("senderId") int senderId, Model m){
//		List<Messages> newMessage = msgService.queryLastMessage(senderId);
//		System.out.println(newMessage);
//		return newMessage;
//	}
//	
//	
	@GetMapping("/deleteMessage")
	public String deleteByMessageId(@RequestParam ("messageId") int messageId) {
			msgService.deleteByMessageId(messageId);
		return "redirect:/queryAllMessages";
	}
//			
//	
	
	
	
	
}
