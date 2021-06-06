package com.xworkz.xworkzapp.facebook;



import java.util.List;
import java.util.Scanner;

import com.xworkz.xworkzapp.facebook.dao.FacebookDAO;
import com.xworkz.xworkzapp.facebook.dao.FacebookDAOImpl;
import com.xworkz.xworkzapp.facebook.dto.FacebookDTO;
import com.xworkz.xworkzapp.facebook.service.FacebookServiceImpl;
import com.xworkz.xworkzapp.facebook.service.FacebookService;

public class Tester {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        int id = sc.nextInt();
        System.out.println("Enter the name");
        String name = sc.next();
        System.out.println("Enter the email");
        String email= sc.next();
        System.out.println("Enter the password");
        String password = sc.next();

        System.out.println();
        FacebookDTO fbDTO = new FacebookDTO();

        fbDTO.setId(id);
        fbDTO.setName(name);
        fbDTO.setEmail(email);
        fbDTO.setPassword(password);

        System.out.println(fbDTO);

        /*FacebookDAO bookDAO = new FacebookDAOImpl();
       
        bookDAO.createFaceBook(fbDTO);  */
        
        
        FacebookService bookservice = new FacebookServiceImpl();
        bookservice.validateAndSave(fbDTO);
        
      /*

        List<FacebookDTO> bookDTOs= bookDAO.getAllFaceBookDetails();
        
        System.out.println("--------");

       
        for(FacebookDTO facebookDTO :bookDTOs){
           if(facebookDTO!=null){
                System.out.println(facebookDTO);
           }
        }
        
        */

    }
}
