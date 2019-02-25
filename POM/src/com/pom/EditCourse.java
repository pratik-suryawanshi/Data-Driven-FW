package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditCourse {

	WebDriver driver;
	WebElement element;
	Properties properties;

	{
		try {
			UtilityClass.loadproperty();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	By addTopic=By.cssSelector(properties.getProperty("com.EditCourse.addTopic.css"));
	By nameTopic=By.xpath(properties.getProperty("com.EditCourse.nameTopic.css"));		
	By clickEdit=By.xpath(properties.getProperty("com.EditCourse.clickEdit.xpath"));


	public EditCourse(WebDriver driver)
	{
		this.driver=driver;
	}


	public void addTopicname()
	{
		driver.findElement(addTopic).click();

	}

	public void nameTopic(String name)
	{
		//driver.findElement(nameTopic).click();
		//driver.findElement(nameTopic).clear();
		driver.findElement(nameTopic).sendKeys(name);
		//driver.findElement(nameTopic).sendKeys(name);

	}

	public void clickEdit()
	{
		driver.findElement(clickEdit).click();
		driver.findElement(clickEdit).click();

	}
}