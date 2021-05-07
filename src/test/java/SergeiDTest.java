import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SergeiDTest {

	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
	}

	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
	}

	@Test
	public void test() throws InterruptedException {
		driver.get("https://google.com/");

		WebElement input = driver.findElement(By.className("gLFyf"));
		input.sendKeys("123\n");

		WebElement result = driver.findElement(By.className("MMgsKf"));

		Assert.assertEquals(result.getText(), "Jess Glynne - 123 [Official Live Video] - YouTube");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
