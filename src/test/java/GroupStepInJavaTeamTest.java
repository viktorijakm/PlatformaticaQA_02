import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class GroupStepInJavaTeamTest {

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
    public void kirillRazzhigaev() throws InterruptedException {

        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//nav/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("search-by")).sendKeys("element");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@data-title=\"Web element\"]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Web element");
        Thread.sleep(5000);
    }

    @Test
    public void aleksAn() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[contains(@class, 'product_list')]/li"));
        Assert.assertEquals(elementList.size(),7);
    }

    @Test
    public void testHaidukLibrary() {
        driver.get("https://www.merriam-webster.com/");
        driver.findElement(By.id("s-term")).sendKeys("anything");
        driver.findElement(By.className("search-icon")).click();
        driver.findElement(By.className("learn-more-header"));
        Assert.assertEquals(driver.findElement(By.className("learn-more-header")).getText(),
                "Learn More about anything");
    }

    @AfterMethod
    public void  afterTest () {
        driver.quit();
    }
}
