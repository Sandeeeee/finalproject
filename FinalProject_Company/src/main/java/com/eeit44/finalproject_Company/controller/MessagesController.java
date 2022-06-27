package com.eeit44.finalproject_Company.controller;

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

import com.eeit44.finalproject_Company.model.Messages;
import com.eeit44.finalproject_Company.service.MessagesService;

//MessageController

@Controller
public class MessagesController {

	@Autowired
	private MessagesService msgService;

	// localhost:8080/login跳轉至帶全部訊息之畫面
	@GetMapping("/loginAndViewAllMessages")
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

		List<Messages> newMessage = msgService.queryAllMessages((String) request.getSession().getAttribute("userId"));
		System.out.println(newMessage);

		mav.getModel().put("newMessage", newMessage);
		mav.setViewName("chatPageCompany");
		return mav;

	}

	@GetMapping("/queryGroupMessage")
	public String QueryMessageByRecevierId(Model model, HttpServletRequest request,
			@RequestParam("senderId") String senderId, @RequestParam("receiverId") String receiverId) {

		List<Messages> groupMessage = msgService
				.findChatMessageByRecevierId((String) request.getSession().getAttribute("userId"), receiverId);
		System.out.println("XXXXX");
		System.out.println(groupMessage);

		model.addAttribute("groupMessage", groupMessage);
		return "queryMessagePageCompany";
	}

	@GetMapping("/deleteMessageByGroup/{receiverId}/{senderId}")
	public ModelAndView deleteMessageByGroup(ModelAndView mav, HttpServletRequest request,
			@PathVariable(value = "senderId") String senderId, @PathVariable(value = "receiverId") String receiverId) {

		String userIdFromSession = (String) request.getSession().getAttribute("userId");
		System.out.println("m"+userIdFromSession);
		System.out.println("k"+receiverId);

		msgService.deletedChatMessageByRecevierId(userIdFromSession, receiverId);

		List<Messages> newMessage = msgService.queryAllMessages(userIdFromSession);
		System.out.println(newMessage);

		mav.getModel().put("newMessage", newMessage);
		mav.setViewName("chatPageCompany");
		return mav;

	}

}
