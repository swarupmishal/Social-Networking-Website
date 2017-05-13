package com.swarup.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
import com.swarup.pojo.User;

@Controller
public class SettingsController {
	
	@RequestMapping("/changePassword.htm")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		HttpSession userSession = request.getSession(false);
		if(userSession==null){
			response.sendRedirect("index.jsp");
		}
		Object object=userSession.getAttribute("user");
		if(object==null){
			response.sendRedirect("index.jsp");
		}
		User u=(User) userSession.getAttribute("user");
		if(u.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
		}
		else
		{
			response.setContentType("text/plain");
			String password=request.getParameter("password");
			UserDAO userDAO=new UserDAO();
			User user=(User) request.getSession().getAttribute("user");
			String userName=user.getUserName();
			userDAO.changePassword(userName, password);
			PrintWriter out=response.getWriter();
			out.print("Password updated successfully for User "+userName);
		}
		
	}
	
//	@RequestMapping("/deleteAccount.htm")
//	public ModelAndView deleteAccount(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
//		HttpSession userSession = request.getSession(false);
//		if(userSession==null){
//			response.sendRedirect("index.jsp");
//			return null;
//		}
//		Object object=userSession.getAttribute("user");
//		if(object==null){
//			response.sendRedirect("index.jsp");
//			return null;
//		}
//		else
//		{
//			User user=(User) request.getSession().getAttribute("user");
//			UserDAO userDAO=new UserDAO();
//			userDAO.deleteFriends(user);
//			userDAO.delete(user);
////			response.sendRedirect("index.jsp");
//			ModelAndView mv=new ModelAndView();
//			mv.setViewName("index");
//			return mv;
//		}
//		
//	}
}
