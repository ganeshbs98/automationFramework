//package com.ui.Utilis;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.testng.ITestContext;
//import org.testng.xml.XmlTest;
//
//public class ExtentReportUtility {
//    private static ExtentSparkReporter extentSparkReporter;
//    private static ExtentReports extentReports;
//    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
//
//    public static void setUpSparkreporter(String filePath) {
//        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + filePath);
//        extentReports = new ExtentReports();
//        extentReports.attachReporter(extentSparkReporter);
//    }
//
//    public static void createExtentTest(String name) {
//        ExtentTest test = extentReports.createTest(name);
//        extentTest.set(test);
//    }
//
//    public static ExtentTest getExtentTest() {
//        return extentTest.get();
//
//    }
//    public static void flushReport(){
//        extentReports.flush();
//    }
//
//}
