import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupLetsDoItTest extends Utility {

   @Test
    public void viktoriiaMarushevskaTargetTest() throws InterruptedException {
        driver.get("https://www.target.com/");
        Thread.sleep(1000);

        driver.findElement(By.id("search")).sendKeys("band aids");
        driver.findElement(By.xpath("//button[text()='go']")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™")).click();
        Thread.sleep(5000);

        String searchResultText = driver.findElement(By.xpath("//span[contains(text(), 'Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™')]")).getText();
        Assert.assertEquals(searchResultText, "Assorted Sizes Flexible Fabric Bandages - 30ct - up & up™");
    }
}
