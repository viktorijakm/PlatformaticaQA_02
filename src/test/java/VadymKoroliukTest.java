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

public class VadymKoroliukTest {

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
    public void testVadymKoroliuk() throws InterruptedException {
        driver.get("https://www.newegg.com/");

        WebElement input = driver.findElement(By.xpath("//*[@id=\"app\"]/header/div[1]/div[3]/div[1]/form/div/div[1]/input"));
        input.sendKeys("ssd");
        WebElement button = driver.findElement(By.cssSelector("#app > header > div.header2020-inner > div.header2020-search >" +
                " div.header2020-search-bar > form > div > div.header2020-search-button > button"));
        button.click();
        WebElement title = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div/h1"));

        Assert.assertEquals("\"SSD\"", title.getText());

        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
