package com.xworkz.xworkzapp.playstore.dto;

public class PlayStoreDTO {
	
	private int id;
	private String appName;
	private String appType;
	private int ratings;
	
	
	public PlayStoreDTO() {
		
	}
	
	@Override
	public String toString() {
		return "PlayStoreDTO [id=" + id + ", appName=" + appName + ", appType=" + appType + ", ratings=" + ratings
				+ "]";
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAppType() {
		return appType;
	}


	public void setAppType(String appType) {
		this.appType = appType;
	}


	public int getRatings() {
		return ratings;
	}


	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	

}
