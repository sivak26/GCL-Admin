package greencard.admin.account.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.User;
import greencard.admin.account.utils.DBConnection;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	DBConnection dbconnection;
	
	boolean status = false;
	Session session = null;
	Transaction transaction;
	User user;
	
	@Override
	public boolean getUserDetails(User login) {
		
		try {
			
			session = dbconnection.getSession();
			
			transaction = session.beginTransaction();

			Query query = session.getNamedQuery("SQL-findByEmail");
			
			query.setString("email", login.getEmail());
			
			List<User> user = query.list();
			
			String email = login.getEmail();
			String password = login.getPassword();
			
			System.out.println("Before " + login.getFirstName());
			
			for(User u:user) {
				
				login.setFirstName(u.getFirstName());
				login.setLastName(u.getLastName());
				login.setEmail(u.getEmail());
				login.setRole(u.getRole());
				login.setAccountStatus(u.getAccountStatus());
			}
			
			System.out.println("After " + login.getFirstName());
			
			if(password.equals(login.getPassword()) && email.equals(login.getEmail())) {
				status = true;
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			session.close();
		}
		
		return status;
	}

}
