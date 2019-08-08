package greencard.admin.account.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DBSession {

	Configuration configuration;
	SessionFactory sessionFactory;
	Session session;
	
	public Session getSession() {
		try {
			configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
			session = sessionFactory.openSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}	
	
}
