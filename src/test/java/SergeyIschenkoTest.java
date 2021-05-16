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

public class SergeyIschenkoTest {

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
    public void testSergeIschenko() throws InterruptedException {
        driver.get("https://www.safeway.com/");

        WebElement input = driver.findElement(By.id("skip-main-content")); //*[@id="skip-main-content"]
        input.click();
        input.sendKeys("milk\n");
        Thread.sleep(1000);

        WebElement product = driver.findElement(By.id("pg136010121"));
        product.click();

        WebElement productName = driver.findElement(By.tagName("h1"));

        Assert.assertEquals(productName.getText(), "Lucerne Milk Whole 1 Gallon - 128 Fl. Oz.");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}