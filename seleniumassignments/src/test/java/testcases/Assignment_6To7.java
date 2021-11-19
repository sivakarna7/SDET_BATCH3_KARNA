
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import utilities.SeleniumUtil;

public class Assignment_6To7 {
	WebDriver driver;
	SeleniumUtil objSelUtil;
	TestData objTestData;

	/*
	 * 6- Launch a browser in @Beforesuite annotation and open url . url -
	 * https://opensource-demo.orangehrmlive.com/
	 */
	@BeforeSuite
	public void LaunchURl() {
		objSelUtil = new SeleniumUtil(driver);
		System.out.println("Setting up driver");
		objSelUtil.launchBrowsers("chrome");
		objTestData = new TestData(objSelUtil.driver);
		objSelUtil.implicityWait();
		System.out.println("Launching URL: " + TestData.AppURL);
		objSelUtil.openApplication(TestData.AppURL);
	}

	/*
	 * 7- Login to application again in @Test method, set priority 1 of the same
	 * method After logging
	 */
	@Test(priority = 1)
	public void TC006_7_BeforeSuiteAndPriorityLogin() throws Exception {
		objSelUtil.setValues(LoginPageLocators.username, TestData.username);
		objSelUtil.setValues(LoginPageLocators.password, TestData.password);
		objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		Assert.assertEquals(objSelUtil.isDisplayed(HomePageLocators.welcome), true, "Login Failed");
	}

	@AfterSuite
	public void closeApps() {
		objSelUtil.closeBrowser();
		objSelUtil.quitBrowser();
	}

}
