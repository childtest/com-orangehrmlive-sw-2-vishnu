package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUpBrowser() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        // navigate to Forgot your password page
        driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();

        //verify the Reset Password text
        String expectedText = "Reset Password";
        String actualText = driver.findElement(By.xpath("//h6")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Reset Password text not verify", expectedText, actualText);

        //.......................................................................

        // click on the Cancel button and navigate to login page
        driver.findElement(By.xpath("//button[@type = 'button']")).click();

        //verify the Reset Password text
        String expectedText1 = "Login";
        String actualText1 = driver.findElement(By.xpath("//h5")).getText();

        // Verify with Assert Junit test
        Assert.assertEquals("Login text not verify", expectedText1, actualText1);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
