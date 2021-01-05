package com.crm.qa.pages;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.crm.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public	static Properties prop;
	public static WebDriver driver;

	public BaseClass() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selinium NaveenAUto Lab\\OOPS\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("url"));
		
	}
	public void initialisebrowser() {
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		
		if (browsername.equals("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
				}
		else if (browsername.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver();
					}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.pageLoadTime,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.implicitWaitTime, TimeUnit.SECONDS);
		
		String url = prop.getProperty("url");
		driver.get(url);
	}

}