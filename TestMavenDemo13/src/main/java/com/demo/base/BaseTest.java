/**
 * 
 */
package com.demo.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author h
 *
 */
public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public void loadConfig() throws Exception {
		prop  =new Properties();
		fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\executable\\config.properties");
		prop.load(fis);
	}
	
	
	public static void setUp() {
		
		String browserName = prop.getProperty("browser");
		System.out.println("Browser: " + browserName);
		
		if (browserName.contentEquals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.contentEquals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		else {
			System.out.println("Invalid browser");
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	

}
