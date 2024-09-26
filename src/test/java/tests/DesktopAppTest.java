package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import drivers.DriverManager;
import pageobjects.DesktopLoginPage;
import utils.EmailUtils;
import utils.ExcelUtils;
import utils.ExtentManager;

public class DesktopAppTest {
	
	@Test
	public void FirstDesktopTest() {
		DriverManager.getAppiumDriver();
		DesktopLoginPage loginPage = new DesktopLoginPage(DriverManager.getAppiumDriver());
		try {
			ExtentManager.getInstance();
			ExtentTest test = ExtentManager.createTest("Desktop Application Login Test");

//			EmailUtils emailUtils = new EmailUtils();
//			emailUtils.mailSent();
			
			ExcelUtils excelUtils = new ExcelUtils("src/resources/testdata.xlsx");
			int rowCount = excelUtils.getRowCount("LoginData");
			for (int i = 1; i < rowCount; i++) {
				String username = excelUtils.getCellData("LoginData", i, 0);
				String password = excelUtils.getCellData("LoginData", i, 1);
				loginPage.enterUsername(username);
				loginPage.enterPassword(password);
				loginPage.clickLoginButton();
				test.pass("Successfully logged in with username: " + username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ExtentManager.flush();
			DriverManager.quitDrivers();
		}
	}
}