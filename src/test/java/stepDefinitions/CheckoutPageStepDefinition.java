package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;


public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) 
	{
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException 
	{
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
	}

	@Then("^Verify user has ability to enter promo code and place the order$")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order()
	{
		checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
		Assert.assertTrue(checkoutPage.VerifypromoBtn());
		Assert.assertTrue(checkoutPage.VerifyplaceOrder());
	}
	
}
