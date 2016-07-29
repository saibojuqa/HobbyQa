package com.disney.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LaunchBrowser {
	static WebDriver driver;

	public static WebDriver Launch_browser(String browsername, String url) {
		if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("chrome")) {
			File file = new File("//Users//manishreddybendhi//Downloads//chrome");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();

		}
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

}
