package com.ui.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.ui.Utilis.ExtentReportUtility;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestListeners  implements IAnnotationTransformer, ITestListener {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        // This line applies the RetryAnalyzer to every @Test method found
        annotation.setRetryAnalyzer(MyretryAnalyzer.class);
    }
    public void onTestStart(ITestResult result) {

        ExtentReportUtility.createExtentTest(result.getMethod()
                .getMethodName());

        //this one is called the moment test is called
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReportUtility.getExtentTest().log(Status.PASS,result.getMethod().getMethodName() +" "+ "PASSED");
        //this is called when the test is pass

    }

    public void onTestFailure(ITestResult result) {
        ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getMethod().getMethodName() +" "+ "FAILED");

        //this is called when test fails
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReportUtility.setUpSparkreporter("/src/test/resources/report.html");
    }
    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        ExtentReportUtility.flushReport();
    }
}
