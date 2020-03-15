package greencard.admin.account.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.Agent;
import greencard.admin.account.utils.DBSession;

@Repository
public class AgentDAOImpl implements AgentDAO {
	
	@Autowired
	DBSession dbSession;
	
	Agent user;
	
	public void save(Agent user) {
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
	public Agent findByUserID(int agclid) {
		
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
				user = (Agent) iterator.next();
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
	public Agent findByEmailID(String email) {
		
		System.out.println("DB .................... " + email);
		
		Session session = null;
		Transaction transaction;
		user = null;
		
		try {
			
			session = dbSession.getSession();
			
			transaction = session.beginTransaction();
			Query query = session.getNamedQuery("HQL_findByEmailId");
			query.setString("email", email);
			
			List list = query.list();
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()) {
				user = (Agent) iterator.next();
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
