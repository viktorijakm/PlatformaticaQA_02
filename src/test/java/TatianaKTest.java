import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TatianaKTest {

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
    public void testTanyaKraskova() {
        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//header/nav[@id='navbar']/div[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'About')]")).click();
        WebElement pageTitleWE = driver.findElement(By.xpath("//h1[contains(text(),'About Selenium')]"));
        String pageTitle = pageTitleWE.getText();
        Assert.assertEquals(pageTitle, "About Selenium");
    }

    @AfterMethod
    public void  afterTest () {
        driver.quit();
    }
}
