import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DariaAltukhovaTest extends Utility {

    final String mainURL = "https://www.edcast.com/";
    final String demoUrl = "https://www.edcast.com/corp/request-a-demo/";

    @Test
    public void testDariaAltukhovaOpenDemoFromPage()  {
        driver.get(mainURL);

        WebElement productButton = driver.findElement(By.id("menu-item-442"));
        productButton.click();

        WebElement dropdownEdCastXP = driver.findElement(By.id("menu-item-46"));
        dropdownEdCastXP.click();

        WebElement requestDemoButton = driver.findElement(By.className("fl-button-text"));
        requestDemoButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), demoUrl);
    }

    @Test
    public void testDariaAltukhovaOpenDemoFromMenu()  {
        driver.get(mainURL);
        WebElement demoHeaderButton = driver.findElement(By.id("menu-item-6658"));
        demoHeaderButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), demoUrl);
    }

    @Test
    public void testDariaAltukhovaDemoVideoButton()  {
        driver.get(mainURL);
        WebElement watchEdcastDemoVideoButton = driver.findElement(By.className("fl-button"));
        watchEdcastDemoVideoButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://go.edcast.com/l/139221/2021-03-31/2m9x9x");
    }
}
