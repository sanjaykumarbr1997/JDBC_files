package com.xworkz.facebook_app;

import com.xworkz.facebook_app.dao.FacebookDAO;
import com.xworkz.facebook_app.dao.FacebookDAOImpl;
import com.xworkz.facebook_app.dto.FacebookDTO;

import java.util.List;
import java.util.Scanner;

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

        FacebookDAO bookDAO = new FacebookDAOImpl();
        bookDAO.createFaceBook(fbDTO);
        bookDAO.getAllFaceBookDetails();

        List<FacebookDTO> bookDTOs= bookDAO.getAllFaceBookDetails();

        for(FacebookDTO facebookDTO :bookDTOs){
            if(facebookDTO!=null) {
                System.out.println(facebookDTO);
            }
        }

    }
}
