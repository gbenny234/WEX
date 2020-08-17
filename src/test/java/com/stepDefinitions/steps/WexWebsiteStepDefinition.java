package com.stepDefinitions.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.Constant.CommonConstants.CommonConstants;
import com.pageObjects.Elements.WexWebsiteElements;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WexWebsiteStepDefinition {

	public WebDriver driver;
	public WexWebsiteElements wex;
	String valueSearched;
	String category;

	/*
	 * This launch the browser. It accept a parameter of browser to be used
	 * acceptable parameter: chrome, firefox or ie
	 */
	@Given("^I lunch \"(.*?)\" browser$")
	public void i_lunch_browser(String desiredBrowser)  {
		
		switch(desiredBrowser.toLowerCase())
		{
		case "firefox": WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); break;
		case "chrome": WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); break;
		case "ie":{
			InternetExplorerOptions options = new InternetExplorerOptions().introduceFlakinessByIgnoringSecurityDomains();
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver(options);
			break;
			
		}
		}

		

		driver.manage().window().maximize();

		wex = new WexWebsiteElements(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	/*
	 * This goes to Wex website accepting a parameter for Wex website
	 * 
	 */
	@When("^user opens url \"(.*?)\"$")
	public void user_opens_url(String url)  {

		driver.get(url);

	}

	/*
	 * This validates that Wex website is launched.
	 * It validates that Wex title is correct
	 */
	@And("^I validate homepage is open$")
	public void i_validate_homepage_is_open() throws InterruptedException  {
		Thread.sleep(2000); //This hard sleep is needed to allow page title to populate. Intermittently failure without this hard wait.
		Assert.assertEquals( driver.getTitle(), "Game-changing payment solutions for every business | WEX Inc.");
		

	}
	
	
	/*
	 * This keyword selects the search field and put mouse focus on it
	 */
	@Then("^my focus is on the search functionality$")
	public void my_focus_is_on_the_search_functionality() throws InterruptedException  {

		Thread.sleep(3000); //This is necessary to handle the stale element reference exception
		wex.clickSearch();

	}
	
	/*
	 * This keyword validates that all search categories are present.
	 */
	@Then("^I validate all search categories$")
	public void i_validate_all_search_categories()  {

		Assert.assertTrue(wex.validateAllWexSearcOption());
		Assert.assertTrue(wex.validateCorporatePaymentSearcOption());
		Assert.assertTrue(wex.validateFleetSearcOption());
		Assert.assertTrue(wex.validateWexCorporateSearcOption());
		Assert.assertTrue(wex.validateWexHealthSearcOption());

	}

	/*
	 * This keyword searches All Wex for a value.
	 * It accepts value to search as a parameter.
	 */
	@When("^I searched for a value \"(.*?)\" in All Wex category$")
	public void i_searched_for_a_value_in_All_Wex_category(String valueToSearch) {
		wex.categorySelect().selectByVisibleText(CommonConstants.allWex);
		wex.enterValue(valueToSearch);
		
		valueSearched=valueToSearch;
		
		category = CommonConstants.allWex;
	}

	/*
	 * This keyword validates that the value searched returned a value and result on the correct category.
	 */
	@Then("^I validate that valid data are returned$")
	public void i_validate_that_valid_data_are_returned()  {
		Assert.assertTrue(wex.validateResultCateoryTab(category));

		Assert.assertTrue(wex.validatesearchResult(valueSearched));
		
		
		

	}

	/*
	 * This keyword validates that the value searched returned no results.
	 */
	
	@Then("^I validate that no results that meet returned$")
	public void i_validate_that_no_results_that_meet_returned() throws Throwable {


		Assert.assertTrue(wex.validateResultCateoryTab(category));

		Assert.assertTrue(wex.validateNoResult());
	}
	
	
	/*
	 * This keyword searches Corporate Payment for a value.
	 * It accepts value to search as a parameter.
	 */
	@When("^I searched for a value \"(.*?)\" in Corporate Payment category$")
	public void i_searched_for_a_value_in_Corporate_Payment_category(String valueToSearch) throws InterruptedException  {

		driver.navigate().back();
		//driver.navigate().refresh();
		wex = new WexWebsiteElements(driver);
		my_focus_is_on_the_search_functionality();
		wex.categorySelect().selectByVisibleText(CommonConstants.corporatePayments);
		wex.enterValue(valueToSearch);
		valueSearched=valueToSearch;
		category = CommonConstants.corporatePayments;
	}

	/*
	 * This keyword searches Fleet for a value.
	 * It accepts value to search as a parameter.
	 */
	@When("^I searched for a value \"(.*?)\" in Fleet category$")
	public void i_searched_for_a_value_in_Fleet_category(String valueToSearch) throws InterruptedException  {
		driver.navigate().back();
		wex = new WexWebsiteElements(driver);
		my_focus_is_on_the_search_functionality();
		wex.categorySelect().selectByVisibleText(CommonConstants.fleet);
		wex.enterValue(valueToSearch);
		valueSearched=valueToSearch;
		category = CommonConstants.fleet;
	}

	/*
	 * This keyword searches Wex Corporate for a value.
	 * It accepts value to search as a parameter.
	 */
	@When("^I searched for a value \"(.*?)\" in Wex Corporate category$")
	public void i_searched_for_a_value_in_Wex_Corporate_category(String valueToSearch) throws InterruptedException  {
		driver.navigate().back();
		wex = new WexWebsiteElements(driver);
		my_focus_is_on_the_search_functionality();
		wex.categorySelect().selectByVisibleText(CommonConstants.wexCorporate);
		wex.enterValue(valueToSearch);
		valueSearched=valueToSearch;
		category = CommonConstants.wexCorporate;

	}

	/*
	 * This keyword searches Wex Health for a value.
	 * It accepts value to search as a parameter.
	 */
	@When("^I searched for a value \"(.*?)\" in Wex Health category$")
	public void i_searched_for_a_value_in_Wex_Health_category(String valueToSearch) throws InterruptedException  {
		driver.navigate().back();
		wex = new WexWebsiteElements(driver);
		my_focus_is_on_the_search_functionality();
		wex.categorySelect().selectByVisibleText(CommonConstants.wexHealth);
		wex.enterValue(valueToSearch);
		valueSearched=valueToSearch;
		category = CommonConstants.wexHealth;

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
