package com.PG.browser;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.PG.genericLibrary.constants;
import com.PG.objectRepository.PGLoginNew;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class BrowserFactoryNew {
	
	static WebDriver driver;
	
	
	public static WebDriver StartApplication()
	{
		if(constants.browser.equalsIgnoreCase("firefox"))
				{
			     driver = new FirefoxDriver();
				}
		else if(constants.browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Automation_SAMS\\SamsPG\\chromedriver.exe");
			driver  = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(constants.url);
			System.out.println("Title of the new window: " + driver.getTitle());
	           	
		}
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public void Login(String MobileNumber, String Password) throws Exception {

		PGLoginNew pg = new PGLoginNew(driver);

		pg.MobileNo().sendKeys(MobileNumber);
		pg.Password().sendKeys(Password);

		Thread.sleep(3000);

		File src = driver.findElement(By.id("imgCapcha")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/test-output/captcha.png";

		try {
			FileHandler.copy(src, new File(path));

			ITesseract image = new Tesseract();

			String imageText = image.doOCR(new File(path));
			System.out.println(imageText);
			pg.Captcha().sendKeys(imageText);
			Thread.sleep(3000);
			//pg.SignIn().click();
		} catch (NoSuchElementException e) {
		}

	}
	
	public static void Quit() {
		
		//driver.quit();
	}
}