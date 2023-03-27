package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Constants;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        driver.get(Constants.BASE_URL);
    }

    public void navigateToCategory(String categoryName) {
        waitForPageToLoad(By.linkText(categoryName), Constants.TIMEOUT);
        driver.findElement(By.linkText(categoryName)).click();
    }

    public void clickSignInButton() {
        waitForPageToLoad(By.id("login2"), Constants.TIMEOUT);
        driver.findElement(By.id("login2")).click();
    }

    public void selectRandomItem() {
        waitForPageToLoad(By.xpath("//div//h4//a"), Constants.TIMEOUT);
        List<WebElement> itemElements = driver.findElements(By.xpath("//div//h4//a"));
        int randomItem = new Random().nextInt(itemElements.size());
        itemElements.get(randomItem).click();
}

    public String getItemName() {
        waitForPageToLoad(By.xpath("id('tbodyid')//h2"), Constants.TIMEOUT);
        return driver.findElement(By.xpath("id('tbodyid')//h2")).getText();

    }

    public int getItemPrice() {
        waitForPageToLoad(By.xpath("id('tbodyid')//h3"), Constants.TIMEOUT);
        String price = driver.findElement(By.xpath("id('tbodyid')//h3")).getText();
        price = price.split(" ")[0].replace("$", "");

        return Integer.parseInt(price);
    }

    public void addItemToCart() {
        waitForPageToLoad(By.linkText("Add to cart"), Constants.TIMEOUT);
        driver.findElement(By.linkText("Add to cart")).click();
    }

    public void navigateToCart() {
        waitForPageToLoad(By.id("cartur"), Constants.TIMEOUT);
        driver.findElement(By.id("cartur")).click();
    }

    public void isItemAddedToCart() {
        waitForPopupToLoad(Constants.TIMEOUT);
        assert driver.switchTo().alert().getText().equals("Product added.");
        driver.switchTo().alert().accept();
    }


}