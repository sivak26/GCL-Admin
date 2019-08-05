package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import greencard.admin.account.model.User;

public interface RegistrationService {
	
	void saveDetails(User user);
	
	boolean signedIn(HttpServletRequest request, HttpServletResponse response, HttpSession sessoin);

	boolean isRegisteredUser(String email);
	
	void setUserIDCookie(int userId, HttpServletResponse response);

}
