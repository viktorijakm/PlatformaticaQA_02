import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class YakovGTest {
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
    public void test() throws InterruptedException {
        driver.get("https://www.sportsmans.com/");

        WebElement input = driver.findElement(By.id("js-site-search-input"));
        input.sendKeys("FN Five SeveN Pistol\n");

        WebElement result = driver.findElement(By.xpath("/html/body/main/div[4]/div[1]/div/div[2]/div/div/div[1]/ul/li[1]/div/div[2]/div[2]/h2/a"));

        Assert.assertEquals(result.getText(), "FN Five SeveN Pistol");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
