package com.gdm.training;

import com.gdm.training.week1.ArrayListTest;
import com.gdm.training.week1.EnumerationTest;

public class Application {
    public static void main(String[] args) {
        System.out.println("GDM Training!");
        EnumerationTest et = new EnumerationTest();
        et.disp();
        ArrayListTest at = new ArrayListTest();
        at.disp();
    }
}
