package pageobjects;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
 
public class DesktopLoginPage {
    private AppiumDriver driver;
 
    private MobileElement getUsernameField() {
        return (MobileElement) driver.findElementByAccessibilityId("basic_assessmentUrl");
    }

    private MobileElement getPasswordField() {
        return (MobileElement) driver.findElementByAccessibilityId("basic_accessCode");
    }

    private MobileElement getLoginButton() {
        return (MobileElement) driver.findElementByName("Sign In");
    }

    // Actions to be performed on the page
    public void enterUsername(String username) {
        getUsernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
 
    public DesktopLoginPage(AppiumDriver driver) {
        this.driver = driver;
   //     PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
 
   

	
}