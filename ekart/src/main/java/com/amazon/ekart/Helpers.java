package com.amazon.ekart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Helpers {
	//static String browser = "chrome";
	public static WebDriver driver;
	//public BufferedReader reader;
	static String propertyFilePath = ".//src//common//property.properties";
	//public static Properties properties;
	public static Properties properties() throws IOException {
			
			//reader = new BufferedReader(new FileReader(propertyFilePath));
			FileInputStream file = new FileInputStream(propertyFilePath);
			Properties properties = new Properties();
			
			properties.load(file);
			return properties;
		
	}
	
	public static String getBrowserName() throws IOException {
		String browser = properties().getProperty("browser");
		System.out.println(browser);
		return browser;
	}
	public static String getChromePath() throws IOException {
		String browserPath = properties().getProperty("chromepath");
		System.out.println(browserPath);
		return browserPath ;
	}
	
	public static String getURL() throws IOException {
		String url = properties().getProperty("url");
		System.out.println(url);
		return url;
	}
	public static String dataFilePath() throws IOException {
		String filepath = properties().getProperty("datafile");
		System.out.println(filepath);
		return filepath;
	}
	public static String sheetName() throws IOException {
		String sheetname = properties().getProperty("sheetname");
		System.out.println(sheetname);
		return sheetname;
	}
	public static String getScreenShortPath() throws IOException {
		String path = properties().getProperty("screenshotpath");
		return path;
	}
	
	public static void startBrowser() throws IOException {
		
		if(getBrowserName().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", getChromePath());
			driver = new ChromeDriver();
		}
		else if(getBrowserName().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//src//browser_drivers//geckodriver");
			driver = new FirefoxDriver();
		}
	}
	
	public static void startApplication() throws IOException {
		driver.get(getURL());
		
	}
	
	public static String readData(int r, int c) throws IOException {
		FileInputStream fis = new FileInputStream(dataFilePath());
		
	XSSFWorkbook wb = new XSSFWorkbook(fis);
		
	XSSFSheet sheet = wb.getSheet(sheetName());
	XSSFRow row = sheet.getRow(r);
	XSSFCell cell = row.getCell(c);
	String data = cell.getStringCellValue();
	return data;	
	}
	
	public static void screenShort(String screenshrotname) throws IOException {
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
	File f1	= ef.getScreenshotAs(OutputType.FILE);
	File f2 = new File(getScreenShortPath()+"//"+screenshrotname+".png");
	FileUtils.copyFile(f1, f2);
	}
	
	
	
}
