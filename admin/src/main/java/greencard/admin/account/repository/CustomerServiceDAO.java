package greencard.admin.account.repository;

import javax.servlet.http.HttpServletRequest;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;

public interface CustomerServiceDAO {
	
	CustomerRegistration getRegistration(String accountId);
	
	CustomerApplication getApplication(String accountId);
	
	CustomerContact getContact(String accountId);
	
	Applicant getApplicant(int applicationId);
	
	int deleteByAccountId(String customerId, String emailId);
	
	int skipAccount(SkipSubmission skipSubmission);
	
	SkipSubmission verifySkipStatus(int userId);
	
	CustomerPhotograph getPhotograph(int userId);

}
