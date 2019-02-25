package keywordDrvien;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class KeyWordExample {

	static WebDriver driver;
	static WebDriverWait wait;

	
	public void open_Browser(String browserName) {
		try {
			//if (browserName.equalsIgnoreCase("Firefox")) {
			//	driver = new FirefoxDriver();
			//} else if (browserName.equalsIgnoreCase("chrome")) {
			//	System.setProperty("webdriver.chrome.driver",
			//			"C://Users//pratik//Documents//drivers//chromedriver.exe");
			//	driver = new ChromeDriver();
			//} else if (browserName.equalsIgnoreCase("IE")) {
			//	System.setProperty("webdriver.ie.driver",
			//			"D:/Jars/IEDriverServer.exe");
			//	driver = new InternetExplorerDriver();
			//}

			{
				System.setProperty("webdriver.chrome.driver",
						"C://Users//pratik//Documents//drivers//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				commonMethods.captureScreenShot(driver);
			}


		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	
	public void enter_URL(String URL) {
		driver.navigate().to(URL);
	}
	
	public By locatorValue(String locatorType, String value) {
		By by;
		switch (locatorType) {
		case "id":
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			by = By.id(value);
			break;
		case "name":
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			by = By.name(value);
			break;
		case "xpath":
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			by = By.xpath(value);
			break;
		case "css":
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			by = By.cssSelector(value);
			break;
		case "linkText":
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			by = By.linkText(value);
			break;
		case "partialLinkText":

			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	
	public void enter_Text(String locatorType, String value, String text) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
			commonMethods.captureScreenShot(driver);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}


	@Test
	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			commonMethods.captureScreenShot(driver);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}



	public void click_On_Button(String locatorType, String value) {
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			commonMethods.captureScreenShot(driver);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}

	
	public void iframe(String locatorType, String value, String text, String value2) {
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
		try {
			By locator1;
			By locator2;
			locator1 = locatorValue(locatorType, value);//frame
			locator2 = locatorValue(locatorType, value2);//inside frame
			WebElement element=driver.findElement(locator2);
			driver.switchTo().frame(element);
			driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
			element=driver.findElement(locator1);

			//element = driver.findElement(locator);
			element.click();
			element.sendKeys(text);
			driver.switchTo().defaultContent();
			commonMethods.captureScreenShot(driver);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}

	
	public void select(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement drpDown = ( driver.findElement(locator));
			drpDown.click();


			commonMethods.captureScreenShot(driver);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	public void enter_Text_in_list(String locatorType, String value, String text) {
		try {

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			By locator;
			locator = locatorValue(locatorType, value);
			String[] splitted = text.split(",");
			List<WebElement> listele = driver.findElements(locator);
			for (int i=0;i<splitted.length;i++)
			{
				listele.get(i).click();
				listele.get(i).sendKeys(splitted[i]);
			}
			commonMethods.captureScreenShot(driver);

		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	
	public void close_Browser() {
		driver.quit();
	}
}