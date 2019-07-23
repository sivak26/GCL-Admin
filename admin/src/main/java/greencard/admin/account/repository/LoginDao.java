package greencard.admin.account.repository;

import greencard.admin.account.model.User;

public interface LoginDao {
	public boolean getUserDetails(User login);

}
