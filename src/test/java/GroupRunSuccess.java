import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupRunSuccess {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

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
        //Assert.assertEquals(total.getText().toString(), "48.00");
        Assert.assertEquals(total.getText(), String.format("%.2f", 48.0));
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
