package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class LoginPage extends BasePage {
    private final By loginButton = By.id("login2");
    private final By usernameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By loginForm = By.id("logInModal");
    private final By signUpButton = By.id("signin2");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        waitForPageToLoad(loginButton, Constants.TIMEOUT);
        driver.findElement(loginButton).click();
    }

    public void enterUsername(String username) {
        waitForPageToLoad(usernameField, Constants.TIMEOUT);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForPageToLoad(passwordField, Constants.TIMEOUT);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLoginForm() {
        waitForPageToLoad(loginForm, Constants.TIMEOUT);
        driver.findElement(loginForm).findElement(By.xpath("//button[text()='Log in']")).click();
    }

    public void clickSignUpButton() {
        waitForPageToLoad(signUpButton, Constants.TIMEOUT);
        driver.findElement(signUpButton).click();
    }

    public void isUserLoggedIn(String randomUser) {
        waitForPageToLoad(By.id("nameofuser"), Constants.TIMEOUT);
        assert driver.findElement(By.id("nameofuser")).getText().equals("Welcome " + randomUser);
    }

    public void isLoginErrorDisplayed() {
        waitForPopupToLoad(Constants.TIMEOUT);
        assert driver.switchTo().alert().getText().equals("Wrong password.");
        driver.switchTo().alert().accept();
    }

    public void isLoginEmptyErrorDisplayed() {
        waitForPopupToLoad(Constants.TIMEOUT);
        assert driver.switchTo().alert().getText().equals("Please fill out Username and Password.");
        driver.switchTo().alert().accept();
    }

    public void isLoginNotRegisteredErrorDisplayed() {
        waitForPopupToLoad(Constants.TIMEOUT);
        assert driver.switchTo().alert().getText().equals("User does not exist.");
        driver.switchTo().alert().accept();
    }

    public void isLoginFormDisplayed() {
        waitForPageToLoad(loginForm, Constants.TIMEOUT);
        assert driver.findElement(loginForm).isDisplayed();
    }

    public void isLoginUsernameLabelDisplayed() {
        waitForPageToLoad(By.xpath("//label[@for='log-name']"), Constants.TIMEOUT);
        assert driver.findElement(By.xpath("//label[@for='log-name']")).getText().equals("Username:");
    }

    public void isLoginPasswordLabelDisplayed() {
        waitForPageToLoad(By.xpath("//label[@for='log-pass']"), Constants.TIMEOUT);
        assert driver.findElement(By.xpath("//label[@for='log-pass']")).getText().equals("Password:");
    }

    public void isLoginFormTitleDisplayed() {
        waitForPageToLoad(By.id("logInModalLabel"), Constants.TIMEOUT);
        assert driver.findElement(By.id("logInModalLabel")).getText().equals("Log in");
    }
    public void login(String username, String password) {
        clickLoginButton();
        enterUsername(username);
        enterPassword(password);
        submitLoginForm();
        isUserLoggedIn(username);

    }
}
