
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import utilities.SeleniumUtil;

@Listeners(modules.ITestListerners.class)
public class Assignment_14 {
	WebDriver driver;
	SeleniumUtil objSelUtil;
	TestData objTestData;

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
	 * 14- Write CSS Selector of highlighted Rectangular object (in Red) in below
	 * Image-
	 */
	@Test
	public void TC014_CSSselectors_Validation() throws Exception {
		objSelUtil.setValues(LoginPageLocators.username, TestData.username);
		objSelUtil.setValues(LoginPageLocators.password, TestData.password);
		objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		objSelUtil.highlightElement(HomePageLocators.cssMainPIM);
		objSelUtil.highlightElement(HomePageLocators.cssMainTime);
		objSelUtil.highlightElement(HomePageLocators.cssMainMaintenance);
		objSelUtil.highlightElement(HomePageLocators.cssDashAssignLeave);
		objSelUtil.highlightElement(HomePageLocators.cssDashTimeSheet);
		objSelUtil.highlightElement(HomePageLocators.cssDashPie);
	}

	/*
	 * 15- Write Xpath Selector of highlighted Rectangular object (in Red) in below
	 */
	@Test
	public void TC015_XpathSelectors_Validation() throws Exception {
		objSelUtil.refreshPage();
		objSelUtil.highlightElement(HomePageLocators.mainAdmin);
		objSelUtil.highlightElement(HomePageLocators.marketPlace);
		objSelUtil.highlightElement(HomePageLocators.dashTimesheets);
		objSelUtil.highlightElement(HomePageLocators.welcome);
	}

	@AfterSuite
	public void closeApps() {
		objSelUtil.quitBrowser();
	}
}
