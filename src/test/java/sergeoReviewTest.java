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

public class sergeoReviewTest {

    @BeforeClass
    public void before(){
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        driver = new ChromeDriver();
    }

    @Test
    public void reviewTest () throws InterruptedException {
        driver.get("http://shop.demoqa.com/my-account/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Lost your password?")).click();
        Thread.sleep(2000);
        driver.navigate().to("http://shop.demoqa.com/my-account/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
