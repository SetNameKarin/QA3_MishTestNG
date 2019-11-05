package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageBase {
    WebDriver driver;
    public static final String LOGIN = "karin";
    public static final String PASSWORD = "12345.com";

    PageBase(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilElementIsVisible(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }



    public void waitUntilAllElementsVisible(List<WebElement> listOptions, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.visibilityOfAllElements(listOptions));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsClickable(By locator, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public void waitUntilElementIsClickable(WebElement element, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilTextPresentInElement(By locator, String text, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilTextPresentInElement(WebElement element, String text, int time){
        try{
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void enterValueToField(WebElement field, String text) {
        field.click();
        field.clear();
        field.sendKeys(text);
    }

}