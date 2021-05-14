import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;

public class GroupJPowerTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void testOlgaKogut() {

        driver.get("https://www.klubok.com/");
        WebElement input = driver.findElement(By.className("sub-input-search"));
        input.sendKeys("fisher price\n");
        List<WebElement> listOfElement = driver.findElements(
                By.xpath("//ul[contains(@class, 'item-list')]/li"));
        Assert.assertEquals(listOfElement.size(), 56);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
