package com.automation.capstone.capstoneshopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class CreateNewUser {

	WebDriver driver;

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

	public CreateNewUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Test
	public void newUserCreation() {

		createAccount.click();
		firstname.sendKeys("testf");
		lastname.sendKeys("testl");
		email_address.sendKeys("sridevi.hp@brillio.com");
		pass1.sendKeys("Test123@123");
		passconfirmation.sendKeys("Test123@123");
		submit.click();
		
		try {
			if (success.isDisplayed()) {
				System.out.println("User created successfully");
			}
		} catch (Exception e) {
			String failMsg = failure.getAttribute("innerHTML");
			System.out.println("Unable to create user successfully : " + failMsg);
		}
	}

}
