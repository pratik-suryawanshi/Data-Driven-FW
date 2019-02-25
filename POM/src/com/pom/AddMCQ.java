package com.pom;



import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMCQ {

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

	By addContent=By.cssSelector(properties.getProperty("com.AddMCQ.addContent.classname"));
	By addMCQConten=By.cssSelector(properties.getProperty("com.AddMCQ.addMCQContent.xpath"));
	By question=By.cssSelector(properties.getProperty("com.AddMCQ.question.css"));
	By enterQuestion=By.xpath(properties.getProperty("com.AddMCQ.enterQuestion.xpath"));
	By addOptions=By.xpath(properties.getProperty("com.AddMCQ.addOptions.xpath"));
	By enterOptions=By.xpath(properties.getProperty("com.AddMCQ.enterOptions.xpath"));
	By selectCheckbox1=By.xpath(properties.getProperty("com.AddMCQ.selectCheckbox1.xpath"));
	By selectCheckbox2=By.xpath(properties.getProperty("com.AddMCQ.selectCheckbox2.xpath"));
	By backbutton=By.cssSelector(properties.getProperty("com.AddMCQ.backbutton.css"));

	public AddMCQ(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickOnaddContent()
	{
		driver.findElement(addContent).click();
		//driver.findElement(addContent).click();

	}

	public void clickOnaddMCQContent()
	{
		driver.findElement(addMCQConten).click();
		//driver.findElement(addMCQConten).click();

	}

	public void enterQuestions( String ques)
	{
		element=driver.findElement(question);
		driver.switchTo().frame(element);
		driver.findElement(enterQuestion).sendKeys(ques); // search for frame
		driver.switchTo().parentFrame();

	}

	public void clickOnAddOptions()
	{
		driver.findElement(addOptions).click();


	}

	public void enterOptions(String text)
	{
		String[] splitted = text.split(",");
		List<WebElement> listele = driver.findElements(enterOptions);
		for (int i=0;i<splitted.length;i++)
		{
			listele.get(i).click();
			listele.get(i).sendKeys(splitted[i]);

		}

	}

	public void selectAnswer1()
	{
		driver.findElement(selectCheckbox1).click();

	}

	public void selectAnswer2()
	{
		driver.findElement(selectCheckbox2).click();

	}

	public void clickOnBackButton()
	{
		driver.findElement(backbutton).click();

	}
}
