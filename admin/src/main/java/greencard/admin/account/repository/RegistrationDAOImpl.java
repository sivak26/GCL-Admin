package greencard.admin.account.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;
import greencard.admin.account.utils.DBConnection;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	@Autowired
	DBConnection dbconnection;
	

	User user;
	
	public void save(User user) {
		Session session = null;
		Transaction transaction;
		try {
			
			session = dbconnection.getSession();
			
			transaction = session.beginTransaction();
			session.persist(user);
			transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public User findByUserID(int agclid) {
		
		Session session = null;
		Transaction transaction;
		
		try {
			
			session = dbconnection.getSession();
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("findByUserID");
			query.setInteger("userId", agclid);
			
			List list = query.list();
			
			Iterator it = list.iterator();
			
			while (it.hasNext()) {
				System.out.println("Query from Database...");
				System.out.println(it.next());
				user = (User) it.next();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();	
			}
		}
		
		return user;
	}
	
	@Override
	public User findByEmailID(String email) {
		
		Session session = null;
		Transaction transaction;
		
		try {
			
			session = dbconnection.getSession();
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("findByEmailId");
			query.setString("email", email);
			
			List list = query.list();
			
			Iterator itr = list.iterator();
			
			while (itr.hasNext()) {
				user = (User) itr.next();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
		return user;
	}
}
