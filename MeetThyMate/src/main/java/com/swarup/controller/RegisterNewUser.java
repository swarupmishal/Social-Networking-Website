package com.swarup.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.swarup.dao.UserDAO;
import com.swarup.exception.AdException;
//import com.swarup.pojo.Address;
import com.swarup.pojo.User;


@Controller
//public class RegisterNewUser implements ServletContextAware{
public class RegisterNewUser extends SimpleFormController{
//	private ServletContext servletContext;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping("/register.htm")
	public String initializeRegistrationForm(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request,HttpServletResponse response) throws IOException{
		
			return "register01";
		
		
	}
	

	
	@RequestMapping("/register02.htm")
	public String formStep3(@ModelAttribute("user")User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, AdException{
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "register01";
		}
		
		UserDAO userDAO=new UserDAO();
		Boolean flag=userDAO.doesUsernameExists(user.getUserName());
		if(flag==false){
			try {
				Email email = new SimpleEmail();
				email.setHostName("smtp.googlemail.com");
				email.setSmtpPort(465);
				email.setAuthenticator(new DefaultAuthenticator("meetthymate@gmail.com", "meetthymate12"));
				email.setSSL(true);
				email.setFrom("meetthymate@gmail.com");
				email.setSubject("Registration Successful");
				email.setMsg("Username: "+user.getUserName()+"\nPassword: "+user.getUserPassword());
				email.addTo(user.getEmail());
				email.send();
				
				System.out.println("test");
				UserDAO userDao = new UserDAO();
				System.out.println("test1");
				
				String path="C:\\Users\\Swarup\\Documents\\workspace-sts-3.7.3.RELEASE\\MeetThyMate\\src\\main\\webapp\\images";
//				String path1=servletContext.getRealPath("/");
//				System.out.println(path1);
//				String path1=getServletContext().getRealPath("");
//				System.out.println(path1);
				if(user.getProfilePic()!=null){
					String fileNameWithExt = user.getProfilePic().getOriginalFilename();
					File file=new File(path+fileNameWithExt);
					user.getProfilePic().transferTo(file);
					
					user.setPhotoName("images/"+fileNameWithExt);
				}

				userDao.create(user.getUserName(), user.getUserPassword(), user.getFirstName(), user.getLastName(), user.getGender(), user.getEmail(), user.getPhone(), user.getAddress().getStreet(), user.getAddress().getAptNo(), user.getAddress().getCity(), user.getAddress().getState(), user.getAddress().getState(),user.getAddress().getZip(), user.getPhotoName());
				
				// DAO.close();
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
			response.sendRedirect("index.jsp");
			return null;
		}
		else{
			response.sendRedirect("userNameAlreadyExists.jsp");
			return null;
		}
		
		
		
	}



//	@Override
//	public void setServletContext(ServletContext servletContext) {
//		// TODO Auto-generated method stub
//		this.servletContext=servletContext;
//		
//	}
	

		
}
