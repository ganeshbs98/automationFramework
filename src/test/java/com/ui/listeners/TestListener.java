//package com.ui.listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//public class TestListener implements ITestListener {
//    private static ExtentSparkReporter extentSparkReporter;
//    ExtentReports extentReports;
//    ExtentTest extentTest;
//
//    public void onTestStart(ITestResult result) {
//        extentTest=extentReports.createTest(result.getMethod().getMethodName());
//
//        //this one is called the moment test is called
//    }
//
//    public void onTestSuccess(ITestResult result) {
//        extentTest.log(Status.PASS,result.getMethod().getMethodName() +" "+ "PASSED");
//        //this is called when the test is pass
//    }
//
//    public void onTestFailure(ITestResult result) {
//        extentTest.log(Status.FAIL,result.getMethod().getMethodName() +" "+ "FAILED");
//
//        //this is called when test fails
//    }
//
//    public void onTestSkipped(ITestResult result) {
//        extentTest.log(Status.SKIP,result.getMethod().getMethodName() +" "+ "SKIPPED");
//
//    }
//    public void onStart(ITestContext context) {
//        extentSparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/src/test/resources/Reports/Test.html");
//        extentReports=new ExtentReports();
//        extentReports.attachReporter(extentSparkReporter);
//
//    }
//
//    public void onFinish(ITestContext context) {
//        extentReports.flush();
//    }
//}
