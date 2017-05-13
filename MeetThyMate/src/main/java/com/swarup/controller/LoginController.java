package com.swarup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
import com.swarup.pojo.User;

@Controller
public class LoginController{
	
//	@RequestMapping(value="/login.htm")
//	public String validateLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, AdException{
//		User u=new User();
//		String userName = request.getParameter("user");
//		System.out.println(userName);
//		String userPassword = request.getParameter("password");
//		System.out.println(userPassword);
//		if (userName == null)
//			throw new RuntimeException("No user name was specified");
//			
//		userName = userName.trim();
//		
//		if (userName.equals(""))
//			throw new RuntimeException("User name cannot be blank");
//
//		if (userPassword == null)
//			throw new RuntimeException("No password was specified");
//			
//		userPassword = userPassword.trim();
//		
//		if (userPassword.equals(""))
//        throw new RuntimeException("Password cannot be blank");
//		
//		try {
//			System.out.print("test");
//			UserDAO userDao = new UserDAO();
//			System.out.print("test1");
//
//			u=userDao.validateUser(userName, userPassword);
//			
//			// DAO.close();
//		} catch (Exception e) {
//			System.out.println("Exception: " + e.getMessage());
//		}
//		if(u==null){
//			request.setAttribute("loginError", true);
//			response.sendRedirect("index.jsp");
//		}
//		else{
//			if(u.getUserName().equalsIgnoreCase("admin")){
//				request.getSession().setAttribute("user", u);
//				UserDAO userDAO=new UserDAO();
//				List<User> accountList=new ArrayList<User>();
//				accountList=userDAO.giveAllUsers();
//				request.getSession().setAttribute("accountList", accountList);
//				return "adminPage";
//				
//			}
//			else{
//				request.getSession().setAttribute("user", u);
//				return "userLoggedIn";
//			}
//		}
//		return null;
//	}
	
	@RequestMapping(value="/login.htm")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, AdException{
		response.setContentType("text/plain");
		String userName = request.getParameter("user");
		System.out.println(userName);
		String userPassword = request.getParameter("password");
		System.out.println(userPassword);
		User u=new User();
		UserDAO userDao = new UserDAO();
		boolean flag=false;
		try {
			
			flag=userDao.isValidUser(userName, userPassword);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		if(flag==false){
			PrintWriter out=response.getWriter();
			out.print("Wrong credentials! Please login with proper credentials!!!");
		}
		else{
			u=userDao.validateUser(userName, userPassword);
			HttpSession userSession = request.getSession();
			userSession.setAttribute("user",u);
		}
		
	}
	
	@RequestMapping("/userLoggedIn.htm")
	public String enterApplication(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
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
		else
		{
			User u=(User) request.getSession().getAttribute("user");
			
			if(u.getUserName().equalsIgnoreCase("admin")){
				request.getSession().setAttribute("user", u);
				UserDAO userDAO=new UserDAO();
				List<User> accountList=new ArrayList<User>();
				accountList=userDAO.giveAllUsers();
				request.getSession().setAttribute("accountList", accountList);
				return "adminPage";
				
			}
			else{
				request.getSession().setAttribute("user", u);
				Cookie cookieUserName=new Cookie("cookieUserName",u.getUserName());
				response.addCookie(cookieUserName);
				return "userLoggedIn";
			}
			
		}
		
		
	}
	
	@RequestMapping("/goToIndex.htm")
	public void goToIndexPage(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		response.sendRedirect("index.jsp");
	}
}
