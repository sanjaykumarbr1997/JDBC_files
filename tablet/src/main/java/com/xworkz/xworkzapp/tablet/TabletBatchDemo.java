package com.xworkz.xworkzapp.tablet;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.xworkz.xworkzapp.tablet.dto.TabletDTO;

public class TabletBatchDemo {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		TabletDTO tDTO =new TabletDTO();
		System.out.println("Enter id ");
		tDTO.setId(sc.nextInt());
		System.out.println("Enter tablet name");
		tDTO.setName(sc.next());
		System.out.println("Enter price");
		tDTO.setPrice(sc.nextFloat());
		System.out.println("Enter tablet color");
		tDTO.setColor(sc.next());
		System.out.println("Enter mfg date  ");
		tDTO.setYearOfManufacture(sc.nextInt());
		
		System.out.println(tDTO);
		
		

		Connection connection = null;
		PreparedStatement preparedStatement1 =null;
		
		
	
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn","root","dontknow");
			preparedStatement1 = connection.prepareStatement("Insert into tablet values(?,?,?,?,?)");
			System.out.println(tDTO.getId());
			preparedStatement1.setInt(1,tDTO.getId());
			preparedStatement1.setString(2, tDTO.getName());
			preparedStatement1.setFloat(3, tDTO.getPrice());
			preparedStatement1.setString(4, tDTO.getColor());
			preparedStatement1.setInt(5, tDTO.getYearOfManufacture());
			preparedStatement1.addBatch();
			preparedStatement1.executeBatch();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement1.close();
			connection.close();
		}
		
		
		System.out.println("Enter tablet name to change cost");
		String name = sc.next();
		System.out.println("Enter new price");
		float price = sc.nextFloat();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/fbn","root","dontknow");
			preparedStatement1 = connection.prepareStatement( "update tablet set price = ? where name = ?");
			preparedStatement1.setString(2,name);
			preparedStatement1.setFloat(1,price );
			preparedStatement1.addBatch();
			preparedStatement1.executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			preparedStatement1.close();
			connection.close();
		}
		
		
		
	
	

	}

}
