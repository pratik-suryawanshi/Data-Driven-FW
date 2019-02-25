
//Test File

package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.AddMCQ;
import com.pom.EditCourse;
import com.pom.LoginPageNew;
import com.pom.PublishCourse;
import com.pom.SendInvite;
import com.pom.createCourse;


public class VerifyValidUser {

	static WebDriver driver;
	static WebDriverWait wait;
	static Properties test_prop;

	@BeforeMethod	
	public void testValues()
	{
		test_prop=new Properties();
		File src=new File(("C:/Users/pratik/workspace/selenium/POM/src/com/config/TestValues.properties"));
		FileInputStream fts = null;
		try {
			fts = new FileInputStream(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			test_prop.load(fts);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}		





	@Test
	public void checkValidUser() throws Exception
	{

		System.setProperty("webdriver.chrome.driver",
				test_prop.getProperty("DriverPath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(test_prop.getProperty("CromeURL"));


		{
			LoginPageNew login=new LoginPageNew(driver);
			login.typeUserName(test_prop.getProperty("LoginPageNew.UserName"));
			login.typePassword(test_prop.getProperty("LoginPageNew.Password"));
			login.clickOnLoginButton();

		}

	}


	@Test
	public void createcourse()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		createCourse course=new createCourse(driver);

		course.clickOnCourseButton();
		course.clickOnCourseImage();
		course.enterCourseName(test_prop.getProperty("CreateCourseName.enterCourseName"));
		course.enterDescription(test_prop.getProperty("CreateCourseName.Description"));
		//course.clickOnDropdownIcon();
		//course.selectSeries(test_prop.getProperty("CreateCourseName.SelectseriesFromDropDown"));
		course.creteSeries();
		course.newSeriesname(test_prop.getProperty("CreateCourseName.enterNewSeriesName"));
		course.clickCorrectButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		course.clickOnCreate();

	}
	@Test
	public void Editcourse()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EditCourse editcourse=new EditCourse(driver);
		editcourse.addTopicname();
		editcourse.nameTopic(test_prop.getProperty("EditCourse.nameTopic"));
		editcourse.clickEdit();
	}



	@Test
	public void mcq()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		AddMCQ adddmcq=new AddMCQ(driver);

		adddmcq.clickOnaddContent();
		adddmcq.clickOnaddMCQContent();
		adddmcq.enterQuestions(test_prop.getProperty("AddMCQ.enterQuestions"));
		adddmcq.clickOnAddOptions();
		adddmcq.clickOnAddOptions();
		adddmcq.enterOptions(test_prop.getProperty("AddMCQ.enterOptions"));
		adddmcq.selectAnswer1();
		adddmcq.selectAnswer2();
		adddmcq.clickOnBackButton();
	}


	@Test
	public void publish()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PublishCourse publishcourse=new PublishCourse(driver);
		publishcourse.clickOnPublish();
		publishcourse.clickOk();
	}

	@Test
	public void sendinv()
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		SendInvite sendinvite=new SendInvite(driver);

		sendinvite.addInvite();
		sendinvite.inviteToCourse();
		sendinvite.newInvite();
		sendinvite.enterEamail(test_prop.getProperty("SendInvite.enterEmail"));
		sendinvite.enterFullName(test_prop.getProperty("SendInvite.enterFullName"));
		sendinvite.addToList();
		sendinvite.sendInviteToMem();
		sendinvite.sendInviteToAll();

	}




	@AfterMethod
	public  static void takescreenshot(ITestResult result)
	{

		String methodName=result.getName();
		String Location_Fail=test_prop.getProperty("failScreenshot");
		String Location_Pass=test_prop.getProperty("passScreenshot");

		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {

			if (ITestResult.FAILURE==result.getStatus())
				FileUtils.copyFile(screenshotFile, new File(Location_Fail + methodName + "_FAIL_" +".png" ));

			else
				FileUtils.copyFile(screenshotFile, new File(Location_Pass + methodName + "_PASS_" +".png" ));
			System.out.println("Screenshot Taken");
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}








