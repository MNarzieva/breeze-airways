package com.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.breezeairways.pages.WebDriverManager;

public class BasePageSteps {
	
	public WebDriver driver;
	public WebDriverManager webDriverManager;

	@Before("@UI")
	public void before() throws Throwable {
		webDriverManager = new WebDriverManager();
		String browserName = "chrome";
		driver = webDriverManager.getDriver(browserName);
	}

	@After("@UI")
	public void after(Scenario scenario) throws Throwable {
		webDriverManager.closeDriver(scenario);
	}

	@Given("I Launch Application with {string} as URL in Browser")
	public void launch_ApplicationURLInBrowser(String value) throws Throwable {
		driver.get(value);
	}
    
}