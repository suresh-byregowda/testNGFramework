package com.automation.capstone.capstoneshopping;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
 
  @BeforeSuite
  public void beforeSuite() {
	  
	  WebDriverManager.chromedriver().setup();	
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://magento.softwaretestingboard.com/");	  
	  //wait = new WebDriverWait(driver, 10);
	  js = (JavascriptExecutor)driver;
			  
	  
	  
	  
  }

}
