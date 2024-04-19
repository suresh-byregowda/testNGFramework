package com.automation.capstone.capstoneshopping;

import org.testng.annotations.Test;


public class TestCases extends BaseTest{
	
	
	@Test(priority = 1)
    public void fieldErrors() {
	  
		AccountCreationError flderror   = new AccountCreationError(driver, log, test, report, softassert);
		flderror.mandatoryFldValidation();	 
	  
  }
	
	
  @Test(priority = 2)
  public void testCreateUserSuccess() {
	  
	  CreateNewUser newuser   = new CreateNewUser(driver, log, test, report, softassert);
	  newuser.newUserCreation();	 
	  
  }
  
  @Test(priority = 3)
    public void loginCreatedUser() {
	  
	  Login login   = new Login(driver, prop, log, wait, test, report, softassert);
	  login.loginToCapstone();	 
	  
  }
  
  @Test(dependsOnMethods ="loginCreatedUser")
  public void addToCart() {
	  AddToCart addToCart   = new AddToCart(driver, act, js, wait, log, test, report, softassert);
	  addToCart.addItems();
}
  
  @Test(dependsOnMethods = {"loginCreatedUser","addToCart"})
  public void viewCart() {
	  ViewCart viewCart   = new ViewCart(driver, act, js, wait, log, test, report, softassert);
	  viewCart.cartItemsCheck();	 
	  viewCart.qtyChange();
	  viewCart.removeItem();
}
}
  
