package UI_tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class RemoveItemTest extends BaseTest {
    @Test
    public void testRemoveItem() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Select a random item and add it to the cart
        homePage.selectRandomItem();
        String itemName = homePage.getItemName();
        int itemPrice = homePage.getItemPrice();
        homePage.addItemToCart();
        // Navigate to the cart page and verify that the item is in the cart
        homePage.navigateToCart();
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(5000);
        Assert.assertEquals(cartPage.getItemCount(), 1, "Item count in cart is not 1");
        Assert.assertEquals(cartPage.getItemName(), itemName, "Item name in cart is incorrect");
        Assert.assertEquals(cartPage.getItemPrice(), itemPrice, "Item price in cart is incorrect");

        // Remove the item from the cart and verify that the cart is empty
        cartPage.removeItem();
        //sleep for 5 seconds
        Thread.sleep(5000);
        Assert.assertEquals(cartPage.getItemCount(), 0, "Item count in cart is not 0");

    }
}
