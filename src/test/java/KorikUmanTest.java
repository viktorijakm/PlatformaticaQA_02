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
    public void before() {WebDriverManager.chromedriver().setup();}

    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() { driver = new ChromeDriver();}

    @Test
    public void vKorenevskyyTest() throws InterruptedException {
        //navigate to website and click on hyperlink
        driver.get("https://ultimateqa.com/");

        WebElement input = driver.findElement(By.xpath("//*[@href='https://ultimateqa.com/selenium-webdriver-java-course/']"));
        input.click();

        //assert expected element is displayed

        Boolean result = driver.findElement(By.className("et_pb_video_overlay_hover")).isDisplayed();
    }

    @Test
    public void newTest() throws InterruptedException {
        //navigate to website
        driver.get("https://ultimateqa.com/");
        //locate search field
        WebElement search = driver.findElement(By.xpath("//*[@name='s'][@class='et_pb_s']"));
        //send search text
        search.sendKeys("Selenium Java\n");
        //locate target element
        WebElement result = driver.findElement(By.className("jetpack-instant-search__search-results-title"));
        //declare veriables
        String expected = "Found 10 results";
        String actual = result.getText();
        //validate test
        Assert.assertEquals(actual, expected);



    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}

