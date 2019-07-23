package greencard.admin.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.User;
import greencard.admin.account.repository.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	String viewPage = "welcome";
	
	@Override
	public String authenticateUser(User login) {
		System.out.println("Service Login");
		boolean loginStatus = loginDao.getUserDetails(login);
		
		if(!loginStatus) {
			viewPage = "error";
		}
		
		return viewPage;
	}

}
