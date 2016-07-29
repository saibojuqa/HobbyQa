package com.disney.util;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;

public class Exit_Browser {
	WebDriver driver;
	public Exit_Browser(WebDriver driver)
	{
		this.driver=driver;
	}
	public void close()
	{
		driver.quit();
	}

}
