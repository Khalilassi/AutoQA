package UI_tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void testLoginWithValidCredentials() {
        // Navigate to the login page
        homePage.navigateToHomePage();

        // Click the "Sign in" button on the home page
        homePage.clickSignInButton();

        // Enter valid username and password and submit the form
        loginPage.enterUsername(Constants.VALID_USERNAME);
        loginPage.enterPassword(Constants.VALID_PASSWORD);
        loginPage.submitLoginForm();

        // Verify that the user is logged in
        loginPage.isUserLoggedIn(Constants.VALID_USERNAME);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        // Navigate to the login page
        homePage.navigateToHomePage();

        // Click the "Sign in" button on the home page
        homePage.clickSignInButton();

        // Enter invalid username and password and submit the form
        loginPage.enterUsername(Constants.VALID_USERNAME);
        loginPage.enterPassword(Constants.INVALID_PASSWORD);
        loginPage.submitLoginForm();

        // Verify that the login fails and an error message is displayed
        loginPage.isLoginErrorDisplayed();
    }
    @Test
    public void testLoginWithEmptyFields() {
        // Navigate to the login page
        homePage.navigateToHomePage();

        // Click the "Sign in" button on the home page
        homePage.clickSignInButton();

        // Enter invalid username and password and submit the form
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.submitLoginForm();

        // Verify that the login fails and an error message is displayed
        loginPage.isLoginEmptyErrorDisplayed();
    }

    @Test
    public void testLoginWithNotRegisteredUser() {
        // Navigate to the login page
        homePage.navigateToHomePage();

        // Click the "Sign in" button on the home page
        homePage.clickSignInButton();

        // Enter invalid username and password and submit the form
        loginPage.enterUsername(Constants.NOT_REGISTERED_USERNAME);
        loginPage.enterPassword(Constants.VALID_PASSWORD);
        loginPage.submitLoginForm();

        // Verify that the login fails and an error message is displayed
        loginPage.isLoginNotRegisteredErrorDisplayed();
    }

    @Test
    public void testLoginFormIsDisplayed() {
        // Navigate to the login page
        homePage.navigateToHomePage();

        // Click the "Sign in" button on the home page
        homePage.clickSignInButton();

        // Verify that the login form is displayed
        loginPage.isLoginFormDisplayed();

        // Verify that the login form title is displayed
        loginPage.isLoginFormTitleDisplayed();

        // Verify that the login username label is displayed
        loginPage.isLoginUsernameLabelDisplayed();

        // Verify that the login password label is displayed
        loginPage.isLoginPasswordLabelDisplayed();

    }
}