package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPayment;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;

public interface CustomerApplicationService {
	
	CustomerRegistration getRegistrationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			String accountId);
	
	CustomerApplication getApplicationDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String accountId);
	
	CustomerPayment getPaymentDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String accountId);
	
	CustomerContact getContactDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String accountId);
	
	Applicant getApplicant(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			int applicationId);
	
	int deleteApplication(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session, 
			String cutomerId);

	int skipFromSubmission(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			String customerId);
	
	int addToSubmission(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			String customerId);
	
	CustomerPhotograph getPhotographs(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			String customerId);
	
	int editCustomerRegistrationInfo(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			String customerId, 
			String customerEmail, 
			String customerName, 
			String customerPassword, 
			String customerPhone, 
			String customerMobile);
}
