package greencard.admin.account.model;

import java.sql.Date;

public class Applicant {
	
	private int applicantId;
	private String firstName;
	private String lastName;
	private String middleName;
	private int gender;
	private int maritalStatus;
	private int applicantEducation;
	private int noOfChildren;
	private Date dateOfBirth;
	private String cityOfBirth;
	private String countryOfBirth;
	private String nativeCountry;
	private Integer photoId;
	
	
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(int maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public int getApplicantEducation() {
		return applicantEducation;
	}
	public void setApplicantEducation(int applicantEducation) {
		this.applicantEducation = applicantEducation;
	}
	public int getNoOfChildren() {
		return noOfChildren;
	}
	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getCityOfBirth() {
		return cityOfBirth;
	}
	public void setCityOfBirth(String cityOfBirth) {
		this.cityOfBirth = cityOfBirth;
	}
	public String getCountryOfBirth() {
		return countryOfBirth;
	}
	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	public String getNativeCountry() {
		return nativeCountry;
	}
	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}

	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	
	
}
