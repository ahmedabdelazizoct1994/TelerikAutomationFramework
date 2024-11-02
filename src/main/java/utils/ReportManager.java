//package utils;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//
//public class ReportManager {
//    private static ExtentReports extent;
//    private static ExtentTest test;
//
//    public static void initializeReport() {
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//    }
//
//    public static ExtentTest createTest(String testName) {
//        test = extent.createTest(testName);
//        return test;
//    }
//
//    public static void flushReport() {
//        extent.flush();
//    }
//}
package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initializeReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReport() {
        extent.flush();
    }
}

