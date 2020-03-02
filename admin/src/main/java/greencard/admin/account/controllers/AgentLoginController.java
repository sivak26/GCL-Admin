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

import greencard.admin.account.model.Agent;
import greencard.admin.account.services.AgentServices;

@Controller
@RequestMapping("/login")
public class AgentLoginController {
	
	@Autowired
	AgentServices registrationService;
	
	Agent agent;
	
	private final static String SUCCESS_PAGE = "actions";
	private final static String LOGIN_PAGE = "login";
	private final static String REGISTRATION_PAGE = "register";
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session, 
			Model model) {
		
		System.out.println("Login GET method called ...");
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		
		if (signedIn) {
			System.out.println("Login - User already in session ...");
			return SUCCESS_PAGE;
		}
		
		return LOGIN_PAGE;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("email") String emailId,
			@RequestParam("password") String password,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,
			Model model) {
		
		System.out.println("Login - POST method called ...");
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		
		if(signedIn) {
			System.out.println("Login - User already in session ...");
			return SUCCESS_PAGE;
		}
		
		System.out.println("Email ID from Request - " + emailId);
		System.out.println("Password from Request - " + password);
		
		boolean authentication = registrationService.authenticate(emailId, password);
		
		System.out.println("Authentication - " + authentication);
		
		if(authentication) {
			try {
				agent = registrationService.getUserDetails(emailId);
				
				if(agent != null) {
					System.out.println("Login - Login Successfully ...");
					
					session.setAttribute("agent", agent);
					
					return SUCCESS_PAGE;
				}
				
				System.out.println("Login - In-valid credentials...");
				return REGISTRATION_PAGE;
				
			} catch (Exception e) {
				System.out.println("Login - Entered Email does not exist our database ...");
				e.getMessage();
			}
		}
		
		System.out.println("Login - Authentication Faild...");
		return LOGIN_PAGE;

	}
}
