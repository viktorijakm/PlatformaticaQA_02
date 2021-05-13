import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GroupJavaBearsTest {

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
    public void testMariaMorozova() {
        driver.get("https://www.duckduckgo.com");

        WebElement input = driver.findElement(By.className("search__input--adv"));
        input.sendKeys("panda\n");

        WebElement res = driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div/h2/a[1]"));
        Assert.assertEquals(res.getText(), "Panda Express | A Fast Casual Chinese Restaurant | Panda ...");
    }

    @Test
    public void testSergeyKuznetsov() {
        driver.get("https://elibrary.unatlib.ru/");
        WebElement input = driver.findElement(By.className("prompt"));
        input.sendKeys("Пушкин\n");
        WebElement result = driver.findElement(By.className("search-stats"));
        Assert.assertNotEquals(result.getText(), "No Results!");
    }

    @Test
    public void testAnastasiiaPotapenko() {
        driver.get("https://www.nps.gov/findapark/index.htm");

        WebElement searchIconButton = driver.findElement(By.xpath("//button[@class = 'multiselect dropdown-toggle btn btn-default']"));
        searchIconButton.click();
        WebElement searchField = driver.findElement(By.xpath("//input[@class = 'form-control multiselect-search']"));
        searchField.sendKeys("Yellowstone National Park\n");
        WebElement searchResult = driver.findElement(By.xpath("//li//label[text() = ' Yellowstone National Park']"));
        searchResult.click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text() = 'Yellowstone' and @class = 'Hero-title ']")).isDisplayed());
    }

    @Test
    public void testAlexMack() {
        driver.get("https://www.fandango.com/");

        WebElement searchField = driver.findElement(By.className("fan-input"));
        searchField.sendKeys("nobody\n");
        WebElement movie = driver.findElement(By.className("results-thumb"));
        movie.click();
        Assert.assertTrue(driver.findElement(By.className("js-movie-video-link")).isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
