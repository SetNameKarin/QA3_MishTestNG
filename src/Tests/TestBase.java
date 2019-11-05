package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    public static final String LOGIN = "karin";
    public static final String PASSWORD = "12345.com";
    public WebDriver driver;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public  void  initWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        waitUntilElementIsClickable(By.id("closedIntro"),30);
        driver.manage().window().fullscreen();
        driver.findElement(By.id("closedIntro")).click();
        waitUntilElementIsClickable(By.id("idsignin"),20);

    }

    public void waitUntilElementIsClickable(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }


}