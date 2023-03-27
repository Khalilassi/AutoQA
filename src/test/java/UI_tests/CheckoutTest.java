package UI_tests;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Constants;

import java.util.Random;

public class CheckoutTest extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);


    }
    @Test
    public void testCheckout() {
        // Navigate to the home page and select a random category
        homePage.navigateToHomePage();
        loginPage.login(Constants.VALID_USERNAME, Constants.VALID_PASSWORD);
        Random random = new Random();
        String[] categories = {"Phones", "Laptops", "Monitors"};
        String category = categories[random.nextInt(categories.length)];
        homePage.navigateToCategory(category);

        // Add a random item to the cart
        homePage.selectRandomItem();
        String itemName = homePage.getItemName();
        int itemPrice = homePage.getItemPrice();
        homePage.addItemToCart();
        // Verify that the item is added to the cart

        homePage.isItemAddedToCart();


        // Go to the cart and click the "Place Order" button
        homePage.navigateToCart();
        cartPage.proceedToCheckout();

        // sleep for 5 seconds

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Fill in the checkout form and submit it
        String cardNumber = "1234567890123456";
        String month = "1";
        String year = "2025";


        checkoutPage.fillCheckoutForm(
                Constants.NAME,
                Constants.COUNTRY,
                Constants.CITY,
                cardNumber,
                month,
                year
        );
        checkoutPage.submitCheckoutForm();

        // Verify that the order is placed successfully
        cartPage.verifyOrderConfirmationTitle();
        cartPage.verifyOrderConfirmation(itemPrice,cardNumber,Constants.NAME);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cartPage.clickOkButton();
        homePage.navigateToCart();
    }
}
