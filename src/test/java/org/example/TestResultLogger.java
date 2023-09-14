package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestResultLogger implements ITestListener {
 //   private static final Logger logger = LogManager.getLogger(TestResultLogger.class);
   Log log = new Log();

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        // Test başarılı olduğunda yapılacak işlemler
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        // Test atlandığında yapılacak işlemler
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Belirli bir başarı yüzdesi içinde başarısız olan testler için yapılacak işlemler
    }

    @Override
    public void onStart(ITestContext context) {
        // TestNG test süreci başladığında yapılacak işlemler
    }

    @Override
    public void onFinish(ITestContext context) {
        // TestNG test süreci tamamlandığında yapılacak işlemler
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        String errorMessage = result.getThrowable().getMessage();
        log.error("Test " + testName + " FAILED with error: " + errorMessage);
    }
}
