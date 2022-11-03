package pages.breezeairways.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.breezeairways.helper.UtilClass;

public class HomePage extends UtilClass {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Roundtrip')] ")
	private WebElement btnRoundTrip;
	
	@FindBy(how = How.XPATH, using = "//*[@id='origin']//input")
	private WebElement txtOrigin;
	
	@FindBy(how = How.XPATH, using = "//*[@id='destination']//input")
	private WebElement txtDestination;
	
	@FindBy(how = How.XPATH, using = "(//*[@aria-label='Options list']//div[@role='option'])[1]")
	private WebElement selectCityOption;
	
	@FindBy(how = How.XPATH, using = "//div[.='Depart']")
	private WebElement selectDateBtn;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'mbsc-cal-slide-a')]//div[starts-with(@title,'$')])[1]")
	private WebElement selectDepartDate;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'mbsc-cal-slide-a')]//div[starts-with(@title,'$')])[2]")
	private WebElement selectReturnDate;
	
	@FindBy(how = How.XPATH, using = "//div[@id='search-flights']")
	private WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'fare-family-card-content')]//div[contains(text(),'Selected')])[1]")
	private WebElement btnFirstSearchResultOutbound;
	
	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'fare-family-card-content')]//div[contains(text(),'Selected')])[2]")
	private WebElement btnFirstSearchResultInbound;
	
	@FindBy(how = How.XPATH, using = "//button[@id='login-later-btn']")
	private WebElement btnLoginLater;
	
	@FindBy(how = How.XPATH, using = "(//span[contains(@class,'not-selected')])[1]")
	private WebElement btnSeatSelect;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),' Continue to return flight ')]")
	private WebElement btnContinue;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Select Seat')]")
	private WebElement txtSeatSelect;
	
	/* Constructor */
	public HomePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, 60);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of Breeze Airways");
		driverWait.until(ExpectedConditions.titleContains("Breeze"));
	}

	/* Page Elements */

	public boolean verifyHomePage() throws InterruptedException {
		LOGGER.info("Checking for Home Page...!!! ");
		Thread.sleep(15000);
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(btnRoundTrip));
			LOGGER.info("Home Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}

	public void setFromSearchField(String inputText) throws InterruptedException {
		LOGGER.info("Enter Search Text... " + inputText);
		setText(driver, txtOrigin, inputText);
		Thread.sleep(5000);
		clickElement(driver, selectCityOption);
	}
	
	public void setToSearchField(String inputText) throws InterruptedException {
		LOGGER.info("Enter Search Text... " + inputText);
		setText(driver, txtDestination, inputText);
		Thread.sleep(5000);
		clickElement(driver, selectCityOption);
	}

	public void clickDepartAndReturnDates() throws InterruptedException {
		LOGGER.info("Clicking Dates Options...!!! ");
		Thread.sleep(2000);
		clickElement(driver, selectDateBtn);
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", selectDepartDate);
		clickElement(driver, selectDepartDate);
		Thread.sleep(2000);
		clickElement(driver, selectReturnDate);
	}
	
	public void clickSearchBtn() {
		LOGGER.info("Clicking Search Btn...!!! ");
		clickElement(driver, btnSearch);
	}
	
	public void clickSeatForOutboundFlight() {
		LOGGER.info("Clicking Seat for Outbound Flight...!!! ");
		clickElement(driver, btnFirstSearchResultOutbound);
	}
	
	public void clickSeatForInboundFlight() {
		LOGGER.info("Clicking Seat for Inbound Flight...!!! ");
		clickElement(driver, btnFirstSearchResultInbound);
	}
	
	public void clickLoginLaterBtn() {
		LOGGER.info("Clicking Login Later Button...!!! ");
		clickElement(driver, btnLoginLater);
	}

	public void clickContinueToReturnFlightBtn(){
		LOGGER.info("Click Continue Btn for Inbound Seat Selection...!!! ");
		clickElement(driver, btnContinue);
	}
	
	public void selectSeatsForOutboundFlight() {
		LOGGER.info("Select Seat Selection for Outbound...!!! ");
		clickElement(driver, btnSeatSelect);
	}

	
	public void selectSeatsForInboundFlight() {
		LOGGER.info("Select Seat Selection for Inbound...!!! ");
		clickElement(driver, btnSeatSelect);
	}

	public boolean verifyFinalResult() throws InterruptedException {
		LOGGER.info("Checking for Seat Selection Operation Completion...!!! ");
		
		int count = driver.findElements(By.xpath("//div[contains(text(),'Select Seat')]")).size();

		if (count == 0) {
			return true;
		}
		return false;
	}

}
