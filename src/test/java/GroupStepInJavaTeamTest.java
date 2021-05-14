import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GroupStepInJavaTeamTest {

    private WebDriver driver;

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void testKirillRazzhigaev() {

        driver.get("https://www.selenium.dev/");
        driver.findElement(By.xpath("//nav/a[3]")).click();
        driver.findElement(By.id("search-by")).sendKeys("element");
        driver.findElement(By.xpath("//div[@data-title=\"Web element\"]")).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Web element");
    }

    @Test
    public void testMarianaLuchynets () throws InterruptedException {
        driver.get("https://www.cvs.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Check testing options')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//strong[contains(text(),'Get COVID-19 vaccine updates from the CDC')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Possible side effects')]")).click();
        Thread.sleep(2000);
        WebElement result = driver.findElement(By.xpath("//div[contains(text(),'To reduce pain and discomfort where you got the shot')]"));
        Assert.assertEquals(result.getText(), "To reduce pain and discomfort where you got the shot");
    }

    @Test
    public void testVitalyZverev() {

        String value = "Selenium";

        driver.get("https://ya.ru/");

        WebElement input = driver.findElement(By.xpath("//span[@class='input__box']/input"));
        input.sendKeys(value + "\n");

        WebElement result = driver.findElement(By.xpath("//div[contains(@class, 'serp-title_font')]"));

        Assert.assertEquals(result.getText(), value);
    }

    @Test
    public void testAleksAn() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//ul[contains(@class, 'product_list')]/li"));
        Assert.assertEquals(elementList.size(), 7);
    }

    @Test
    public void testVladVysotski() throws InterruptedException {

        driver.get("https://www.paypal.com/");
        driver.manage().window().maximize();
        Thread.sleep(500);

        WebElement button = driver.findElement(By.xpath("//*[@id='signup-button']"));
        button.click();
        Thread.sleep(500);

        String text = driver.findElement(By.xpath("//*[@id=\"main\"]/section/div/div/h1")).getText();
        Assert.assertEquals(text,"PayPal is a secure, easy way to pay and get paid - sign up for free");
    }

    @Test
    public void testHaidukLibrary() {
        driver.get("https://www.merriam-webster.com/");
        driver.findElement(By.id("s-term")).sendKeys("anything");
        driver.findElement(By.className("search-icon")).click();
        driver.findElement(By.className("learn-more-header"));
        Assert.assertEquals(driver.findElement(By.className("learn-more-header")).getText(),
                "Learn More about anything");
    }

    @Test
    public void testLarisaMalushkina() throws InterruptedException {

        driver.get("https://marshalls.com/");
        WebElement modalClose = driver.findElement(By.xpath("//*[@id='modal-close']"));
        modalClose.click();
        WebElement inputField = driver.findElement(By.xpath("//input[@id='search-text-input']"));
        inputField.sendKeys("dress");
        WebElement searchButton = driver.findElement(By.xpath("//input[@id='search-submit-button']"));
        searchButton.click();
        WebElement result = driver.findElement(By.xpath("//h1[contains(text(),'Dresses')]"));
        Assert.assertEquals(result.getText(), "Dresses");
        Thread.sleep(2000);
    }

    @Test
    public void testVitaliiDmitrenko() {

        driver.get("https://www.gismeteo.ua/weather-kharkiv-5053/");
        WebElement tenDaysButton = driver.findElement(By.xpath("//a[@href='/weather-kharkiv-5053/10-days/']"));
        tenDaysButton.click();

        WebElement tenDaysTitle = driver.findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(tenDaysTitle.getText(),"Погода в Харькове на 10 дней");

        WebElement monthButton = driver.findElement(By.xpath("//a[@href='/weather-kharkiv-5053/month/']"));
        monthButton.click();

        WebElement monthTitle = driver.findElement(By.xpath("//div[@class='pageinfo_title index-h1']//h1"));
        Assert.assertEquals(monthTitle.getText(),"Погода в Харькове на месяц");
    }

    @Test
    public void testNataliaBoiko() throws InterruptedException {
        driver.get("https://akniga.org/");
        List<WebElement> listOfAllLinks = driver.findElements(By.xpath("/html/body/main/div[3]/div[1]/div/a"));
        Random random = new Random();
        int NumberOfrandomCategory = random.nextInt(listOfAllLinks.size());
        String NameOfCategory = listOfAllLinks.get(NumberOfrandomCategory).getText().toLowerCase();
        listOfAllLinks.get(NumberOfrandomCategory).click();
        if (driver.getCurrentUrl().contains("google")) {
            driver.get(listOfAllLinks.get(NumberOfrandomCategory).getAttribute("href"));
            Thread.sleep(500);
        }
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().toLowerCase().contains(NameOfCategory));
        driver.findElement(By.xpath("/html/body/main/div[1]/div[4]/div[1]/div/a[2]")).click();
        Thread.sleep(1000);
        List<WebElement> listOfResult = driver.findElements(By.className("content__main__articles--item"));
        int Counter = 0;
        for (WebElement el : listOfResult) {
            int CurrentScore = 0;
            try {
                CurrentScore = Integer.parseInt(el.findElement(By.className("ls-vote-item-up")).getText());
            } catch (Exception e) {
            }
            try {
                CurrentScore -= Integer.parseInt(el.findElement(By.className("ls-vote-item-down")).getText());
            } catch (Exception e) {
            }
            if (Counter == 0) Counter = CurrentScore;
            try {
                Assert.assertTrue(Counter >= CurrentScore);
            } catch (AssertionError e) {
                System.out.println("Error: " + el.findElement(By.className("caption__article-main")).getText());
            }
            Counter = CurrentScore;
        }
        driver.findElement(By.xpath("/html/body/main/div[1]/div[4]/div[1]/div/a[3]")).click();
        Thread.sleep(1000);
        listOfResult = driver.findElements(By.className("content__main__articles--item"));
        Counter = 0;
        for (WebElement el : listOfResult) {
            String textComments = el.findElement(By.className("link__action--comment")).getText();
            int CurrentScore = 0;
            try {
                CurrentScore = Integer.parseInt(textComments.substring(0, textComments.indexOf(" ")));
            } catch (Exception e) {
            }
            if (Counter == 0) Counter = CurrentScore;
            try {
                Assert.assertTrue(Counter >= CurrentScore);
            } catch (AssertionError e) {
                System.out.println("Error: " + el.findElement(By.className("caption__article-main")).getText());
            }
            Counter = CurrentScore;
        }
     }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
