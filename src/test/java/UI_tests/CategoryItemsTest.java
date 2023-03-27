package UI_tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.Constants;

import static pages.BasePage.waitForPageToLoad;

public class CategoryItemsTest extends BaseTest {

    @Test
    public void testCategoryItems() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Get a list of category elements
        logger.info("Getting a list of category elements");
        List<WebElement> categoryElements = driver.findElements(By.className("list-group"));
        String [] categories = categoryElements.get(0).getText().split("\n");
        logger.info("Checking each category for at least one item");

        for (int i = 1; i < categories.length; i++) {
            String category = categories[i];
            logger.info(String.format("Checking category '%s'", category));
            homePage.navigateToCategory(category);
            waitForPageToLoad(By.xpath("//div//h4//a"), Constants.TIMEOUT);
            List<WebElement> itemElements = driver.findElements(By.xpath("//div//h4//a"));
            Assert.assertTrue(itemElements.size() > 0, String.format("No items found for category '%s'", category));
        }

    }
}
