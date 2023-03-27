package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

import java.time.Duration;

public abstract class BasePage {
    public static final Logger logger = Logger.getLogger(BasePage.class.getName());
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void waitForPageToLoad(By locator, int timeoutInSeconds) {
        Duration waitTime = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitForPopupToLoad(int timeoutInSeconds) {
        Duration waitTime = Duration.ofSeconds(timeoutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}