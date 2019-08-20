package greencard.admin.account.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.utils.DBSession;

@Repository
public class CustomerServiceDAOImpl implements CustomerServiceDAO {
	
	@Autowired
	DBSession dbSession;
	
	CustomerRegistration customerRegistration;
	CustomerContact customerContact;

	@Override
	public CustomerRegistration getRegistration(String accountId) {
		Session session = null;
		Transaction transaction;
		
		try {
			
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			int userId = Integer.parseInt(accountId);
			
			Query query = session.getNamedQuery("findByAccountId");
			query.setInteger("accountId", userId);
			
			List list = query.list();
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				customerRegistration = (CustomerRegistration) iterator.next();
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return customerRegistration;
	}
	
	@Override
	public int deleteByAccountId(String customerId, String emailId) {
		System.out.println("Database - Deleting...");
		int status = 0;
		
		Session session = null;
		Transaction transaction;
		
		try {
			
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			int userId = Integer.parseInt(customerId);
			
			Query query = session.getNamedQuery("deleteByAccountId");
			query.setString("emailId", emailId);
			query.setInteger("accountId", userId);
			
			status = query.executeUpdate();
			System.out.println("Status is = " + status);
			
			transaction.commit();
			System.out.println("Status is 1 = " + status);
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return status;
	}
	
	@Override
	public int skipAccount(String customerId) {
		
		System.out.println("Database - Skiping...");
		int status = 0;
		
		Session session = null;
		Transaction transaction;
		
		try {
			
			 Date date= new Date();
			 long time = date.getTime();
			 Timestamp ts = new Timestamp(time);
			
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			int userId = Integer.parseInt(customerId);
			
			Query query = session.getNamedQuery("skipAccount");
			query.setInteger("customerId", userId);
			query.setTimestamp("updatedDate", ts);
			
			status = query.executeUpdate();
			System.out.println("Status is = " + status);
			
			transaction.commit();
			System.out.println("Status is 1 = " + status);
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return status;
	}
	
	@Override
	public CustomerContact getContact(String accountId) {
		Session session = null;
		Transaction transaction;
		int userId = 0;
		
		try {
			System.out.println("Contact DAO Called ...");
			
			session = dbSession.getSession();
			
			transaction = session.beginTransaction();
			
			userId = Integer.parseInt(accountId);
			System.out.println("UserId =" + userId);
			
			Query query = session.getNamedQuery("findByuserId");
			query.setInteger("accountId", userId);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				customerContact = (CustomerContact) iterator.next();
				
			}
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error contact with database ...");
			e.getMessage();
			
		} finally {
			session.close();
		}
		return customerContact;
	}

}
