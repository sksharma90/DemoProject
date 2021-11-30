package com.PG.Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAF;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class PopulationOfCollegeForLifeScience extends BaseClass implements PGCAFData
{
	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "LifeScience(M,F)";
	int rowCount = constants.fileone1.getRowCount(sheetName);
	
	@Test(priority = 0)
	public void LoggingIn() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);
	}
	
	@Test(priority =1)
	public void populationOfCollegeForEducationSubject() throws InterruptedException, IOException
	{
		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);
		//logger = report.createTest("population of College as per Subject for Male/Female Candidates");
		From.ClickOnAddPreferenceTab().click();
		Thread.sleep(2000);
		From.AddPreferencePGSubject("Life Science");
		Thread.sleep(2000);
		FileInputStream myFile = new FileInputStream("D:\\Automation_SAMS\\SamsPG\\SAMS_PGAddPreferencesInputData.xlsx");
		// FileInputStream fis = new FileInputStream(myFile);
		XSSFWorkbook myWorkBook = new XSSFWorkbook(myFile);
		XSSFSheet mySheet = myWorkBook.getSheet("LifeScience(M,F)");
		System.out.println(mySheet);

		int rowCount1 = mySheet.getLastRowNum();

		System.out.println(rowCount1);

		for (int j = 1; j <= rowCount1; j++) {

			Thread.sleep(1000);
			//String data0 = mySheet.getRow(j).getCell(0).getStringCellValue();
			//bc.SelectDistrictNameforOption().sendKeys(data0);
			//System.out.println(data0);
			//Thread.sleep(5000);

			Select drobcown = new Select(From.AddCollegeNameforOption());
			java.util.List<WebElement> elementCount = drobcown.getOptions();
			Thread.sleep(200);

			int itemSize = elementCount.size();


			String data1 = mySheet.getRow(j).getCell(1).getStringCellValue();

			System.out.println(data1);

			

			// String sheetName = "";
			try {
				From.SelectAddCollegeNameforOption(data1);
				Thread.sleep(4000);
				Select select = new Select(driver.findElement(By.id("ddlCPreference")));
				Thread.sleep(4000);
				WebElement option = select.getFirstSelectedOption();
				Thread.sleep(400);
				String defaultItem = option.getText();
				Thread.sleep(400);
				System.out.println(defaultItem);
				if (defaultItem.equals(data1)) {
					System.out.println("Pass");

					// if (rowCount == 100)
					constants.fileone1.setCellData(sheetName, "Status", j+1, "Pass");
					System.out.println(j);
				} else {
					System.out.println("Fail");
					constants.fileone1.setCellData(sheetName, "Status", j+1, "Fail");
					System.out.println(j);
			}
			}
				catch (Exception e) {
				// TODO: handle exception
					System.out.println("Fail");
					constants.fileone1.setCellData(sheetName, "Status", j+1, "Fail");
					System.out.println(j);
			}
			
			}
		}
	}

