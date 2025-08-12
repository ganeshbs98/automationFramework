package com.ui.Pages;

import com.ui.Utilis.Controller;
import com.ui.Utilis.LoggerUtility;
import com.ui.Utilis.SeleniumWrapper;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public  class HomePage extends Controller {
     Logger logger = LoggerUtility.getLogger(this.getClass());
     SeleniumWrapper seleniumWrapper=new SeleniumWrapper();
     private static final By SIGN_IN_BUTTON = By.xpath("//a[contains(@title,'Log in to your' )]");

     public void goToLoginPage() {
          logger.info("Navigating to Login Page");
          seleniumWrapper.click(SIGN_IN_BUTTON);

     }

}
