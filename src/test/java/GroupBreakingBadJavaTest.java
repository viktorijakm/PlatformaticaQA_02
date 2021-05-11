import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GroupBreakingBadJavaTest {

    @BeforeClass
    public void before(){
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;
    @BeforeMethod
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void dudeAlexSoccerTest() {
        driver.get("https://services.smartbear.com/samples/TestComplete14/smartstore/");
        driver.findElement(By.xpath("//*[@title='Soccer']")).click();

        WebElement elem = driver.findElement(By.id("content-center"))
                                .findElement(By.tagName("h1"));
        Assert.assertEquals(elem.getText(), "Soccer");
    }

    @Test
    public void dariaRazzhigaevaTest() throws InterruptedException {
        driver.get("https://www.airbnb.com/");

        WebElement input = driver.findElement(By.id("bigsearch-query-detached-query"));
        input.sendKeys("Tokyo");
        driver.findElement(By.className("_m9v25n")).click();

        Thread.sleep(5000);

        WebElement result = driver.findElement(By.className("_14i3z6h"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void vitaliiArtemenkoFoodTest() {
        driver.get("https://lightlife.com/");
        driver.findElement(By.xpath("//a[text()='Our Food'][1]")).click();
        WebElement food = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(food.getText(), "Our Food");
    }

    @Test
    public void evgeniyTMainGitCommandTest() {
        driver.get("https://use-web.ru/news.php?id=138&tid=3");
        WebElement result = driver.findElement(By.xpath("//h2[text()= 'Основные Git команды. ']"));

        Assert.assertEquals(result.getText(), "Основные Git команды.");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    public static void flash(WebElement element, WebDriver driver) {
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 5; i++) {
            changColor("#000000", element, driver);
            changColor(bgcolor, element, driver);
        }
    }

    public static void changColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor= '" + color + "' ", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            System.out.println("Something went wrong.");
        }
    }
}
