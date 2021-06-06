package com.xworkz.xworkzapp.playstore.constants;

public class Constants {
	
	public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fbn?user=root&password=dontknow";
	public static final String INSERT_QUERY = "insert into play_store values(?,?,?,?)";
	public static final String UPDATE_RATINGS_BY_APP_NAME = "update play_store set app_ratings = ? where app_name = ?";
	public static final String DELETE_QUERY = "delete from play_store where app_name = ?";
	public static final String SELECT_QUERY = "select * from play_store";
	

}
