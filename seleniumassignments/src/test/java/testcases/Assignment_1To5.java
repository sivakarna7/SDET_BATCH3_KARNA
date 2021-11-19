
package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import utilities.SeleniumUtil;

public class Assignment_1To5 {
	WebDriver driver;
	SeleniumUtil objSelUtil;
	TestData objTestData;

	@BeforeClass
	public void setUp() {
		objSelUtil = new SeleniumUtil(driver);
		System.out.println("Setting up driver");
		objSelUtil.launchBrowsers("chrome");
		objTestData = new TestData(objSelUtil.driver);
		objSelUtil.implicityWait();
	}

	/* 1- Open the above URL in Chrome browser. */
	@Test
	public void TC001_LaunchURL() {
		System.out.println("*******************************************************");
		System.out.println("Launching URL: " + TestData.AppURL);
		objSelUtil.openApplication(TestData.AppURL);
	}

	/* 2- Print the title of this application. */
	@Test
	public void TC002_Title() {
		try {
			System.out.println("*******************************************************");
			System.out.println("Title of the URL: " + objSelUtil.driver.getTitle());
			Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM");
		} catch (Exception e) {
			System.out.println("Page is not loaded");
			e.printStackTrace();
		}
	}

	/*
	 * 3- Write Xpath and CssSelector of login page for following web objects - All
	 * Text box’s, All - Hyperlinks, All Images.
	 */
	@Test
	public void TC003_LoginPageElements() {
		try {
			System.out.println("*******************************************************");
			List<WebElement> lstTxtBox = objSelUtil.driver.findElements(By.tagName("form"));
			System.out.println("Total TextBoxes:" + lstTxtBox.size());
			for (WebElement ele : lstTxtBox) {
				System.out.println(ele.getText() + "	" + ele.getAttribute("input"));
			}
			System.out.println("*******************************************************");
			List<WebElement> lstLinks = objSelUtil.driver.findElements(By.tagName("a"));
			System.out.println("Total Links:" + lstLinks.size());
			for (WebElement ele : lstLinks) {
				System.out.println(ele.getText() + "	" + ele.getAttribute("href"));
			}
			System.out.println("*******************************************************");
			List<WebElement> lstImg = objSelUtil.driver.findElements(By.tagName("img"));
			System.out.println("Total Images:" + lstImg.size());
			for (WebElement ele : lstImg) {
				System.out.println(ele.getText() + "	" + ele.getAttribute("src"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* 4- Login with given User Name and Password and validate Dashboard. */
	@Test
	public void TC004_LoginValidCredentials() throws Exception {
		System.out.println("*******************************************************");
		objSelUtil.setValues(LoginPageLocators.username, TestData.username);
		objSelUtil.setValues(LoginPageLocators.password, TestData.password);
		objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		Assert.assertEquals(objSelUtil.isEnabled(HomePageLocators.mainDashboard), true);
		System.out.println("Logged In");
	}

	/*
	 * 5- Click on Admin Link in Home Page and validate following text - • User
	 * Management • Job • Organization • Qualifications
	 */
	@Test
	public void TC005_AdminLink_Text_Validation() throws Exception {
		try {
			System.out.println("*******************************************************");
			objSelUtil.hoverMouse(HomePageLocators.mainAdmin);
			System.out
					.println("Checking: " + objSelUtil.getText(HomePageLocators.adminUserMgmt) + " == User Management");
			Assert.assertEquals(objSelUtil.getText(HomePageLocators.adminUserMgmt), "User Management",
					"User Management text not matching:");
			System.out.println("Checking: " + objSelUtil.getText(HomePageLocators.adminJob) + " == Job");
			Assert.assertEquals(objSelUtil.getText(HomePageLocators.adminJob), "Job", "Job text not matching:");
			System.out.println(
					"Checking: " + objSelUtil.getText(HomePageLocators.adminOrganization) + " == Organization");
			Assert.assertEquals(objSelUtil.getText(HomePageLocators.adminOrganization), "Organization",
					"Organization text not matching:");
			System.out.println(
					"Checking: " + objSelUtil.getText(HomePageLocators.adminQualifications) + " == Qualifications");
			Assert.assertEquals(objSelUtil.getText(HomePageLocators.adminQualifications), "Qualifications",
					"Qualifications text not matching:");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@AfterClass
	public void closeApps() {
		System.out.println("*******************************************************");
		objSelUtil.closeBrowser();
	}
}
