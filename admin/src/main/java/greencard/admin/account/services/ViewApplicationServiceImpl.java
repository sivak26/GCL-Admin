package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.repository.CustomerServiceDAO;

@Service
public class ViewApplicationServiceImpl implements ViewApplicationService {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	CustomerRegistration customerRegistration;
	CustomerContact customerContact;

	@Override
	public CustomerRegistration getRegistrationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId) {
		
		System.out.println("Service - Customer Service called ...");
		try {
			System.out.println("Getting Registration Details ...");
			
			customerRegistration = customerServiceDAO.getRegistration(accountId);
			
		}catch (Exception e) {
			System.out.println("Service - Null pointer exception ...");
			e.getMessage();
		}
		
		return customerRegistration;
	}

	
	@Override
	public int deleteApplication(HttpServletRequest request, 
			HttpServletResponse response, 
			String customerId) {
		System.out.println("Service - Delete operation Starts...");
		
		int deleteStatus = 0;
		
		customerRegistration = getRegistrationDetails(request, response, customerId);
		
		String emailId = customerRegistration.getEmail();
		
		if(!emailId.contains("-deleted")) {
			String[] email = emailId.split("@", 2);
			emailId = email[0] + "-deleted@" + email[1];
			deleteStatus = customerServiceDAO.deleteByAccountId(customerId, emailId);
		}
		
		return deleteStatus;
	}
	
	@Override
	public int skipSubmission(HttpServletRequest request, HttpServletResponse response, String customerId) {
		
		System.out.println("Service - Skip operation Starts...");
		
		int skipStatus = 0;
		
		skipStatus = customerServiceDAO.skipAccount(customerId);
		
		return skipStatus;
	}
	
	@Override
	public CustomerContact getContactDetails(HttpServletRequest request, HttpServletResponse response,
			String accountId) {
		System.out.println("Service - Customer Service called ...");
		try {
			
			System.out.println("Getting Contact Details ...");
			
			customerContact = customerServiceDAO.getContact(accountId);
			System.out.println("City from DAO - " +customerContact.getCity());
			
		}catch (Exception e) {
			System.out.println("Service - Null pointer exception Contact...");
			e.getMessage();
		}
		
		return customerContact;
	}
}
