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

    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

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
    public void testMarianaLuchynets () throws InterruptedException {
        driver.get("https://www.cvs.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Check testing options')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//strong[contains(text(),'Get COVID-19 vaccine updates from the CDC')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Possible side effects')]")).click();
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//div[contains(text(),'To reduce pain and discomfort where you got the shot')]"));
        Assert.assertEquals(result.getText(), "To reduce pain and discomfort where you got the shot");
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
        Assert.assertEquals(elementList.size(), 7);
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

    @Test
    public void testLarisaMalushkina() throws InterruptedException {

        driver.get("https://marshalls.com/");
        WebElement modalClose = driver.findElement(By.xpath("//*[@id='modal-close']"));
        modalClose.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='search-text-input']"));
        inputField.sendKeys("dress");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='search-submit-button']"));
        searchButton.click();
        WebElement result = driver.findElement(By.xpath("//h1[contains(text(),'Dresses')]"));
        Assert.assertEquals(result.getText(), "Dresses");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
