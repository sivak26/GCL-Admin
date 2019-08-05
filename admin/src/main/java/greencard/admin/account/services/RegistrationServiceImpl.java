package greencard.admin.account.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.User;
import greencard.admin.account.repository.RegistrationDAO;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDAO registrationDAO;
	
	User user;
	
	
	@Override
	public void saveDetails(User user) {
		
		registrationDAO.save(user);
	}
	
	@Override
	public boolean signedIn(HttpServletRequest request, HttpServletResponse response, HttpSession sessoin) {
		
		if(cookieExist(request)) {
			return true;
		}
		
		if(isUserSession(sessoin, request)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isRegisteredUser(String email) {
		System.out.println("Service - Check Is user already registered or NOT ...");
		user = registrationDAO.findByEmailID(email);
		
		if (user != null) {
			System.out.println("Service - Already registered ...");
			return true;
		}
		
		return false;
	}
	

	private boolean isUserSession(HttpSession sessoin, HttpServletRequest request) {
		
		int agclid;
		String cookieValue;
		
		try {
		if(sessoin.getAttribute("agent") == null) {
			System.out.println("User not in Session. So retrieve session using cookie ...");

			cookieValue = getagclidCookieValue(request);
			
			if (cookieValue != "" && cookieValue != null) {
				System.out.println("Cookie value exists in service");
				agclid = Integer.parseInt(getagclidCookieValue(request));
				user = registrationDAO.findByUserID(agclid);
			}
			
			if (user != null) {
				System.out.println("User values successfully get from database....");
				sessoin.setAttribute("agent", user);
				return true;
			}
			
			return false;
			
		} else {
			System.out.println("User is in Sesison ...");
			User user = (User) sessoin.getAttribute("agent");
			
			agclid = Integer.parseInt(getagclidCookieValue(request));
			
			if(agclid == user.getUserId()) {
				System.out.println("Same User ... ");
				return true;
			} else {
				System.out.println("Different User...");
			}
			
		}
		} catch (Exception e) {
			System.out.println("Exception throwning because of NULL value or number format...");
			e.getMessage();
		}

		
		return false;
	}

	private String getagclidCookieValue(HttpServletRequest request) {
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("agclid")) {
				System.out.println("AGCLID value = " + cookie.getValue());
				cookieValue = cookie.getValue();
				return cookieValue;
			}
		}
		return cookieValue;
	}

	private boolean cookieExist(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("agclid")) {
					System.out.println("Cookie value from Service = " + cookie.getValue());
					return true;
				}
			}
		}
		System.out.println("Cooke value is ... " + cookies);
		return false;
	}
	
	public void setUserIDCookie(int userId, HttpServletResponse response) {
		System.out.println("Setting Cookie value after Registration success....");
		
		String agentId = Integer.toString(userId);
		
		try {
		Cookie cookie = new Cookie("agclid", agentId);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		
		response.addCookie(cookie);
		}catch (Exception e) {
			System.out.println("Cookie value setting error ....");
		}
		
	}
}
