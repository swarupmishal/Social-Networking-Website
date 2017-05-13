package com.swarup.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.swarup.exception.AdException;
import com.swarup.pojo.Message;
import com.swarup.pojo.User;

public class MessageDAO extends DAO {

	public MessageDAO() {
	}
	
	public Message get(long messageID)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Message where messageID = :messageID");
            q.setLong("messageID", messageID);
            Message message = (Message) q.uniqueResult();
            commit();
            return message;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get message " + messageID, e);
        }
        finally{
        	close();
        }
    }

	public void addMessage(String message, String sender, String receiver) throws AdException {
		try {
			begin();
			Message message2 = new Message();
			message2.setMessage(message);
			message2.setSender(sender);
			message2.setReceiver(receiver);
			getSession().save(message2);
			commit();
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating message: " + e.getMessage());
		} finally {
			close();
		}
	}
	
	public List list(String username) throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Message where receiver = :receiver");
            q.setString("receiver", username);
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Messages", e);
        }
        finally{
        	close();
        }
    }
	
	public void delete(Message message) throws AdException {
        try {
            begin();
            getSession().delete(message);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete message " + message, e);
        }
        finally{
        	close();
        }
    }
}
