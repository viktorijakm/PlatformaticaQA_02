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

public class ValeriiSarukhanovTest {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() {

        driver.get("https://www.homedepot.com/");

        WebElement input = driver.findElement(By.id("headerSearch"));
        input.sendKeys("rose\n");

        WebElement finder = driver.findElement(By.xpath("//span[@class ='product-pod__title__product']"));

        Assert.assertTrue(finder.getText().toLowerCase().contains("rose"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
