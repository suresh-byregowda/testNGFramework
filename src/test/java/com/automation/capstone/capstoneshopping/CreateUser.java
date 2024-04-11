package com.automation.capstone.capstoneshopping;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class CreateUser extends BaseTest{
  @Test
  public void testCreateUserSuccess() {
	  
	  CreateNewUser newuser   = new CreateNewUser(driver,js);
	  newuser.newUserCreation();	 
	  
  }
  
  
  
  
  
  
}
