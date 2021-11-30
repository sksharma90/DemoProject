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

public class EnvironmentalEconomics extends BaseClass implements PGCAFData {

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
	public void EnvironMentalEconomicsWithAtleast45Percentage() throws Exception {

		// logger = report.createTest("Verify EnvironMental Economics Apply Atleast 45
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		From.BasicInformationDetails();
		Thread.sleep(500);

		From.AdditionalDetails();
		Thread.sleep(500);

		From.GraduationPassed().click();

		Thread.sleep(500);

		From.GraduationWithDistinction().click();

		From.TenthMaxMark().clear();
		Thread.sleep(400);
		From.TenthMaxMark().sendKeys("600");
		Thread.sleep(400);
		From.TenthSecuredMarksorCGPA().clear();
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
		From.PlusTwoSecuredMarksorCGPA().clear();
		Thread.sleep(400);
		From.PlusTwoSecuredMarksorCGPA().sendKeys("455");

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
		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("275");
		String[] arrData = { "Arts", "Commerce", "Science", "B Pharma", "B Sc (Nursing)", "B.Ed", "BAMS", "BTech", "BE",
				"B Pharma", "BArch", "BDS (Bachelor of Dental Surgery)", "BBA", "BCA", "Law(LLB)", "BES", "BHMS", "BIT",
				"BSW", "Graduation with 1 yr B.Lib.Sc", "B.Sc. (ITM)", "B.Sc. (IST)", "B.Sc. (CS)", "B.Sc. (IT)","MBBS","Shastri",
				"BHM(Bachelor of Hotel Management)", "BOT (Bachelor of Occupational Therapy)", "Vetenary Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);

			From.GraduationStream(arrData[i]);
			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("BTech")) {
				From.CoreorHons("BTech");
			} else if (defaultItem.equals("BE")) {
				From.CoreorHons("BE");
			} else if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			} else if (defaultItem.equals("BES")) {
				From.CoreorHons("Electronics");
			} else if (defaultItem.equals("BHMS")) {
				From.CoreorHons("BHMS");
			} else if (defaultItem.equals("BIT")) {
				From.CoreorHons("Computer Science");
			} else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			} else if (defaultItem.equals("Graduation with 1 yr B.Lib.Sc")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Sc. (ITM)")) {
				From.CoreorHons("B.Sc. (ITM)");
			} else if (defaultItem.equals("B.Sc. (CS)")) {
				From.CoreorHons("B.Sc. (CS)");
			} else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			} else if (defaultItem.equals("B.Sc. (IT)")) {
				From.CoreorHons("B.Sc. (IT)");
			}else if (defaultItem.equals("B.Sc. (IST)")) {
				From.CoreorHons("B.Sc. (IST)");
			}else if (defaultItem.equals("BBA")) {
				From.CoreorHons("BBA");
			} else if (defaultItem.equals("BCA")) {
				From.CoreorHons("BCA");
			} else if (defaultItem.equals("B Pharma")) {
				From.CoreorHons("B Pharma");
			}else if (defaultItem.equals("B Sc (Nursing)")) {
				From.CoreorHons("B Sc (Nursing)");
			}else if (defaultItem.equals("B.Ed")) {
				From.CoreorHons("Education");
			}else if (defaultItem.equals("BAMS")) {
				From.CoreorHons("BAMS");
			}else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			}else if (defaultItem.equals("BDS (Bachelor of Dental Surgery)")) {
				From.CoreorHons("BDS (Bachelor of Dental Surgery");
			}else if (defaultItem.equals("BHM(Bachelor of Hotel Management)")) {
				From.CoreorHons("BHM(Bachelor of Hotel Management)");
			}else if (defaultItem.equals("BOT (Bachelor of Occupational Therapy)")) {
				From.CoreorHons("BOT (Bachelor of Occupational Therapy)");
			}else if (defaultItem.equals("MBBS")) {
				From.CoreorHons("MBBS");
			}else if (defaultItem.equals("Shastri")) {
				From.CoreorHons("Shastri");
			}else if (defaultItem.equals("Vetenary Science")) {
				From.CoreorHons("Vetenary Science");
			}else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			}

			else if (defaultItem.equals("Arts")) {

				Thread.sleep(300);
				From.Hons1().click();

				Thread.sleep(300);

				From.CoreorHons("Sociology");

				Thread.sleep(300);
				From.GraduationElective1("Hindi");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Commerce")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Commerce");
				Thread.sleep(300);
				From.GraduationElective1("Commerce");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Animal Science");
				Thread.sleep(300);
				From.GraduationElective1("Botany");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}
			ExtentFactory.getInstance().getExtent().info("Selecting Environmental Economics");
			Thread.sleep(400);
			From.PGSubjectofAdmission("Environmental Economics");

			Thread.sleep(400);

			// Thread.sleep(500);
			// From.CollegeorUniversityPreference("Maharaja Purna Chandra (Autonomous)
			// College, Baripada");

			Thread.sleep(400);

			From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
			Thread.sleep(400);

			From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
			Thread.sleep(400);
			From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
			Thread.sleep(400);

			From.ADD().click();
			Thread.sleep(400);

			From.EducationalQualificationNext1().click();

			Thread.sleep(400);

			String actualPopup = From.PopUpMsg().getText();
			System.out.println(actualPopup);
			ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
			if (actualPopup.contains("Are you sure want to proceed ?"))

			{
				constants.fileone.setCellData(sheetName, "Status", 125, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationCancel().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 125, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Are you sure want to proceed ?", "Test Failed");

			softAssert.assertAll();

			ExtentFactory.getInstance().getExtent()
					.info("Successfully Checked EnvironMentalEconomics PG Department Atleast 45 Percentage scenario");
		}

	}

	@Test(priority = 2)
	public void EnvironMentalEconomicsWithLessThan45Percentage() throws Exception {

		// logger = report.createTest("Verify EnvironMental Economics with Less Than 45
		// Percentage");

		PGCAFNew From = new PGCAFNew(driver);
		Thread.sleep(400);

		Thread.sleep(500);

		From.GraduationSecuredMarksorCGPA().clear();
		Thread.sleep(400);

		From.GraduationSecuredMarksorCGPA().sendKeys("260");

		String[] arrData = { "Arts", "Commerce", "Science", "B Pharma", "B Sc (Nursing)", "B.Ed", "BAMS", "BTech", "BE",
				"B Pharma", "BArch", "BDS (Bachelor of Dental Surgery)", "BBA", "BCA", "Law(LLB)", "BES", "BHMS", "BIT",
				"BSW", "Graduation with 1 yr B.Lib.Sc", "B.Sc. (ITM)", "B.Sc. (IST)", "B.Sc. (CS)", "B.Sc. (IT)","MBBS","Shastri",
				"BHM(Bachelor of Hotel Management)", "BOT (Bachelor of Occupational Therapy)", "Vetenary Science" };

		for (int i = 0; i < arrData.length; i++) {

			System.out.println(arrData[i]);

			From.GraduationStream(arrData[i]);

			Thread.sleep(400);

			From.GraduationStream(arrData[i]);
			Thread.sleep(400);
			Select select = new Select(driver.findElement(By.id("ddlGraduationStream")));
			Thread.sleep(400);
			WebElement option = select.getFirstSelectedOption();
			Thread.sleep(400);
			String defaultItem = option.getText();
			Thread.sleep(400);

			System.out.println(defaultItem);

			if (defaultItem.equals("BTech")) {
				From.CoreorHons("BTech");
			} else if (defaultItem.equals("BE")) {
				From.CoreorHons("BE");
			} else if (defaultItem.equals("Law(LLB)")) {
				From.CoreorHons("Law");
			} else if (defaultItem.equals("BES")) {
				From.CoreorHons("Electronics");
			} else if (defaultItem.equals("BHMS")) {
				From.CoreorHons("BHMS");
			} else if (defaultItem.equals("BIT")) {
				From.CoreorHons("Computer Science");
			} else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			} else if (defaultItem.equals("Graduation with 1 yr B.Lib.Sc")) {
				From.CoreorHons("Library Science");
			} else if (defaultItem.equals("B.Sc. (ITM)")) {
				From.CoreorHons("B.Sc. (ITM)");
			} else if (defaultItem.equals("B.Sc. (CS)")) {
				From.CoreorHons("B.Sc. (CS)");
			} else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			} else if (defaultItem.equals("B.Sc. (IT)")) {
				From.CoreorHons("B.Sc. (IT)");
			}else if (defaultItem.equals("B.Sc. (IST)")) {
				From.CoreorHons("B.Sc. (IST)");
			}else if (defaultItem.equals("BBA")) {
				From.CoreorHons("BBA");
			} else if (defaultItem.equals("BCA")) {
				From.CoreorHons("BCA");
			} else if (defaultItem.equals("B Pharma")) {
				From.CoreorHons("B Pharma");
			}else if (defaultItem.equals("B Sc (Nursing)")) {
				From.CoreorHons("B Sc (Nursing)");
			}else if (defaultItem.equals("B.Ed")) {
				From.CoreorHons("Education");
			}else if (defaultItem.equals("BAMS")) {
				From.CoreorHons("BAMS");
			}else if (defaultItem.equals("BArch")) {
				From.CoreorHons("BArch");
			}else if (defaultItem.equals("BDS (Bachelor of Dental Surgery)")) {
				From.CoreorHons("BDS (Bachelor of Dental Surgery");
			}else if (defaultItem.equals("BHM(Bachelor of Hotel Management)")) {
				From.CoreorHons("BHM(Bachelor of Hotel Management)");
			}else if (defaultItem.equals("BOT (Bachelor of Occupational Therapy)")) {
				From.CoreorHons("BOT (Bachelor of Occupational Therapy)");
			}else if (defaultItem.equals("MBBS")) {
				From.CoreorHons("MBBS");
			}else if (defaultItem.equals("Shastri")) {
				From.CoreorHons("Shastri");
			}else if (defaultItem.equals("Vetenary Science")) {
				From.CoreorHons("Vetenary Science");
			}else if (defaultItem.equals("BSW")) {
				From.CoreorHons("Social Work");
			}

			else if (defaultItem.equals("Arts")) {

				Thread.sleep(300);
				From.Hons1().click();

				Thread.sleep(300);

				From.CoreorHons("Sociology");

				Thread.sleep(300);
				From.GraduationElective1("Hindi");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Commerce")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Commerce");
				Thread.sleep(300);
				From.GraduationElective1("Commerce");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}

			else if (defaultItem.equals("Science")) {
				Thread.sleep(300);
				From.Hons1().click();

				From.CoreorHons("Animal Science");
				Thread.sleep(300);
				From.GraduationElective1("Botany");

				Thread.sleep(300);
				From.Credit1("84");
				Thread.sleep(300);
				From.Elective1Credit1("24");
			}
			ExtentFactory.getInstance().getExtent().info("Selecting Environmental Economics");
			Thread.sleep(400);
			From.PGSubjectofAdmission("Environmental Economics");

			Thread.sleep(400);

			// Thread.sleep(500);
			// From.CollegeorUniversityPreference("Maharaja Purna Chandra (Autonomous)
			// College, Baripada");

			Thread.sleep(400);

			Thread.sleep(400);
			From.FirstPreference("Berhampur University, Bhanja Vihar, Berhampur");
			Thread.sleep(400);

			From.SecondPreference("Bhadrak (Autonomous) College,Bhadrak");
			Thread.sleep(400);
			From.ThirdPreference("Dharanidhar (Autonomous) College, Keonjhar");
			Thread.sleep(400);

			From.ADD().click();
			Thread.sleep(400);

			String actualPopup = From.PopUpMsg().getText();
			System.out.println(actualPopup);
			ExtentFactory.getInstance().getExtent().info("Assertion of Expected & Actual Result");
			if (actualPopup.contains("Graduation Percentage cannot be less than 45"))

			{
				constants.fileone.setCellData(sheetName, "Status", 126, "Pass");
				Thread.sleep(300);
				From.EducationalQualificationOk().click();
			}

			else {
				constants.fileone.setCellData(sheetName, "Status", 126, "Fail");
			}
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(actualPopup, "Graduation Percentage cannot be less than 45", "Test Failed");

			softAssert.assertAll();

			ExtentFactory.getInstance().getExtent().info(
					"Successfully Checked EnvironMentalEconomics PG Department with Less Than 45 Percentage scenario");
		}

	}
}