package com.automation.capstone.capstoneshopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationError {

	WebDriver driver;
	
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

	public AccountCreationError(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@Test
	public void mandatoryFldValidation() {
		
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
		System.out.println( emailAddressErr.getText());
		
		pass.sendKeys("te");
		submit.click();
		Assert.assertEquals("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.", passErr.getText());
		System.out.println( passErr.getText());
		
		pass.sendKeys("test123");
		submit.click();
		Assert.assertEquals("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.", passErr.getText());
		System.out.println( passErr.getText());
		
		pass.sendKeys("Test123#123");
		passconfirmation.sendKeys("test123");
		submit.click();
		Assert.assertEquals("Please enter the same value again.", passConfirmationErr.getText());
		System.out.println( passErr.getText());
		
		
		  }
		 
	}


