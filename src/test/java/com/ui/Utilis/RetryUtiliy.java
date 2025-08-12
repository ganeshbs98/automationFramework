package com.ui.Utilis;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUtiliy implements IRetryAnalyzer {

    private static final int COUNT=3;

    @Override
    public boolean retry(ITestResult iTestResult) {

        return false;
    }

}
