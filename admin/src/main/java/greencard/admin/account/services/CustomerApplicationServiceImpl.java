package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerPayment;
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.model.SkipSubmission;
import greencard.admin.account.repository.CustomerServiceDAO;

@Service
public class CustomerApplicationServiceImpl implements CustomerApplicationService {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	CustomerRegistration customerRegistration;
	CustomerApplication customerApplication;
	CustomerContact customerContact;
	Applicant applicant;
	SkipSubmission skipSubmission;
	CustomerPhotograph customerPhotograph;
	CustomerPayment customerPayment;

	@Override
	public CustomerRegistration getRegistrationDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			String accountId) {
		
		System.out.println("Service - Customer Service called ...");
		try {
			System.out.println("Getting Registration Details ...");
			
			customerRegistration = customerServiceDAO.getRegistration(accountId);
			
			if (customerRegistration != null) {
				session.setAttribute("customerRegistration", customerRegistration);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Registration details found for this customer...");
			e.getMessage();
		}
		
		return customerRegistration;
	}
	
	@Override
	public CustomerApplication getApplicationDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String accountId) {
		System.out.println("Service - Application Called...");
		
		try {
			
			customerApplication = customerServiceDAO.getApplication(accountId);
			
			if (customerApplication != null) {
				session.setAttribute("customerApplication", customerApplication);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Application details found for this customer...");
			e.getMessage();
		}
		
		return customerApplication;
	}
	
	
	@Override
	public CustomerPayment getPaymentDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session, 
			String accountId) {
		
		System.out.println("Customer Application Service Impl - Payment...");
		
		try {
			
			customerPayment = customerServiceDAO.getPayment(accountId);
			
			if (customerPayment != null) {
				session.setAttribute("customerPayment", customerPayment);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Payment details found for this customer...");
		}
		
		
		return customerPayment;
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
	public int skipFromSubmission(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session,
			String customerId) {
		
		System.out.println("Service - Skip operation Starts..." + customerId);
		
		int skipStatus = 0;
		int skippedAccount;
		
		int userId = Integer.parseInt(customerId);
		
//		Date date= new Date();
//		long time = date.getTime();
//		Timestamp timeStamp = new Timestamp(time);
		
		try {
			
			skipSubmission = customerServiceDAO.verifySkipStatus(userId);
			
			if (skipSubmission == null) {
				System.out.println("This account not found in database ");
				
				skipSubmission = new SkipSubmission();
				skipSubmission.setUserId(userId);
				//skipSubmission.setUpdatedDate(timeStamp);
			
				skippedAccount = customerServiceDAO.skipAccount(skipSubmission);
			
				if (skippedAccount != 0) {
					System.out.println("Inserted into SkipList....");
					skipStatus = 1;
				}
			}
			
		} catch (Exception e) {
			System.out.println("Throw null pointer exception ...");
			e.getMessage();
		}
		
		return skipStatus;
	}
	
	@Override
	public int addToSubmission(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session,
			String customerId) {
		
		int addSubmissionStatus = 0;
		
		int userId = Integer.parseInt(customerId);
		
		try {
			
			skipSubmission = customerServiceDAO.verifySkipStatus(userId);
			
			if (skipSubmission == null) {
				System.out.println("This account not found OR already deleted from database ");
				return addSubmissionStatus;
			}
				
			customerServiceDAO.addToSubmission(skipSubmission);
			
			skipSubmission = customerServiceDAO.verifySkipStatus(userId);
			
			if (skipSubmission == null) {
				System.out.println("This account deleted from database ");
				addSubmissionStatus = 1;
			}
			
		} catch (Exception e) {
			System.out.println("Throw null pointer exception ...");
			e.getMessage();
		}
		
		return addSubmissionStatus;
	}
	
	@Override
	public CustomerContact getContactDetails(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String accountId) {
		
		try {
			
			customerContact = customerServiceDAO.getContact(accountId);
			
			if (customerContact != null) {
				session.setAttribute("customerContact", customerContact);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Contact details found for this customer...");
			e.getMessage();
		}
		
		return customerContact;
	}
	
	@Override
	public Applicant getApplicant(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session,
			int applicationId) {
		
		try {
			
			applicant = customerServiceDAO.getApplicant(applicationId);
			
			if (applicant != null) {
				session.setAttribute("applicant", applicant);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Applicant details found for this customer...");
			e.getMessage();
		}
		
		return applicant;
	}
	
	@Override
	public CustomerPhotograph getPhotographs(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			String customerId) {
		
		try {
			
			int userId = Integer.parseInt(customerId);
			
			customerPhotograph = customerServiceDAO.getPhotograph(userId);
			
			if (customerPhotograph != null) {
				session.setAttribute("customerPhotograph", customerPhotograph);
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception - No Photographs details found for this customer...");
			e.getMessage();
		}
		return customerPhotograph;
	}
	
	@Override
	public int editCustomerRegistrationInfo(HttpServletRequest request, HttpServletResponse response,
			HttpSession session, String customerId, String customerEmail, String customerName, String customerPassword,
			String customerPhone, String customerMobile) {
		
		System.out.println("Edit Application Service to update Registration Table...");
		
		int updateStatus = 0;
		
		try {
			
			updateStatus = customerServiceDAO.updateCustomerRegistration(customerId, customerEmail, customerName, 
					customerPassword, customerPhone, customerMobile);
			
		} catch (Exception e) {
			System.out.println("Edit Application Service exception..");
			e.getMessage();
		}
		
		
		return updateStatus;
	}
	
}
