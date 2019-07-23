package greencard.admin.account.services;

import greencard.admin.account.model.User;

public interface LoginService {
	
	public String authenticateUser(User login);
	
}