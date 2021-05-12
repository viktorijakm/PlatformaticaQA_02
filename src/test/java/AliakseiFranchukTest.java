import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AliakseiFranchukTest {

    private WebDriver driver;

    @BeforeClass
    public void setUpDriverManager(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void webTest() {

        driver.get("https://www.tut.by/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,9000)");

        WebElement approve = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div[2]/ul/li[1]/a"));

        Assert.assertEquals(approve.getText(), "ТУТ БАЙ МЕДИА");

    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }

}
