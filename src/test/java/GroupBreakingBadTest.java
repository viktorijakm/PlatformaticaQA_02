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

    public class GroupBreakingBadTest {

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
        public void vadymKarpychTest() throws InterruptedException {
            driver.get("https://www.wholefoodsmarket.com/");

            WebElement input = driver.findElement(By.xpath("//span[contains(text(),'Find a Store')]"));
            input.click();

            WebElement input2 = driver.findElement(By.id("store-finder-search-bar"));
            input2.sendKeys("Sacramento");
            input2.click();

            WebElement output = driver.findElement(By.xpath("//a[contains(text(),'Sacramento')]"));

            Assert.assertEquals(output.getText(), "Sacramento");

        }

        @AfterMethod
        public void afterTest() {
            driver.quit();
        }
    }



