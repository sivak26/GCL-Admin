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

import greencard.admin.account.model.CustomerApplication;
import greencard.admin.account.model.CustomerPayment;
import greencard.admin.account.services.CustomerApplicationService;

@Controller
public class ApplicationActionController {
	
	public final String APPLICATION_ACTION_PAGE = "/actions/applicationAction";
	public final String PAYMENT_PAGE = "/actions/payment";
	
	@Autowired
	CustomerApplicationService customerApplicationService;
	CustomerPayment customerPayment;
	CustomerApplication customerApplication;
	
	@RequestMapping(value = "/applicationAction", method = RequestMethod.POST)
	public String applicationAction(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			@RequestParam("accountId") String customerId,
			Model model) {
		
		System.out.println("Application Action Controller...");
		
		try {
			if (customerId != "") {
				customerPayment = customerApplicationService.getPaymentDetails(request, response, session, customerId);
				customerApplication = customerApplicationService.getApplicationDetails(request, response, session, customerId);
			}
			
			if (customerPayment == null || customerApplication == null) {
				return PAYMENT_PAGE;
			}
			
			model.addAttribute("customerId", customerId);
			model.addAttribute("payment", customerPayment);
			model.addAttribute("application", customerApplication);
			
		} catch (Exception e) {
			System.out.println("Null pointer exception in ApplicationActionController....");
			e.getMessage();
		}
		
		return APPLICATION_ACTION_PAGE;
	}

}
