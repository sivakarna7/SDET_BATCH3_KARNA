package modules;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import utilities.SeleniumUtil;

public class ITestListerners implements ITestListener, ISuiteListener {

	public void onTestSuccess(ITestResult result) {
		Shutterbug.shootPage(TestData.driver, Capture.FULL_SCROLL, 500)
				.withName(result.getName() + "_" + SeleniumUtil.timestamp()).save();
	}

	public void onTestFailure(ITestResult result) {
		Shutterbug.shootPage(TestData.driver, Capture.FULL_SCROLL, 500)
				.withName("Failed_" + result.getName() + SeleniumUtil.timestamp())
				.save();
	}

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Case started: " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case skipped: " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
