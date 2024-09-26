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
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Garima.Goyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                	
                	  // Initialize Chrome Options if needed
//                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--start-maximized");  // Opens Chrome in full screen
//                    chromeOptions.addArguments("--disable-infobars");  // Disables the 'Chrome is being controlled by automated test software' message
//
//                    // Set up the WebDriver using WebDriverManager to manage ChromeDriver
//                    WebDriverManager.chromedriver().setup();
//                    webDriver = new ChromeDriver(chromeOptions);
                    webDriver.get("https://app-qa.certiplate.com/account/login");
                    break;
                case "firefox":
                   System.setProperty("webdriver.gecko.driver", "C:\\Users\\Garima.Goyal\\Downloads\\geckodriver-v0.35.0-win32\\geckodriver.exe");
                   webDriver = new FirefoxDriver();
                   webDriver.get("https://app-qa.certiplate.com/account/login");
                    break;
                    
                case "edge":
                    System.setProperty("webdriver.edge.driver", "C:\\Users\\Garima.Goyal\\Downloads\\edgedriver_win64\\msedgedriver.exe");
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
 
    public static void quitDrivers() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}