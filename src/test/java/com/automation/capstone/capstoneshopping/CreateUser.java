package com.automation.capstone.capstoneshopping;

import org.testng.annotations.Test;


public class CreateUser extends BaseTest{
	
	
	@Test
    public void fieldErrors() {
	  
		AccountCreationError flderror   = new AccountCreationError(driver);
		flderror.mandatoryFldValidation();	 
	  
  }
	
	
  @Test
  public void testCreateUserSuccess() {
	  
	  CreateNewUser newuser   = new CreateNewUser(driver);
	  newuser.newUserCreation();	 
	  
  }
  
  @Test
    public void loginCreatedUser() {
	  
	  Login login   = new Login(driver);
	  login.loginToCapstone();	 
	  
  }
}
  
