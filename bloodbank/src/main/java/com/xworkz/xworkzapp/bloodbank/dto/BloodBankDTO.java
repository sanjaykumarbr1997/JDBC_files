package com.xworkz.xworkzapp.bloodbank.dto;
import java.io.Serializable;

public class BloodBankDTO  implements Serializable{
	
	private int bloodBankID;
	private String donorName;
	private int donorAge;
	private Long  contactNo;
	private boolean  isSmoker;
	private String bloodBankLocation;
	
	public BloodBankDTO() {
		//
	}

	@Override
	public String toString() {
		return "BloodBankDTO [bloodBankID=" + bloodBankID + ", donorName=" + donorName + ", donorAge=" + donorAge
				+ ", contactNo=" + contactNo + ", isSmoker=" + isSmoker + ", bloodBankLocation=" + bloodBankLocation
				+ "]";
	}

	public int getBloodBankID() {
		return bloodBankID;
	}

	public void setBloodBankID(int bloodBankID) {
		this.bloodBankID = bloodBankID;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public int getDonorAge() {
		return donorAge;
	}

	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}

	public  Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public boolean isSmoker() {
		return isSmoker;
	}

	public void setSmoker(boolean isSmoker) {
		this.isSmoker = isSmoker;
	}

	public String getBloodBankLocation() {
		return bloodBankLocation;
	}

	public void setBloodBankLocation(String bloodBankLocation) {
		this.bloodBankLocation = bloodBankLocation;
	}
	
	

}
