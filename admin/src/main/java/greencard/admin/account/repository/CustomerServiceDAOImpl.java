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

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;
import greencard.admin.account.utils.DBSession;

@Repository
public class CustomerServiceDAOImpl implements CustomerServiceDAO {
	
	@Autowired
	DBSession dbSession;
	
	CustomerRegistration customerRegistration;
	CustomerApplication customerApplication;
	CustomerContact customerContact;
	Applicant applicant;
	SkipSubmission skipSubmission;
	CustomerPhotograph customerPhotograph;

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
	public CustomerApplication getApplication(String accountId) {
		System.out.println("DAO - Get Application called...");
		
		Session session = null;
		Transaction transaction;
		
		try {
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			
			int userId = Integer.parseInt(accountId);
			
			Query query = session.getNamedQuery("application_findByAccountId");
			query.setInteger("accountId", userId);
			
			List list = query.list();
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				customerApplication = (CustomerApplication) iterator.next();	
			}
			
			transaction.commit();
			} catch (Exception e) {
				System.out.println("Error while connecting Database...");
				e.printStackTrace();
			} finally {
				if (session != null) {
					session.close();
				}
			}
		System.out.println(customerApplication.getApplicationTakenBy());
		return customerApplication;
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
	public int skipAccount(SkipSubmission skipSubmission) {
		
		System.out.println("Database - Skiping...");
		int status = 0;
		Session session = null;
		Transaction transaction;
		
		try {
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			
			session.persist(skipSubmission);
			transaction.commit();
			System.out.println(" >>>>>>>> Status is >>>>>>> = " + status);
			
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
	public SkipSubmission verifySkipStatus(int userId) {
		System.out.println("Checking account skiped or not ...");
		
		Session session = null;
		Transaction transaction;
		
		try {
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("verifySkipByUserId");
			query.setInteger("userId", userId);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				skipSubmission = (SkipSubmission) iterator.next();
			}
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Database error ...");
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return skipSubmission;
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
	
	@Override
	public Applicant getApplicant(int applicationId) {
		
		Session session = null;
		Transaction transaction;
		
		try {
			System.out.println("Applicant DAO Called ...");
			
			session = dbSession.getSession();
			
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("findByApplicationId");
			query.setInteger("applicationId", applicationId);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			System.out.println("==========" + query.list());
			while (iterator.hasNext()) {
				applicant = (Applicant) iterator.next();
				
			}
			System.out.println("<>>>>>>>>>>>>>>>> DateOfBirth = " + applicant.getDateOfBirth());
			
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error contact with database ...");
			e.getMessage();
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return applicant;
	}
	
	@Override
	public CustomerPhotograph getPhotograph(int userId) {
		System.out.println("PhotoGraphs details ...");
		
		Session session = null;
		Transaction transaction;
		
		try {
			session = dbSession.getSession();
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("Photo_findByAccountId");
			query.setInteger("userId", userId);
			
			List list = query.list();
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				customerPhotograph = (CustomerPhotograph) iterator.next();
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			System.out.println("Database error ...");
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return customerPhotograph;
	}

}
