package org.example.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import org.example.base.BaseTest;
import org.example.utils.ExtentManager;
import org.example.utils.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getReports();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result){

        test = extent.createTest(result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result){

        test.pass("Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result){

        test.fail(result.getThrowable());
        test.fail(
                "Screenshot captured"
        );
        //Get test class object
        BaseTest test = (BaseTest) result.getInstance();
        //Call Screenshot method
        ScreenshotUtil.takeScreenshot(test.driver, result.getName());

    }

    @Override
    public void onFinish(
            org.testng.ITestContext context
    ){


        extent.flush();


    }
}
