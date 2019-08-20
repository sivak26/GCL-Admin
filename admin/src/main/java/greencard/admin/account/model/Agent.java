package greencard.admin.account.model;

import java.sql.Timestamp;
import java.util.Date;

public class Agent {
	 Date date= new Date();
	 long time = date.getTime();
	 Timestamp ts = new Timestamp(time);
	 
	private int userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String role;
	private Timestamp createdDate = ts;
	private int accountStatus = 1;
	private Timestamp lastLoginDate = ts;

	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
	public int getAccountStatus() {
		return accountStatus;
	}
	
	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}
	
	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public String toString() {
		return "User [date=" + date + ", time=" + time + ", ts=" + ts + ", userId=" + userId + ", email=" + email
				+ ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
				+ ", createdDate=" + createdDate + ", accountStatus=" + accountStatus + ", lastLoginDate="
				+ lastLoginDate + "]";
	}
	
}
