import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class StasChampionTest {

    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://google.com/");

        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys("123\n");

        WebElement result = driver.findElement(
                By.xpath("//*[@id=\"wp-tabs-container\"]/div[1]/div/div/div/div/div/div/div[2]/h3/a/h3"));

        Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
