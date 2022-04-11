/**
 * 
 */
package com.demo.cases;




import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.BaseTest;

/**
 * @author h
 *
 */
public class TestCase2 extends BaseTest{
	
	
	@BeforeMethod
	public void browserSetUp() throws Exception {
		
		BaseTest.setUp();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	//*** Test Cases
	
	@Test
	public void verifyTitle() {
		String actualTite = driver.getTitle();
		System.out.println("Title: " + actualTite);
		
		Assert.assertEquals(actualTite, driver.getTitle());
		
	}
	
	
	
	@Test
	public void verifyURL() {
		String actualURL = driver.getCurrentUrl();
		System.out.println("Title: " + actualURL);
		
		Assert.assertEquals(actualURL, driver.getCurrentUrl());
		
	}

}
