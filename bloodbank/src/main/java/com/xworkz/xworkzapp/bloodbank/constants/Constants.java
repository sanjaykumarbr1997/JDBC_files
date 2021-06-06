package com.xworkz.xworkzapp.bloodbank.constants;

public class Constants {
	
	public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/fbn?user=root&password=dontknow";
	public static final String INSERT_QUERY = "insert into blood_bank values(?,?,?,?,?,?)";
	public static final String UPDATE_AGE_BY_DONOR_NAME = "update blood_bank set donor_age = ? where donor_name= ?";
	public static final String DELETE_QUERY = "delete from blood_bank where donor_name = ?";
	public static final String SELECT_QUERY = "select * from blood_bank";
	public static final String SELECT_ISSMOKER_BY_NAME ="select is_smoker from blood_bank where donor_name= ?";
	public static final String SELECT_BY_LOCATION = "select * from blood_bank where blood_bank_location=?";
	public static final String SELECT_CONTACT_NUMBER= "select donor_contact_number from blood_bank";

}
