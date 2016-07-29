package com.disney.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Domain_selection {
	WebDriver driver;
@CacheLookup
@FindBy(how=How.XPATH,using=".//*[@id='results']/div[2]/div[2]/ul/li[1]/div/ul/li[3]/div/div") WebElement domaintype;


public void domainselect()
{
domaintype.click();	
}
public Domain_selection(WebDriver driver)
{
this.driver=driver;

}
}
