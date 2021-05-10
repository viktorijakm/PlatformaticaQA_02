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
    public void test() throws InterruptedException {
        //navigate to website and click on hyperlink
        driver.get("https://ultimateqa.com/");

        WebElement input = driver.findElement(By.xpath("//*[@href='https://ultimateqa.com/selenium-webdriver-java-course/']"));
        input.click();

        //assert expected element is displayed

        Boolean result = driver.findElement(By.className("et_pb_video_overlay_hover")).isDisplayed();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}

