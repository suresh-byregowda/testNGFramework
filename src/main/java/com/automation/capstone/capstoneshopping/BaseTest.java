package com.automation.capstone.capstoneshopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	File src;
	FileInputStream fis;
	Properties prop;
	Logger log;
	ExtentReports report;
	ExtentTest test;

	@BeforeSuite
	public void beforeSuite() throws IOException {

		report = new ExtentReports("./src/extentReport/Report.html");

		src = new File(
				"C:\\Users\\Sridevi.HP\\eclipse-workspace\\Capstone\\capstoneshopping\\resources\\data.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);

		PropertyConfigurator.configure(
				"C:\\Users\\Sridevi.HP\\eclipse-workspace\\Capstone\\capstoneshopping\\resources\\log4j.properties");
		log = Logger.getLogger("TestCases.class");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		wait = new WebDriverWait(driver, 40);
		js = (JavascriptExecutor) driver;
		act = new Actions(driver);

	}
	
	@AfterSuite
	public void endTest() {
		report.flush();
		driver.quit();
		
	}
	
	@BeforeMethod
	public void reportfluch(ITestResult result) {

	}
	
	@AfterMethod
	public void reportSetup(ITestResult result) {
		
	}


	
	

}
