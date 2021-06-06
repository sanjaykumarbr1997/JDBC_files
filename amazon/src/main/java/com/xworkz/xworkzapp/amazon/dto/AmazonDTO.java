package com.xworkz.xworkzapp.amazon.dto;

public class AmazonDTO {
	
	private int id;
	private String name;
	private String orderedItem;
	private Float itemPrice;
	private Long contactNo;
	private Boolean deliverStatus;
	
	public AmazonDTO() {
		//
	}

	@Override
	public String toString() {
		return "AmazonDTO [id=" + id + ", name=" + name + ", orderedItem=" + orderedItem + ", itemPrice=" + itemPrice
				+ ", contactNo=" + contactNo + ", deliverStatus=" + deliverStatus + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderedItem() {
		return orderedItem;
	}

	public void setOrderedItem(String orderedItem) {
		this.orderedItem = orderedItem;
	}

	public Float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public Boolean getDeliverStatus() {
		return deliverStatus;
	}

	public void setDeliverStatus(Boolean deliverStatus) {
		this.deliverStatus = deliverStatus;
	}
	
	

}
