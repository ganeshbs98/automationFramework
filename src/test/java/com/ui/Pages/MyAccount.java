package com.ui.Pages;

import com.ui.Utilis.Controller;
import com.ui.Utilis.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Controller {
    SeleniumWrapper seleniumWrapper=new SeleniumWrapper();
    private static final By MY_ACCOUNT_HEADER = By.xpath("//h1[contains(text(),'My account')]");

    public void verifyMyAccountPage() {
        try {
            seleniumWrapper.EleIsDisplayed(MY_ACCOUNT_HEADER);
        } catch (Exception e) {
            throw new RuntimeException("Error verifying My Account page: " + e.getMessage(), e);
        }
    }
}
