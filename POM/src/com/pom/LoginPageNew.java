package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageNew {

	static WebDriver driver;
	static WebDriverWait wait;
	Properties properties;

	{
		try {
			properties=new Properties();
			File src=new File(("C:/Users/pratik/workspace/selenium/POM/src/com/config/locator.properties"));
			FileInputStream fis =  new FileInputStream(src);
			properties.load(fis);

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}		
	}

	By username=By.id(properties.getProperty("com.LoginPageNew.Uesrname.id"));
	By password=By.name(properties.getProperty("com.LoginPageNew.Password.name"));
	By loginButton=By.cssSelector(properties.getProperty("com.LoginPageNew.Loginbutton.xpath"));


	public LoginPageNew(WebDriver driver)
	{
		this.driver=driver;

	}

	public void enterURL(String URL)
	{

		driver.navigate().to(URL);


	}

	public void typeUserName(String uid)
	{

		driver.findElement(username).sendKeys(uid);

	}

	public void typePassword(String pass)
	{

		driver.findElement(password).sendKeys(pass);

	}

	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();

	}

}
