import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupBugBustersTest {

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
    public void testTimYoshi() throws InterruptedException {
        driver.get("https://www.lamborghini.com/en-en");
        driver.findElement(By.linkText("MODELS")).click();
        WebElement lambo = driver.findElement(By.xpath("/html/body/div/div[1]/div/section[2]/div[2]/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/a/span"));
        Assert.assertEquals(lambo.getText(),"AVENTADOR SVJ");
    }


    @Test
    public void testRomanB() throws InterruptedException {

        driver.get("https://www.homedepot.com/");

        WebElement input = driver.findElement(By.id("headerSearch"));
        input.sendKeys("aluminum angle\n");
        Thread.sleep(3000);

        WebElement finder = driver.findElement(By.xpath("//span[@class ='product-pod__title__product']"));

        Assert.assertTrue(finder.getText().toLowerCase().contains("aluminum angle"));
        Thread.sleep(1000);
    }


    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
