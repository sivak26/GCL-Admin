package greencard.admin.account.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import greencard.admin.account.model.Customer;
import greencard.admin.account.services.CustomerService;

@Controller
public class ShowCustomerApplication {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/showApplication", method = RequestMethod.GET)
	public String customerList (HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("accountId") String accountId,
			Model model) {
		
		try {
			if (accountId != null && accountId != "") {
				System.out.println("Controller - AccountID exists...");
				Customer customer = customerService.getAccountDetails(request, response, accountId);
				
				model.addAttribute("customer", customer);
				
				System.out.println("Controller - Email from Model = " + customer.getEmail());
				
				
			}
		}catch (Exception e) {
			System.out.println("Controller - Null pointer exception...");
			e.getMessage();
		}
		return "/actions/showApplication";
	}

}
