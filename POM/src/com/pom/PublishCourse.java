package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PublishCourse {
	WebDriver driver;
	WebElement element;
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

	By publish=By.cssSelector(properties.getProperty("com.PublishCourse.publish.css"));
	By okbutton=By.cssSelector(properties.getProperty("com.PublishCourse.okbutton.css"));

	public PublishCourse(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnPublish()
	{
		driver.findElement(publish).click();

	}


	public void clickOk()
	{
		driver.findElement(okbutton).click();

	}

}
