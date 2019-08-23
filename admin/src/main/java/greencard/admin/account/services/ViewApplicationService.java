package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;

public interface ViewApplicationService {
	
	CustomerRegistration getRegistrationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId);
	
	CustomerApplication getApplicationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId);
	
	CustomerContact getContactDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId);
	
	Applicant getApplicant(HttpServletRequest request, 
			HttpServletResponse response, 
			int applicationId);
	
	int deleteApplication(HttpServletRequest request, 
			HttpServletResponse response,
			String cutomerId);

	int skipSubmission(HttpServletRequest request,
			HttpServletResponse response,
			String customerId);
}
