package greencard.admin.account.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import greencard.admin.account.model.User;
import greencard.admin.account.services.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model){
		model.addAttribute("userForm", new User());
		System.out.println("GET....");
		return "register";
	}


	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, Model model) {
		System.out.println(userForm.getFirstName());
		registrationService.saveDetails(userForm);
		System.out.println("POST....");
		return "welcome";
	}

}
