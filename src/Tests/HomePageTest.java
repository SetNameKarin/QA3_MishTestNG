package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends  TestBase{


    @Test
    public void homePageVerification() throws InterruptedException {

        //-----------Find list events`s element-------------
        WebElement listEvent = driver.findElement(By.id ("idtitletypesearchevents"));


        //-----------Verify that listEvent elements contains 'list events' text -----------

        System.out.println("Home page verification: " + listEvent.getText().equals("List events"));



    }


}
