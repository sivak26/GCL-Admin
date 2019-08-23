package greencard.admin.account.repository;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;

public interface CustomerServiceDAO {
	
	CustomerRegistration getRegistration(String accountId);
	
	CustomerApplication getApplication(String accountId);
	
	CustomerContact getContact(String accountId);
	
	Applicant getApplicant(int applicationId);
	
	int deleteByAccountId(String customerId, String emailId);
	
	int skipAccount(String customerId);

}
