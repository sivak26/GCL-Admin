package greencard.admin.account.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;
import greencard.admin.account.utils.DBSession;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	@Autowired
	DBSession dbSession;
	
	User user;
	
	public void save(User user) {
		Session session = null;
		Transaction transaction;
		try {
			
			session = dbSession.getSession();
			
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
			
			session = dbSession.getSession();
			
			transaction = session.beginTransaction();
			
			Query query = session.getNamedQuery("SQL_findByUserId");
			query.setInteger("userId", agclid);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				user = (User) iterator.next();
			}
			
			transaction.commit();
			
			
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
			
			session = dbSession.getSession();
			
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("HQL_findByEmailId");
			query.setString("email", email);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				user = (User) iterator.next();
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
