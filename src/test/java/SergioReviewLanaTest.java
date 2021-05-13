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

public class SergioReviewLanaTest {




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
        public void  review() {
            driver.get("http://shop.demoqa.com/my-account/");
            driver.findElement(By.linkText("Lost your password?")).click();
         driver.navigate().to("http://shop.demoqa.com/my-account");
         driver.navigate().back();
         driver.navigate().forward();
         driver.navigate().refresh();
        }



        @AfterMethod
        public void afterTest() {
            driver.quit();
        }



}
