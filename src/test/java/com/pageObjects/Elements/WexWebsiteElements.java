package com.pageObjects.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WexWebsiteElements {
	
	public WebDriver wexDriver;
	
	public WexWebsiteElements(WebDriver wDriver)
	{
		wexDriver = wDriver;
		PageFactory.initElements(wDriver, this);
		
	}
	
	@FindBy(xpath= "//a[@data-toggle='wex-searchPanel' and @class ='mega-menu-link ge-primary-nav']")
	@CacheLookup
	WebElement seachButton;
	
	@FindBy(xpath= "//a[@class='mega-menu-link ge-primary-nav' and text()= 'WEX Worldwide']")
	@CacheLookup
	WebElement wexWorldwideNav;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='All WEX' and @selected = 'selected']")
	@CacheLookup
	WebElement allWex;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='Corporate Payments']")
	@CacheLookup
	WebElement corporatePayments;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='Fleet']")
	@CacheLookup
	WebElement fleet;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='WEX Corporate']")
	@CacheLookup
	WebElement wexCorporate;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='WEX Health']")
	@CacheLookup
	WebElement wexHealth;
	
	@FindBy(xpath= "//select[@id='bline']//child::option[text()='wexhealth']")
	@CacheLookup
	WebElement wexhealth;
	
	@FindBy(xpath= "//input[@id='s']")
	@CacheLookup
	WebElement focusOnSearchField;
	
	@FindBy(xpath= "//select[@id='bline']")
	@CacheLookup
	WebElement selectCateg;
	
	@FindBy(xpath= "//div[@class='hero-content']//child::h1[text()='Search WEX']")
	@CacheLookup
	WebElement searchNotWorking;
	
	@FindBy(xpath= "//button[@type='submit']//child::i[@class= 'fas fa-search']")
	@CacheLookup
	WebElement submitSearch;
	
	@FindBy(xpath= "//*[@id='mainContent']/div[2]/div/div/div[1]/h4/a")
	@CacheLookup
	WebElement searchResult;
	
	@FindBy(xpath= "//li[contains(@class,'is-active')]//child::a")
	@CacheLookup
	WebElement resultTab;
	
	@FindBy(xpath= "//div[@class='cell xxlarge-12']//child::p[text()='Sorry, there are no results that meet this criteria.']")
	@CacheLookup
	WebElement noResult;
	
	
	
	
	
	
	Select category;
	
	public Select categorySelect()
	{
	  category= new Select(selectCateg);
	  return category;
	}
	
	public void clickSearch()
		{	
		
		seachButton.click();
		focusOnSearchField.click();
	}
	
	public void waitForDynamic(int howlong)
	{	
		WebDriverWait wait = new WebDriverWait(wexDriver, howlong);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-toggle='wex-searchPanel' and @class ='mega-menu-link ge-primary-nav']")));

}
	

	
	public void enterValue(String value)
	{
		focusOnSearchField.clear();
		focusOnSearchField.sendKeys(value);
		submitSearch.click();
	}
	
	public boolean wexWorldwideNavMenu()
	{
		return wexWorldwideNav.isDisplayed();
	}
	
	public boolean validateAllWexSearcOption()
	{
		return allWex.isDisplayed();
	}
	
	public boolean validateCorporatePaymentSearcOption()
	{
		return corporatePayments.isDisplayed();
	}
	
	public boolean validateFleetSearcOption()
	{
		return fleet.isDisplayed();
	}
	
	public boolean validateWexCorporateSearcOption()
	{
		return wexCorporate.isDisplayed();
	}
	
	public boolean validateWexHealthSearcOption()
	{
		return wexHealth.isDisplayed();
	}
	
	public boolean validatesearchNotWorking()
	{
		return searchNotWorking.isDisplayed();
	}
	
	public boolean validatesearchResult(String result)
	{
		return searchResult.getText().toLowerCase().contains(result.toLowerCase());
	}
	
	
	public boolean validateResultCateoryTab(String tabText)
	{
		return resultTab.getText().equals(tabText);
	}
	
	public boolean validateNoResult()
	{
		return noResult.isDisplayed();
	}
	
}
