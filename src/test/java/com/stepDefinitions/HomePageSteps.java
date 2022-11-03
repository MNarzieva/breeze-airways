package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.breezeairways.pages.HomePage;
import pages.breezeairways.pages.WebDriverManager;

public class HomePageSteps {
	
	public WebDriver driver = getDriver();
	public HomePage homePage;
	
	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
    
	@Then("I Verify Home Page Loaded Successfully")
	public void verify_ApplicationHomePage() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Home Page.", result);
	}
	  
    @When("I Enter Source City as {string} in From Searchbox Field; in Home Page")
    public void enterSourceCityText(String inputText) throws InterruptedException {
    	homePage = new HomePage(driver);
    	homePage.setFromSearchField(inputText);
    }
    
    @When("I Enter Destination City as {string} in From Searchbox Field; in Home Page")
    public void enterDestinationCityText(String inputText) throws InterruptedException {
    	homePage = new HomePage(driver);
    	homePage.setToSearchField(inputText);
    }
    
    @When("I Enter Departure and Return Dates; in Home Page")
    public void enterDates() throws InterruptedException {
    	homePage = new HomePage(driver);
    	homePage.clickDepartAndReturnDates();
    }
    
    @When("I Click On Search Button; in Home Page")
    public void click_LogoutButton() {
    	homePage = new HomePage(driver);
    	homePage.clickSearchBtn();
    }

}