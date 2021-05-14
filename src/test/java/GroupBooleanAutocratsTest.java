import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GroupBooleanAutocratsTest {

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
    public void UlianaShutaTest() {

        String expected = "Computer Science";

        driver.get("https://www.uchicago.edu/");

        WebElement search = driver.findElement(By.id("search-trigger"));
        search.click();

        WebElement inputSearch = driver.findElement(By.id("searchtext"));
        inputSearch.sendKeys("Computer Science");

        WebElement searchButton = driver.findElement(By.xpath("//button[text()='Search']"));
        searchButton.click();

        WebElement result = driver.findElement(By.xpath("//div[@class='col12']/h1/strong"));

        Assert.assertEquals(expected, result.getText());
    }

    @Test
    public void testVictoriaRus() {

        final String result = "FILTERS";

        driver.get("https://www.zara.com/us/");

        driver.findElement(By.xpath("//*[@id=\"theme-app\"]/div/div/header/div/div[2]/div/div/a/span[1]/span")).click();

        WebElement searchField = driver.findElement(By.id("search-products-form-combo-input"));
        searchField.click();
        searchField.sendKeys("Black Dress",Keys.ENTER);

        WebElement outcome = driver.findElement(By.xpath("//*[@id=\"main\"]/article/div/div/div[1]/div[2]/div[2]/button/span"));

        Assert.assertEquals(result, outcome.getText());
    }

    @Test
    public void testPonomid() throws InterruptedException {
        String email = "opiijohno@gmail.com";
        driver.get("https://earnon.social");
        //navigate to url
        WebElement signInButton = driver.findElement(By.xpath("/html/body/div[1]/menu/div/div[2]/a[1]"));
        signInButton.click();
        //click Sign In
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Smmtool88");
        //input log/pass: opiijohno@gmail.com/Smmtool88
        WebElement continueButton = driver.findElement(By.xpath("/html/body/div/main/section/div/div/div/form/div[2]/button"));
        continueButton.click();
        Thread.sleep(4000);
        //click 'Continue'
        WebElement closeButton = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button"));
        closeButton.click();
        //close notification
        WebElement profileOnHeaderButton = driver.findElement(By.xpath("//*[@id=\"root\"]/header/div/div/div[1]/div/div/button[3]"));
        profileOnHeaderButton.click();
        //click 'Profile' on header
        WebElement fieldEmailWeb = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/header/div[2]/p"));
        String fieldEmail = fieldEmailWeb.getText();
        Assert.assertEquals(fieldEmail, email);
        //assert email in header
        Thread.sleep(3000);
    }

    @Test
    public void testAlekseiMaslo() throws InterruptedException {

        final String expResultText = "desk";

        driver.get("https://www.ikea.com/us/en/");
        Thread.sleep(1000);

        WebElement inputField = driver.findElement(By.name("q"));
        inputField.sendKeys("desk");
        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.id("search-box__searchbutton"));
        searchButton.click();
        Thread.sleep(5000);

        WebElement surveyText = driver.findElement(By.xpath("//section/fieldset/legend"));

        Assert.assertTrue(surveyText.getText().contains(expResultText));
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
