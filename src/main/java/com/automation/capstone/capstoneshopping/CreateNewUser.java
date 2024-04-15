package com.automation.capstone.capstoneshopping;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CreateNewUser {

	private Logger log;
	private WebDriver driver;
	private ExtentTest test;
	private ExtentReports report;

	@FindBy(xpath = "//li/a[text() =  'Create an Account']")
	WebElement createAccount;

	@FindBy(id = "firstname")
	WebElement firstname;

	@FindBy(id = "lastname")
	WebElement lastname;

	@FindBy(id = "email_address")
	WebElement email_address;

	@FindBy(id = "password")
	WebElement pass1;

	@FindBy(id = "password-confirmation")
	WebElement passconfirmation;

	@FindBy(xpath = "//div/button[@type = 'submit']/span[text() = 'Create an Account']")
	WebElement submit;

	@FindBy(xpath = "//div[text()='Thank you for registering with Main Website Store.']")
	WebElement success;

	@FindBy(xpath = "//div[contains(text(),'There is already an account with this email address.')]")
	WebElement failure;

	public CreateNewUser(WebDriver driver, Logger log, ExtentTest test, ExtentReports report) {

		this.driver = driver;
		this.log = log;
		this.test = test;
		this.report= report;
		PageFactory.initElements(driver, this);
	}

	public void newUserCreation() {

		log.info("================Create new user test case===============");
		test = report.startTest("newUserCreation");
		createAccount.click();
		firstname.sendKeys("testf");
		lastname.sendKeys("testl");
		email_address.sendKeys("sridevi.hp@brillio.com");
		pass1.sendKeys("Test123@123");
		passconfirmation.sendKeys("Test123@123");
		submit.click();


		try {
			if (success.isDisplayed()) {
				test.log(LogStatus.PASS, "User created successfully");
				log.info("User created successfully");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to create user successfully : " + failure.getAttribute("innerHTML"));
			log.info("Unable to create user successfully : " + failure.getAttribute("innerHTML"));
		}

		Assert.assertTrue(success.isDisplayed(),
				"Unable to create user successfully. -> " + failure.getAttribute("innerHTML"));
		report.endTest(test);

	}

}
