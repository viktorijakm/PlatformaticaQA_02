import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GroupBooleanAutocratsTest {

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
    public void UlianaShutaTest() {

        String expected = "Computer Science";

        driver.get("https://www.uchicago.edu/");

        WebElement search = driver.findElement(By.id("search-trigger"));
        search.click();

        WebElement inputSearch = driver.findElement(By.id("searchtext"));
        inputSearch.sendKeys("Computer Science");

        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();

        WebElement result = driver.findElement(By.xpath("//div[@class='col12']/h1/strong"));

        Assert.assertEquals(expected, result.getText());
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
