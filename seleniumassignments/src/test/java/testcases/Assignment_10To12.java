
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import utilities.SeleniumUtil;

/*11- Implement ITestListener for above scenario where full-page screenshot needs to be capture where ever test is pass or failed. 
 * Hint – Please use Shutterbug class*/
@Listeners(modules.ITestListerners.class)
public class Assignment_10To12 {
	WebDriver driver;
	SeleniumUtil objSelUtil;
	TestData objTestData;

	@BeforeMethod
	public void Setup() {
		objSelUtil = new SeleniumUtil(driver);
		System.out.println("Setting up driver");
		objSelUtil.launchBrowsers("chrome");
		objTestData = new TestData(objSelUtil.driver);
		objSelUtil.implicityWait();
		System.out.println("Launching URL: " + TestData.AppURL);
		objSelUtil.openApplication(TestData.AppURL);
	}

	/*
	 * 10- Read Dashboard heading using [driver.findelement(by.xpath()).gettext()].
	 * Refer below screenshot-
	 */
	@Test
	public void TC010_ReadHeading() throws Exception {
		try {
			objSelUtil.setValues(LoginPageLocators.username, TestData.username);
			objSelUtil.setValues(LoginPageLocators.password, TestData.password);
			objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
			objSelUtil.clickWebElement(HomePageLocators.mainDashboard);
			System.out.println("Reading Dashboard header text: " + objSelUtil.getText(HomePageLocators.dashboardHdg));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* 12- Implement Retry analyzer – retry 3 times only for the above scenario. */
	@Test(retryAnalyzer = modules.IRetryAnalyzerListener.class)
	public void TC011_12_RetryAnalyzer() {
		try {
			Assert.assertEquals(false, true, "Failing Intentionally:");
		} catch (Exception e) {
			System.out.println("Failing intentionally");
		}
	}

	@AfterMethod
	public void closeApps() {
		objSelUtil.quitBrowser();
	}
}
