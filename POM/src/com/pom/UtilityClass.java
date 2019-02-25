package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public  class UtilityClass {

	static WebDriver driver;
	static WebDriverWait wait;
	static WebElement element;
	static Properties properties;
	static FileInputStream fis;

//explicit wait
	//below function is return to fail the case
	public static void waitforelement(WebElement webElement)
	{
		wait= new WebDriverWait(driver,30);
		element=wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public static void loadproperty() throws IOException
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
		finally
		{
			fis.close();
		}
	}

}





