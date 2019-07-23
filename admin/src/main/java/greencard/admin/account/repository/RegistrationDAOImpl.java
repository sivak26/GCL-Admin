package greencard.admin.account.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {
	
	@SuppressWarnings("deprecation")
	public void save(User user) {
		Configuration cfg;
		SessionFactory sf = null;
		Session session = null;
		Transaction t = null;
		try {
			cfg = new Configuration();
			sf = cfg.configure().buildSessionFactory();
			session = sf.openSession();
			t = session.beginTransaction();
//			session.save(user);
			session.persist(user);
			t.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			System.out.println("FINALLY...");
		}
	}
}
