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

public class IrinaBTest {
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
    public void testIrinaB(){
        driver.get("http://www.99-bottles-of-beer.net/");

        WebElement actualResult = driver.findElement(By.xpath("//div[@id='main']/h2"));

        Assert.assertEquals(actualResult.getText(), "Welcome to 99 Bottles of Beer");

    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
