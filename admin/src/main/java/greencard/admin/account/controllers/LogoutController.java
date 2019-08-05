package greencard.admin.account.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession httpSession;
		request.getSession().invalidate();
		
		System.out.println("Called");

		Cookie jSessionIdCookie = new javax.servlet.http.Cookie("JSESSIONID", null);
		System.out.println(jSessionIdCookie.getValue());
		jSessionIdCookie.setMaxAge(0);
        jSessionIdCookie.setPath("/admin/");
        System.out.println(jSessionIdCookie.getValue());
        
		return "redirect:/";
	}
	
}
