package com.xworkz.lightapp;

public class CflLightImpl implements ISwitch{
    @Override
    public void sOn() {
        System.out.println("CFL light turned on");
    }

    @Override
    public void sOff() {
        System.out.println("CFL light turned off");
    }
}
