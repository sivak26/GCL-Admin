package greencard.admin.account.model;

import java.sql.Timestamp;

public class CustomerPhotograph {

	private int userId;
	private String photographType;
	private String resolution;
	private int photographStatus;
	private Timestamp uploadedDate;
	private int backgroundRejectedFlaggedStatus;
	private int blurRejectedFlaggedStatus;
	private int faceRejectedFlaggedStatus;
	private int faceProcessorErrorFlaggedStatus;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPhotographType() {
		return photographType;
	}
	public void setPhotographType(String photographType) {
		this.photographType = photographType;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public int getPhotographStatus() {
		return photographStatus;
	}
	public void setPhotographStatus(int photographStatus) {
		this.photographStatus = photographStatus;
	}
	public Timestamp getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Timestamp uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public int getBackgroundRejectedFlaggedStatus() {
		return backgroundRejectedFlaggedStatus;
	}
	public void setBackgroundRejectedFlaggedStatus(int backgroundRejectedFlaggedStatus) {
		this.backgroundRejectedFlaggedStatus = backgroundRejectedFlaggedStatus;
	}
	public int getBlurRejectedFlaggedStatus() {
		return blurRejectedFlaggedStatus;
	}
	public void setBlurRejectedFlaggedStatus(int blurRejectedFlaggedStatus) {
		this.blurRejectedFlaggedStatus = blurRejectedFlaggedStatus;
	}
	public int getFaceRejectedFlaggedStatus() {
		return faceRejectedFlaggedStatus;
	}
	public void setFaceRejectedFlaggedStatus(int faceRejectedFlaggedStatus) {
		this.faceRejectedFlaggedStatus = faceRejectedFlaggedStatus;
	}
	public int getFaceProcessorErrorFlaggedStatus() {
		return faceProcessorErrorFlaggedStatus;
	}
	public void setFaceProcessorErrorFlaggedStatus(int faceProcessorErrorFlaggedStatus) {
		this.faceProcessorErrorFlaggedStatus = faceProcessorErrorFlaggedStatus;
	}
}
