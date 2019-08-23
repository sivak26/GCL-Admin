package greencard.admin.account.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import greencard.admin.account.model.Applicant;
import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerContact;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.services.ViewApplicationService;

@Controller
public class ViewActionController {
	
	@Autowired
	ViewApplicationService viewApplicationService;
	
	
	@RequestMapping(value = "/showApplication", method = RequestMethod.POST)
	public String viewApplication (HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("accountId") String accountId,
			Model model) {
		
		try {
			if (accountId != null && accountId != "") {
				System.out.println("Controller - AccountID exists...");
				
				CustomerRegistration customerRegistration = viewApplicationService.getRegistrationDetails(request, response, accountId);
				
				CustomerContact customerContact = viewApplicationService.getContactDetails(request, response, accountId);
				
				CustomerApplication customerApplication = viewApplicationService.getApplicationDetails(request, response, accountId);
				
				System.out.println("*********** Application ID = " + customerApplication.getApplicationId());
				
				Applicant applicant = viewApplicationService.getApplicant(request, response, customerApplication.getApplicationId());
								
				model.addAttribute("registration", customerRegistration);
				model.addAttribute("application", customerApplication);
				model.addAttribute("contact", customerContact);
				model.addAttribute("applicant", applicant);
				
				
				
				System.out.println("Controller - Email from Model = " + customerRegistration.getEmail());
				System.out.println("Controller - City  from Model = " + customerContact.getCity());
				
				
			}
		}catch (Exception e) {
			System.out.println("Controller - Null pointer exception...");
			e.getMessage();
		}
		return "/actions/showApplication";
	}
	
	@RequestMapping(value = "/deleteApplication", method = RequestMethod.POST)
	public String deleteApplication(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			@RequestParam("customerId") String customerId,
			Model model) {
		
		System.out.println("Controller - Delete Operation...");
		System.out.println("Customer ID = " + customerId);
		int deleteStatus = 0;
		
		if(customerId != "") {
			System.out.println("Customer Id not empty...");
			deleteStatus = viewApplicationService.deleteApplication(request, response, customerId);
		}
		
		model.addAttribute("deleteStatus", deleteStatus);
		
		return "/actions/showApplication";
	}
	
	public String skipSubmission(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("customerId") String customerId,
			Model model) {
		
		System.out.println("Controller - Skip operation ...");
		int skipStatus = 0;
		
		if (customerId != "") {
			skipStatus = viewApplicationService.skipSubmission(request, response, customerId);
		}
		
		model.addAttribute("skipStatus", skipStatus);
		
		return "/actions/showApplication";
	}

}
