package greencard.admin.account.repository;

import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;

public interface CustomerServiceDAO {
	
	CustomerRegistration getRegistration(String accountId);
	
	int deleteByAccountId(String customerId, String emailId);
	
	int skipAccount(String customerId);
	
	CustomerContact getContact(String accountId);

}
