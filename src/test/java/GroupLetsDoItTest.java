import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupLetsDoItTest {

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
    public void viktoriiaMarushevskaTargetTest() throws InterruptedException {

        driver.get("https://www.target.com/");

        Thread.sleep(1000);

        driver.findElement(By.id("search")).sendKeys("band aids");
        driver.findElement(By.xpath("//button[text()='go']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™")).click();

        Thread.sleep(3000);

        String searchResultText = driver.findElement(By.xpath("//span[contains(text(), 'Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™')]")).getText();
        Assert.assertEquals(searchResultText, "Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
