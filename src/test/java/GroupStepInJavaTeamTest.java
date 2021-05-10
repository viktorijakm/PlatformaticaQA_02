import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroupStepInJavaTeamTest {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void testKirillRazzhigaev() {

        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//nav/a[3]")).click();
        driver.findElement(By.id("search-by")).sendKeys("element");
        driver.findElement(By.xpath("//div[@data-title=\"Web element\"]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Web element");
    }

    @Test
    public void testVitalyZverev() {

        String value = "Selenium";

        driver.get("https://ya.ru/");

        WebElement input = driver.findElement(By.xpath("//span[@class='input__box']/input"));
        input.sendKeys(value + "\n");

        WebElement result = driver.findElement(By.xpath("//div[contains(@class, 'serp-title_font')]"));

        Assert.assertEquals(result.getText(), value);
    }

    @Test
    public void testAleksAn() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[contains(@class, 'product_list')]/li"));
        Assert.assertEquals(elementList.size(),7);
    }

    @AfterMethod
    public void  afterTest () {
        driver.quit();
    }
}
