package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface LogoutService {

	void clearSession(HttpServletRequest request, 
			HttpServletResponse response, 
			HttpSession session);
}
