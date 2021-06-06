package com.xworkz.xworkzapp.amazon.constants;

public class Constants {
	
	public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fbn?user=root&password=dontknow";
	public static final String INSERT_QUERY = "insert into amazon_order values(?,?,?,?,?,?)";
	public static final String UPDATE_DELIVERY_STATUS_BY_NAME = "update amazon_order set delivery_status = ? where name= ?";
	public static final String DELETE_QUERY = "delete from amazon_order where name = ?";
	public static final String SELECT_QUERY = "select * from amazon_order";
	

}
