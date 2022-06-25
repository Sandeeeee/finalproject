package com.eeit44.finalproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

	@RequestMapping("/chatroom")
	public String viewHomePage(Model model,
			String senderId,String receiverId,
			String senderName,String receiverName,
			String channel
			) {
		//http://localhost:3000/chatroom?receiverId=1&senderId=2&senderName=Peter&receiverName=July&channel=人力媒合
		//http://localhost:3000/chatroom?receiverId=2&senderId=1&senderName=July&receiverName=Peter&channel=人力媒合
		
		//httpservletRquest
		//HttpSession session = request.getSession();
		//session.getAttribute("senderId", senderId);取得資料
		
		
		model.addAttribute("senderId", senderId);
		model.addAttribute("receiverId", receiverId);
		model.addAttribute("senderName", senderName);
		model.addAttribute("receiverName", receiverName);
		model.addAttribute("channel", channel);
		return "chatroom";
	}
	
	//@RequestMapping("/redirectToChatRoom")
	//public String redirectToChatRoom(Model model,
	//HttpServeletRequest hq{
	
	//httpservletRquest
	//HttpSession session = request.getSession();
	//session.getAttribute("senderId");
	// url  組好
	// java redirect(url)
	//}
	
	//整合:透過session讓request參數為空
	//微服務:帶參數(明碼)	
}
