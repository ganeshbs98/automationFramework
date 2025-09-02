package com.ui.Utilis;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SeleniumWrapper extends Controller {
    Logger logger=LoggerUtility.getLogger(this.getClass());
    public int globalWait = 25;
    private WebDriver driver;
    private AndroidDriver androidDriver;
    private IOSDriver iosDriver;
    private WebDriverWait wait;

    public SeleniumWrapper(){
        this.driver=Controller.browser();
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(globalWait));
    }


    public void click(By locator) {
        try {

            logger.info("Clicking the element");
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }
    public void enterText(By locator, String text) {
        try {
            logger.info("Entering the text :"+ text);
            if (text != null && !text.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
                TakeScreenshot("enterText");
            } else {
                throw new IllegalArgumentException("Text cannot be null or empty");
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }
    public boolean EleIsDisplayed(By locator) {
        try {
            logger.info("verifying the element is Displayed :");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }
    private WebElement getElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + locator, e);
        }
    }

    public String TakeScreenshot(String name) {
        File cap=null;
        String path = null;
        String newPath = null;
        try{
            if (browser() != null) {
                cap = ((TakesScreenshot) browser()).getScreenshotAs(OutputType.FILE);
            } else if (android()!=null) {
                cap = ((TakesScreenshot) android()).getScreenshotAs(OutputType.FILE);

            }else {
//             cap = (TakesScreenshot) ios();
            }
             path=System.getProperty("user.dir")+"/screenshots/"+name;
            File screenShotpath=new File(path);
            FileUtils.copyFile(cap,screenShotpath);
        }catch(IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
