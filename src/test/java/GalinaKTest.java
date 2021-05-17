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

public class GalinaKTest {
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
    public void testGalinaK() {

        driver.get("https://www.cabq.gov/parksandrecreation/recreation/swimming/indoor-pools");

        driver.findElement(
                By.xpath("//div[@id='parent-fieldname-text']/div/div/p/a[@data-val='e8f7542fb4e0de27b3ea4a0e73a708a5']")
        ).click();

        WebElement address = driver.findElement(
                By.xpath("//div[@id='parent-fieldname-text']/div/div/div/p[contains(text(),'6705 Fortuna NW ')]"));

        Assert.assertEquals(address.getText(), "Location\n" +
                "6705 Fortuna NW\n" +
                "Albuquerque, NM 87121\n" +
                "View map.");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
