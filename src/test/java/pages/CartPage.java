package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void verifyOrderConfirmationTitle() {
        waitForPageToLoad(By.xpath("//h2[text()='Thank you for your purchase!']"), Constants.TIMEOUT);
    }

    public void verifyOrderConfirmation(int itemPrice, String cardNumber, String name) {
        waitForPageToLoad(By.xpath("//h2[text()='Thank you for your purchase!']"), Constants.TIMEOUT);
        int price = Integer.parseInt(driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']//following-sibling::p")).getText().split("\n")[1].split(": ")[1].split(" ")[0]);
        String card = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']//following-sibling::p")).getText().split("\n")[2].split(": ")[1];
        String customerName = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']//following-sibling::p")).getText().split("\n")[3].split(": ")[1];
        if (price == itemPrice && card.equals(cardNumber) && customerName.equals(name)) {
            logger.info("Order confirmation is correct");
            assert true;
        } else {


            //logging the actual values in the report
            logger.warning("Order confirmation is incorrect");
            logger.info("Expected price: " + itemPrice);
            logger.info("Actual price: " + price);
            logger.info("Expected card number: " + cardNumber);
            logger.info("Actual card number: " + card);
            logger.info("Expected customer name: " + name);
            logger.info("Actual customer name: " + customerName);
            clickOkButton();
            assert false;
        }
    }

    public void proceedToCheckout() {
        waitForPageToLoad(By.xpath("//button[text()='Place Order']"), Constants.TIMEOUT);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    }

    public void clickOkButton() {
        waitForPageToLoad(By.xpath("//button[text()='OK']"), Constants.TIMEOUT);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
    }

    public int getItemCount() {
        waitForPageToLoad(By.id("page-wrapper"), Constants.TIMEOUT);
        return driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr")).size();

    }

    public String getItemName() {
        waitForPageToLoad(By.xpath("//tbody[@id='tbodyid']//tr//td[2]"), Constants.TIMEOUT);
        return driver.findElement(By.xpath("//tbody[@id='tbodyid']//tr//td[2]")).getText();
    }

    public int getItemPrice() {
        waitForPageToLoad(By.xpath("//tbody[@id='tbodyid']//tr//td[3]"), Constants.TIMEOUT);
        return Integer.parseInt(driver.findElement(By.xpath("//tbody[@id='tbodyid']//tr//td[3]")).getText().split(" ")[0]);

    }

    public void removeItem() {
        waitForPageToLoad(By.linkText("Delete"), Constants.TIMEOUT);
        driver.findElement(By.linkText("Delete")).click();
    }
}