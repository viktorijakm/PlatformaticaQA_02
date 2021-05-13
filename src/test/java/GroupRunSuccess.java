import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupRunSuccess {

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
    public void testDimaStepanenko() throws InterruptedException {
        driver.get("http://demowebshop.tricentis.com/");

        WebElement buttonBooks = driver.findElement(By.xpath("//div[@class=\"listbox\"]/ul/li/a[@href=\"/books\"]"));
        buttonBooks.click();
        WebElement clickScienceBook = driver.findElement(By.xpath("//h2/a[@href=\"/fiction\"]"));
        clickScienceBook.click();
        WebElement qtyField = driver.findElement(By.id("addtocart_45_EnteredQuantity"));
        qtyField.clear();
        qtyField.sendKeys("2");
        WebElement pushAddToCartButton = driver.findElement(By.id("add-to-cart-button-45"));
        pushAddToCartButton.click();
        WebElement clickShoppingCartLink = driver.findElement(
                By.xpath("//li/a[@href=\"/cart\"]/span[@class=\"cart-label\"]"));
        clickShoppingCartLink.click();
        Thread.sleep(2000);
        WebElement total = driver.findElement(
                By.xpath("//td[@class=\"subtotal nobr end\"]/span[@class=\"product-subtotal\"]"));
        //Assert.assertEquals(total.getText().toString(), "48.00");
        Assert.assertEquals(total.getText(), String.format("%.2f", 48.0));
    }

    @Test
    public void testDimaStepanenkoSergeoReview () throws InterruptedException {

        driver.get("http://shop.demoqa.com/my-account/");
        driver.findElement(By.linkText("Lost your password?")).click();
        Thread.sleep(2000);
        driver.navigate().to("http://shop.demoqa.com/my-account/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

    }
    public static void newJSClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Test
    public void testDimaStepanenkoPracticeForm() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(1000);
        WebElement textFirstNameField = driver.findElement(By.id("firstName"));
        textFirstNameField.sendKeys("Dmytro");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Stepanenko");
        Thread.sleep(1000);
        textFirstNameField.clear();
        Thread.sleep(1000);
        textFirstNameField.sendKeys("Igor");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@title=''][@for=\"gender-radio-1\"][@class=\"custom-control-label\"]"))
                .click();
        Thread.sleep(1000);

        //Example how to use Collection in tests
        List<WebElement> gender = driver.findElements(By.xpath("//input[@type='radio']"));
        for(int i = 0; i < gender.size(); i++) {
            String value = gender.get(i).getAttribute("value");
            Thread.sleep(1000);
            if (value.equalsIgnoreCase("male")){
                newJSClick(driver, gender.get(i));
                break;
            }
        }
        Thread.sleep(1000);





    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
