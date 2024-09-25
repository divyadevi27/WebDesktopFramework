package pageobjects;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class LoginPage {
	 private WebDriver driver;

	  
 
    @FindBy(id = "username")
    private WebElement usernameField;
 
    @FindBy(id = "password")
    private WebElement passwordField;
 
    @FindBy(xpath = "//span[text()=' Sign In ']")
    private WebElement loginButton;
 
    public LoginPage(WebDriver driver) {
      //  this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
 
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
 
    public void clickLoginButton() {
        loginButton.click();
    }
//    
//    private MobileElement getUsernameField() {
//        return (MobileElement) driver.findElementByAccessibilityId("basic_assessmentUrl");
//    }
//
//    private MobileElement getPasswordField() {
//        return (MobileElement) driver.findElementByAccessibilityId("basic_accessCode");
//    }
//
//    private MobileElement getLoginButton() {
//        return (MobileElement) driver.findElementByName("Sign In");
//    }
//
//    // Actions to be performed on the page
//    public void enterUsername(String username) {
//        getUsernameField().sendKeys(username);
//    }
//
//    public void enterPassword(String password) {
//        getPasswordField().sendKeys(password);
//    }
//
//    public void clickLoginButton() {
//        getLoginButton().click();
//    }
//    
}