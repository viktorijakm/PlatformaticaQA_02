import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupSquirrelsTest {

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
    public void nYerlan() {

        driver.get("https://www.zoni.edu/");
        driver.findElement(By.xpath("//*[@id=\"menu-item-11815\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"panel-10867-1-1-0\"]/div/div/a/img")).click();
        WebElement txtStandardProgram = driver.findElement(By.xpath("//*[@id=\"panel-19455-0-0-0\"]/div/h3"));
        Assert.assertEquals(txtStandardProgram.getText(),"Standard English Program");
    }

    @Test
    public void testOlgaVergasova() {
        driver.get("https://apnews.com/hub/sports");
        WebElement list = driver.findElement(By.xpath("//*[@data-key=\"hub-title\"]"));
        String result = list.getText();
        Assert.assertEquals(result, "SPORTS");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
