package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReported {
    public static void main(String[] args){
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/TestExtentReport.html");
    extent.attachReporter(spark);
    ExtentTest test = extent.createTest("SalesforceTest0628Test");
    test.log(Status.PASS, MarkupHelper.createLabel("Test passed", ExtentColor.GREEN));
    test.log(Status.FAIL,MarkupHelper.createLabel("Test failed",ExtentColor.RED));
    test.log(Status.INFO, MarkupHelper.createLabel("Test info",ExtentColor.BLUE));
    test.log(Status.WARNING,MarkupHelper.createLabel("Test warning",ExtentColor.AMBER));
    extent.flush();
    }
    }


