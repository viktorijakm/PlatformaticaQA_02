import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class IlyaVodnevTest {
    @BeforeClass
    public void beforeClass() {

        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.gismeteo.ru");

        WebElement input = driver.findElement(By.className("search_input"));
        input.sendKeys("Екатеринбург");
        Thread.sleep(1000);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement twoWeeks = driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a"));
        twoWeeks.click();
    }

    @AfterMethod
    public void afterTest() {

        driver.quit();
    }
}
