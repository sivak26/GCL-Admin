package greencard.admin.account.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;
import greencard.admin.account.repository.CustomerServiceDAO;

@Service
public class ViewApplicationServiceImpl implements ViewApplicationService {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	CustomerRegistration customerRegistration;
	CustomerApplication customerApplication;
	CustomerContact customerContact;
	Applicant applicant;
	SkipSubmission skipSubmission;
	CustomerPhotograph customerPhotograph;

	@Override
	public CustomerRegistration getRegistrationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			String accountId) {
		
		System.out.println("Service - Customer Service called ...");
		try {
			System.out.println("Getting Registration Details ...");
			
			customerRegistration = customerServiceDAO.getRegistration(accountId);
			
			session.setAttribute("customerRegistration", customerRegistration);
			
		} catch (Exception e) {
			System.out.println("Service - Null pointer exception ...");
			e.getMessage();
		}
		
		return customerRegistration;
	}
	
	@Override
	public CustomerApplication getApplicationDetails(HttpServletRequest request, HttpServletResponse response,
			String accountId) {
		System.out.println("Service - Application Called...");
		
		try {
			
			customerApplication = customerServiceDAO.getApplication(accountId);
			
		} catch (Exception e) {
			System.out.println("Null pointer exception ...");
			e.getMessage();
		}
		
		return customerApplication;
	}

	
	@Override
	public int deleteApplication(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			String customerId) {
		System.out.println("Service - Delete operation Starts...");
		
		int deleteStatus = 0;
		
		customerRegistration = getRegistrationDetails(request, response, session, customerId);
		
		String emailId = customerRegistration.getEmail();
		
		if(!emailId.contains("-deleted")) {
			String[] email = emailId.split("@", 2);
			emailId = email[0] + "-deleted@" + email[1];
			deleteStatus = customerServiceDAO.deleteByAccountId(customerId, emailId);
		}
		
		return deleteStatus;
	}
	
	@Override
	public int skipSubmission(HttpServletRequest request, 
			HttpServletResponse response, 
			String customerId) {
		
		System.out.println("Service - Skip operation Starts..." + customerId);
		
		int skipStatus = 0;
		
		int userId = Integer.parseInt(customerId);
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		
		try {
			skipSubmission = new SkipSubmission();
			skipSubmission.setUserId(userId);
			skipSubmission.setUpdatedDate(ts);
			
			skipSubmission = customerServiceDAO.verifySkipStatus(userId);
			
			if (skipSubmission != null) {
				System.out.println("Already skiped");
				return skipStatus;
			}
			
			skipStatus = customerServiceDAO.skipAccount(skipSubmission);
			
		} catch (Exception e) {
			System.out.println("Throw null pointer exception ...");
			e.getMessage();
		}
		
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
	
	@Override
	public Applicant getApplicant(HttpServletRequest request, 
			HttpServletResponse response, 
			int applicationId) {
		
		System.out.println("Service - Customer Service called ...");
		try {
			
			System.out.println("Getting Applicant Details ...");
			
			applicant = customerServiceDAO.getApplicant(applicationId);
			System.out.println("City from DAO - " + applicant.getFirstName());
			
		} catch (Exception e) {
			System.out.println("Service - Null pointer exception Applicant...");
			e.getMessage();
		}
		
		return applicant;
	}
	
	@Override
	public CustomerPhotograph getPhotographs(HttpServletRequest request, HttpServletResponse response,
			String customerId) {
		
		System.out.println("Photographs service called ...");
		
		try {
			int userId = Integer.parseInt(customerId);
			
			customerPhotograph = customerServiceDAO.getPhotograph(userId);
			
		} catch (Exception e) {
			System.out.println(">>>>>> Null pointer Exception ...");
			e.getMessage();
		}
		return customerPhotograph;
	}
}
