package drivers;
 
import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import java.net.URL;
import java.util.concurrent.TimeUnit;
 
public class DriverManager
 {
    private static WebDriver webDriver;
    private static AppiumDriver appiumDriver;
 
    public static WebDriver getWebDriver(String browser) {
        if (webDriver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                    webDriver.get("https://app-qa.certiplate.com/account/login");
                    break;
                case "firefox":
                   System.setProperty("webdriver.gecko.driver", "D:\\Driver\\geckodriver.exe");
                   webDriver = new FirefoxDriver();
                   webDriver.get("https://app-qa.certiplate.com/account/login");
                    break;
                    
                case "edge":
                    System.setProperty("webdriver.edge.driver", "D:\\Driver\\msedgedriver.exe");
                    webDriver = new EdgeDriver();
                    webDriver.get("https://app-qa.certiplate.com/account/login");
                     break;
                // Add other browsers as needed
                default:
                    throw new IllegalArgumentException("Browser not supported");
            }
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return webDriver;
    }
 
    public static AppiumDriver getAppiumDriver() {
        if (appiumDriver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "C:\\Users\\Divya.Devi\\AppData\\Local\\Programs\\certiplate-candidate-app\\navrithi-certiplate.exe");
            capabilities.setCapability("platformName", "Windows");
            capabilities.setCapability("deviceName", "WindowsPC");
 
            try {
                appiumDriver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                appiumDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appiumDriver;
    }
 
    public static void quitWindowDrivers() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
    
    public static void quitAppiumDrivers() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}