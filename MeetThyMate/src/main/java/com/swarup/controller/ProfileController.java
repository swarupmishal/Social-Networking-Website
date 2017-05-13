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
import com.swarup.pojo.Address;
import com.swarup.pojo.User;

@Controller
public class ProfileController {
	@RequestMapping(value="/profile.htm")
	public String showProfile(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
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
			String memberName="";
			int id=0;
			int lookupType = Integer.parseInt(request.getParameter("type"));
			if (lookupType == 1)
				id = Integer.parseInt(request.getParameter("data"));
			if (lookupType == 2)
			      memberName = request.getParameter("data");
			
			
			UserDAO userDAO=new UserDAO();
			User user=userDAO.get(memberName);
			
			
			request.getSession().setAttribute("user", user);
			return "profile";
		}
		
	}
	
	@RequestMapping("/update.htm")
	public String updateProfile(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
			return "update";
		}
		
		
	}
	
	@RequestMapping("/updateUser.htm")
	public String saveUpdatedProfile(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
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
			UserDAO userDAO=new UserDAO();
			User user=(User) request.getSession().getAttribute("user");
			Address address=user.getAddress();
			String username=user.getUserName();
			String gender=request.getParameter("gender");
			String email=request.getParameter("email").replaceAll("[^\\dA-Za-z@. ]", "").replaceAll("\\s\\s+", " ").trim();
			String phone=request.getParameter("phone").replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s\\s+", " ").trim();;
			int aptNo=Integer.parseInt(request.getParameter("aptNo").replaceAll("[^\\d ]", "").replaceAll("\\s\\s+", " ").trim());
			String street=request.getParameter("street").replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s\\s+", " ").trim();;
			String city=request.getParameter("city").replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s\\s+", " ").trim();;
			String state=request.getParameter("state").replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s\\s+", " ").trim();;
			String country=request.getParameter("country").replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s\\s+", " ").trim();;
			int zip=Integer.parseInt(request.getParameter("zip").replaceAll("[^\\d ]", "").replaceAll("\\s\\s+", " ").trim());
			
			User u=userDAO.updateUser(user, address, username, gender, email, phone, aptNo, street, city, state, country, zip);
			request.getSession().setAttribute("user", u);
			return "userLoggedIn";
		}
		
	}
	
	@RequestMapping("/change.htm")
	public String changeSetting(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
			return "settings";
		}
		
	}
	
	@RequestMapping("/logout.htm")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
	}
	
	@RequestMapping("/loggedin.htm")
	public String home(HttpServletRequest request, HttpServletResponse response) throws AdException, IOException{
		
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
			User user=(User) request.getSession().getAttribute("user");
			String userName=user.getUserName();
			UserDAO userDAO=new UserDAO();
			FriendDAO friendDAO=new FriendDAO();
			User u=userDAO.get(userName);
			long personID=u.getPersonID();
			List friendList=friendDAO.list(personID);
			
			request.getSession().setAttribute("friendList", friendList);
			
			return "userLoggedIn";
		}
		
	}
	
	
	
}
