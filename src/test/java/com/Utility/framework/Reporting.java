package com.Utility.framework;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	private static String resultpath = "test-output/Report/"+ "Extent-Report";

	//String ReportLocation = "test-output/Report/" + resultpath + "/";
    @BeforeSuite
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());// time stamp
		String repName = "ExTentReport-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(resultpath + repName);

		//htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "\\test-output\\extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Subhendu");

		htmlReporter.config().setDocumentTitle("Rest Assured Report"); // Tile of report
		htmlReporter.config().setReportName("API Test Automation Report"); // name of the report
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //
		// location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
    @AfterMethod

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getTestClass()+tr.getName()); // create new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
	   //logger.fail(tr.getClass());                                                         // information to the report
																							// with GREEN color
																							// highlighted
	}
    @AfterMethod
	public void onTestFailure(ITestResult tr) {
		
		logger = extent.createTest(tr.getTestClass()+tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.INFO, MarkupHelper.createLabel("This is a Failed Test", ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable());
	}
    @AfterMethod
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getTestClass()+tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
    @AfterMethod
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
