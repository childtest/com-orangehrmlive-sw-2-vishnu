package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter the required details
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        // click on Login button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //verify the Dashboard text
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Dashboard not displayed", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
