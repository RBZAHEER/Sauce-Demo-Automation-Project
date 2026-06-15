package org.example.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getReports(){
        if(extent == null){
            ExtentSparkReporter esr = new ExtentSparkReporter("reports/TestReport.html");

            String tt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            esr.config().setReportName("Sauce Demo Automation Report" + tt);

            esr.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();

            extent.attachReporter(esr);

            extent.setSystemInfo("Tester","Zaheer");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium POM"
            );

        }

        return extent;
    }
}
