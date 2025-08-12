package com.ui.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyretryAnalyzer implements IAnnotationTransformer, IRetryAnalyzer {

    private static final int MAX_ATTEMPTS = 3;
    private int current_Attempt = 1;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (current_Attempt <= MAX_ATTEMPTS) {
            current_Attempt++;
            return true;
        }
        return false;
    }
}
