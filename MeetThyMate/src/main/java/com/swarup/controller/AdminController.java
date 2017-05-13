package com.swarup.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swarup.dao.FriendDAO;
import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
import com.swarup.pojo.Friend;
import com.swarup.pojo.User;

@Controller
public class AdminController {

	@RequestMapping("/adminPage.htm")
	public String showAdminPage(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		//Object object=request.getSession().getAttribute("user");
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
		User user=(User) userSession.getAttribute("user");
		if(!user.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
		UserDAO userDAO=new UserDAO();
		List<User> accountList=new ArrayList<User>();
		accountList=userDAO.giveAllUsers();
		request.getSession().setAttribute("accountList", accountList);
		return "adminPage";
	}
	}
	@RequestMapping("/deleteAccounts.htm")
	public ModelAndView deleteSelectedAccounts(HttpServletRequest request,HttpServletResponse response) throws AdException, IOException{
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
		User user=(User) userSession.getAttribute("user");
		if(!user.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String[] accountArray= request.getParameterValues("username");
			UserDAO userDAO=new UserDAO();
			
			int i;
			for(i=0; i<accountArray.length; i++){
				User u=userDAO.get(accountArray[i]);
				userDAO.delete(u);
			}
			ModelAndView mv=new ModelAndView("accountDeleted","noOfDeletedAccounts",i);
	        return mv;
		}
		
	}
}
