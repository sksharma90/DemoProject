package com.PG.Tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.PG.Listener.ExtentFactory;
import com.PG.browser.BrowserFactoryNew;
import com.PG.genericLibrary.constants;
import com.PG.objectRepository.BaseClass;
import com.PG.objectRepository.PGCAFData;
import com.PG.objectRepository.PGCAFNew;

public class SmokeTest_Subrat extends BaseClass implements PGCAFData {

	XSSFWorkbook wb;
	XSSFSheet sht;
	String sheetName = "Result";
	int rowCount = constants.fileone.getRowCount(sheetName);

	@Test(priority = 0)
	public void LoggingIn() throws Exception {

		BrowserFactoryNew bc = new BrowserFactoryNew();
		bc.Login(MobileNumber, Password);
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void CAF_Submit() throws Exception {


		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.GraduationPassed().click();

		Thread.sleep(500);

		From.GraduationWithDistinction().click();
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		
		
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().sendKeys("455");
		Thread.sleep(500);
		From.PlusTwoStream("Science");

		Thread.sleep(500);
		From.PlusTwoMarkType("MARK");

		Thread.sleep(500);
		From.PlusTwoBoard("CHSE, Odisha");

		Thread.sleep(500);
		From.PlusTwoYOP("2018");

		Thread.sleep(400);
		From.PlusTwoRollNo().clear();
		Thread.sleep(400);
		From.PlusTwoRollNo().sendKeys("41TC178");
		Thread.sleep(400);
		From.PlusTwoMaxMark().clear();
		Thread.sleep(400);
		From.PlusTwoMaxMark().sendKeys("600");
		
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("455");

		Thread.sleep(500);
		From.GraduationStream("B.Sc. (IST)");
		Thread.sleep(500);
		From.GraduationMarkType("MARK");
		Thread.sleep(500);

		From.GraduationBoard("Siksha ‘O’ Anusandhan University, Bhubaneswar");

		Thread.sleep(500);

		From.GraduationYOP("2021");

		Thread.sleep(400);
		From.GraduationRollNo().clear();
		Thread.sleep(400);
		From.GraduationRollNo().sendKeys("51TC678");

		Thread.sleep(400);
		From.GraduationMaxMark().clear();
		Thread.sleep(400);
		From.GraduationMaxMark().sendKeys("600");

		
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("275");
		Thread.sleep(500);
		From.CoreorHons("B.Sc. (IST)");
		Thread.sleep(500);
		From.GraduationStream("Science");
		Thread.sleep(500);
		From.GraduationStream("B.Sc. (IST)");
		Thread.sleep(500);
		From.CoreorHons("B.Sc. (IST)");
		Thread.sleep(500);
		From.PGSubjectofAdmission("Electronic Science");
		Thread.sleep(5000);
		From.ADD().click();
		//From.ADD();
		Thread.sleep(500);
		From.PGSubjectofAdmission("MCA (Master in Computer Application)");
		Thread.sleep(500);
		From.ADD().click();
		From.PGSubjectofAdmission("M.Sc (Computer Science)");
		Thread.sleep(500);
		From.ADD().click();
		From.FirstPreference("Gangadhar Meher University, Amrut Vihar, Sambalpur");
		Thread.sleep(500);
		From.SecondPreference("Sambalpur University, Jyoti Vihar, Sambalpur");
		Thread.sleep(500);
		From.ThirdPreference("Utkal University, Vanivihar, Bhubaneswar");
		Thread.sleep(500);
		From.EducationalQualificationNext().click();
		Thread.sleep(5000);
		From.EducationalQualificationOk().click();
		Thread.sleep(500);
		From.PDFUploadImage();

		Thread.sleep(500);

		From.UploadButton().click();
		Thread.sleep(500);
		From.UploadOkButton().click();
		Thread.sleep(500);
		From.UploadNextButton().click();
		Thread.sleep(500);
		
	
	}
}
