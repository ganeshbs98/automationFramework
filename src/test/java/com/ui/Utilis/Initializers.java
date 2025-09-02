package com.ui.Utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ui.PojoClasses.ExtentPojo;
import com.ui.PojoClasses.TestEnv;
import com.ui.PojoClasses.PropertiesPojo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;


public class Initializers {
    public static PropertiesPojo propertiesPojo = new PropertiesPojo();

    protected static ThreadLocal<RemoteWebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<AndroidDriver> androidDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<IOSDriver> iosDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<TestEnv> envThreadLocal = new ThreadLocal<>();
    protected static String executionType = "local";

    public static ExtentReports extent = null;
    public static ThreadLocal<ExtentTest> extentTestNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentClassNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentMethodNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentScenarioNode = new ThreadLocal<>();
    public ExtentTest extentTest = null;
    public static ExtentPojo extentPojo = null;
    protected static String platformType;

    public static String envtype = "NA";
    protected static List<String> mobileApps;
    protected static List<String> webApps;

    public static RemoteWebDriver browser() {
        return webDriverThreadLocal.get();
    }

    public static AndroidDriver android() {
        return androidDriverThreadLocal.get();
    }

    public static IOSDriver ios() {
        return iosDriverThreadLocal.get();
    }

    public static TestEnv tEnv() {
        return envThreadLocal.get();
    }
}