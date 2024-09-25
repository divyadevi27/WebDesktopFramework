package crestech.com.CrestechSelenium;

import org.openqa.selenium.WebDriver;

import drivers.DriverManager;
import pageobjects.LoginPage;
import utils.ExcelUtils;
 
public class WebAppTest {
    public static void main(String[] args) {
        DriverManager.getWebDriver("edge");
        LoginPage loginPage = new LoginPage(DriverManager.getWebDriver("edge"));

        try {
            ExcelUtils excelUtils = new ExcelUtils("src/resources/testdata.xlsx");
            int rowCount = excelUtils.getRowCount("LoginData");
 
            for (int i = 1; i < rowCount; i++) {
                String username = excelUtils.getCellData("LoginData", i, 0);
                String password = excelUtils.getCellData("LoginData", i, 1);
 
                loginPage.enterUsername("akansha.sharma@crestechsoftware.com" );
                loginPage.enterPassword("Password1");
                loginPage.clickLoginButton();
 
                // Add assertions or further actions as needed
                // Optionally update Excel with results
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DriverManager.quitDrivers();
        }
    }
}