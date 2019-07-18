package com.qa.testcases;


import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.testbase;
import com.qa.pages.LoginPage;
import com.qa.utill.TestUtill;

import junit.framework.Assert;

public class LoginPageTest extends testbase {
	LoginPage loginPage;
	String SheetName = "Contacts";
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initializeDriver();
		log.info("Initialozation completed");
		loginPage = new LoginPage();
		log.info("Object created");
		
	}
	
	
	@Test(priority =1)
	public void validatePageTitle()
	{
		String landpage = driver.getTitle();
		Assert.assertEquals(landpage,"whataburger.com : eb admin");
	}
	
	@DataProvider
	public Object[][] getConnectTestData()
	{
		Object data [][]=TestUtill.getTestData(SheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider = "getConnectTestData")
	public void ValidateLogin(String username, String Password)
	{
		loginPage.EnterUserNamePassword(username,Password);
		boolean value = loginPage.ValidateHomeScreen();
		Assert.assertTrue(value);

	}
	
	@AfterMethod
	public void teaDown()
	{
		driver.quit();
	}

}
