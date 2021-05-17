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

public class OlgaKTest {

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
    public void testOlgaKovtun() throws InterruptedException {

        driver.get("https://www.codewars.com/");

        WebElement logInButton = driver.findElement(
                By.xpath("//section[@id='header_section']/ul/li/a[contains(text(),'Log In')]"));
        logInButton.click();

        WebElement emailField = driver.findElement(By.id("user_email"));
        emailField.sendKeys("tester1");

        WebElement passwordField = driver.findElement(By.id("user_password"));
        passwordField.sendKeys("12345");

        WebElement signInButton = driver.findElement(
                By.xpath("//form[@id='new_user']/button[contains(text(), 'Sign in')]"));
        signInButton.click();

        Thread.sleep(2000);
        String errorText = driver.findElement(
                By.cssSelector("div.alert-box.error.flash-msg.error")).getText();

        Assert.assertEquals(errorText, "Invalid Email or password.");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
