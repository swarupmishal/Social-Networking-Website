package com.swarup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swarup.dao.MessageDAO;
import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
import com.swarup.pojo.Message;
import com.swarup.pojo.User;

@Controller
public class MessageController {
	@RequestMapping("/sendMessage.htm")
	public String sendMessage(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			
			MessageDAO messageDAO=new MessageDAO();
			String message=request.getParameter("message");
			String receiver=request.getParameter("friend");
			if(message.isEmpty()||receiver.isEmpty()){
				response.sendRedirect("nullMessage.jsp");
			}
			
			User user=(User) request.getSession().getAttribute("user");
			String sender=user.getUserName();
			messageDAO.addMessage(message, sender, receiver);
			return "messageSent";
		}
		
	}
	
	@RequestMapping("/message.htm")
	public ModelAndView showMessages(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String username=request.getParameter("data");
			MessageDAO messageDAO=new MessageDAO();
			List messageList=messageDAO.list(username);
			ModelAndView mv=new ModelAndView("showMessages", "messageList", messageList);
			return mv;
		}
		
	}
	
	@RequestMapping("/reply.htm")
	public ModelAndView replyToMessage(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			MessageDAO messageDAO=new MessageDAO();
			User user=(User) request.getSession().getAttribute("user");
			long messageID=Long.parseLong(request.getParameter("replyID"));
			Message message=messageDAO.get(messageID);
			String receiver=message.getSender();
			String sender=user.getUserName();
			ModelAndView mv=new ModelAndView();
			mv.addObject("sender",sender);
			mv.addObject("receiver",receiver);
			mv.setViewName("replyToMessage");
			return mv;
		}
		
	}
	
	@RequestMapping("/replyMessageTo.htm")
	public String sendReply(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String sender=request.getParameter("sender");
			String receiver=request.getParameter("receiver");
			String message=request.getParameter("message");
			MessageDAO messageDAO=new MessageDAO();
			messageDAO.addMessage(message, sender, receiver);
			return "messageSent";
		}
		
	}
	
	@RequestMapping("/deleteMessage.htm")
	public String deleteMessage(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
			return null;
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			MessageDAO messageDAO=new MessageDAO();
			long messageID=Long.parseLong(request.getParameter("deleteID"));
			Message message=messageDAO.get(messageID);
			messageDAO.delete(message);
			return "messageDeleted";
		}
		
	}
}
