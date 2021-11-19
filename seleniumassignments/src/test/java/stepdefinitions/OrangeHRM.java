package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import modules.TestData;
import pageobjects.HomePageLocators;
import pageobjects.LoginPageLocators;
import pageobjects.TimePageLocators;
import utilities.SeleniumUtil;

public class OrangeHRM {
	public WebDriver driver;
	public SeleniumUtil objSelUtil;
	public TestData objTestData;
	String date = "";
	String time = "";
	String PunchInTime = "";

	// ****************************** TC016_Scenario1
	@Given("Launch url")
	public void launch_url() {
		objSelUtil = new SeleniumUtil(driver);
		System.out.println("Setting up driver");
		objSelUtil.launchBrowsers("chrome");
		objTestData = new TestData(driver);
		objSelUtil.implicityWait();
	}

	@When("I am in OrangeHRP Application")
	public void i_am_in_orange_hrp_application() {
		// System.out.println("Launching URL: " + TestData.AppURL);
		objSelUtil.openApplication(TestData.AppURL);
	}

	@Then("Login to Application")
	public void login_to_application() {
		try {
			objSelUtil.setValues(LoginPageLocators.username, TestData.username);
			objSelUtil.setValues(LoginPageLocators.password, TestData.password);
			objSelUtil.clickWebElement(LoginPageLocators.btnLogin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Dashboard page is available and click on Admin menu")
	public void dashboard_page_is_available_and_click_on_admin_menu() {
		try {
			objSelUtil.clickWebElement(HomePageLocators.mainAdmin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("Close application")
	public void close_application() {
		objSelUtil.quitBrowser();
	}

	// ************************************TC017_Scenario2
	@Given("I click on Admin Link")
	public void i_click_on_admin_link() {
		try {
			objSelUtil.clickWebElement(HomePageLocators.mainAdmin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("Click on Job")
	public void click_on_job() {
		try {
			objSelUtil.hoverMouse(HomePageLocators.mainAdmin);
			objSelUtil.hoverMouse(HomePageLocators.adminJob);
			objSelUtil.hoverMouse(HomePageLocators.adminJobTitles);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("validate text Job Title")
	public void validate_text_job_title() {
		try {
			Assert.assertEquals(objSelUtil.getText(HomePageLocators.adminJobTitles), "Job Titles", "Not Matching: ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ***********************************TC018_Scenario3
	@Given("User logged in successfully")
	public void user_logged_in_successfully() {
		try {
			Assert.assertEquals(objSelUtil.driver.getTitle(), "OrangeHRM", "Not logged In: ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Checking for default tab")
	public void checking_for_default_tab() {
		try {
			Assert.assertEquals(objSelUtil.isEnabled(HomePageLocators.mainDashboard), true,
					"Default is not Dashboard: ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Given("Getting into Attendance")
	public void getting_into_attendance() {
		try {
			objSelUtil.hoverMouse(HomePageLocators.mainTime);
			objSelUtil.hoverMouse(TimePageLocators.attendance);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Punching In")
	public void punching_in() {
		try {
			objSelUtil.clickWebElement(TimePageLocators.attPunchIn);
			String welcomeName = objSelUtil.getText(HomePageLocators.welcome);
			String[] arr = welcomeName.split(" ", 2);
			objSelUtil.setValues(TimePageLocators.attPunchInNotes, "Logged in: " + arr[1]);
			objSelUtil.clickWebElement(TimePageLocators.attPunchInBtn);
			PunchInTime = objSelUtil.getText(TimePageLocators.attPunchInTime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Validate success or failure")
	public void validate_success_or_failure() {
		try {
			date = SeleniumUtil.date_YYYY_MM_DD();
			time = SeleniumUtil.time_HHMM();
			String varPunchInTime = date + " " + time;
			Assert.assertEquals(PunchInTime, varPunchInTime, "Not Punched In:");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Getting into Employee Records")
	public void getting_into_employee_records() {
		try {
			objSelUtil.clickWebElement(TimePageLocators.attEmpRecords);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Searching for Employee Record")
	public void searching_for_employee_record() {
		try {
			String welcomeName = objSelUtil.getText(HomePageLocators.welcome);
			String[] arr = welcomeName.split(" ", 2);
			objSelUtil.setValues(TimePageLocators.attEmpName, arr[1]);
			objSelUtil.clickWebElement(TimePageLocators.attEmpRecNameList);
			objSelUtil.clickWebElement(TimePageLocators.attEmpRecDate);
			String calDatePick = "xpath=//*[@id='ui-datepicker-div']//table//tbody//tr//a[contains(text(),'"
					+ SeleniumUtil.todaydate() + "')]";
			objSelUtil.clickWebElement(calDatePick);
			objSelUtil.clickWebElement(TimePageLocators.attEmpRecBtnView);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Then("Capture screenshot")
	public void capture_screenshot() {
		objSelUtil.shutterbugScreenshot("EmployeeAttendanceRecords");
	}

	@When("Punching Out")
	public void punching_out() {
		try {
			objSelUtil.clickWebElement(TimePageLocators.attPunchIn);
			String welcomeName = objSelUtil.getText(HomePageLocators.welcome);
			String[] arr = welcomeName.split(" ", 2);
			objSelUtil.setValues(TimePageLocators.attPunchInNotes, "Logged Out: " + arr[1]);
			objSelUtil.clickWebElement(TimePageLocators.attPunchInBtn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@When("Validate punched out or not")
	public void validate_punched_out_or_not() {
		try {
			Assert.assertEquals(objSelUtil.getAttribute(TimePageLocators.attPunchInBtn, "value"), "In",
					"Not Punched out");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}