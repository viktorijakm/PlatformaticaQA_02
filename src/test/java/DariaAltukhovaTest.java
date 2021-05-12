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

public class DariaAltukhovaTest {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    final String demoUrl = "https://www.edcast.com/corp/request-a-demo/";

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testDariaAltukhovaOpenDemoFromPage() throws InterruptedException {
        driver.get("https://www.edcast.com/");

        WebElement productButton = driver.findElement(By.id("menu-item-442"));
        productButton.click();

        WebElement dropdownEdCastXP = driver.findElement(By.id("menu-item-46"));
        dropdownEdCastXP.click();
        Thread.sleep(3000);

        WebElement requestDemoButton = driver.findElement(By.className("fl-button-text"));
        requestDemoButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), demoUrl);
    }

    @Test
    public void testDariaAltukhovaOpenDemoFromMenu() throws InterruptedException {
        driver.get("https://www.edcast.com/");
        WebElement demoHeaderButton = driver.findElement(By.id("menu-item-6658"));
        demoHeaderButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), demoUrl);
        driver.quit();
    }

    @Test
    public void testDariaAltukhovaDemoVideoButton() throws InterruptedException {
        driver.navigate().to("https://www.edcast.com/");
        WebElement watchEdcastDemoVideoButton = driver.findElement(By.className("fl-button"));
        watchEdcastDemoVideoButton.click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://go.edcast.com/l/139221/2021-03-31/2m9x9x");

        driver.quit();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}

