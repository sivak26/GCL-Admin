package greencard.admin.account.repository;

import greencard.admin.account.model.User;

public interface RegistrationDAO {
	
	void save(User user);

	User findByUserID(int agclid);

	User findByEmailID(String email);
}
