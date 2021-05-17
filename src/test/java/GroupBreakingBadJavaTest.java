import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GroupBreakingBadJavaTest {

    private WebDriver driver;

    public static void newScroll(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
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

    @BeforeClass
    public void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDudeAlexSoccer() {
        driver.get("https://services.smartbear.com/samples/TestComplete14/smartstore/");
        WebElement elemSoccer = driver.findElement(By.xpath("//*[@title='Soccer']"));
        flash(elemSoccer, driver);
        driver.findElement(By.xpath("//*[@title='Soccer']")).click();

        WebElement elem = driver.findElement(By.id("content-center"))
                                .findElement(By.tagName("h1"));
        flash(elem, driver);
        Assert.assertEquals(elem.getText(), "Soccer");
    }

    @Test
    public void testDudeAlexSoccerFlash() {
        driver.get("https://services.smartbear.com/samples/TestComplete14/smartstore/");
        WebElement elemSoccer = driver.findElement(By.xpath("//*[@title='Soccer']"));
        flash(elemSoccer, driver);
        elemSoccer.click();

        WebElement elem = driver.findElement(By.id("content-center"))
                                .findElement(By.tagName("h1"));
        flash(elem, driver);
        Assert.assertEquals(elem.getText(), "Soccer");
    }

    @Test
    public void testDariaRazzhigaeva() throws InterruptedException {
        driver.get("https://arc.losrios.edu/");
        driver.findElement(By.linkText("About Us")).click();

        Thread.sleep(1000);

        WebElement element = driver.findElement(By.linkText("Contact Us"));
        newScroll(driver, element);

        WebElement address = driver.findElement(By.className("address_link"));
        Assert.assertTrue(address.getText().contains("4700 College Oak Drive"));
    }

    @Test
    public void testVitaliiArtemenkoFood() {
        driver.get("https://lightlife.com/");
        driver.findElement(By.xpath("//a[text()='Our Food'][1]")).click();
        WebElement food = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(food.getText(), "Our Food");
    }

    @Test
    public void testEvgeniyTMainGitCommand() {
        driver.get("https://use-web.ru/news.php?id=138&tid=3");
        WebElement result = driver.findElement(By.xpath("//h2[text()= 'Основные Git команды. ']"));

        Assert.assertEquals(result.getText(), "Основные Git команды.");
    }

    @Test
    public void testLenaDik(){

        driver.get("https://lafitness.com/Pages/Default.aspx#");

        WebElement element = driver.findElement(By.id("ctl00_GlobalHeader_txtZip"));
        element.sendKeys("20878\n");
        WebElement clubName = driver.findElement(By.id("ctl00_MainContent_repClubInfo_ctl01_lblClubDisplayName"));

        Assert.assertEquals(clubName.getText(), "Gaithersburg - Copley Place");
    }

    @Test
    public void testAntonBrutTrip() throws InterruptedException {
        driver.get("https://www.nationalgeographic.com/");

        driver.findElement(By.xpath("//button[@aria-label='Menu']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Book A Trip')]")).click();

        driver.findElement(By.xpath("//div/span[contains(text(), 'Destination')]")).click();
        WebElement northAmerica = driver.findElement(By.id("react-select-2--option-9"));
        northAmerica.click();

        driver.findElement(By.xpath("//div/span[contains(text(), 'Trip Type')]")).click();
        Thread.sleep(750);
        WebElement train = driver.findElement(By.id("react-select-3--option-6"));
        train.click();

        driver.findElement(By.xpath("//div/span[contains(text(), 'Departure Month')]")).click();
        Thread.sleep(750);
        WebElement august2021 = driver.findElement(By.id("react-select-4--option-1"));
        august2021.click();

        driver.findElement(By.xpath("//span[contains(text(), 'Search Trips')]")).click();

        WebElement tripTitle = driver.findElement(By.className("ngs-exp-search--facet-header"));
        Thread.sleep(300);
        Assert.assertEquals(tripTitle.getText(), "Find a Trip");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
