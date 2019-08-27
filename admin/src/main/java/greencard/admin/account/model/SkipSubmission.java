package greencard.admin.account.model;

import java.sql.Timestamp;

public class SkipSubmission {
	
	private int userId;
	private Timestamp updatedDate;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

}
