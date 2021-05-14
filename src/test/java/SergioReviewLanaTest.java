import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SergioReviewLanaTest {

    private WebDriver driver;

    public static void newClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }

    @BeforeClass
    public void before() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {

        driver = new ChromeDriver();
    }

    @Test
    public void review() {
        driver.get("http://shop.demoqa.com/my-account/");
        driver.findElement(By.linkText("Lost your password?")).click();
        driver.navigate().to("http://shop.demoqa.com/my-account");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void newTest2() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("John");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Smith");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Brown");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).clear();

        List<WebElement> genders = driver.findElements(By.xpath("//input[@type = 'radio']"));
        genders.size();
        for (int i = 0; i < genders.size(); i++) {
            String value = genders.get(i).getAttribute("value");
            Thread.sleep(2000);
            if (value.equalsIgnoreCase("male")) {
                newClick(driver, genders.get(i));
                break;
            }
        }
    }

    @AfterMethod
    public void afterTest() {

        driver.quit();
    }
}