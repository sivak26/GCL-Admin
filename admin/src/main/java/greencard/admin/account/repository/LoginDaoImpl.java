package greencard.admin.account.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	boolean status = false;
	
	Configuration cfg = null;
	SessionFactory sf = null;
	Session s = null;
	
	@Override
	public boolean getUserDetails(User login) {
		
		try {
			System.out.println("Try block");
			
			cfg = new Configuration();
			sf = cfg.configure().buildSessionFactory();
			s = sf.openSession();
			System.out.println("IN>>.....");			
			String hql = "from Admin where userId = 2";
			System.out.println(">>>>>>>>>>>>>>" + hql);
			Query q = s.createQuery(hql);
			System.out.println("Query ==== " + q);
			int i = q.executeUpdate();			
			System.out.println("++++++++++++++++"+i);
			
			//User user = (User) s.get(User.class, 1);
		
//			System.out.println("Database email" + user.getEmail());
//			System.out.println("Database password" + user.getPassword());
//			
//			System.out.println("password" + login.getPassword());
//				
//			if(user.getPassword().equals(login.getPassword())) {
//				status = true;
//			}
			
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
