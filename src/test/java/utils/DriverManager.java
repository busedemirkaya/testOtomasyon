package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class DriverManager {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;
    public String baseURL;
    public void setDriver(String testBrowser) throws MalformedURLException {
        switch (testBrowser) {
            case"firefox": {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-minimized");
                driver = new FirefoxDriver(firefoxOptions);
               break;
            }
            case"chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-minimized");
                driver = new RemoteWebDriver(chromeOptions);
                break;
            }
            default: {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
        }
        js = (JavascriptExecutor) driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.print("Chrome");
        baseURL = "https://www.e-bebek.com";
        driver.manage().window().maximize();;

    }
}