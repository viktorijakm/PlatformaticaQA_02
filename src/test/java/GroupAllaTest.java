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
import java.util.concurrent.TimeUnit;


public class GroupAllaTest {

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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

        WebElement GismeteoButton = driver.findElement(By.xpath("//h3[contains(text(),'GISMETEO:')]"));
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

    @Test
    public void testSherstnevaHanna() {
        driver.get("https://www.tut.by/");
        driver.findElement(By.xpath("//a[@class=\'enter\']")).click();
        Boolean result = driver.findElement(By.xpath("//div[@class='b-auth-form__inner']//div[2]/input")).isEnabled();
        Assert.assertFalse(result);
    }

    @Test
    public void testIgorChupin() throws InterruptedException {

        driver.get("https://www.tut.by/");
        WebElement input = driver.findElement(By.className("enter"));
        input.click();

        WebElement username = driver.findElement(By.name("login"));
        username.sendKeys("unexistingmail@mail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("password");

        WebElement buttonEnter = driver.findElement(By.xpath("//input[@value=\'Войти\']"));
        buttonEnter.click();

        Thread.sleep(1000); //без этого ответ не всегда успевает появиться
        Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(),
                "Неверное имя пользователя или пароль");
    }

    @Test
    public void vladimirMiskoTest() {

        driver.get("https://www.google.com/");

        WebElement input = driver.findElement(By.className("gLFyf"));

        input.sendKeys("tut.by\n");

        WebElement result = driver.findElement(
                By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div[1]/a/h3"));

        Assert.assertEquals(result.getText(), "Белорусский портал TUT.BY. Новости Беларуси и мира");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
