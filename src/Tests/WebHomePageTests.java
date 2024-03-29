package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.WebPageHomeHelper;

import java.util.List;

public class WebHomePageTests extends TestBase{
    WebPageHomeHelper webPageHome;

    @BeforeMethod
    public void initTests (){
        webPageHome = PageFactory.initElements(driver, WebPageHomeHelper.class);
        webPageHome.waitUntilPageIsloaded();

    }

    @Test
    public void webHomePageTest()  {

        Assert.assertTrue(webPageHome.correctPageIsLoaded(),
                "'ListEvent' element is not displayed or 'Login' button is not displayed");
    }


}