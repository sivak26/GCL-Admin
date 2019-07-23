package greencard.admin.account.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	boolean status = false;
	
	Configuration cfg;
	SessionFactory sf;
	Session s;
	Transaction tx;
	
	@Override
	public boolean getUserDetails(User login) {
		
		try {
			cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        	sf = cfg.buildSessionFactory(serviceRegistry);
			s = sf.openSession();
			tx = s.beginTransaction();
			
			Query query = s.getNamedQuery("SQL-findByEmail");
			System.out.println(">>>>>> 1 Query = ");
			
			query.setString("email", login.getEmail());
			
			System.out.println(">>>>>> 2 Query = ");
			
			List<User> user = query.list();
			
			String email = "";
			String password = "";
			
			System.out.println("Email = " + email);
			System.out.println("Password = " + password);
			
			for(User u:user) {
				email = u.getEmail();
				password = u.getPassword();
			}
			
			System.out.println("Email = " + email);
			System.out.println("Password = " + password);
			
			
			
			if(password.equals(login.getPassword()) && email.equals(login.getEmail())) {
				status = true;
			}
			
			tx.commit();
			
		} catch (Exception e) {
			System.out.println("Catch block");
			e.getMessage();
		} finally {
			s.close();
			sf.close();
		}
		
		return status;
	}

}
