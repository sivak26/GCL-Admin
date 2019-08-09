package greencard.admin.account.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greencard.admin.account.model.Customer;
import greencard.admin.account.repository.CustomerServiceDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	Customer customer;

	@Override
	public Customer getAccountDetails(HttpServletRequest request, 
			HttpServletResponse response, 
			String accountId) {
		
		System.out.println("Service - Customer Service called ...");
		try {
			customer = customerServiceDAO.findByAccountId(accountId);
		}catch (Exception e) {
			System.out.println("Service - Null pointer exception ...");
			e.getMessage();
		}
		
		return customer;
	}

}
