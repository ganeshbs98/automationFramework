package com.ui.Utilis;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Controller extends TestBase {
    Logger logger=LoggerUtility.getLogger(this.getClass());
    public static WebDriver driver;
    public static AndroidDriver androidDriver;
    public static IOSDriver iosDriver;

    public Controller() {
        this.driver = browser();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }

    public void setIosDriver(IOSDriver iosDriver) {
        this.iosDriver = iosDriver;
    }
}
