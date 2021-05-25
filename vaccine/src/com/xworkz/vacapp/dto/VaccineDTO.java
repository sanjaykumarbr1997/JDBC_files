package com.xworkz.vacapp.dto;

public class VaccineDTO {

	private String name;
	private String mfgDate;
	private int quantity;
	
	public VaccineDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
