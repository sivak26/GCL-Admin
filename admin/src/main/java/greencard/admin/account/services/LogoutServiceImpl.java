package greencard.admin.account.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class LogoutServiceImpl implements LogoutService {

	@Override
	public void clearSession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		System.out.println("Service - Logout Service called to clear session ...");
		
		if (session != null) {
			System.out.println(session.getAttributeNames());
		}

		System.out.println("Request - " + request.getSession());
		
		request.getSession().invalidate();
		
		
		Cookie jsessionId = new Cookie("JSESSIONID", null);
		jsessionId.setMaxAge(0);
		jsessionId.setPath("/");
		
		Cookie agclid = new Cookie("agclid", null);
		agclid.setMaxAge(0);
		agclid.setPath("/");
		
		System.out.println("Service - JSESSIONID = " + jsessionId);
		System.out.println("Service - Agclid = " + agclid);
		
		response.addCookie(jsessionId);
		response.addCookie(agclid);
	}
	
	

}
