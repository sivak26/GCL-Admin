package greencard.admin.account.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import greencard.admin.account.model.Agent;
import greencard.admin.account.services.AgentServices;

@Controller
@RequestMapping("/registration")
public class AgentRegistrationController {
	
	@Autowired
	AgentServices registrationService;
	
	
	private final static String SUCCESS_PAGE = "actions";
	private final static String REGISTRATION_PAGE = "register";
	private final static String LOGIN_PAGE = "/login";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String registraion(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session,  
			Model model){
		
		System.out.println("GET Method Called ....");
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		System.out.println("Signedin Status = " + signedIn);
		
		if (signedIn) {
			System.out.println("Controller - User already in session ...");
			return SUCCESS_PAGE;
		}
		
		model.addAttribute("agent", new Agent());
		return REGISTRATION_PAGE;
	}


	@RequestMapping(method = RequestMethod.POST)
	public String registration(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session, 
			@ModelAttribute("agent") Agent agent, Model model) {
		
		System.out.println("POST method called ....");
		
		boolean signedIn = registrationService.signedIn(request, response, session);
		
		if (signedIn) {
			System.out.println("Controller - User already in session ...");
			return SUCCESS_PAGE;
		}
		
		boolean registeredUser = registrationService.isRegisteredUser(agent.getEmail());
		
		if(registeredUser) {
			System.out.println("Controller - User already exists ....");
			return LOGIN_PAGE;
		}
		
		registrationService.saveDetails(agent);
		
		System.out.println("Controller - " + agent.getFirstName());
		System.out.println("Controller - " + agent.getLastName());
		System.out.println("Controller - " + agent.getUserId());
		System.out.println("Controller - " + agent.getEmail());
		System.out.println("Controller - " + agent.getPassword());

		return SUCCESS_PAGE;
	}
}
