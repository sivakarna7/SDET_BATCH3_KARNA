package utilities;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import modules.TestData;

public class ReportUtil {

	public ReportUtil() throws IOException {
		TestData.spark = new ExtentSparkReporter(
				TestData.TestResults + SeleniumUtil.datestamp() + "/ExtentTest_" + SeleniumUtil.timestamp() + ".html");
		TestData.extent = new ExtentReports();
		TestData.spark.loadXMLConfig(TestData.CONFIG_FILE);
		TestData.extent.attachReporter(TestData.spark);
	}
	public void reportStatus(String testName, String auth, String cat, String info, Status stat) {		
		TestData.test = TestData.extent.createTest(testName);
		TestData.test.assignAuthor(auth);
		TestData.test.assignCategory(cat);
		TestData.test.info(info);
		TestData.test.log(stat, info);
	}
}
