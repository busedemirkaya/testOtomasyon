package tests;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;
import utils.DriverManager;
import java.net.MalformedURLException;
import java.util.ArrayList;
public class WindowHandlling extends DriverManager {
    @Test
    public void windowhandllingTest() throws InterruptedException {
        String openingURL = "https://e-bebek.com";
        driver.get(openingURL);
        String firstWindow = driver.getWindowHandle();
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(2000);
        driver.get(baseURL);
        Thread.sleep(2000);

        driver.switchTo().window(firstWindow);
        driver.get("https://e-bebek.com");
        Thread.sleep(2000);


    }
}
