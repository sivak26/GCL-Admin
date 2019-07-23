package greencard.admin.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import greencard.admin.account.model.User;
import greencard.admin.account.services.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	String viewPage;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginForm", new User());
		System.out.println("Login GET");
		return "login";
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginForm") User loginForm, Model model) {
		System.out.println("Login POST");
		viewPage = loginService.authenticateUser(loginForm);
		return viewPage;
	}
}
