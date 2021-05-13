import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GroupBugBustersTest {

    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void testMK() throws InterruptedException {
        driver.get("https://www.dillards.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("topcat_Kids")).click();
        WebElement result = driver.findElement(By.linkText("Girls"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void testLudaPetkel() {
        driver.get("https://www.flooringliquidators.ca/");
        driver.findElement(By.linkText("About")).click();
        WebElement result = driver.findElement(By.xpath("//strong[.='About Us']"));
        Assert.assertTrue(result.isDisplayed());
        WebElement phone = driver.findElement(By.className("show-phones"));
        Assert.assertEquals(phone.getText(), "1 (866) 473-7222");
    }

    @Test
    public void testAndreyTeterin() throws InterruptedException {
        driver.get("https://www.btcsatoshi.com/");
        Thread.sleep(3000);
        WebElement price = driver.findElement(By.xpath("//label[@id='oneBitcoin']"));
        Assert.assertEquals(price.getText(), driver.getTitle().substring(1, 9));
        Thread.sleep(3000);
    }

    @Test
    public void testMikhailMir() throws InterruptedException {
        driver.get("https://www.wasserstrom.com/");
        String parentHandle = driver.getWindowHandle();
        driver.findElement(By.id("Header_GlobalLogin_signInQuickLink")).click();

        for (String childHandle : driver.getWindowHandles()) {
            if (!childHandle.equals(parentHandle)) {
                driver.switchTo().window(childHandle);
                break;
            }
        }

        Thread.sleep(1000);
        driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1")).sendKeys("userWasserStrom");
        driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1")).sendKeys("WasserStrom4321!");
        driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_rememberMe_In_Logon_1_img")).click();
        driver.findElement(By.id("Header_GlobalLogin_WC_AccountDisplay_links_2")).click();
        Thread.sleep(5000);

        WebElement iconUser = driver.findElement(By.id("Header_GlobalLogin_signOutQuickLink"));
        Assert.assertTrue(iconUser.isDisplayed());
    }

    @Test
    public void testStanislavKaplanYandexlogoPresence() {
        driver.get("http://yandex.com");
        driver.manage().window().maximize();
        boolean result;
        result = driver.findElements(By.xpath("//div[@class = 'logo__image_bg']")).size() > 0;
        Assert.assertTrue(result, "Logo is here");
    }


    @Test
    public void testRomanB() throws InterruptedException {

        driver.get("https://www.homedepot.com/");

        WebElement input = driver.findElement(By.id("headerSearch"));
        input.sendKeys("aluminum angle\n");
        Thread.sleep(3000);

        WebElement finder = driver.findElement(By.xpath("//span[@class ='product-pod__title__product']"));

        Assert.assertTrue(finder.getText().toLowerCase().contains("aluminum angle"));
        Thread.sleep(1000);

        }
    
  @Test
    public void testEdwardNasdaq(){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.nasdaq.com/");

        driver.findElement(By.className("primary-nav__anchor-text")).click();
        driver.findElement(By.id("find-symbol-input-dark")).sendKeys("AAPL");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.findElement(By.className("find-symbol__suggestion")).click();

        WebElement AppleStock = driver.findElement(By.className("symbol-page-header__name"));
        Assert.assertEquals(AppleStock.getText(), "Apple Inc. Common Stock (AAPL)");

    }

    @Test
    public void testTimYoshi() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.lamborghini.com/en-en");
        driver.findElement(By.linkText("MODELS")).click();
        WebElement lambo = driver.findElement(By.xpath("/html/body/div/div[1]/div/section[2]/div[2]/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div[3]/a/span"));
        Assert.assertEquals(lambo.getText(),"AVENTADOR SVJ");

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
