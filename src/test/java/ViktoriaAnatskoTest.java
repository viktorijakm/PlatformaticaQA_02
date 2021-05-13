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

public class ViktoriaAnatskoTest {

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
    public void testViktoriaAnatsko() throws InterruptedException {
        driver.get("https://oz.by/");

        WebElement input = driver.findElement(By.id("top-s"));
        input.sendKeys("карандаш\n");

        WebElement result = driver.findElement(
                By.xpath("//*[@id=\"goods-table\"]/li[1]/div/div/div/div/a/p[1]"));
        Assert.assertEquals(result.getText(), "Карандаш чернографитный с ластиком \"Party Blackline\" (HB)");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
