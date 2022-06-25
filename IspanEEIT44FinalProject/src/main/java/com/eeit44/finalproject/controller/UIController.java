package com.eeit44.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.eeit44.finalproject.service.MessagesService;

@Controller
public class UIController {

	@Autowired
	MessagesService msgService;
	
//	@RequestMapping("/chatroom")
//	public String viewHomePage(Model model,
//			String senderId,String receiverId,
//			String senderName,String receiverName,
//			String channel
//			) {
//		//http://localhost:3000/chatroom?receiverId=1&senderId=2&senderName=Peter&receiverName=July&channel=人力媒合
//		//http://localhost:3000/chatroom?receiverId=2&senderId=1&senderName=July&receiverName=Peter&channel=人力媒合
//		
//		//httpservletRquest
//		//HttpSession session = request.getSession();
//		//session.getAttribute("senderId", senderId);取得資料
//		
//		
//		model.addAttribute("senderId", senderId);
//		model.addAttribute("receiverId", receiverId);
//		model.addAttribute("senderName", senderName);
//		model.addAttribute("receiverName", receiverName);
//		model.addAttribute("channel", channel);
//		return "chatroom";
//	}
	
	//從session取資料
	@RequestMapping("/login")
	public String login (Model model, HttpServletRequest request, 
			@RequestParam ("senderId") Integer senderId,
			@RequestParam ("recevierId") Integer recevierId,
			@RequestParam ("senderName") String senderName,
			@RequestParam ("recevierName") String recevierName,
			@RequestParam ("channel") String channel) {
		HttpSession session = request.getSession();
		session.setAttribute("senderId", senderId);
		session.setAttribute("recevierId",  recevierId);
		session.setAttribute("senderName",  senderName);
		session.setAttribute("recevierName", recevierName);
		session.setAttribute("channel", "人力媒合");
			
		Integer senderIdFromSession = (Integer) request.getSession().getAttribute("senderId");
		Integer recevierIdFromSession = (Integer) request.getSession().getAttribute("recevierId");
		String senderNameFromSession = (String) request.getSession().getAttribute("senderName");
		String recevierNameFromSession = (String) request.getSession().getAttribute("recevierName");
		String senderIdFromSessionFromSession = (String) request.getSession().getAttribute("channel");
		System.out.println(senderIdFromSession);
		System.out.println(recevierIdFromSession);
		System.out.println(senderNameFromSession);
		System.out.println(recevierNameFromSession);
		System.out.println(senderIdFromSessionFromSession);
	
		
//		String url = "http://localhost:3000/chatroom?receiverId=" 
//		+ request.getSession().getAttribute("recevierId")
//		 + "&senderId=" + request.getSession().getAttribute("senderId") 
//		 +"&senderName=" + request.getSession().getAttribute("senderName") 
//		 +"&receiverName=" + request.getSession().getAttribute("recevierName")  
//		 + "&channel=" + request.getSession().getAttribute("channel") ;
//		System.out.println(url);
		
		

		model.addAttribute("senderId", request.getSession().getAttribute("senderId"));
		model.addAttribute("receiverId", request.getSession().getAttribute("recevierId"));
		model.addAttribute("senderName", request.getSession().getAttribute("senderName"));
		model.addAttribute("receiverName", request.getSession().getAttribute("recevierName"));
		model.addAttribute("channel", request.getSession().getAttribute("channel"));
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
