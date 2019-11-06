package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IntroPageHelper;


public class TestBase {
    public static final String LOGIN = "karin";
    public static final String PASSWORD = "12345.com";
    public WebDriver driver;
    IntroPageHelper introPage;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void initWebDriver() {

        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.manage().window().fullscreen();
        introPage = PageFactory.initElements(driver, IntroPageHelper.class);

        introPage.waitUntilPageLoaded();
        introPage.closeIntroPage();
    }

}