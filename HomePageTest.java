package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends  TestBase{


    @Test
    public void homePageVerification() throws InterruptedException {

        //-----------Find list events`s element-------------
        WebElement listEvent = driver.findElement(By.id ("idtitletypesearchevents"));




        //-----------Verify that listEvent elements contains 'list events' text -----------

       // System.out.println("Home page verification: " + listEvent.getText().equals("List events"));
        Assert.assertEquals(listEvent.getText(), "List events", "Name of the listEvents element is not \"List events\"");



    }
    @Test
    public  void singleFilterHolidays() throws InterruptedException {
        waitUntilElementIsVisible(By.name("selectholidays"),10);
        WebElement holidaysFilter = driver.findElement(By.name("selectholidays"));
        Select selector  = new Select(holidaysFilter);
        selector.selectByValue("Shabbat");
       // Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("idsignin"),20);
    }



}
