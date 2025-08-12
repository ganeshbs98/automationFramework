package com.ui.Utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.PojoClasses.ExtentPojo;
import com.ui.PojoClasses.TestEnv;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Initializers {
    protected static ThreadLocal<RemoteWebDriver> webDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<AndroidDriver> androidDriverThreadLocal = new ThreadLocal<>();
    protected static ThreadLocal<TestEnv> envThreadLocal = new ThreadLocal<>();

    public static ExtentReports extent = null;
    public static ThreadLocal<ExtentTest> extentTestNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentClassNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentMethodNode = new ThreadLocal<>();
    public static ThreadLocal<ExtentTest> extentScenarioNode = new ThreadLocal<>();
    public ExtentTest extentTest = null;
    public static ExtentPojo extentPojo = null;

    public static String envtype="NA";
    // Main ExtentReports initialization method
    public static synchronized void initExtentReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    // ExtentTest management for parallel execution
    public static ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestNode.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return extentTestNode.get();
    }

    public static void endTest() {
        if (extentTestNode.get() != null) {
            extentTestNode.remove();
        }
    }

    public static RemoteWebDriver browser() {
        return webDriverThreadLocal.get();
    }

    public static AndroidDriver android() {
        return androidDriverThreadLocal.get();
    }

    public static TestEnv tEnv() {
        return envThreadLocal.get();
    }
}