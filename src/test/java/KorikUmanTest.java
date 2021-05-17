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

public class KorikUmanTest {
    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void testOneVkorenevskyy() throws InterruptedException {

        WebElement input = driver.findElement(By.xpath("//*[@href='https://ultimateqa.com/selenium-webdriver-java-course/']"));
        input.click();

        boolean result = driver.findElement(By.className("et_pb_video_overlay_hover")).isDisplayed();
        Assert.assertTrue(result);
    }

    @Test
    public void testTwoVkorenevskyy() throws InterruptedException {

        WebElement searchField = driver.findElement(By.xpath("//*[@name='s'][@class='et_pb_s']"));

        searchField.sendKeys("Selenium Java\n");

        WebElement result = driver.findElement(By.className("jetpack-instant-search__search-results-title"));

        String expected = "Found 10 results";
        String actual = result.getText();

        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}

