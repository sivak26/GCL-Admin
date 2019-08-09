package greencard.admin.account.repository;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import greencard.admin.account.model.Customer;
import greencard.admin.account.model.User;
import greencard.admin.account.utils.DBSession;

@Repository
public class CustomerServiceDAOImpl implements CustomerServiceDAO {
	
	@Autowired
	DBSession dbSession;
	
	Customer customer;

	@Override
	public Customer findByAccountId(String accountId) {
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
				customer = (Customer) iterator.next();
			}
			transaction.commit();
			
		} catch (Exception e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();	
			}
		}
		return customer;
	}

}
