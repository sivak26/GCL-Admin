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

import greencard.admin.account.model.CustomerRegistration;
import greencard.admin.account.services.CustomerApplicationService;

@Controller
public class EditActionController {
	
	public static String EDIT_APPLICATION_PAGE = "/actions/editApplication";
	public static String SELECT_ACTION_PAGE = "actions";
	
	@Autowired
	CustomerApplicationService customerApplicationService;
	
	@RequestMapping(value = "/editApplication", method = RequestMethod.POST)
	public String editApplication(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			@RequestParam("accountId") String customerId,
			Model model) {
		
		System.out.println("Edit Application Controller...");
		
		try {
			if (customerId != "" && customerId != null) {
			
			CustomerRegistration customerRegistration = customerApplicationService.getRegistrationDetails(request, response, session, customerId);
			
			model.addAttribute("customerId", customerId);
			model.addAttribute("registration", customerRegistration);
			
			} else {
			
				return SELECT_ACTION_PAGE;
			}
			
		} catch (Exception e) {
			System.out.println("Exception in controller...");
			e.getMessage();
		}
		return EDIT_APPLICATION_PAGE;
	}
	
	@RequestMapping(value = "/editRegistration", method = RequestMethod.POST)
	public String editRegistration(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			@RequestParam(required = true, value = "customerId") String customerId,
			@RequestParam(required = true, value = "customerEmailId") String customerEmailId,
			@RequestParam(required = true, value = "customerName") String customerName,
			@RequestParam(required = true, value = "customerPassword") String customerPassword,
			@RequestParam(required = true, value = "customerPhone") String customerPhone,
			@RequestParam(required = true, value = "customerMobile") String customerMobile,
			Model model) {
		
		System.out.println("Edit Controller - Edit the Registration Details...");
		
		int updateStatus = 0;
		
		try {
			
			if (customerId != "" && customerId != null) {
				
				updateStatus = customerApplicationService.editCustomerRegistrationInfo(request, response, session, customerId, customerEmailId, customerName, customerPassword, customerPhone, customerMobile);
				
				if (updateStatus == 1) {
					customerApplicationService.getRegistrationDetails(request, response, session, customerId);
				}
				
				model.addAttribute("customerId", customerId);
				model.addAttribute("registration", session.getAttribute("customerRegistration"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Controller - Exception ....");
			e.getMessage();
		}
		
		return EDIT_APPLICATION_PAGE;
	}

}
