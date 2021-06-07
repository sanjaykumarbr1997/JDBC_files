package com.xworkz.xworkzapp.bloodbank;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.xworkz.xworkzapp.bloodbank.dto.BloodBankDTO;
import com.xworkz.xworkzapp.bloodbank.service.BloodBankService;
import com.xworkz.xworkzapp.bloodbank.service.BloodBankServiceImpl;

public class Tester {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of record that you need to enter :");
		int numberOfRecords = scanner.nextInt();
		
		for(int num=0;num<numberOfRecords;num++) {
		
		    BloodBankDTO bankDTO = new BloodBankDTO();	
			System.out.println("Enter Blood Bank ID");
			bankDTO.setBloodBankID(scanner.nextInt());
			System.out.println("Enter Donor Name");
			bankDTO.setDonorName(scanner.next());
			System.out.println("Enter Donor Age");
			bankDTO.setDonorAge(scanner.nextInt());
			System.out.println("Enter Donor Contact no.");
			bankDTO.setContactNo(scanner.nextLong());
			System.out.println("Whether Donor is Smoker?");
			bankDTO.setSmoker(scanner.nextBoolean());
			System.out.println("Enter Donor Blood Bank Location");
			bankDTO.setBloodBankLocation(scanner.next());
			
			System.out.println(bankDTO);
			System.out.println();
			
			BloodBankService bloodBankService = new BloodBankServiceImpl();
			try {
				bloodBankService.validateAndSave(bankDTO);
				
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
				
				}
			
		}
		
		BloodBankService bloodBankService = new BloodBankServiceImpl();
		System.out.println("Enter number of records to update");
		
		int numberOfRecordsUpdate = scanner.nextInt();
		
		for(int num=0;num<numberOfRecordsUpdate;num++) {
			
			System.out.println("Enter Name to update");
			String name = scanner.next();
			System.out.println("Enter Age");
			int age = scanner.nextInt();
		
		
		  try {
			bloodBankService.validateAndUpdateAgeByName(age, name);
			System.out.println("Age is updated");
			
		  } catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		
		}
		
		System.out.println("Enter number of records to delete");
		
		int numberOfRecordsToDelete = scanner.nextInt();
		
		for(int num=0;num<numberOfRecordsToDelete;num++) {
			
			System.out.println("Enter name to delete records");
			String name = scanner.next();
			
			try {
			bloodBankService.validateDeleteDetailsByName(name);
			System.out.println("Details deleted");
			
			} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
			
		
		}
			
		
		try {
			bloodBankService.validateAndFetch();
			System.out.println("Details fethced");	
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		
		
		
		BloodBankService bloodS = new BloodBankServiceImpl();
		
		List<BloodBankDTO> bookDTOs=  bloodS.validateAndFetch();
         
        for(BloodBankDTO banksDTO :bookDTOs){
           if(banksDTO!=null){
                System.out.println(banksDTO);
           }
        }
        
        
        System.out.println("Enter no of records to fetch  issmoker by name ");
        int recd = scanner.nextInt();
        
        for(int start =0;start<recd;start++) {
        	
        	System.out.println("Enter name to fetch issmoker");
            String name = scanner.next();
        	
        	
        try {
        	List<String> smoker=bloodS.validateAndgetIsSmokerByName(name);
			System.out.println(" Is smoker  fetched");
			for(String ism :smoker){
	            if(ism!=null){
	                 System.out.println(ism.toString());
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
        
        
      
        }
        
       
        
        
        	
        	System.out.println("Enter location to get details");
            String name = scanner.next();
        	
        	
        try {
        	List<BloodBankDTO> bldDTOs=bloodS.validateGetDetailsByLocation(name);
			System.out.println(" Details fetched");
			for(BloodBankDTO blDTO:bldDTOs){
	            if(blDTO!=null){
	                 System.out.println(blDTO);
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
        
        
        try {
        	 List<String> connumber = bloodS.validateGetAllContactNumber();
			System.out.println("Details of all Contact number fethced");
			for(String con :connumber){
	            if(con!=null){
	                 System.out.println(con);
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
           
        
        
        
        
        
        
        scanner.close();
		
	}

	
}

