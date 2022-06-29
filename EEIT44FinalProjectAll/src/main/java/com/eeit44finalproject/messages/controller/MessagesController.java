package com.eeit44finalproject.messages.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eeit44finalproject.messages.model.Messages;
import com.eeit44finalproject.messages.service.MessagesService;

//MessageController

@Controller
public class MessagesController {

	@Autowired
	private MessagesService msgService;
	
	
//-----------------Admin---------------Admin---------------Admin---------------Admin---------------Admin--------------//
	
	// localhost:8080/login跳轉至帶全部訊息之畫面
	@GetMapping("/loginAndViewAllMessagesAdmin")
	public ModelAndView loginAdmin(ModelAndView mav, Model model, HttpServletRequest request,
			@RequestParam("userId") String userId, @RequestParam("password") String password,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {

		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("password", password);

		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");

		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password", passwordFromSession);

		Page<Messages> page = msgService.findAllMessageByPageAdmin(pageNumber);
		mav.getModel().put("page", page);
		mav.setViewName("chatPageAdmin");
		return mav;
	}

	// localhost:8080/queryAllMessages 可察看全部訊息
	@GetMapping("/queryAllMessagesAdmin")
	@ResponseBody
	public ModelAndView queryAllMessagesAdmin(Model model, ModelAndView mav, HttpServletRequest request) {
		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");

		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password", passwordFromSession);

		List<Messages> newMessage = msgService.queryAllMessagesAdmin();
		System.out.println(newMessage);

		mav.getModel().put("newMessage", newMessage);
		mav.setViewName("chatPageAdmin");
		return mav;

	}

	@GetMapping("/queryGroupMessageAdmin")
	public String QueryMessageBySenderIdAndRecevierIdAdmin(Model model, @RequestParam("senderId") String senderId,
			@RequestParam("receiverId") String receiverId) {

		List<Messages> groupMessage = msgService.findChatMessageBySenderIdAndRecevierIdAdmin(senderId, receiverId);
		System.out.println("XXXXX");
		System.out.println(groupMessage);

		model.addAttribute("groupMessage", groupMessage);
		return "queryMessagePageAdmin";
	}

	@GetMapping("/deleteMessageAdmin")
	public String deleteByMessageIdAdmin(@RequestParam("messageId") String messageId) {
		msgService.deleteByMessageIdAdmin(messageId);
		return "redirect:/queryAllMessages";
	}

	@GetMapping("/deleteMessageByGroupAdmin")
	public String deleteMessageByGroupAdmin(
			Model model, 
			HttpServletRequest request,
			@RequestParam(value = "senderId") String senderId, 
			@RequestParam(value = "receiverId") String receiverId,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {

		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");

		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password", passwordFromSession);

		msgService.deletedChatMessageBySenderIdAndRecevierIdAdmin(senderId, receiverId);
		

//		Page<Messages> page = msgService.findAllMessageByPageAdmin(pageNumber);
//		mav.getModel().put("page", page);
//		mav.setViewName("deletePageAdmin");
//		return mav;
		List<Messages> groupMessage = msgService.findChatMessageBySenderIdAndRecevierIdAdmin(senderId, receiverId);
		System.out.println("XXXXX");
		System.out.println(groupMessage);

		model.addAttribute("groupMessage", groupMessage);
		return "queryMessagePageAdmin";
		
	}
	
//---------------Company/Student-------------Company/Student--------------Company/Student--------------Company/Student--------------//	

	
	// localhost:8080/login跳轉至帶全部訊息之畫面
	@GetMapping("/loginAndViewAllMessagesCompany")
	public ModelAndView login(ModelAndView mav, Model model, HttpServletRequest request,
			@RequestParam("userId") String userId, @RequestParam("password") String password,
			@RequestParam(name = "p", defaultValue = "1") Integer pageNumber) {

		HttpSession session = request.getSession();
		session.setAttribute("userId", userId);
		session.setAttribute("password", password);

		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		String passwordFromSession = (String) request.getSession().getAttribute("password");

		System.out.println(userIdFromSession);
		System.out.println(passwordFromSession);

		model.addAttribute("userId", userIdFromSession);
		model.addAttribute("password", passwordFromSession);

		List<Messages> newMessage = msgService.queryAllMessagesCompany((String) request.getSession().getAttribute("userId"));
		System.out.println(newMessage);

		mav.getModel().put("newMessage", newMessage);
		mav.setViewName("chatPageCompany");
		return mav;

	}

	@GetMapping("/queryGroupMessageCompany")
	public String QueryMessageByRecevierId(Model model, HttpServletRequest request,
			@RequestParam("senderId") String senderId, @RequestParam("receiverId") String receiverId) {

		List<Messages> groupMessage = msgService
				.findChatMessageByRecevierIdCompany((String) request.getSession().getAttribute("userId"), receiverId);
		System.out.println("XXXXX");
		System.out.println(groupMessage);

		model.addAttribute("groupMessage", groupMessage);
		return "queryMessagePageCompany";
	}

	@GetMapping("/deleteMessageByGroupCompany/{receiverId}/{senderId}")
	public ModelAndView deleteMessageByGroup(ModelAndView mav, HttpServletRequest request,
			@PathVariable(value = "senderId") String senderId, @PathVariable(value = "receiverId") String receiverId) {

		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		System.out.println("m"+userIdFromSession);
		System.out.println("k"+receiverId);

		msgService.deletedChatMessageByRecevierIdCompany(userIdFromSession, receiverId);

		List<Messages> newMessage = msgService.queryAllMessagesCompany(userIdFromSession);
		System.out.println(newMessage);

		mav.getModel().put("newMessage", newMessage);
		mav.setViewName("chatPageCompany");
		return mav;

	}

	//-----------------Admin---------------Admin---------------Admin---------------Admin---------------Admin--------------//
	
	
}
