package greencard.admin.account.model;

import java.sql.Timestamp;

public class CustomerApplication {
	
	private int applicationId;
	private int productId;
	private Timestamp createdDate;
	private Timestamp lastAccessed;
	private int applicationType;
	private int applicationTakenForReview;
	private Timestamp applicationTakenTime;
	private int photoSentThrough;
	private int photoUploadStatus;
	private int applicationStatus;
	private int applicationTakenBy;
	
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getLastAccessed() {
		return lastAccessed;
	}
	public void setLastAccessed(Timestamp lastAccessed) {
		this.lastAccessed = lastAccessed;
	}
	public int getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(int applicationType) {
		this.applicationType = applicationType;
	}
	public int getApplicationTakenForReview() {
		return applicationTakenForReview;
	}
	public void setApplicationTakenForReview(int applicationTakenForReview) {
		this.applicationTakenForReview = applicationTakenForReview;
	}
	public Timestamp getApplicationTakenTime() {
		return applicationTakenTime;
	}
	public void setApplicationTakenTime(Timestamp applicationTakenTime) {
		this.applicationTakenTime = applicationTakenTime;
	}
	public int getPhotoSentThrough() {
		return photoSentThrough;
	}
	public void setPhotoSentThrough(int photoSentThrough) {
		this.photoSentThrough = photoSentThrough;
	}
	public int getPhotoUploadStatus() {
		return photoUploadStatus;
	}
	public void setPhotoUploadStatus(int photoUploadStatus) {
		this.photoUploadStatus = photoUploadStatus;
	}
	public int getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public int getApplicationTakenBy() {
		return applicationTakenBy;
	}
	public void setApplicationTakenBy(int applicationTakenBy) {
		this.applicationTakenBy = applicationTakenBy;
	}
	
	
}
