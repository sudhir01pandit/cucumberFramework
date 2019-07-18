package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.testbase;

public class LoginPage extends testbase{
	

	@FindBy(xpath="(//div[@class='formfield']//input)[1]")
	@CacheLookup
	public WebElement userNameTextField;
	
	@FindBy(xpath="(//div[@class='formfield']//input)[2]")
	public WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginInButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logOutButton;
	

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUserNamePassword(String username, String password )
	{
		 userNameTextField.click();
		 userNameTextField.sendKeys(username);
		 passwordTextField.click();
		 passwordTextField.sendKeys(password);
		 loginInButton.click();
		 
		 Set<String> handles = driver.getWindowHandles();
		 Iterator<String> it = handles.iterator();
		 String parenwindow = it.next();
		 
		 driver.switchTo().window(parenwindow);
	}
	
	public static String VerifyhomeScreentitle() throws InterruptedException 
	{
		Thread.sleep(8000);
		return driver.getTitle();
		
	}
	
	public boolean ValidateHomeScreen() 
	{
		boolean buttonPresence=driver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed();
		return buttonPresence;
		
	}

}
