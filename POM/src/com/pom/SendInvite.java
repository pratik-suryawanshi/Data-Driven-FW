package com.pom;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SendInvite {


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

	By inviteAll=By.cssSelector(properties.getProperty("com.SendInvite.inviteAll.css"));
	By addinvitee=By.className(properties.getProperty("com.SendInvite.addinvitee.classname"));
	By inviteToCourseOnly=By.cssSelector(properties.getProperty("com.SendInvite.inviteToCourseOnly.css"));
	By newInvite=By.xpath(properties.getProperty("com.SendInvite.newInvite.xpath"));
	By email=By.id(properties.getProperty("com.SendInvite.email.id"));
	By fullname=By.cssSelector(properties.getProperty("com.SendInvite.fullname.css"));
	By addtolist=By.cssSelector(properties.getProperty("com.SendInvite.addtolist.css"));
	By sendtoall=By.cssSelector(properties.getProperty("com.SendInvite.sendinvitetoall.css"));


	public SendInvite(WebDriver driver)
	{
		this.driver=driver;
	}

	public void addInvite()
	{
		driver.findElement(addinvitee).click();
	}

	public void inviteToCourse()
	{
		driver.findElement(inviteToCourseOnly).click();

	}

	public void newInvite()
	{
		driver.findElement(newInvite).click();

	}

	public void enterEamail(String emailString)
	{
		driver.findElement(email).sendKeys(emailString);

	}

	public void enterFullName(String fullnameString)
	{
		driver.findElement(fullname).sendKeys(fullnameString);

	}

	public void addToList()
	{
		driver.findElement(addtolist).click();

	}

	public void sendInviteToMem()
	{
		driver.findElement(inviteAll).click();

	}

	public void sendInviteToAll()
	{
		driver.findElement(sendtoall).click();

	}

}





