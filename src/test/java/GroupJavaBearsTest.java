import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupJavaBearsTest {

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
    public void mariaMorozovaTest() {
        driver.get("https://www.duckduckgo.com");

        WebElement input = driver.findElement(By.className("search__input--adv"));
        input.sendKeys("panda\n");

        WebElement res = driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]"));
        Assert.assertEquals(res.getText(), "Panda Express | A Fast Casual Chinese Restaurant | Panda ...");
    }

    @Test
    public void sergeyKuznetsovTest() {
        driver.get("https://elibrary.unatlib.ru/");
        WebElement input = driver.findElement(By.className("prompt"));
        input.sendKeys("Пушкин\n");
        WebElement result = driver.findElement(By.className("search-stats"));
        Assert.assertNotEquals(result.getText(), "No Results!");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
