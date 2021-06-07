package com.xworkz.xworkzapp.tablet.dto;

public class TabletDTO {
	
	private int id;
	private String name ;
	private float price;
	private String color;
	private int yearOfManufacture;
	
	public TabletDTO() {
		//
	}

	@Override
	public String toString() {
		return "TabletDTO [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color
				+ ", yearOfManufacture=" + yearOfManufacture + "]";
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	
}