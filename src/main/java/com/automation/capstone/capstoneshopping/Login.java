package com.automation.capstone.capstoneshopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;

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

	public Login(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@Test
	public void loginToCapstone() {

		signIn.click();
		email.sendKeys("sridevi.hp@brillio.com");
		pass.sendKeys("Test123@123");
		submit.click();
		
		Assert.assertTrue(success.isDisplayed(), "User could not login successfully");
		
		/*
		 * try { if (success.isDisplayed()) {
		 * System.out.println("User logged in successfully"); } } catch (Exception e) {
		 * System.out.println("User could not login successfully " ); }
		 */
		 
	}

}
