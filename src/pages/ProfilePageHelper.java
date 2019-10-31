package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePageHelper extends PageBase{

    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }


public void goToTheProfile(){
    driver.findElement(By.id("profile")).click();

    waitUntilElementIsClickable(By.xpath(" //div[@id='idbtneditavatar']//div//i[@class='fa fa-plus-circle']"), 30);
    waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:", 20);
    waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);

}

public void openProfileInEditMode(){

    driver.findElement(By.id("idbtneditprofile")).click();
    waitUntilElementIsClickable(By.xpath("//span[@id='fieldobjfamilyName']//input"), 20);
    waitUntilElementIsClickable(By.id("idbtnsaveprofile"), 20);


}


    public void lastNameChanging(String name) {
        //----------------Enter new Last name------------
        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(name);
        waitUntilElementIsVisible(By.id("idbtnsaveprofile"), 30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"), 30);
    }


        public void saveProfile() {
            driver.findElement(By.id("idbtnsaveprofile")).click();
            waitUntilTextPresentInElement(By.xpath("//span[@id='fieldobjfamilyName']"), "Petrov", 20);
            waitUntilElementIsClickable(By.id("idbtneditprofile"), 30);
            waitUntilElementIsClickable(By.id("family"), 20);
        }
        public void goToTheFamilyPage(){
            driver.findElement(By.id("family")).click();
           waitUntilElementIsVisible(By.id("idfamilyinfoimg"), 30);
           waitUntilTextPresentInElement(By.id("titleprofile"), "My Family:", 30);

        }

            public void goToTheProfilePage() {
            driver.findElement(By.id("profile")).click();
            waitUntilElementIsClickable(By.xpath(" //div[@id='idbtneditavatar']//div//i[@class='fa fa-plus-circle']"), 30);
            waitUntilTextPresentInElement(By.id("titleprofile"), "My Profile:", 20);
            waitUntilElementIsVisible(By.id("imgavatarinprofilefamily"), 20);

              }

    public String getFamilyName(){
        return driver.findElement(By.id("fieldobjfamilyName")).getText();
    }

    public void waitingForFamilyIconIsClickable(){
        waitUntilElementIsClickable(By.id("family"), 30);

    }
            //--------------------Personal information for comparing --------------------
            public String confessionProfile(){

                return driver.findElement(By.cssSelector("#fieldobjconfession")).getText();

            }

            public String languagesProfile(){

                return driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();}


            public String foodPreferenceProfile(){

                return driver.findElement(By.cssSelector("#fieldobjfoodPreferences")).getText();
            }


            public String EmailProfile(){

                return driver.findElement(By.cssSelector("#fieldobjelMail")).getText();
            }


            public String phoneNumberProfile(){

                return driver.findElement(By.cssSelector("#fieldobjphoneNumber")).getText();
                }





}
