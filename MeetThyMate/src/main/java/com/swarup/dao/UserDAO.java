package com.swarup.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.multipart.MultipartFile;

import com.swarup.exception.AdException;
import com.swarup.pojo.Address;
//import com.swarup.pojo.Address;
import com.swarup.pojo.User;

public class UserDAO extends DAO{
	public UserDAO() {
    }
	
	public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
        finally{
        	close();
        }
    }
	
	public User create(String userName, String password, String firstName, String lastName, String gender, String email, String phone, String street, int aptNo, String city, String country, String state, int zip, String photoName) throws AdException{
		try{
			begin();
			User user=new User();
			Address address=new Address();
			user.setUserName(userName);
			user.setUserPassword(password);
			user.setFirstName(firstName);
			user.setGender(gender);
			user.setAddress(address);			
			user.setLastName(lastName);
			user.setRole("user");
			user.setEmail(email);
			user.setPhone(phone);
			user.setPhotoName(photoName);
			address.setAptNo(aptNo);
			address.setCity(city);
			address.setCountry(country);
			address.setState(state);
			address.setStreet(street);
			address.setZip(zip);
//			address.setUser(user);
//			photo.setPhotoName(profilePic);
			
			getSession().save(address);
			getSession().save(user);
			
			commit();
			
			
			return user;
		}
		catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
		finally{
        	close();
        }
	}
		public void delete(User user) throws AdException {
	        try {
	            begin();
	            getSession().delete(user);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete user " + user.getFirstName(), e);
	        }
	        finally{
	        	close();
	        }
	    }
		
		public User validateUser(String uname, String pwd) throws AdException{
			try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :username");
	            q.setString("username", uname);
	            User user = (User) q.uniqueResult();
	            if(user.getUserPassword().equals(pwd)){
	            	commit();
		            return user;
	            }
	     
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + uname, e);
	        }
			return null;
		}
		
		public User updateUser(User user, Address address, String username, String gender, String email, String phone, int aptNo, String street, String city, String state, String country, int zip) throws AdException{
			try{
				begin();
				String hql="UPDATE User set gender = :gender, email = :email,  phone = :phone where userName = :username";
				Query query=getSession().createQuery(hql);
				query.setParameter("gender", gender);
				query.setParameter("email", email);
				query.setParameter("phone", phone);
				query.setParameter("username", username);
				int result=query.executeUpdate();
				commit();
				System.out.println("Rows affected for user: "+result);
			}catch (HibernateException e){
	            rollback();
	            throw new AdException("Could not update user " + username, e);
	        }
			
			try{
				begin();
				long id= address.getAddressID();
				String hql="UPDATE Address set aptNo = :aptNo, street = :street, city = :city, state = :state, country = :country, zip = :zip where addressID = :id";
				Query query=getSession().createQuery(hql);
				query.setParameter("aptNo", aptNo);
				query.setParameter("street", street);
				query.setParameter("city", city);
				query.setParameter("state", state);
				query.setParameter("country", country);
				query.setParameter("zip", zip);
				query.setParameter("id", id);
				int result=query.executeUpdate();
				commit();
				System.out.println("Rows affected for Address: "+result);
			}catch (HibernateException e){
	            rollback();
	            throw new AdException("Could not update Address " + address.getAddressID(), e);
	        }
			finally{
	        	close();
	        }
			
			return user;
			
		}
		
		public void changePassword(String userName, String password) throws AdException{
			try{
				begin();
				String hql="UPDATE User set userPassword = :password where userName = :username";
				Query query=getSession().createQuery(hql);
				query.setParameter("username", userName);
				query.setParameter("password", password);
				int result=query.executeUpdate();
				commit();
				System.out.println("Rows affected for userPassword of User: "+result);
			}catch (HibernateException e){
	            rollback();
	            throw new AdException("Could not update userPassword for User " + userName, e);
	        }
			finally{
	        	close();
	        }
		}
		

		
		public User searchUser(String usernameToSearch) throws AdException{
			try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :username");
	            q.setString("username", usernameToSearch);
	            User user = (User) q.uniqueResult();
	            commit();
	            return user;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + usernameToSearch, e);
	        }
			finally{
	        	close();
	        }
		}
		
		public void deleteFriends(User user) throws AdException{
			try {
	            begin();
	            
	            Query q = getSession().createQuery("DELETE from Friend where personID = :personID");
	            q.setLong("personID", user.getPersonID());
	            int result=q.executeUpdate();
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not delete friends of user " + user.getUserName(), e);
	        }
			finally{
	        	close();
	        }
		}
		
		public List giveAllUsers() throws AdException{
			List list;
			try {
	            begin();
	            Query q = getSession().createQuery("from User");
	            list = q.list();
	            commit();
	            
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the Messages", e);
	        }
	        finally{
	        	close();
	        }
			return list;
		}
		
		public boolean isValidUser(String username,String password) throws AdException{
			try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
	            if(user.getUserPassword().equals(password)){
		            return true;
	            }
	            else{
	            	return false;
	            }
	     
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + username, e);
	        }
			
		}
		
		public boolean doesUsernameExists(String username) throws AdException{
			
			try {
	            begin();
	            Query q = getSession().createQuery("from User where userName = :username");
	            q.setString("username", username);
	            User user = (User) q.uniqueResult();
	            if(user==null){
		            return false;
	            }
	            else{
	            	return true;
	            }
	     
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not get user " + username, e);
	        }
		}
	}
