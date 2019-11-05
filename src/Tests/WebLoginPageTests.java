package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebLoginPageHelper;



public class WebLoginPageTests extends TestBase{

    WebLoginPageHelper loginPage;
    @BeforeMethod
    public void initTests(){

        loginPage = PageFactory.initElements(driver, WebLoginPageHelper.class);
        loginPage.loginPageOpen();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void webLoginPositive() {

        WebElement loginInput = driver.findElement(By.id("logininput"));
        WebElement passwordInput = driver.findElement(By.id("passwordinput"));
        loginInput.click();
        loginInput.sendKeys(LOGIN);
        passwordInput.click();
        passwordInput.sendKeys(PASSWORD);
        driver.findElement(By.id("signinrequest")).click();
        waitUntilElementIsClickable(By.id("profile"),20);
        WebElement profileIcon = driver.findElement(By.id("profile"));
        Assert.assertTrue(profileIcon.getAttribute("title").contains("marinaA"));

    }

    @Test
    public void webNegativeLogin() {

        System.out.println("We are on the Login window: " + driver
                .findElement(By.id("clickreg")).getText().contains("registration"));

        //---- Enter incorrect login/psw ---
        driver.findElement(By.id("logininput")).sendKeys(LOGIN);
        driver.findElement(By.id("passwordinput")).sendKeys("123");
        WebElement signInButton = driver.findElement(By.id("signinrequest"));
        signInButton.click();
        //Thread.sleep(3000);
        waitUntilElementIsVisible(By.id("wrongloginorpassword"),10);

        //--- Error message 'wrong authorization is displayed' ----
        Assert.assertTrue(driver
                .findElement(By.id("wrongloginorpassword")).getText().contains("Wrong Authorization"));

        //--- Close login window ---
        driver.findElement(By.id("closedsignin")).click();
        waitUntilElementIsVisible(By.id("idtitletypesearchevents"),20);

        // ---- User is on the HomePage for the unauthorized user--------
        Assert.assertEquals(driver.findElement(By.id("idsignin")).getText(), "Login","Name of the loginButton is not equal to 'Login'");

    }
}