package modules;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestData {
	public static WebDriver driver;
	public static String AppURL = "https://opensource-demo.orangehrmlive.com";
	public static String username = "Admin";
	public static String password = "admin123";
	public static final String CONFIG_PROP_FILE = "src/main/resources/postedgeData.properties";
	public static final String EXCEL_INPUT_FILE = "src/main/resources/testData.xlsx";
	public static final String CONFIG_FILE = "src/main/resources/extent-config.xml";
	public static final String dataSheet = "Sheet1";
	public static Properties p;

	public static String DownloadPath = "C:/Users/" + System.getProperty("user.name") + "/Downloads/";
	public static String TestResults = "test-output/QATestResults_";
	public static ArrayList<HashMap<String, String>> hmInput = new ArrayList<HashMap<String, String>>();
	public static ArrayList<HashMap<String, String>> listLocationTableDataUI = new ArrayList<HashMap<String, String>>();
	public static ArrayList<HashMap<String, String>> listGeneralInfoDataUI = new ArrayList<HashMap<String, String>>();
	public static String[][] arrayExcelData = null;

	public static URL url;
	public static File file;
	public static InputStream input;
	public static BufferedInputStream fileToParse;

	public static BufferedReader fileSrc;
	public static BufferedReader fileDst;

	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static String date1;

	public static String downloadedFileName = null;
	public static String BackerfilePath = null;

	public static FileReader fr;
	public static FileWriter fw;

	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static HSSFWorkbook hworkbook;
	public static FileInputStream fis;
	public static FileOutputStream fos;

	public TestData(WebDriver driver) {
		TestData.driver = driver;
	}

	public String MonthPicker(String m) {
		String monthValue = null;
		switch (m) {
		case "1":
			monthValue = "Jan";
			break;
		case "2":
			monthValue = "Feb";
			break;
		case "3":
			monthValue = "Mar";
			break;
		case "4":
			monthValue = "Apr";
			break;
		case "5":
			monthValue = "May";
			break;
		case "6":
			monthValue = "Jun";
			break;
		case "7":
			monthValue = "Jul";
			break;
		case "8":
			monthValue = "Aug";
			break;
		case "9":
			monthValue = "Sep";
			break;
		case "10":
			monthValue = "Oct";
			break;
		case "11":
			monthValue = "Nov";
			break;
		case "12":
			monthValue = "Dec";
			break;
		default:
			System.out.println("Invalid Month");
		}
		return monthValue;

	}
}