package greencard.admin.account.services;

import org.springframework.stereotype.Service;

import greencard.admin.account.model.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	public void saveDetails(User user) {
		
		System.out.println(user.getEmail());
		
	}

}
