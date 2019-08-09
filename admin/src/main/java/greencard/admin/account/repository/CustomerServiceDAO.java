package greencard.admin.account.repository;

import greencard.admin.account.model.Customer;

public interface CustomerServiceDAO {
	
	Customer findByAccountId(String accountId);

}
