package com.disney.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Domain_Cart_Page {
	WebDriver driver;
	@CacheLookup
	@FindBy(how=How.XPATH,using=".//*[@id='search']/a") WebElement Continuetocart;
	
	@CacheLookup
	@FindBy(how=How.XPATH,using=".//*[@id='btn-continue-to-cart']") WebElement Continuetocart2;
	
	public void checkout(){
		Continuetocart.click();
		
	}
	public void checkoutfinal()
	{
	Continuetocart2.click();

}
	public Domain_Cart_Page(WebDriver driver)
	{
	this.driver=driver;

	}
}
