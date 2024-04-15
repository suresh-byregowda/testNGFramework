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

public class AccountCreationError {

	private WebDriver driver;
	private Logger log;
	private ExtentTest test;
	private ExtentReports report;
	
	@FindBy(xpath = "//li/a[text() =  'Create an Account']")
	WebElement createAccount;

	@FindBy(id = "firstname-error")
	WebElement firstnameErr;

	@FindBy(id = "firstname-error")
	WebElement lastnameErr;

	@FindBy(id = "email_address-error")
	WebElement emailAddressErr;

	@FindBy(id = "password-error")
	WebElement passErr;

	@FindBy(id = "password-confirmation-error")
	WebElement passConfirmationErr;

	@FindBy(partialLinkText = "Sign In")
	WebElement signIn;

	@FindBy(id = "email_address")
	WebElement email;

	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "password-confirmation")
	WebElement passconfirmation;
	
	@FindBy(xpath = "//div/button[@type = 'submit']/span[text() = 'Create an Account']")
	WebElement submit;


	public AccountCreationError(WebDriver driver, Logger log, ExtentTest test, ExtentReports report) {

		this.driver = driver;
		this.log = log;
		this.test = test;
		this.report = report;
		PageFactory.initElements(driver, this);
	}


	
	public void mandatoryFldValidation() {
		
		log.info("=================Field validatoin test cases===================");
		test = report.startTest("mandatoryFldValidation");
		createAccount.click();
		submit.click();
		Assert.assertEquals("This is a required field.", firstnameErr.getText());
		Assert.assertEquals("This is a required field.", lastnameErr.getText());
		Assert.assertEquals("This is a required field.", emailAddressErr.getText());
		Assert.assertEquals("This is a required field.", passErr.getText());
		Assert.assertEquals("This is a required field.", passConfirmationErr.getText());
		
		
		email.sendKeys("test");
		submit.click();
		Assert.assertEquals("Please enter a valid email address (Ex: johndoe@domain.com).", emailAddressErr.getText());
		if(emailAddressErr.getText().equals("Please enter a valid email address (Ex: johndoe@domain.com)."))
		{
			test.log(LogStatus.PASS, "Please enter a valid email address (Ex: johndoe@domain.com).");
			log.info(emailAddressErr.getText());
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		pass.sendKeys("te");
		submit.click();
		Assert.assertEquals("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.", passErr.getText());
		if(passErr.getText().equals("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."))
		{
			test.log(LogStatus.PASS, "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.");
			log.info(passErr.getText());
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		pass.sendKeys("test123");
		submit.click();
		Assert.assertEquals("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.", passErr.getText());
		if(passErr.getText().equals("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."))
		{
			test.log(LogStatus.PASS, "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.");
			log.info(passErr.getText());
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		pass.sendKeys("Test123#123");
		passconfirmation.sendKeys("test123");
		submit.click();
		Assert.assertEquals("Please enter the same value again.", passConfirmationErr.getText());
		if(passConfirmationErr.getText().equals("Please enter the same value again."))
		{
			test.log(LogStatus.PASS, "Please enter the same value again.");
			log.info(passConfirmationErr.getText());
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
		
		report.endTest(test);
		  }
		 
	}


