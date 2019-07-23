package greencard.admin.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.User;
import greencard.admin.account.repository.RegistrationDAO;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDAO registrationDAO;
	
	public void saveDetails(User user) {
		registrationDAO.save(user);
	}

}
