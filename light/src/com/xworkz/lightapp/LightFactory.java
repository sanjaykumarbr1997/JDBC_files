package com.xworkz.lightapp;

public class LightFactory {

    public static ISwitch getLight(String type){
        if(type.equalsIgnoreCase("tubelight")){
            return new TubeLightImpl();
        }
        else if(type.equalsIgnoreCase("cfllight")){
            return new CflLightImpl();
        }
        return null;
    }
}