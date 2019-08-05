package greencard.admin.account.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import greencard.admin.account.model.User;
import greencard.admin.account.services.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	
	private final static String SUCCESS_PAGE = "welcome";
	private final static String REGISTRATION_PAGE = "register";
	private final static String NEXT_PAGE = "register";
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registraion(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			@CookieValue(value = "agclid", required = false) String agclid, 
			Model model){
		
		System.out.println("GET....");
		
		// Checking agclid cookie and user session exist or not
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		
		if (signedIn) {
			System.out.println("User already in session ...");
			return SUCCESS_PAGE;
		}
		
		model.addAttribute("agent", new User());
		return NEXT_PAGE;
		
	}


	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			@ModelAttribute("agent") User agent, Model model) {
		
		System.out.println("POST....");
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		
		if (signedIn) {
			System.out.println("Controller - User already in session ...");
			return SUCCESS_PAGE;
		}
		
		boolean registeredUser = registrationService.isRegisteredUser(agent.getEmail());
		
		if(registeredUser) {
			System.out.println("User already exists ....");
			return REGISTRATION_PAGE;
		}
		
		registrationService.saveDetails(agent);
		
		System.out.println("Controller - " + agent.getEmail());
		System.out.println("Controller - " + agent.getFirstName());
		System.out.println("Controller - " + agent.getLastName());
		System.out.println("Controller - " + agent.getRole());
		System.out.println("Controller - " + agent.getPassword());
		
		registrationService.setUserIDCookie(agent.getUserId(), response);
		
		System.out.println("NEXT PAGE");
		return NEXT_PAGE;
	}
	
}
