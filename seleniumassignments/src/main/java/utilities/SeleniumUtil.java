package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;


public class SeleniumUtil {
	public WebDriver driver;
	public WebElement wElement;
	public List<WebElement> wElements;
	public WebDriverWait wait;
	Actions act;

	public SeleniumUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void launchBrowsers(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\My Files\\Projects\\Automation\\Selenium Files\\chromedriver_win32\\chromedriver.exe");
			// WebDriverManager.chromedriver().setup();/* WebDriverManager is not working in
			// my machine*/
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.firefox.driver",
					"C:\\My Files\\Projects\\Automation\\Selenium Files\\chromedriver_win32\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		}
	}

	public void openApplication(String link) {
		driver.manage().window().maximize();
		driver.get(link);
	}

	public void minimizeBrowser() {
		driver.manage().window().setPosition(new Point(-2000, 0));
	}

	public void implicityWait() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public void waitForElement(String element) throws Exception {
		wait = new WebDriverWait(driver, 40);
		getWebElement(element);
		wait.until(ExpectedConditions.elementToBeClickable(wElement));
	}

	public WebElement getWebElement(String locator) throws Exception {
		String[] arrLocator = locator.split("=", 2);
		String locType = arrLocator[0];
		String locVal = arrLocator[1];
		if (locType.equalsIgnoreCase("xpath")) {
			wElement = driver.findElement(By.xpath(locVal));
		} else if (locType.equalsIgnoreCase("id")) {
			wElement = driver.findElement(By.id(locVal));
		} else if (locType.equalsIgnoreCase("classname")) {
			wElement = driver.findElement(By.className(locVal));
		} else if (locType.equalsIgnoreCase("name")) {
			wElement = driver.findElement(By.name(locVal));
		} else if (locType.equalsIgnoreCase("link")) {
			wElement = driver.findElement(By.linkText(locVal));
		} else if (locType.equalsIgnoreCase("css")) {
			wElement = driver.findElement(By.cssSelector(locVal));
		} else {
			throw new Exception("Wrong object type");
		}
		return wElement;
	}

	public List<WebElement> getWebElements(String locator) throws Exception {
		String[] arrLocator = locator.split("=", 2);
		String locType = arrLocator[0];
		String locVal = arrLocator[1];
		if (locType.equalsIgnoreCase("tagName")) {
			wElements = driver.findElements(By.tagName(locVal));
		} else if (locType.equalsIgnoreCase("classname")) {
			wElements = driver.findElements(By.className(locVal));
		} else if (locType.equalsIgnoreCase("linkText")) {
			wElements = driver.findElements(By.linkText(locVal));
		} else if (locType.equalsIgnoreCase("xpath")) {
			wElements = driver.findElements(By.xpath(locVal));
		} else if (locType.equalsIgnoreCase("id")) {
			wElements = driver.findElements(By.id(locVal));
		} else if (locType.equalsIgnoreCase("name")) {
			wElements = driver.findElements(By.name(locVal));
		} else if (locType.equalsIgnoreCase("cssSelector")) {
			wElements = driver.findElements(By.cssSelector(locVal));
		} else {
			throw new Exception("Wrong object type");
		}
		return wElements;
	}

	public void clickWebElement(String clickElement) throws Exception {
		getWebElement(clickElement);
		wElement.click();
	}

	public void setValues(String element, String value) throws Exception {
		getWebElement(element);
		wElement.sendKeys(value);
	}

	public String getText(String setwElement) {
		String elementTxt = "";
		try {
			getWebElement(setwElement);
			elementTxt = wElement.getText();
		} catch (Exception e) {
			e.getMessage();
		}
		return elementTxt;
	}

	public String getAttribute(String element, String attribute) {
		String elementAttr = "";
		try {
			getWebElement(element);
			if (attribute.equalsIgnoreCase("value")) {
				elementAttr = wElement.getAttribute("value");
			} else if (attribute.equalsIgnoreCase("type")) {
				elementAttr = wElement.getAttribute("type");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return elementAttr;
	}

	public void captureScreenShot(String snapShot) {
		TakesScreenshot srcShot = ((TakesScreenshot) driver);
		File Src = srcShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Src,
					new File(TestData.TestResults + datestamp() + "/" + snapShot + "_" + timestamp() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void shutterbugScreenshot(String snapShot) {
		// Shutterbug.shootPage(driver).withName(snapShot).save();
		Shutterbug.shootPage(driver, Capture.FULL_SCROLL, 500).withName(snapShot + "_" + timestamp()).save();
	}

	public void highlightElement(String element) throws Exception {
		getWebElement(element);
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("arguments[0]. setAttribute('style', 'border:3px solid red')", wElement);
	}

	public void selectByText(String wElement, String option) throws Exception {
		Select selectDropDown = new Select(getWebElement(wElement));
		// List<WebElement> dd = selectDropDown.getOptions();
		// Loop to print one by one
		// for (int j = 0; j < dd.size(); j++) {
		// System.out.println(dd.get(j).getText());

		// }
		selectDropDown.selectByVisibleText(option);
		// return selectDropDown;
	}

	public void selectByIndex(String wElement, String option) throws Exception {
		Select selectDropDown = new Select(getWebElement(wElement));
		selectDropDown.selectByVisibleText(option);
	}

	public void selectByValue(String wElement, String option) throws Exception {
		Select selectDropDown = new Select(getWebElement(wElement));
		selectDropDown.selectByValue(option);
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void clearWebElement(String clearElement) throws Exception {
		getWebElement(clearElement);
		wElement.clear();
	}

	public void doubleClick(WebElement wElement) {
		act = new Actions(driver);
		act.doubleClick(wElement).perform();
	}

	public void hoverMouse(String element) throws Exception {
		act = new Actions(driver);
		getWebElement(element);
		act.moveToElement(wElement).build().perform();
	}

	public boolean isEnabled(String element) throws Exception {
		getWebElement(element);
		boolean enabled = wElement.isEnabled();
		return enabled;
	}

	public boolean isDisplayed(String element) throws Exception {
		try {
			getWebElement(element);
			boolean displayed = wElement.isDisplayed();
			return displayed;
		} catch (ElementNotVisibleException e) {
			return false;
		}
	}

	public boolean isSelected(String element) throws Exception {
		getWebElement(element);
		boolean selected = wElement.isSelected();
		return selected;
	}

	public int tableColCount(String element) throws Exception {
		getWebElements(element);
		int colCount = wElements.size();
		System.out.println(colCount);
		return colCount;
	}

	public int tableRowCount(String element) throws Exception {
		getWebElements(element);
		int rowCount = wElements.size();
		System.out.println(rowCount);
		return rowCount;
	}

	public List<String> getTableHeaders(String locator, int colCnt) throws Exception {
		List<String> lst = new LinkedList<String>();
		for (int i = 0; i <= colCnt; i++) {
			getWebElement(locator + "/thead/tr/th[" + i + "]");
			lst.add(wElement.getText());
		}
		return lst;
	}

	public String getTableBodyData(String locator, int rwIdx, int colIdx) throws Exception {
		String val = "";

		locator = locator + "/tbody/tr[" + rwIdx + "]/td[" + colIdx + "]";
		getWebElement(locator);
		if (wElement != null)
			val = wElement.getText();

		return val;

	}

	public List<HashMap<String, String>> getTableBodyData(String locator) throws Exception {

		List<String> l = getTableHeaders(locator, tableColCount(locator));

		List<HashMap<String, String>> lst = new LinkedList<HashMap<String, String>>();

		for (int i = 1; i <= tableRowCount(locator); i++) {
			HashMap<String, String> hmp = new HashMap<String, String>();
			for (int j = 1; j <= tableColCount(locator); j++) {
				locator = locator + "/tbody/tr[" + i + "]/td[" + j + "]";
				getWebElement(locator);
				if (wElement != null)
					hmp.put(l.get(j - 1), wElement.getText());

			}
			lst.add(hmp);

		}
		return lst;
	}

	public Alert getAlert() {
		// System.out.println("alert : " + driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
		// System.out.println("accept Alert is done...");
	}

	public void dismissAlert() {
		getAlert().dismiss();
		// System.out.println("dismiss Alert is done...");
	}

	public String getAlertText() {
		String text = getAlert().getText();
		// System.out.println("alert text: " + text);
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			// System.out.println("alert is present");
			return true;
		} catch (NoAlertPresentException e) {
			// System.out.println(e.getCause());
			return false;
		}
	}

	public void acceptAlertIfPresent() {
		if (isAlertPresent()) {
			acceptAlert();
		} else {
			System.out.println("Alert is not present..");
		}
	}

	public void dismissAlertIfPresent() {
		if (isAlertPresent()) {
			dismissAlert();
		} else {
			System.out.println("Alert is not present..");
		}
	}

	public void acceptPrompt(String text) {
		if (isAlertPresent()) {
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			System.out.println("alert text: " + text);
		}
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}

	public static String datestamp() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	public static String date_YYYY_MM_DD() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static String time_HHMM() {
		return new SimpleDateFormat("HH:mm").format(new Date());
	}

	public static String todaydate() {
		return new SimpleDateFormat("dd").format(new Date());
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
