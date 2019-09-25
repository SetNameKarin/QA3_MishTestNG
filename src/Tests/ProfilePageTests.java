package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase {

    @Test
public  void lastNameChanging() throws InterruptedException {
        //---------Find login button and press it -------------

        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(1000);

        // ----------- Find login and password fields fill them ------------

        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("login123");
        passwordField.click();
        passwordField.sendKeys("pswrd123");
        Thread.sleep(1000);

        //--------------
        driver.findElement(By.id("signinrequest")).click();
        Thread.sleep(2000);

        //--------------Go to profile-----------
        WebElement profile = driver.findElement(By.id("profile"));
        profile.click();
        Thread.sleep(1000);

        //--------------Open in edit mode-------------
        WebElement editProfile = driver.findElement(By.id("idbtneditprofile"));
        editProfile.click();
        Thread.sleep(1000);

        //----------------Enter new Last name------------
        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("horosho");
        Thread.sleep(2000);

        WebElement saveButton = driver.findElement(By.id("idbtnsaveprofile"));
        Thread.sleep(1000);
        saveButton.click();
        Thread.sleep(5000);

        //Testing changes
        WebElement searchRawLastName = driver.findElement(By.id("fieldobjfamilyName"));
        System.out.println(searchRawLastName.getText().equals("horosho"));


    }

    @Test
    public void locators() throws InterruptedException {
         //---------Find login button and press it -------------

        // WebElement loginIcon = driver.findElement(By.xpath("//i[@id='idsignin']"));
        // WebElement loginIcon = driver.findElement(By.xpath("//i[@class = 'fa fa-lock']"));
        //  WebElement loginIcon = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        // WebElement loginIcon = driver.findElement(By.cssSelector("#idsignin"));
        // WebElement loginIcon = driver.findElement(By.cssSelector("i[id='idsignin']"));
        //WebElement loginIcon = driver.findElement(By.cssSelector("i[id='idsignin'] > span"));
        WebElement loginIcon = driver.findElement(By.cssSelector("i#idsignin span"));
        loginIcon.click();
        Thread.sleep(2000);

        // ----------- Find login and password fields fill them ------------

        WebElement loginField = driver.findElement(By.cssSelector("#logininput"));   ////i[.//input[.='your login']]
        WebElement passwordField = driver.findElement(By.cssSelector("#passwordinput"));
        loginField.click();
        loginField.sendKeys("karin");
        Thread.sleep(3000);
        passwordField.click();
        passwordField.sendKeys("12345.com");
        Thread.sleep(3000);

        //------------------Sign in click------------------------------------

        driver.findElement(By.cssSelector("#signinrequest")).click();
        Thread.sleep(2000);

        //--------------Go to profile-----------
        //WebElement profile = driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        WebElement profile = driver.findElement(By.cssSelector("#profile"));
        profile.click();
        Thread.sleep(2000);

        //--------------------Personal information --------------------
        //Confession
        String confessionP = driver.findElement(By.cssSelector("#fieldobjconfession")).getText();

        //Languages
        String languageP = driver.findElement(By.cssSelector("#fieldobjlanguages")).getText();

        //Food preference:
        String foodP = driver.findElement(By.cssSelector("#fieldobjfoodPreferences")).getText();

        //Email
        String emailP = driver.findElement(By.cssSelector("#fieldobjelMail")).getText();

        //Phone number:
        String phoneP = driver.findElement(By.cssSelector("#fieldobjphoneNumber")).getText();
        Thread.sleep(5000);


        //---------------------Click Family icon--------------
        driver.findElement(By.xpath("//i[@id='family']")).click();
        Thread.sleep(5000);

        //----------------------Family info-------------------
        //Confession
        String confessionF = driver.findElement(By.xpath("//span[@id='fieldobjconfession']")).getText();

        //Languages
        String languageF = driver.findElement(By.xpath("//span[@id='fieldobjlanguages']")).getText();

        //Food preference:
        String foodF = driver.findElement(By.xpath("//span[@id='fieldobjfoodPreferences']")).getText();

        //Email
        String emailF = driver.findElement(By.xpath("//a[contains(text(),'kokok_ko@mail.ru')]")).getText();

        //Phone number:
        String phoneF = driver.findElement(By.xpath("//a[contains(text(),'0507111528')]")).getText();

        Thread.sleep(5000);


        //-----Comparing results----------

        System.out.println("Confession: " + confessionP.equals(confessionF));
        System.out.println("Language: " + languageP.equals(languageF));
        System.out.println("Food preference: " + foodP.equals(foodF));
        System.out.println("Email: " + emailP.equals(emailF));
        System.out.println(("Phone number: " + phoneP.equals(phoneF)));
    }
 }
