package com.swarup.controller;

import java.io.IOException;
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
public class FriendController {
	@RequestMapping("/viewContacts.htm")
	public ModelAndView showFriendsList(HttpServletRequest request,HttpServletResponse response) throws AdException, IOException{
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
		if(user.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String userName=request.getParameter("data");
			UserDAO userDAO=new UserDAO();
			FriendDAO friendDAO=new FriendDAO();
			User u=userDAO.get(userName);
			long personID=u.getPersonID();
			List friendList=friendDAO.list(personID);
			ModelAndView mv = new ModelAndView("friendList", "friendList", friendList);
	        return mv;
		}
		
	}
	
	@RequestMapping("/deleteContact.htm")
	public ModelAndView deleteFriend(HttpServletRequest request,HttpServletResponse response) throws AdException, IOException{
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
		if(user.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String[] friendArray= request.getParameterValues("friendList");
			FriendDAO friendDAO=new FriendDAO();
			Friend friend=new Friend();
			int i;
			for(i=0; i<friendArray.length; i++){
				friendDAO.delete(Long.parseLong(friendArray[i]));
			}
			ModelAndView mv=new ModelAndView("deleteFriend","noOfDeletedFriends",i);
	        return mv;
		}
		
	}
}
