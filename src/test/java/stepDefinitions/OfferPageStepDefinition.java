package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import utils.TestContextSetup;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) 
	{
	this.testContextSetup = testContextSetup;	
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException 
	{
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();  
	} 
	
	public void switchToOffersPage() 
	{	
		//if (testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		// testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	 @Then("Validate product name in offers page matches with landing page")
	    public void validate_product_name_in_offers_page_matches_with_landing_page()
	 {
		 Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	 }
}
