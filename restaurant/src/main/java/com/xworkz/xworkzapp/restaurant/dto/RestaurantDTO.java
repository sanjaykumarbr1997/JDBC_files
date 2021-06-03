package com.xworkz.xworkzapp.restaurant.dto;

public class RestaurantDTO {
	
	private int customerID;
	private String customerName;
	private String customerOrderedItem;
	private float customerRatings;
	
	public RestaurantDTO() {
		System.out.println("Restaurant DTO Created");
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getcustomerOrderedItem() {
		return customerOrderedItem;
	}

	public void setCustomerOrderedItem(String customerOrderedItem) {
		this.customerOrderedItem = customerOrderedItem;
	}

	public float getCustomerRatings() {
		return customerRatings;
	}

	public void setCustomerRatings(float customerRatings) {
		
		if ((customerRatings <0) || (customerRatings>5)) {
			System.out.println("Invalid input for ratings");
			this.customerRatings = 01000;
			
		}
		else {
			this.customerRatings = customerRatings;
		}
	}

	@Override
	public String toString() {
		return "RestaurantDTO [customerID=" + customerID + ", customerName=" + customerName
				+ ", customerOrderedItem=" + customerOrderedItem + ", customerRatings=" + customerRatings + "]";
	}
}