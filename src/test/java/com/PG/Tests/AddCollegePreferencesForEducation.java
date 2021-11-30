package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.PG.Listener.ExtentFactory;
import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class AddCollegePreferencesForEducation extends BaseClass implements PGCAFData
{
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "AddCollege_Education";
	int rowCount = constants.fileone.getRowCount(sheetName);
	
	@Test(priority = 0)
	public void LoggingIn() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);
	}
	@Test(priority=1)
	public void CheckForAddMoreThan10Colleges() throws InterruptedException
	{
		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		//logger = report.createTest("population of College as per Subject for Male/Female Candidates");
		From.ClickOnAddPreferenceTab().click();
		Thread.sleep(2000);
		From.AddPreferencePGSubject("EDUCATION");
		Thread.sleep(2000);
		//ExtentFactory.getInstance().getExtent().info("Adding Colleges for choise locking");
		int collegeCount=4;
		for (int j = 1; j <= collegeCount; j++)
		{
			From.SelectAddCollegeNameByIndex(j);
			From.ADD().click();
		}
		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		//ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.toLowerCase().contains("More than 10 preferences can not be added".toLowerCase()))

		{
			constants.fileone.setCellData(sheetName, "Status", 2, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 2, "Fail");
		}
	}
	@Test(priority= 2)
	public void CheckForAddWomenCollegeForMaleCandidate() throws InterruptedException
	{
		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		//logger = report.createTest("population of College as per Subject for Male/Female Candidates");
		//From.ClickOnAddPreferenceTab().click();
		Thread.sleep(2000);
		From.AddPreferencePGSubject("EDUCATION");
		Thread.sleep(2000);
		From.AddPreferenceCollegeDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		From.SelectAddCollegeNameforOption("Rama Devi Women’s University, Bhubaneswar");
		From.ADD().click();
		Thread.sleep(2000);
		From.AddPreferenceSubmitTab().click();
		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		//ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Only female candidates can apply for women college"))

		{
			constants.fileone.setCellData(sheetName, "Status", 3, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 3, "Fail");
		}
	}
	@Test(priority= 3)
	public void CheckForAddDuplicateCollegeForEducation() throws InterruptedException
	{
		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		//logger = report.createTest("population of College as per Subject for Male/Female Candidates");
		//From.ClickOnAddPreferenceTab().click();
		Thread.sleep(2000);
		From.AddPreferencePGSubject("EDUCATION");
		Thread.sleep(2000);
		From.AddPreferenceCollegeDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		From.AddPreferenceCollegeDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		From.AddPreferenceCollegeDelete();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		From.SelectAddCollegeNameByIndex(1);
		From.ADD().click();
		Thread.sleep(2000);
		From.SelectAddCollegeNameByIndex(1);
		From.ADD().click();
		Thread.sleep(2000);
		String actualPopup = From.PopUpMsg().getText();
		System.out.println(actualPopup);
		//ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");

		if (actualPopup.contains("Same preference (Subject + College/University) could not be provided more than once. !"))

		{
			constants.fileone.setCellData(sheetName, "Status", 4, "Pass");
			Thread.sleep(300);
			From.PopUpOK().click();
		}

		else {
			constants.fileone.setCellData(sheetName, "Status", 4, "Fail");
		}
	}
	
}
