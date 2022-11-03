package com.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.breezeairways.pages.HomePage;
import pages.breezeairways.pages.WebDriverManager;

public class SeatSelectionPageSteps {
	
	public WebDriver driver = getDriver();
	public HomePage homePage;
	
	public WebDriver getDriver() {
		return WebDriverManager.driver;
	}
    
    @When("I Select First Available Seat for Outbound Flight; in Seat Selection Page")
    public void selectFirstAvailableSeatOutboundFlight() {
    	homePage = new HomePage(driver);
    	homePage.selectSeatsForOutboundFlight();
    }
    
    @When("I Click On Continue To Return Flight Seat booking Button; in Seat Selection Page")
    public void click_ContinueBtn() {
    	homePage = new HomePage(driver);
    	homePage.clickContinueToReturnFlightBtn();
    }
    
    @When("I Select First Available Seat for Inbound Flight; in Seat Selection Page")
    public void selectFirstAvailableSeatInboundFlight() {
    	homePage = new HomePage(driver);
    	homePage.selectSeatsForInboundFlight();
    }
    
    @Then("I Verify Seats Selection Successfully; in Seat Selection Page")
	public void verify_Result() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyFinalResult();
		Assert.assertTrue("Problem in Seat Selection.", result);
	}
    
}