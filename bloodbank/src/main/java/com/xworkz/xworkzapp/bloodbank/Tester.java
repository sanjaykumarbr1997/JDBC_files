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
	
		
		try {
			bloodBankService.validateAndUpdateAgeByName(23, "Sham");
			System.out.println("Age is updated");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		

		try {
			bloodBankService.deleteDetailsByName("Hitler");
			System.out.println("Details deleted");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
			
			
		
		try {
			bloodBankService.validateAndFetch();
			System.out.println("Details fethced");
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		scanner.close();
		
		
		BloodBankService bloodS = new BloodBankServiceImpl();
		
		List<BloodBankDTO> bookDTOs=  bloodS.validateAndFetch();
        
        System.out.println("--------");

       
        for(BloodBankDTO banksDTO :bookDTOs){
           if(banksDTO!=null){
                System.out.println(banksDTO);
           }
        }
		
	}

	
}

