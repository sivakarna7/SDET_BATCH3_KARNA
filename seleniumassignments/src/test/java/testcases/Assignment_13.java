
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
public class Assignment_13 {
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
	 * 13- Execute following scenario • Login to OrangeHRM • Click on PIM • Enter
	 * Employee Name-Linda Anderson in Search box (refer below image) • Validate and
	 * capture screenshot
	 */
	@Test
	public void TC013_PIM_Validation() throws Exception {
		objSelUtil.setValues(LoginPageLocators.username, TestData.username);
		objSelUtil.setValues(LoginPageLocators.password, TestData.password);
		objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		objSelUtil.clickWebElement(HomePageLocators.mainPIM);
		objSelUtil.setValues(HomePageLocators.pimEmpName, "Linda Anderson");
		objSelUtil.clickWebElement(HomePageLocators.pimSrchBtn);
	}

	@AfterSuite
	public void closeApps() {
		objSelUtil.quitBrowser();
	}
}
