package com.ui.test;

import com.ui.Pages.HomePage;
import com.ui.Pages.LoginPage;
import com.ui.Pages.MyAccount;

import com.ui.Utilis.LoggerUtility;
import com.ui.Utilis.TestBase;
import com.ui.Utilis.TestController;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    Logger logger=LoggerUtility.getLogger(this.getClass());
    @Test
    public void loginTest() {
        logger.info("Test Execution Started");
        HomePage home=new HomePage();
        home.goToLoginPage();
        LoginPage loginPage=new LoginPage();
        loginPage.EnterLoginDetails("tijigov754@nicext.com","Pass123");
        MyAccount myAccount=new MyAccount();
        myAccount.verifyMyAccountPage();

    }
}
