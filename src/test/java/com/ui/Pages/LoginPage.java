package com.ui.Pages;

import com.ui.Utilis.LoggerUtility;
import com.ui.Utilis.SeleniumWrapper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    SeleniumWrapper seleniumWrapper=new SeleniumWrapper();
    private static final By EMAIL_FIELD = By.id("email");
    private static final By PASSWORD_FIELD = By.id("passwd");
    private static final By submitButton = By.id("SubmitLogin");



    public void EnterLoginDetails(String email,String password){
        seleniumWrapper.enterText(EMAIL_FIELD, email);
        logger.info("Entering the Password field");
        seleniumWrapper.enterText(PASSWORD_FIELD, password);
        logger.info("Entering the Submit button");
        seleniumWrapper.click(submitButton);
    }
}
