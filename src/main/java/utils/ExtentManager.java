package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
//	private static ExtentHtmlReporter htmlReporter;
	private static ExtentSparkReporter spark;
	private static ExtentTest test;

	public static ExtentReports getInstance() {
		if (extent == null) {
			String reportName = "ExtentReport.html";
			String filePath = System.getProperty("user.dir")+ "\\" + reportName;
//			htmlReporter = new ExtentHtmlReporter(filePath);
			System.out.println(filePath);
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(filePath);
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Crestech");
			spark.config().setReportName("Smoke Test Suite");
			spark.config().setTimelineEnabled(true);
		}
		return extent;
	}
	
	public static ExtentTest createTest(String testName) {
        test = getInstance().createTest(testName);
        return test;
    }
	
	public static void flush() {
	    if (extent != null) {
	        extent.flush();
	    }
	}
}