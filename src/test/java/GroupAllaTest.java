import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GroupAllaTest {

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
    public void poptsovRomanTest() throws InterruptedException {

        driver.get("https://10mail.org/");
        Thread.sleep(3000); //awaiting the issuance of the address

        WebElement mailArea = driver.findElement(By.className("address"));
        String currentString = mailArea.getText();
        System.out.println("Received mail: " + currentString);

        boolean checkMail = !currentString.equals("");

        Assert.assertTrue(checkMail, "email not received");

    }

      @Test
    public void testGunchenkoAlex() {
        driver.get("https://www.google.com/");
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys("gismeteo\n");
        WebElement result1 = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        Assert.assertEquals(result1.getText(), "GISMETEO: Погода в Украине, прогноз погоды на сегодня ...");
        WebElement GismeteoButton = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));
        GismeteoButton.click();
        WebElement searchField = driver.findElement(By.id("js-search"));
        searchField.sendKeys("Харьков\n");
        driver.findElement(By.linkText("Харьков")).click();
        driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/section/nav/div/ul/li[7]/a")).click();
        WebElement pageTitile = driver.findElement(By.tagName("h1"));
        String pageTitleName = pageTitile.getText();
        Assert.assertEquals(pageTitleName, "Погода в аэропорту Харьков на месяц");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}


