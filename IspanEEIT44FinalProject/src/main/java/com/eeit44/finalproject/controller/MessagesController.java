package com.eeit44.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/login")
	public ModelAndView login (ModelAndView mav,HttpServletRequest request, @RequestParam ("companyId") Integer senderId) {
		HttpSession session = request.getSession();
		session.setAttribute("senderId", senderId);

		//Integer senderIdFromSession = (Integer) request.getSession().getAttribute("senderId");
		//System.out.println(senderIdFromSession);
		
		//msgService.queryMessage(senderId);
//		List<Messages> newMessage = msgService.queryMessage(senderId);
		List<Messages> newMessage = msgService.queryLastMessage(senderId);
		
		mav.getModel().put("newMessage", newMessage);  
		mav.setViewName("chat");
		return mav;

	}
	
	
	@PostMapping("/insertMessage")
	@ResponseBody
	public String insertMessage (@RequestBody Messages messages, Model m) {
		Messages newMessage = msgService.insertMessage(messages);
		System.out.println(newMessage);
		return "";
	}

	@GetMapping("/queryMessage/{senderId}")
	@ResponseBody
	public ModelAndView queryMessage (ModelAndView mav, @PathVariable ("senderId") int senderId) {
		
		List<Messages> newMessage = msgService.queryMessage(senderId);
		System.out.println(newMessage);
		
		 
		 mav.getModel().put("newMessage", newMessage);  
			mav.setViewName("chat");
			return mav;
	}
	
	
	@GetMapping("/queryLastMessage/{senderId}")
	@ResponseBody
	public List<Messages> queryLastMessage (@PathVariable ("senderId") int senderId, Model m){
		List<Messages> newMessage = msgService.queryLastMessage(senderId);
		System.out.println(newMessage);
		return newMessage;
	}
	
//	@PostMapping("/uploadfile")
//	@ResponseBody
//	public String proccessUploadAction(HttpServletRequest request, @RequestParam("myFile")MultipartFile mf) throws IllegalStateException, IOException {
//		String fileName = mf.getOriginalFilename();
//		System.out.println("fileName:" + fileName);
//		
//		String saveTempDir = request.getSession().getServletContext().getRealPath("/")+"uploadTempDir\\";
//		File saveTempDirFile = new File(fileName);
//		saveTempDirFile.mkdirs();
//		
//		String saveFilePath = saveTempDir + fileName;
//		File savePathFile = new File(saveFilePath);
//		mf.transferTo(savePathFile);
//		
//		if(fileName!=null && fileName.length()!=0) {
//			fileUpload(fileName, saveFilePath);
//		}
//		
//		return "saveFilePath:"+ saveFilePath;
//	}

	
//	private void saveFile(String fileName, String saveFilePath) {
//		try {
//			FileInputStream is1 = new FileInputStream(saveFilePath);
//			byte[] b = new byte[is1.available()];
//			is1.read(b);
//			is1.close();
//			
//			File comp = new Company(fileName, b);
//			msgService.fileUpload();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
//	}
	
	
	@GetMapping("/deleteMessage/{receiverId}")
	public String deleteMessage(@PathVariable ("receiverId") int receiverId) {
			msgService.deleteMessage(receiverId);
			return "";
	}
			
	
	
	
	
	
}
