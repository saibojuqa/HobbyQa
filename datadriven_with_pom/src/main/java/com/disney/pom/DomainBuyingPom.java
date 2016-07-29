package com.disney.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DomainBuyingPom {
	

		WebDriver driver;
	    @CacheLookup
		@FindBy(how=How.NAME,using="domainToCheck") WebElement searchbox;
	    
	    @CacheLookup
		@FindBy(how=How.XPATH,using="html/body/div[5]/div[1]/div/div/div/div[1]/div/div/div/form/div/div/span/button") WebElement click;
		public void search(String domain )
		{    //click on the search butoom 
			Actions act=new Actions(driver);
			//act.doubleClick().click(searchbox).build().perform();
			searchbox.sendKeys(domain);
			act.doubleClick(click).build().perform();
			
		}
		public DomainBuyingPom(WebDriver driver)
		{
			this.driver=driver;
			
		}
	}

