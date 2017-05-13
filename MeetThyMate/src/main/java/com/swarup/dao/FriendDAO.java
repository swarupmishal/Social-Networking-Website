package com.swarup.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.swarup.exception.AdException;
import com.swarup.pojo.Address;
import com.swarup.pojo.Friend;
import com.swarup.pojo.User;

public class FriendDAO extends DAO{
	public FriendDAO() {
    }
	
	public void addFriend(String username, long id)
            throws AdException {
		try{
			begin();
			Friend friend=new Friend();
			friend.setFriendUserName(username);
			friend.setPersonID(id);
			
			getSession().save(friend);			
			commit();
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
	
	
	public List list(long personID) throws AdException {
		List list;
		try {
            begin();
            Query q = getSession().createQuery("from Friend where personID = :personID");
            q.setLong("personID", personID);
            list = q.list();
            commit();
            
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Friends", e);
        }
        finally{
        	close();
        }
        return list;
    }
	
	public void delete(Long id) throws AdException {
        try {
            begin();
            
            Query q = getSession().createQuery("from Friend where friendID = :friendID");
            q.setLong("friendID", id);
            Friend friend = (Friend) q.uniqueResult();
            getSession().delete(friend);
            commit();
        } catch (HibernateException e) {
            rollback();
			throw new AdException("Could not delete Friend ", e);
        }
        finally{
        	close();
        }
    }
}
