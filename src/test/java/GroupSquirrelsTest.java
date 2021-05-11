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

    @Test
    public void SKhatskevitch() throws InterruptedException {
        driver.get("https://en.wikipedia.org/wiki/Website");
        WebElement result = driver.findElement(
                By.xpath("//*[@class='firstHeading']"));
        Assert.assertEquals(result.getText(), "Website");
    }

    @Test
    public void testRichardGobal() throws InterruptedException {
        driver.get("https://www.iherb.com/");
        driver.findElement(By.className("iherb-header-search-input")).sendKeys("blueberry juice\n");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pid_7091\"]/div[2]/div[1]/a")).click();
        Thread.sleep(1000);
        WebElement isItInStock = driver.findElement(By.xpath("//*[@id='stock-status']/strong"));
        Thread.sleep(1000);
        Assert.assertEquals(isItInStock.getText(), "In Stock");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
