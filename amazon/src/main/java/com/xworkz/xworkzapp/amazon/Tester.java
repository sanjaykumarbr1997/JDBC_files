package com.xworkz.xworkzapp.amazon;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.xworkz.xworkzapp.amazon.dto.AmazonDTO;
import com.xworkz.xworkzapp.amazon.service.AmazonService;
import com.xworkz.xworkzapp.amazon.service.AmazonServiceImpl;


public class Tester {

	public static void main(String[] args) throws ClassNotFoundException , SQLException{
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of record that you need to enter :");
		int numberOfRecords = scanner.nextInt();
		
		for(int num=0;num<numberOfRecords;num++) {
			
		
		    AmazonDTO amazonDTO = new AmazonDTO();	
			System.out.println("Enter  ID");
			amazonDTO.setId(scanner.nextInt());
			System.out.println("EnterName");
			amazonDTO.setName(scanner.next());
			System.out.println("Enter Item");
			amazonDTO.setOrderedItem(scanner.next());
			System.out.println("Enter Item Price");
			amazonDTO.setItemPrice(scanner.nextFloat());
			System.out.println("Enter Contact Number");
			amazonDTO.setContactNo(scanner.nextLong());
			System.out.println("Enter Delivery status");
			amazonDTO.setDeliverStatus(scanner.nextBoolean());
			
			System.out.println(amazonDTO);
			System.out.println();
			
			AmazonService amazonService = new AmazonServiceImpl();
			try {
				amazonService.validateOrderDetails(amazonDTO);
				
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
				
				}
			
		}
		
		AmazonService amazonService = new AmazonServiceImpl();
	
		System.out.println("Enter number of records to update");
		
		int numberOfRecordsUpdate = scanner.nextInt();
		
		for(int num=0;num<numberOfRecordsUpdate;num++) {
		
			System.out.println("Enter Name to update");
			String name = scanner.next();
			System.out.println("Enter Status");
			Boolean status = scanner.nextBoolean();
		
		try {
			amazonService.validateUpdateDeliveryStatusByName(status, name);
			System.out.println("Delivery status is updated");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		}
		
		System.out.println("Enter number of records  to delete");
		
		int recordToDelete = scanner.nextInt();
		
		for(int num=0;num<recordToDelete;num++) {
			
			System.out.println("Enter Name to Delete details");
			String name1 = scanner.next();
		
		try {
			amazonService.validateDeleteDetailsByName(name1);
			System.out.println("Details deleted");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		}
			
			
		
		try {
			amazonService.validateGetAllOrderDetails();
			System.out.println("Details fethced");	
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		scanner.close();
		
		
		AmazonService amS = new AmazonServiceImpl();
		
		List<AmazonDTO> amazonDTOs=  amS.validateGetAllOrderDetails();
         
        for(AmazonDTO amazonsDTO :amazonDTOs){
           if(amazonsDTO!=null){
                System.out.println(amazonsDTO);
           }
        }
		
	}

}
