package com.xworkz.xworkzapp.facebook;



import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;
import com.xworkz.xworkzapp.facebook.service.FacebookServiceImpl;
import com.xworkz.xworkzapp.facebook.service.FacebookService;

public class Tester {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of record that you need to enter :");
		int numberOfRecords = scanner.nextInt();
		
		for(int num=0;num<numberOfRecords;num++) {
		
		    FacebookDTO fbDTO = new FacebookDTO();	
			System.out.println("Enter Facebook ID");
			fbDTO.setId(scanner.nextInt());
			System.out.println("Enter Name");
			fbDTO.setName(scanner.next());
			System.out.println("Enter Email address");
			fbDTO.setEmail(scanner.next());
			System.out.println("Enter password");
			fbDTO.setPassword(scanner.next());
			
			
			System.out.println(fbDTO);
			System.out.println();
			
			FacebookService fbService = new FacebookServiceImpl();
			
			try {
				fbService.validateAndSave(fbDTO);
				
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
				
				}
			
		}
		
		FacebookService fbService = new FacebookServiceImpl();
		
		System.out.println("Enter number of records to update");
		
		int numberOfRecordsUpdate = scanner.nextInt();
		
	for(int num=0;num<numberOfRecordsUpdate;num++) {
		
			System.out.println("Enter Name to update");
			String name = scanner.next();
			System.out.println("Enter new password");
			String password = scanner.next();
		try {
			fbService.validateAndUpdate(password, name);
			System.out.println("Passwoerd is updated");
			
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
			fbService.validateAndDelete(name);
			System.out.println("Details deleted");
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
			
	}
		
		try {
			fbService.validateAndFetchFaceBookDetails();
			System.out.println("Details fethced");	
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		
		
		
		
		FacebookService fbS = new FacebookServiceImpl();
		
		List<FacebookDTO> bookDTOs=  fbS.validateAndFetchFaceBookDetails();
         
        for(FacebookDTO banksDTO :bookDTOs){
           if(banksDTO!=null){
                System.out.println(banksDTO);
           }
        }
        
        try {
        	 List<String> ems = fbS.validateAndgetAllEmails();
			System.out.println("Details of all E-mail fethced");
			for(String email :ems){
	            if(email!=null){
	                 System.out.println(email);
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
        
        
        
        System.out.println("Enter no of records to fetch password by email address ");
        int rec = scanner.nextInt();
        
        for(int start =0;start<rec;start++) {
        	
        	System.out.println("Enter email adress to fetch password");
            String email1 = scanner.next();
        	
        	
        try {
        	List<String> password=fbService.validateAndGetPasswordByEmail(email1);
			System.out.println(" Password fethced");
			for(String pswd :password){
	            if(pswd!=null){
	                 System.out.println(pswd.toString());
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
        
        
      
        }
        
        System.out.println("Enter no of records to fetch  email by name ");
        int reco = scanner.nextInt();
        
        for(int start =0;start<reco;start++) {
        	
        	System.out.println("Enter name to fetch email");
            String name = scanner.next();
        	
        	
        try {
        	List<String> emaill=fbService.validateGetEmailByName(name);
			System.out.println(" Email fethced");
			for(String eml :emaill){
	            if(eml!=null){
	                 System.out.println(eml.toString());
	            }
	         }
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
        
        
      
        }
        
        
        
        scanner.close();
		

    }
}
