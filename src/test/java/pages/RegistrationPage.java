package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private final By usernameField = By.id("sign-username");
    private final By passwordField = By.id("sign-password");
    private final By signUpButton = By.cssSelector("button[onclick='register()']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(String username, String password) {
        waitForPageToLoad(usernameField, 10);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitRegistrationForm() {
        waitForPageToLoad(signUpButton, 10);
        driver.findElement(signUpButton).click();
    }

    public void waitForRegistrationSuccess() {
        waitForPopupToLoad(10);
        if (driver.switchTo().alert().getText().equals("Sign up successful.")){
            driver.switchTo().alert().accept();
            logger.info("Registration successful");
        }else {
            driver.switchTo().alert().accept();
            logger.info("Registration failed");
            logger.info("Error message: " + driver.switchTo().alert().getText());
            assert false;
        }
    }

    public void emptyUsernameError() {
        waitForPopupToLoad(10);
        if(driver.switchTo().alert().getText().equals("Please fill out Username and Password.")){
            driver.switchTo().alert().accept();
            logger.info("Empty username error displayed");
        }else {
            driver.switchTo().alert().accept();
            logger.info("Empty username error not displayed");
            logger.info("Error message: " + driver.switchTo().alert().getText());
            assert false;
        }
    }

    public void existingUsernameError() {
        waitForPopupToLoad(10);
        if(driver.switchTo().alert().getText().equals("This user already exist.")){
            driver.switchTo().alert().accept();
            logger.info("Existing username error displayed");
        }else {
            driver.switchTo().alert().accept();
            logger.info("Existing username error not displayed");
            logger.info("Error message: " + driver.switchTo().alert().getText());
            assert false;
        }
    }

    public void formTitle() {
        waitForPageToLoad(By.id("signInModalLabel"), 10);
        if( driver.findElement(By.id("signInModalLabel")).getText().equals("Sign up")){
            logger.info("Sign up form title displayed");}
        else {
            logger.info("Sign up form title not displayed");
            logger.info("Error message: " + driver.findElement(By.id("signInModalLabel")).getText());
            assert false;
        }
    }

    public void usernameLabel() {
        waitForPageToLoad(By.xpath("//label[@for='sign-username']"), 10);
        if (driver.findElement(By.xpath("//label[@for='sign-username']")).getText().equals("Username:")){
            logger.info("Username label displayed");
        }else {
            logger.info("Username label not displayed");
            logger.info("Error message: " + driver.findElement(By.xpath("//label[@for='sign-username']")).getText());
            assert false;
        }

    }

    public void passwordLabel() {
        waitForPageToLoad(By.xpath("//label[@for='sign-password']"), 10);
        assert driver.findElement(By.xpath("//label[@for='sign-password']")).getText().equals("Password:");
        if (driver.findElement(By.xpath("//label[@for='sign-password']")).getText().equals("Password:")){
            logger.info("Password label displayed");
        }else {
            logger.info("Password label not displayed");
            logger.info("Error message: " + driver.findElement(By.xpath("//label[@for='sign-password']")).getText());
            assert false;
        }

    }

    public void signUpButton() {
        waitForPageToLoad(By.cssSelector("button[onclick='register()']"), 10);
        assert driver.findElement(By.cssSelector("button[onclick='register()']")).getText().equals("Sign up");
        if (driver.findElement(By.cssSelector("button[onclick='register()']")).getText().equals("Sign up")){
            logger.info("Sign up button displayed");
        }else {
            logger.info("Sign up button not displayed");
            logger.info("Error message: " + driver.findElement(By.cssSelector("button[onclick='register()']")).getText());
            assert false;

        }

    }
}