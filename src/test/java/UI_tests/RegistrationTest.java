package UI_tests;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import org.testng.annotations.Test;
import utils.Constants;

public class RegistrationTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @BeforeTest
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }
    @AfterTest
    public void tearDown() {
        super.tearDown();
    }
    //test for registration
    @Test
    public void testRegistration() {

        // Navigate to the home page
        logger.info("Navigating to the home page");
        homePage.navigateToHomePage();

        // Click the "Sign up" button on the login page
        logger.info("Clicking the 'Sign up' button on the login page");
        loginPage.clickSignUpButton();

        // Fill in the registration form and submit it
        logger.info("Filling in the registration form and submitting it");
        registrationPage.fillRegistrationForm(
                Constants.USERNAME,
                Constants.PASSWORD);
        logger.info("Submitting the registration form");
        registrationPage.submitRegistrationForm();

        // Verify that the user is logged in
        logger.info("Verifying that the user is logged in");
        registrationPage.waitForRegistrationSuccess();
    }

    //test for empty fields
    @Test
    public void testRegistrationWithEmptyFields() {
        // Navigate to the home page
        logger.info("Navigating to the home page");
        homePage.navigateToHomePage();

        // Click the "Sign up" button on the login page
        logger.info("Clicking the 'Sign up' button on the login page");
        loginPage.clickSignUpButton();

        // Fill in the registration form and submit it
        logger.info("Filling in the registration form and submitting it");
        registrationPage.fillRegistrationForm(
                "",
                "");
        logger.info("Submitting the registration form");
        registrationPage.submitRegistrationForm();

        // Verify that the user is logged in
        logger.info("Verifying that the user is logged in");
        registrationPage.emptyUsernameError();


    }
    // test for existing user
    @Test
    public void testRegistrationExistingUser(){
        // Navigate to the home page
        logger.info("Navigating to the home page");
        homePage.navigateToHomePage();

        // Click the "Sign up" button on the login page
        logger.info("Clicking the 'Sign up' button on the login page");
        loginPage.clickSignUpButton();

        // Fill in the registration form and submit it
        logger.info("Filling in the registration form and submitting it");
        registrationPage.fillRegistrationForm(
                "test",
                "test");
        logger.info("Submitting the registration form");
        registrationPage.submitRegistrationForm();

        // Verify that the user exists and error message is displayed
        logger.info("Verifying that the user exists and error message is displayed");
        registrationPage.existingUsernameError();
    }
    @Test
    public void testRegistrationForm(){
        // Navigate to the home page
        logger.info("Navigating to the home page");
        homePage.navigateToHomePage();

        // Click the "Sign up" button on the login page
        logger.info("Clicking the 'Sign up' button on the login page");
        loginPage.clickSignUpButton();

        // verify form title is displayed and correct
        logger.info("Verifying that the form title is displayed and correct");
        registrationPage.formTitle();

        // verify username label is displayed and correct
        logger.info("Verifying that the username label is displayed and correct");
        registrationPage.usernameLabel();

        // verify password label is displayed and correct
        logger.info("Verifying that the password label is displayed and correct");
        registrationPage.passwordLabel();

        // verify sign up button is displayed and correct
        logger.info("Verifying that the sign up button is displayed and correct");
        registrationPage.signUpButton();

    }
}