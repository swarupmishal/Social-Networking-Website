package com.swarup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swarup.dao.FriendDAO;
import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
import com.swarup.pojo.User;

@Controller
public class SearchController {
	@RequestMapping("/searchByUserName.htm")
	public String search(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
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
		User usr=(User) userSession.getAttribute("user");
		if(usr.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			String usernameToSearch=request.getParameter("lookupMemberName");
			UserDAO userDAO=new UserDAO();
			User u=userDAO.searchUser(usernameToSearch);
			if(usernameToSearch.isEmpty()||u==null||u==(User)request.getSession().getAttribute("user")){
				response.sendRedirect("nullFriend.jsp");
			}
//			FriendDAO friendDAO=new FriendDAO();
//			User user=userDAO.get(usernameToSearch);
//			long personID=u.getPersonID();
//			List friendList=friendDAO.list(personID);
//			if(friendList.contains(arg0));
			request.getSession().setAttribute("searchedUser", u);
			return "searchResults";
		}
		
	}
	
	@RequestMapping("/addContact.htm")
	public String addContact(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
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
		User usr=(User) userSession.getAttribute("user");
		if(usr.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("authorizedUser.jsp");
			return null;
		}
		else
		{
			FriendDAO friendDAO=new FriendDAO();
			User searchedUser=(User) request.getSession().getAttribute("searchedUser");
			String searchedUserName=searchedUser.getUserName();
			User u=(User) request.getSession().getAttribute("user");
			long id=u.getPersonID();
			friendDAO.addFriend(searchedUserName, id);
			return "addContact";
		}
		
	}
	
	
}
