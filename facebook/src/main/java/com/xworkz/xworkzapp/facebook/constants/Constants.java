package com.xworkz.xworkzapp.facebook.constants;

public class Constants {

	public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fbn?user=root&password=dontknow";
	public static final String INSERT_QUERY = "insert into facebook_table values(?,?,?,?)";
	public static final String UPDATE_PASSWORD_BY_NAME = "update facebook_table set facebook_password = ? where facebook_name= ?";
	public static final String DELETE_QUERY = "delete from facebook_table where facebook_name= ?";
	public static final String SELECT_QUERY = "select * from facebook_table";
	public static final String SELECT_EMAILS_QUERY= "select facebook_email from facebook_table";
	public static final String SELECT_PASSWORD_BY_EMAIL ="select facebook_password from facebook_table where facebook_email= ?";
	public static final String SELECT_EMAIL_BY_NAME ="select facebook_email from facebook_table where facebook_name= ?";


}
