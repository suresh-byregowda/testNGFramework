package com.automation.capstone.capstoneshopping;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Login {

	private WebDriver driver;
	private Properties prop;
	private Logger log;
	private ExtentTest test;
	private ExtentReports report;

	private WebDriverWait wait;

	@FindBy(partialLinkText = "Sign In")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "pass")
	WebElement pass;

	@FindBy(xpath = "//div/button[@type = 'submit']/span[text() = 'Sign In']")
	WebElement submit;

	@FindBy(xpath = "//span[@class = 'logged-in'][text() = 'Welcome, testf testl!']")
	WebElement success;

	@FindBy(xpath = "//div[contains(text(),'There is already an account with this email address.')]")
	WebElement failure;

	public Login(WebDriver driver, Properties prop, Logger log, WebDriverWait wait, ExtentTest test, ExtentReports report) {

		this.driver = driver;
		this.prop = prop;
		this.log = log;
		this.wait = wait;
		this.test = test;
		this.report= report;
		PageFactory.initElements(driver, this);
	}

	public void loginToCapstone() {

		log.info("===============Login test cases===============");
		test = report.startTest("loginToCapstone");
		signIn.click();
		email.sendKeys(prop.getProperty("username"));
		pass.sendKeys(prop.getProperty("password"));
		submit.click();
		wait.until(ExpectedConditions.visibilityOf(success));
		Assert.assertTrue(success.isDisplayed(), "User could not login successfully");
		log.info("User could not login successfully");

		try {
			if (success.isDisplayed()) {
				test.log(LogStatus.PASS, "User logged in successfully");
				log.info("User logged in successfully");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,"User could not login successfully ");
			log.info("User could not login successfully");
		}
		report.endTest(test);
	}

}
