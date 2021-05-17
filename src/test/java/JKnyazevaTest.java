import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class JKnyazevaTest {
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
    public  void test() throws InterruptedException {

            driver.get("https://www.google.com/");

            WebElement input = driver.findElement(By.className("gLFyf"));
            input.sendKeys("123\n");
            Thread.sleep(2000);

            WebElement result = driver.findElement(By.className("DKV0Md"));
            Assert.assertEquals(result.getText(), "УМОРИТЕЛЬНЫЕ ЛАЙФХАКИ ДЛЯ ЛЕНИВЫХ || Крутые ...");
            Thread.sleep(1000);

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }


}
