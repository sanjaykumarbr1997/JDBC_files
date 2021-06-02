package com.xworkz.lightapp;

import java.util.Scanner;
public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the light");
        String type = sc.next();
        ISwitch iSwitch=LightFactory.getLight(type);
        if(iSwitch!=null){
            iSwitch.sOn();
            iSwitch.sOff();
        }
        
        sc.close();
    }

}
