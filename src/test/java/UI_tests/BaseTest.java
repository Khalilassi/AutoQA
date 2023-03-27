package UI_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.logging.Logger;
import java.util.logging.Level;

import java.time.Duration;


public class BaseTest {
    protected static WebDriver driver;
    public static final Logger logger = Logger.getLogger(BaseTest.class.getName());



    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }

}
