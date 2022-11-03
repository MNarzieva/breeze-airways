package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.When;
import pages.breezeairways.pages.HomePage;
import pages.breezeairways.pages.WebDriverManager;

public class SearchPageSteps {
	
	public WebDriver driver = getDriver();
	public HomePage homePage;
	
	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
    
    @When("I Select First Outbound Flight; in Search Page")
    public void selectOutboundFlight() {
    	homePage = new HomePage(driver);
    	homePage.clickSeatForOutboundFlight();
    }
    
    @When("I Select First Inbound Flight; in Search Page")
    public void selectInboundFlight() {
    	homePage = new HomePage(driver);
    	homePage.clickSeatForInboundFlight();
    }
    
    @When("I Click On Login Later Link; in Search Page")
    public void click_LoginLaterButton() {
    	homePage = new HomePage(driver);
    	homePage.clickLoginLaterBtn();
    }

}