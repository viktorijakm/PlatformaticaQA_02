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

public class AlekseiMasloTest {

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
    public void testAlekseiMaslo() throws InterruptedException {

        final String expResultText = "desk";

        driver.get("https://www.ikea.com/us/en/");
        Thread.sleep(1000);

        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("desk");
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.id("search-box__searchbutton"));
        searchButton.click();
        Thread.sleep(5000);

        WebElement surveyText = driver.findElement(By.xpath("//section/fieldset/legend"));

        Assert.assertTrue(surveyText.getText().contains(expResultText));
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
