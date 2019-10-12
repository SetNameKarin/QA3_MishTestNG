package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class HomePageTests extends  TestBase{


    @Test
    public void homePageVerification() throws InterruptedException {

        //-----------Find list events`s element-------------
        WebElement listEvent = driver.findElement(By.id ("idtitletypesearchevents"));
        waitUntilElementIsClickable(By.linkText("Shuster"), 20);




        //-----------Verify that listEvent elements contains 'list events' text -----------

       // System.out.println("Home page verification: " + listEvent.getText().equals("List events"));
        Assert.assertEquals(listEvent.getText(), "List events", "Name of the listEvents element is not \"List events\"");



    }
    @Test
    public  void singleFilterHolidays() throws InterruptedException {
        waitUntilElementIsVisible(By.name("selectholidays"),10);


        // ----- to wait that select-element (filter by holiday) and all options are loaded ---
        waitUntilElementIsVisible(By.name("selectholidays"),30);
        waitUntilAllElementsVisible(driver.findElements(By.xpath("//select[@name = 'selectholidays']/option")), 30);// !!!!!!!!!!!!!!!!!!!

        // --- get select-element (filter by holiday)
        WebElement holidaysFilter = driver
                .findElement(By.name("selectholidays"));

        // --- verify states clear button ----
        System.out.println("is displayed: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isDisplayed());
        System.out.println("is enabled: " + driver
                .findElement(By.xpath("//div[@id='idbtnclearfilter']")).isEnabled());

        // ------ choose filter "shabbat" ------
        Select selector = new Select(holidaysFilter);
        selector.selectByValue("Shabbat");
        Thread.sleep(10000);

        // ------ wait that filter "shabbat" is chosen -----
        waitUntilElementIsClickable(By
                .xpath("//div[@id='idbtnclearfilter']"),20);
        waitUntilElementIsPresent(By
                .xpath("//option[@selected][@value = 'Shabbat']"),20);
        // ------ wait that all events by fiter "shabbat" are loaded ----
        waitUntilAllElementsVisible(driver.findElements(By
                .xpath("//div[@class = 'itemEventInsert']")),40);

        // ------ get all holidays values for all chosen by filter "Shabbat" events
        List<WebElement> listHolidays = driver.findElements(By.xpath("//div[@class = 'holidayItemEvents']"));

        // --- verify that all holidays values are "Shabbat" ----
        int counter = 0;
        for (int i=0; i < listHolidays.size(); i++){
            if (listHolidays.get(i).getText().equals("Shabbat")) counter++;
        }
        Assert.assertEquals(counter, listHolidays.size());



    }



}
