package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createCourse {


	static WebDriver driver;
	static WebDriverWait wait;
	Properties properties;
	{
		try {
			UtilityClass.loadproperty();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	By description=By.cssSelector(properties.getProperty("com.createCourse.description.css"));
	By enterDescription=By.xpath(properties.getProperty("com.createCourse.enterDescription.xpath"));		
	By enterCourseName=By.id(properties.getProperty("com.createCourse.enterCourseName.id"));		
	By enterSeries=By.cssSelector(properties.getProperty("com.createCourse.enterSeries.css"));
	By clickOnCourseImage=By.cssSelector(properties.getProperty("com.createCourse.clickOnCourseImage.css"));
	By courseButton=By.cssSelector(properties.getProperty("com.createCourse.clickOnCourseButton.css"));
	By clickOnCreate=By.cssSelector(properties.getProperty("com.createCourse.clickOnCreate.css")); 
	By dropdownIcon=By.cssSelector(properties.getProperty("com.createCourse.dropdownIcon.css"));
	By textindropdown=By.xpath(properties.getProperty("com.createCourse.textindropdown.xpath"));
	By createSeries=By.cssSelector(properties.getProperty("com.createCourse.createSeries.css"));
	By clickCorrectButton=By.cssSelector(properties.getProperty("com.createCourse.correctButton.css"));
	By newSeriesName=By.cssSelector(properties.getProperty("com.createCourse.newSeriesName.css"));

	public createCourse(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnDropdownIcon(){
		driver.findElement(dropdownIcon).click();


	}

	public void clickOnCourseButton()
	{

		driver.findElement(courseButton).click();


	}


	public void clickOnCourseImage()
	{

		driver.findElement(clickOnCourseImage).click();

	}

	public void enterCourseName(String coursename)
	{

		driver.findElement(enterCourseName).sendKeys(coursename);

	}

	public void enterDescription(String descr)
	{

		WebElement element=driver.findElement(description);//inside frame
		driver.switchTo().frame(element);
		driver.findElement(enterDescription).clear();
		driver.findElement(enterDescription).click();
		driver.findElement(enterDescription).sendKeys(descr);// search for frame
		driver.switchTo().parentFrame();


	}

	public void selectSeries(String series)
	{

		//Select sc=new Select ( driver.findElement(enterSeries));
		//sc.selectByVisibleText(series);
		//element.sendKeys(series);
		Select sc1=new Select ( driver.findElement(textindropdown));
		UtilityClass.waitforelement(driver.findElement(textindropdown));
		sc1.selectByVisibleText(series);
		//driver.findElement(textindropdown).sendKeys(series);
		//driver.findElement(textindropdown).sendKeys(series);

	}

	public void creteSeries()
	{
		driver.findElement((createSeries)).click();

	}

	public void clickCorrectButton()
	{
	
		driver.findElement(clickCorrectButton).click();

	}

	public void newSeriesname(String newName)
	{
		driver.findElement(newSeriesName).sendKeys(newName);

	}

	public void clickOnCreate()
	{
		driver.findElement(clickOnCreate).click();
		driver.findElement(clickOnCreate).click();

	}

}
