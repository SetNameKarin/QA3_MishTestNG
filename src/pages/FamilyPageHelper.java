package pages;

import Tests.ProfilePageTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FamilyPageHelper extends PageBase{

    public FamilyPageHelper(WebDriver driver) {
        super(driver);
    }


    public void goToTheFamilyPage(){
        driver.findElement(By.id("family")).click();
        waitUntilElementIsVisible(By.id("idfamilyinfoimg"), 30);
        waitUntilTextPresentInElement(By.id("titleprofile"), "My Family:", 30);

    }

    public String getTitle(){
        return driver.findElement(By.id("titleprofile")).getText();
    }

    public String confessionFamily(){
        return  driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();
    }

    public String languagesFamily(){
        return driver.findElement(By.xpath("//span[@id='fieldobjlanguages']")).getText();
    }
    public String foodPreferenceFamily(){
        return driver.findElement(By.xpath("//span[@id='fieldobjfoodPreferences']")).getText();
    }

    public String emailFamily(){
       return driver.findElement(By.xpath("//a[contains(text(),'kokok_ko@mail.ru')]")).getText();
    }

    public String phoneNumberFamily(){
        return driver.findElement(By.xpath("//a[contains(text(),'0507111528')]")).getText();
    }


}
