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

    @AfterMethod
    public void afterTest() { driver.quit(); }
}