package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import drivers.DriverManager;
import pageobjects.LoginPage;
import utils.ExcelUtils;
import utils.ExtentManager;

public class WebAppTest extends DriverManager {

	@Parameters("browser")
	@Test
	public void WebAppFirst(String browser) {
		DriverManager.getWebDriver(browser);
		LoginPage loginPage = new LoginPage(getDriver());

		try {
			ExcelUtils excelUtils = new ExcelUtils("src/resources/testdata.xlsx");
			int rowCount = excelUtils.getRowCount("LoginData");
			ExtentManager.getInstance();
			if (browser.equalsIgnoreCase("chrome")) {
				ExtentManager.createTest("Chrome Results");
			} else {
				ExtentManager.createTest("Firefox Results");
			}

			for (int i = 1; i < rowCount; i++) {
				String username = excelUtils.getCellData("LoginData", i, 0);
				String password = excelUtils.getCellData("LoginData", i, 1);

				loginPage.enterUsername("akansha.sharma@crestechsoftware.com");
				loginPage.enterPassword("Password1");
				loginPage.clickLoginButton();

				// Add assertions or further actions as needed
				// Optionally update Excel with results
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ExtentManager.flush();
			DriverManager.quitWindowDrivers();
		}
	}

	@Parameters("browser")
	@Test
	public void WebAppSecond(String browser) {
		try {
			DriverManager.getWebDriver(browser);
			System.out.println("Second hello");
			ExtentManager.getInstance();
			if (browser.equalsIgnoreCase("chrome")) {
				ExtentManager.createTest("WebAppSecond: Chrome");
			} else {
				ExtentManager.createTest("WebAppSecond: Firefox");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ExtentManager.flush();
			DriverManager.quitWindowDrivers();
		}
	}
}