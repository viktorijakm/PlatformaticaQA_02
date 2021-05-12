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
    public void test1StasChampion() throws InterruptedException {
        driver.get("https://google.com/");

        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys("123\n");

        WebElement result = driver.findElement(
                By.xpath("//*[@id=\"wp-tabs-container\"]/div[1]/div/div/div/div/div/div/div[2]/h3/a/h3"));

        Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
    }

    @Test
    public void test2StasChampion() throws InterruptedException {
        driver.get("https://bukovel.com/en/");

        Thread.sleep(5000);

        WebElement readMoreButton = driver.findElement(
                By.xpath("//div[@id='scaleContainer']/div/div/a[contains(text(), 'Read more')]"));
        readMoreButton.click();
        WebElement text = driver.findElement(By.xpath("//div[@class='inner-info-text ']"));
        Assert.assertEquals(text.getText(), "WINTER SEASON CLOSING DATE SCHEDULED FOR MAY 10TH");
    }

    @AfterMethod
    public void afterTest() {
            driver.quit();
        }
}
