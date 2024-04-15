package com.automation.capstone.capstoneshopping;

import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ViewCart {

	private WebDriver driver;
	private Actions act;
	private JavascriptExecutor js;
	private WebDriverWait wait;
	private Logger log;
	private ExtentTest test;
	private ExtentReports report;

	@FindBy(xpath = "//a[@class = 'action showcart']")
	WebElement viewCartLink;

	@FindBy(xpath = "//a[@class = 'action viewcart']")
	WebElement viewCart;

	@FindBy(xpath = "//table[@id = 'shopping-cart-table']/tbody")
	List<WebElement> cartItemsList;

	@FindBy(xpath = "//input[@title = 'Qty'][@type = 'number']")
	WebElement qty;

	@FindBy(xpath = "//a[@title='Edit item parameters']/following-sibling::a[@title = 'Remove item']")
	WebElement removeItem;

	@FindBy(xpath = "//span[@class ='counter qty']/span")
	WebElement itemCount;

	public ViewCart(WebDriver driver, Actions act, JavascriptExecutor js, WebDriverWait wait, Logger log,
			ExtentTest test, ExtentReports report) {

		this.driver = driver;
		this.act = act;
		this.js = js;
		this.wait = wait;
		this.log = log;
		this.test = test;
		this.report= report;
		PageFactory.initElements(driver, this);
	}

	public void cartItemsCheck() {
		log.info("====================Edit cart items and Remove cart item test cases=====================");
		test = report.startTest("cartItemsCheck");
		wait.until(ExpectedConditions.visibilityOf(viewCartLink));
		js.executeScript("arguments[0].click()", viewCartLink);

		wait.until(ExpectedConditions.visibilityOf(viewCart));
		js.executeScript("arguments[0].click()", viewCart);
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
		// act.moveToElement(viewCartLink).click().perform();
		// viewCart.click();

		Assert.assertTrue(cartItemsList.size() > 0, "No items added to cart. -> ");

		for (int i = 1; i <= cartItemsList.size(); i++) {
			System.out.println(driver
					.findElement(By.xpath("//table[@id = 'shopping-cart-table']/tbody[" + i + "]/tr/td/div/strong/a"))
					.getText());
		}

		report.endTest(test);
	}

	public void qtyChange() {
		test = report.startTest("qtyChange");
		if (cartItemsList.size() >0) {
			test.log(LogStatus.PASS, "Items are added to the cart");
			log.info("Items are added to the cart");
			int qt = Integer.parseInt(qty.getAttribute("value"));
			qty.clear();
			qty.sendKeys(String.valueOf(qt + 1));
			act.moveToElement(qty).click();			
			test.log(LogStatus.PASS, "Quantity is increased by 1");
			log.info("Item quantity is increased by 1");	
			Assert.assertEquals(Integer.parseInt(qty.getAttribute("value")), qt + 1);
		}
		else {
			test.log(LogStatus.FAIL, "Cart is empty");
			log.info("Cart is empty");
			Assert.assertTrue(cartItemsList.size() >0);
		
		}
		report.endTest(test);

	}

	public void removeItem() {
		test = report.startTest("removeItem");
		removeItem.click();
		wait.until(ExpectedConditions.visibilityOf(itemCount));
		log.info("Actual items in the cart: " + itemCount.getText());
		log.info("Expected items in the cart: " + String.valueOf(cartItemsList.size()));
		if(Integer.parseInt(itemCount.getText()) == cartItemsList.size()) {
			test.log(LogStatus.PASS, "Item removed successfully");
			log.info("Item removed successfully");
		}
		else {

			test.log(LogStatus.FAIL, "Couldn't remove item successfully");
			log.info("Couldn't remove item successfully");
		}

		Assert.assertEquals(Integer.parseInt(itemCount.getText()), cartItemsList.size());
		report.endTest(test);
	}
}
