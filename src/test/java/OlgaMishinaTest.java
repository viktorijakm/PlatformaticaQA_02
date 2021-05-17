import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OlgaMishinaTest {
    @BeforeClass
    public void before() { WebDriverManager.chromedriver().setup(); }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() { driver = new ChromeDriver(); }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.zippershipper.com/");

        WebElement input = driver.findElement(By.xpath("//input[@id='txtRedirectSearchBox']"));
        input.sendKeys("Dress Zippers\n");

        WebElement linkZippersByUse = driver.findElement(By.cssSelector("[id='dlCategories_ctl01_hlCategory']"));

        Assert.assertTrue(linkZippersByUse.isDisplayed());
        linkZippersByUse.click();

        WebElement image = driver.findElement(By.xpath("(//img[@class ='CategoryProductThumbnail']) [1]"));

        Assert.assertTrue(image.isDisplayed());
    }

    @AfterMethod
     public void afterMethod(){ driver.quit();}

}

