package com.ui.Utilis;

import org.testng.annotations.BeforeMethod;

public class sampleClass{
    @BeforeMethod
    public void init() {
        System.out.println("Browser instance created");

    }
}
