package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver driver;
    @BeforeMethod
    public  void  initWebDriver() throws InterruptedException {
        driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.get("https://mishpahug.co.il/");
        driver.manage().window().fullscreen();
        driver.findElement(By.id("closedIntro")).click();
        Thread.sleep(5000);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }}
