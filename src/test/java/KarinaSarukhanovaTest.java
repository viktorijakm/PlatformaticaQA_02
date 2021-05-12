import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class KarinaSarukhanovaTest {

        @BeforeClass
        public void before() {
            WebDriverManager.chromedriver().setup();
        }

        private WebDriver driver;

        @BeforeMethod
        public void beforeTest() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void test() {

            driver.get("https://www.gamestop.com/");

            WebElement input = driver.findElement(By.name("q"));
            input.sendKeys("motherboard\n");

            List<WebElement> result = driver.findElements(By.cssSelector("div.less-tile-info .link-name"));
            for (int i = 0; i < result.size(); i++) {
                String text = result.get(i).getText();
                Assert.assertTrue(text.contains("Motherboard"));
            }
        }

        @AfterMethod
        public void afterTest() {
            driver.quit();
        }
    }

