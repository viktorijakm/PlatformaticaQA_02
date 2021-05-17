import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupRunSuccessTest extends Utility {

       @Test
    public void testDimaStepanenko() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com/");

        WebElement buttonBooks = driver.findElement(By.xpath("//div[@class=\"listbox\"]/ul/li/a[@href=\"/books\"]"));
        buttonBooks.click();
        WebElement clickScienceBook = driver.findElement(By.xpath("//h2/a[@href=\"/fiction\"]"));
        clickScienceBook.click();
        WebElement qtyField = driver.findElement(By.id("addtocart_45_EnteredQuantity"));
        qtyField.clear();
        qtyField.sendKeys("2");
        WebElement pushAddToCartButton = driver.findElement(By.id("add-to-cart-button-45"));
        pushAddToCartButton.click();
        WebElement clickShoppingCartLink = driver.findElement(
                By.xpath("//li/a[@href=\"/cart\"]/span[@class=\"cart-label\"]"));
        clickShoppingCartLink.click();
        Thread.sleep(2000);
        WebElement total = driver.findElement(
                By.xpath("//td[@class=\"subtotal nobr end\"]/span[@class=\"product-subtotal\"]"));
        Assert.assertEquals(total.getText(), String.format("%.2f", 48.0));
    }
}
