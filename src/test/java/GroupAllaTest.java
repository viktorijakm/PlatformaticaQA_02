import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupAllaTest {

    public static boolean tenMinuteMailTest() {

        String currentMail = "";
        //System.setProperty("webdriver.chrome.driver", "C:/_install/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver chromedrv = new ChromeDriver();


        try {
            chromedrv.get("https://10mail.org/");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            WebElement mailArea = chromedrv.findElement(By.className("address"));
            currentMail = mailArea.getText();

            if (currentMail.equals(""))
                return false;

            System.out.println("Received mail: " + currentMail);
        } finally {

            chromedrv.quit();

        }

        return true;
    }

    @Test
    public void poptsovRomanTest() {
        Assert.assertEquals(tenMinuteMailTest(), true, "test failed");
    }

}
