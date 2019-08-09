package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import greencard.admin.account.model.Customer;

public interface CustomerService {
	
	Customer getAccountDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId);

}
