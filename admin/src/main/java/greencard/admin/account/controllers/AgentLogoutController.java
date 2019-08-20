package greencard.admin.account.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import greencard.admin.account.services.AgentServices;

@Controller
@RequestMapping("/logout")
public class AgentLogoutController {
	
	@Autowired
	AgentServices logoutService;
	
	private final static String LOGIN_PAGE = "login";
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String signout(HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session,
			Model model) {

		logoutService.clearSession(request, response, session);
		
		return LOGIN_PAGE;
	}

	
}
