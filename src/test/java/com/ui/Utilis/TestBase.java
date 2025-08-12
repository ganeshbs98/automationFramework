package com.ui.Utilis;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.PojoClasses.RemoteEnvPojo;
import com.ui.PojoClasses.TestEnv;
import com.ui.PojoClasses.TestEnvPojo;
import com.ui.Utilis.Android.Android;
import com.ui.Utilis.Android.AppiumManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;

public class TestBase extends Android {
    Logger logger=LoggerUtility.getLogger(this.getClass());


    public WebDriver driver;
    public AndroidDriver androidDriver;
    public IOSDriver iosDriver;

    public TestBase() {
        if (browser() != null) {
            this.driver = browser();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

//    public WebDriver getDriver() {
//        return driver;
//    }
//
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }
//
    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }
//
//    public IOSDriver getIosDriver() {
//        return iosDriver;
//    }
//
//    public void setIosDriver(IOSDriver iosDriver) {
//        this.iosDriver = iosDriver;
//    }

//    @BeforeSuite
//    public void beforeSuite() {
//        Initializers.initExtentReport();
//    }
//    @BeforeMethod
//    public void setupTest(Method method) {
//        // Starts a new test for each TestNG @Test method
//        ExtentTest test = Initializers.startTest(method.getName());
//    }

    @BeforeTest
    public void testBaseInitialisation(ITestContext context, XmlTest xmlTest) {
        logger.info("loading and setting the remote env json");
        RemoteEnvPojo tRemoteEnv = JsonUtility.readJson("/tenv/remote-env.json", RemoteEnvPojo.class);
        logger.info("loading and setting the Test env json");
        TestEnvPojo tLocalEnv = JsonUtility.readJson("/tenv/test-env.json", TestEnvPojo.class);
        envThreadLocal.set(new TestEnv());
        tEnv().setExecution_type(tRemoteEnv.getExecution_type());
        tEnv().setGrid_execution_local(tRemoteEnv.getGrid_execution_local());
        tEnv().setInitialSelfHeal(tRemoteEnv.getInitialSelfHeal());
        tEnv().setMailPassword(tEnv().getMailPassword());
        tEnv().setHealingToggle(tRemoteEnv.getHealingToggle());
        tEnv().setHealingMatchScore(tRemoteEnv.getHealingMatchScore());
        tEnv().setJenkins_execution(tRemoteEnv.getJenkins_execution());
        tEnv().setAppType("Android");

        if (tLocalEnv.getWeb() != null) {
            tEnv().setWebSystemOS(tLocalEnv.getWeb().getSystemOS());
            tEnv().setWebSystemOSVersion(tLocalEnv.getWeb().getSystemOsVersion());
            tEnv().setWebBrowser(tLocalEnv.getWeb().getBrowser());
            tEnv().setWebHeadless(tLocalEnv.getWeb().getHeadless());
            tEnv().setWebBrowserVersion(tLocalEnv.getWeb().getBrowserVersion());
            tEnv().setWebUrl(tLocalEnv.getWeb().getWebUrl());
            tEnv().setWebBuildNumber(tLocalEnv.getWeb().getBuildNumber());
            tEnv().setWebNetworkLogs(tLocalEnv.getWeb().getNetworkLgs());
            tEnv().setApiEnvType(tLocalEnv.getApi().getEnv_Type());
            envtype = tEnv().getApiEnvType();
        }
        if (context.getSuite().getParameter("url") != null) {
            tEnv().setWebUrl(context.getSuite().getParameter("url"));
            System.out.println(tEnv().getWebUrl());
        }
        if (!tEnv().getExecution_type().equalsIgnoreCase("remote")) {
            AppiumManager appiumManager = new AppiumManager();
            appiumManager.startAppium();
        }
        logger.info("creating the Browser Instance");
        if (tEnv().getAppType().equalsIgnoreCase("Android")) {
            tEnv().setElementLocator("Android");
            createAndroidInstance(context, xmlTest);

        }
//        else {
//            createBrowserInstance(context, xmlTest);
//        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        ExtentTest test = Initializers.getTest();
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            // You can add logic to capture and attach a screenshot here
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        } else {
            test.log(Status.PASS, "Test Passed");
        }
        Initializers.extent.flush();
        Initializers.endTest();
    }

    @AfterSuite
    public void afterSuite() {
        // You can add final report cleanup or closure here if needed
    }


}
