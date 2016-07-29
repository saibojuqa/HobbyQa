package com.disney.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.disney.pom.DomainBuyingPom;
import com.disney.pom.Domain_Cart_Page;
import com.disney.pom.Domain_selection;
import com.disney.util.Exit_Browser;
import com.disney.util.LaunchBrowser;
import com.dsney.excelreader.ReusableXcel1;

public class BuyingdomainAndCheckout {
	//logger 
	final static org.apache.log4j.Logger log = Logger.getLogger(BuyingdomainAndCheckout.class);
	// WebDriver driver1;

	@Test(dataProvider = "passingdata") 
	public void Search(String domain1, String domain2) throws IOException

	{
		File fis = new File(
				"/Users/manishreddybendhi/Desktop/datadriven_with_pom 1.27.48 PM/src/main/java/com/disney/configuration/Configuraion.properties");
		FileInputStream fisip = new FileInputStream(fis);
		log.debug("the file is loaded well ");
		Properties prop = new Properties();
		prop.load(fisip);
		log.debug("properties are good  ");
		String url = prop.getProperty("Url");
		String browser = prop.getProperty("Browser");
		log.info("url is loaded  ");
		WebDriver driver1 = LaunchBrowser.Launch_browser(browser, url);
		Assert.assertEquals(url, "https://www.godaddy.com/");
		DomainBuyingPom search = PageFactory.initElements(driver1, DomainBuyingPom.class);
		search.search(domain1);
		WebDriverWait wait = new WebDriverWait(driver1, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@id='results']/div[2]/div[2]/ul/li[1]/div/ul/li[3]/div/div")));
		Domain_selection select = PageFactory.initElements(driver1, Domain_selection.class);
		select.domainselect();
		Domain_Cart_Page cart = PageFactory.initElements(driver1, Domain_Cart_Page.class);
		cart.checkout();
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='btn-continue-to-cart']")));
		cart.checkoutfinal();
		Exit_Browser driver_quit = new Exit_Browser(driver1);
		driver_quit.close();
	}

	@DataProvider(name = "passingdata")
	public Object[][] datapass() {
		ReusableXcel1 objone = new ReusableXcel1(
				"/Users/manishreddybendhi/Desktop/datadriven_with_pom 1.27.48 PM/ExcelReader/Domains.xlsx");
		int row = objone.rowcount("Sheet2");
		System.out.println("the value in the row is =" + row);
		Object[][] data = new Object[row][2];
		for (int i = 0; i < row; i++) {
			data[i][0] = objone.readsell("Sheet1", i, 0);
			data[i][1] = objone.readsell("Sheet1", i, 1);
		}
		return data;
	}
}