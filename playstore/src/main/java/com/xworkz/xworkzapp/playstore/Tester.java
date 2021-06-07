package com.xworkz.xworkzapp.playstore;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.xworkz.xworkzapp.playstore.dto.PlayStoreDTO;
import com.xworkz.xworkzapp.playstore.service.PlayStoreService;
import com.xworkz.xworkzapp.playstore.service.PlayStoreServiceImpl;


public class Tester {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of record that you need to enter :");
		int numberOfRecords = scanner.nextInt();
		
		for(int num=0;num<numberOfRecords;num++) {
		
		    PlayStoreDTO playDTO = new PlayStoreDTO();	
			System.out.println("Enter App ID");
			playDTO.setId(scanner.nextInt());
			
			System.out.println("EnterApp Name");
			playDTO.setAppName(scanner.next());
			
			System.out.println("Enter App Type");
			playDTO.setAppType(scanner.next());
			
			System.out.println("Enter Ratings.");
			playDTO.setRatings(scanner.nextInt());
			
			
			
			System.out.println(playDTO);
			System.out.println();
			
			
			PlayStoreService PlayStoreService = new PlayStoreServiceImpl();
			try {
				PlayStoreService.validateAndSave(playDTO);
				
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
				
				}
			
		}

	
		
		PlayStoreService playStoreService = new PlayStoreServiceImpl();
		System.out.println("Enter number of records to update");
		
		int numberOfRecordsUpdate = scanner.nextInt();
		
		for(int num=0;num<numberOfRecordsUpdate;num++) {
		
			System.out.println("Enter app name to update");
			String name = scanner.next();
			System.out.println("Enter new ratings");
			int ratings = scanner.nextInt();
		
			try {
			playStoreService.validateAndUpdateRatingsByName(ratings,name);
			System.out.println("Ratings  updated");
			
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
			playStoreService.deleteDetailsByName(name);
			System.out.println("Details deleted");
			
			} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
			
			
		}
		try {
			playStoreService.validateAndFetch();
			System.out.println("Details fethced");
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		PlayStoreService psStore = new PlayStoreServiceImpl();
		
		List<PlayStoreDTO> playDTOs=  psStore.validateAndFetch();
        
        System.out.println("--------");

       
        for(PlayStoreDTO pDTO :playDTOs){
           if(pDTO!=null){
                System.out.println(pDTO);
           }
        }
        
        
        try {
			playStoreService.validateGetMaxRatings();
			System.out.println("Maximum rating is :");
			
			
			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			
			}
		PlayStoreService psSt = new PlayStoreServiceImpl();
		
		List<Integer> maxs=  psSt.validateGetMaxRatings();
        
        System.out.println("--------");

       
        for(Integer max :maxs){
           if( max!=null){
                System.out.println( max);
           }
        }
        
        
        System.out.println("Enter rating to find apps");
        int ratings = scanner.nextInt();
        try {
        PlayStoreService psStoreDTO = new PlayStoreServiceImpl();
		
        List<PlayStoreDTO> playsDTOs=  psStoreDTO.validateGetAppsByRatings(ratings);

       
        for(PlayStoreDTO pDTO :playsDTOs){
            if(pDTO!=null){
                 System.out.println(pDTO);
            }
         }
        }catch (ClassNotFoundException |SQLException e){
        	e.printStackTrace();
        }
        
        
        
        
        System.out.println("Enter type to find apps");
        String type = scanner.next();
        try {
        PlayStoreService psStoreDTO = new PlayStoreServiceImpl();
		
        List<PlayStoreDTO> playsDTOs=  psStoreDTO.validateGetAppsByType(type);
        for(PlayStoreDTO pDTO :playsDTOs){
            if(pDTO!=null){
                 System.out.println(pDTO);
            }
         }
        }catch (ClassNotFoundException |SQLException e){
        	e.printStackTrace();
        }
        
        scanner.close();  
		
	}


}
