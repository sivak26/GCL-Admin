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
		
		if(!cookieExist(request)) {
			System.out.println("Service - Cookie value not exists ...");
			return false;
		}
		
		if(!isUserSession(sessoin, request)) {
			createSessionWithCookie(request, response, sessoin);
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean isRegisteredUser(String email) {
		System.out.println("Service - Check if the user already registered or NOT ...");
		user = registrationDAO.findByEmailID(email);
		
		if (!user.equals(null)) {
			System.out.println("Service - " + user.getEmail() + " User already registered ...");
			return true;
		}
		return false;
	}
	
	@Override
	public boolean authenticate(String emailId, String password) {
		System.out.println("Service - Authenticate using EmailID ...");
		
		user = registrationDAO.findByEmailID(emailId);
		
		System.out.println("Service - Password from Database = " + user.getPassword());
		System.out.println("Service - Password from Request  = " + password);

		return (password.equals(user.getPassword()));
	}
	
	@Override
	public User getUserDetails(String emailId) {
		
		System.out.println("Service - Getting user detail using EmailID ...");
		
		user = registrationDAO.findByEmailID(emailId);
		
		System.out.println("Service - Email from Database = " + user.getEmail());
		System.out.println("Service - FirstName from Database  = " + user.getFirstName());
		System.out.println("Service - UserID from Database  = " + user.getUserId());

		return user;
	}
	
	private boolean createSessionWithCookie(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		System.out.println("Service - Creating serssion using Cookie ...");
		String cookieValue = getagclidCookieValue("agclid", request);
		
		user = (User)registrationDAO.findByUserID(Integer.parseInt(cookieValue));
		
		if (user != null) {
			session.setAttribute("agent", user);
			return true;
		}
		return false;
	}
	
	private boolean isUserSession(HttpSession sessoin, HttpServletRequest request) {
		if(sessoin.getAttribute("agent") == null) {
			return false;
		} else {
			System.out.println("Service - User in session ...");
			user = (User) sessoin.getAttribute("agent");
			
			int agentIdFromCookie = Integer.parseInt(getagclidCookieValue("agclid", request));
			
			int agentIdFromUser = user.getUserId();
			
			System.out.println("userID from Database = " + agentIdFromUser);
			System.out.println("userID from Cookie = " + agentIdFromCookie);

			return agentIdFromCookie == agentIdFromUser;
		}
	}

	private String getagclidCookieValue(String agclid, HttpServletRequest request) {
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals(agclid)) {
				System.out.println("AGCLID value = " + cookie.getValue());
				cookieValue = cookie.getValue();
			}
		}
		return cookieValue;
	}

	private boolean cookieExist(HttpServletRequest request) {

		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("agclid")) {
					System.out.println("Cookie Value EXISTS ..." + cookie.getValue());
					return true;
				}
			}
		}
		System.out.println("Service - Cookie value NOT EXISTS ...");
		return false;
	}
	
	public void setUserIDCookie(int userId, HttpServletResponse response) {
		String agentId = Integer.toString(userId);
		
		try {
			Cookie cookie = new Cookie("agclid", agentId);
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			response.addCookie(cookie);
			System.out.println("Service - agclid cookie set after Registration success ...");
		}catch (Exception e) {
			System.out.println("Service - Exception while setting agclid cookie ...");
		}
		
	}
}
