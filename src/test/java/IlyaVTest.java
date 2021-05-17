import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class IlyaVTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

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
        Thread.sleep(1000);

        WebElement twoWeeks = driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a"));
        twoWeeks.click();
        Thread.sleep(1000);

        WebElement heading = driver.findElement(By.xpath("/html/body/section/div[2]/div/div[1]/div/div[1]/div/h1"));
        Assert.assertEquals(heading.getText(), "Погода в Екатеринбурге на две недели");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
