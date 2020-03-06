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
import greencard.admin.account.model.CustomerPhotograph;
import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.services.ViewApplicationService;

@Controller
public class ViewActionController {
	
	public static String ACTION_FOR_CUSTMER_PAGE = "/actions/popups/actionForCustomer";
	public static String SHOW_APPLICATION_PAGE = "/actions/showApplication";
	public static String SELECT_ACTION_PAGE = "actions";
	
	@Autowired
	ViewApplicationService viewApplicationService;
	
	@RequestMapping(value = "/customerAction", method = RequestMethod.GET)
	public String actionForCustomer(HttpServletRequest request,  
			HttpServletResponse response, 
			@RequestParam("nextAction") String nextAction, 
			Model model) {
		
		System.out.println("Next Action is = " + nextAction);
		
		if (nextAction != null && nextAction != "") {
			
			model.addAttribute("nextAction", nextAction);
			return ACTION_FOR_CUSTMER_PAGE;
			
		}
		
		return SELECT_ACTION_PAGE;
		
	}
	
	/*@RequestMapping(value = "/showApplication", method = RequestMethod.GET)
	public String viewApplication(HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestParam("accountId") String accountId, 
			Model model) {
		
		System.out.println("Show Application GET ......");
		
		if (accountId != null && accountId != "") {
			model.addAttribute("accountId", accountId);
			return SHOW_APPLICATION_PAGE;
		}
		
		return SELECT_ACTION_PAGE;
	}*/
	
	@RequestMapping(value = "/showApplication", method = RequestMethod.POST)
	public String viewApplication (HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session, 
			@RequestParam("accountId") String accountId,  
			Model model) {
		
		System.out.println("Account ==> " + accountId);
		
		try {
			if (accountId != null && accountId != "") {
				System.out.println("Controller - AccountID exists...");
				
				CustomerRegistration customerRegistration = viewApplicationService.getRegistrationDetails(request, response, session, accountId);
				
				CustomerContact customerContact = viewApplicationService.getContactDetails(request, response, accountId);
				
				CustomerApplication customerApplication = viewApplicationService.getApplicationDetails(request, response, accountId);
				
				Applicant applicant = viewApplicationService.getApplicant(request, response, customerApplication.getApplicationId());
				
				CustomerPhotograph customerPhotograph = viewApplicationService.getPhotographs(request, response, accountId);

				if (session.getAttribute("customerRegistration") != null) {
					System.out.println("session not null ....." + session.getAttribute("customerRegistration.getFirstName()"));
					model.addAttribute("registration", (CustomerRegistration) session.getAttribute("customerRegistration"));
					
					CustomerRegistration cr = (CustomerRegistration) session
						    .getAttribute("customerRegistration");
					System.out.println("CUR ===== > " + cr.getEmail());
				} else {
					System.out.println("CUR =====wwwww > ");
					model.addAttribute("registration", customerRegistration);
				}
				
				model.addAttribute("application", customerApplication);
				model.addAttribute("contact", customerContact);
				model.addAttribute("applicant", applicant);
				model.addAttribute("photographs", customerPhotograph);
				model.addAttribute("customerId", customerRegistration.getUserId());
				
			}
		} catch (Exception e) {
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
			deleteStatus = viewApplicationService.deleteApplication(request, response, session, customerId);
		}
		
		model.addAttribute("deleteStatus", deleteStatus);
		model.addAttribute("accountId", customerId);
		
		return "/actions/showApplication";
		//return "redirect:gcl/actions/showApplication";
	}
	
	@RequestMapping(value = "/skipSubmission", method = RequestMethod.POST)
	public String skipSubmission(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("customerId") String customerId,
			Model model) {
		
		System.out.println("Controller - Skip operation ..." + customerId);
		int skipStatus = 0;
		
		if (customerId != "") {
			skipStatus = viewApplicationService.skipSubmission(request, response, customerId);
		}
		System.out.println("Controller - Skip Status is " + skipStatus);
		
		model.addAttribute("skipStatus", skipStatus);
		
		return "/actions/showApplication";
	}

}
