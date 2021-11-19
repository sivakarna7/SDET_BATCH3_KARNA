
package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import utilities.SeleniumUtil;

public class Assignment_8To9 {
	WebDriver driver;
	SeleniumUtil objSelUtil;
	TestData objTestData;

	@BeforeClass
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
	 * 8- Write Test method and page title for different menus- in order(Admin, PIM,
	 * Leave Dashboard, Directory and Maintenance)
	 */
	@Test(priority = 1)
	public void TC008_PageTitles() throws Exception {
		objSelUtil.setValues(LoginPageLocators.username, TestData.username);
		objSelUtil.setValues(LoginPageLocators.password, TestData.password);
		objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		objSelUtil.clickWebElement(HomePageLocators.mainAdmin);
		Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "Admin Title is not matching:");
		objSelUtil.clickWebElement(HomePageLocators.mainPIM);
		Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "PIM Title is not matching:");
		objSelUtil.waitForElement(HomePageLocators.mainLeave);
		objSelUtil.hoverMouse(HomePageLocators.mainLeave);
		objSelUtil.clickWebElement(HomePageLocators.leaveList);
		Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "Leave Title is not matching:");
		objSelUtil.clickWebElement(HomePageLocators.mainDirectory);
		Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "Directory Title is not matching:");
		objSelUtil.clickWebElement(HomePageLocators.mainMaintenance);
		Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "Maintenance Title is not matching:");
	}

	/* 9- Write a method (avoid using Test annotation) to minimize the window. */
	@AfterClass
	public void closeApps() {
		objSelUtil.minimizeBrowser();//minimizes the window
		objSelUtil.closeBrowser();
		objSelUtil.quitBrowser();
	}
}
