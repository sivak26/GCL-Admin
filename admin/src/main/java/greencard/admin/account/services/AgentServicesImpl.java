package greencard.admin.account.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.Agent;
import greencard.admin.account.repository.AgentDAO;

@Service
public class AgentServicesImpl implements AgentServices {
	
	@Autowired
	AgentDAO registrationDAO;
	
	Agent user;
	
	
	@Override
	public void saveDetails(Agent user) {
		registrationDAO.save(user);
	}
	
	@Override
	public boolean signedIn(HttpServletRequest request, HttpServletResponse response, HttpSession sessoin) {
		
		boolean isAgentSession = false;
		
		try {
			if(!sessoin.getAttribute("agent").equals(null)) {
				isAgentSession = true;
			}
		} catch (Exception e) {
			System.out.println("Service - Agent not in Session ...");
		}
		
		return isAgentSession;
	}
	
	@Override
	public boolean isRegisteredUser(String email) {
		System.out.println("Service - Check if the user already registered or NOT ..." + email);
		
		boolean registeredUser = false;
		
		try {
			user = registrationDAO.findByEmailID(email);
		
			if (!user.equals(null)) {
				System.out.println("Service - " + user.getEmail() + " User already registered ...");
				registeredUser = true;
			}
		} catch (Exception e) {
			System.out.println("Service - Email Not Exists ...");
		}
		return registeredUser;
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
	public Agent getUserDetails(String emailId) {
		
		System.out.println("Service - Getting user detail using EmailID ...");
		
		user = registrationDAO.findByEmailID(emailId);
		
		System.out.println("Service - Email from Database = " + user.getEmail());
		System.out.println("Service - FirstName from Database  = " + user.getFirstName());
		System.out.println("Service - UserID from Database  = " + user.getUserId());

		return user;
	}
	
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
		
		System.out.println("Service - JSESSIONID = " + jsessionId);
		
		response.addCookie(jsessionId);
	}
}
