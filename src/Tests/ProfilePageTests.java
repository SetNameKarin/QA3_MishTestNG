package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase {
    @BeforeMethod
    public void initTests() throws InterruptedException {
        //--------------Login to the system-----------
        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        waitUntilElementIsVisible(By.id("login-form"), 30);


        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("karin");
        passwordField.click();
        passwordField.sendKeys("12345.com");
       waitUntilElementIsClickable(By.id("signinrequest"), 20);

        driver.findElement(By.id("signinrequest")).click();
       Thread.sleep(3000);
        //waitUntilElementIsVisible(By.id("profile"), 30);
       // waitUntilElementIsClickable(By.id("profile"), 20);

        //--------------Go to the profile-----------
       driver.findElement(By.id("profile")).click();
       Thread.sleep(2000);
       //waitUntilElementIsVisible(By.id("titleprofile"),30);

    }


    @Test
public  void lastNameOfFamilyChanging() throws InterruptedException {
              //--------------Open in edit mode-------------
       driver.findElement(By.id("idbtneditprofile")).click();
       Thread.sleep(2000);
     //waitUntilElementIsVisible(By.xpath(" //div[@id='idbtneditavatar']//div//i[@class='fa fa-plus-circle']"), 30);

        //----------------Enter new Last name------------
        WebElement lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("horosho");
        waitUntilElementIsVisible(By.id("idbtnsaveprofile"), 30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"), 30);


        //-----------------Save profile-----------

        driver.findElement(By.id("idbtnsaveprofile")).click();
       waitUntilElementIsClickable(By.id("idbtneditprofile"),30);
        waitUntilElementIsVisible(By.xpath("//span[@id = 'fieldobjfamilyName']/a"),20);

        /*------------------Testing changes-------------------
        WebElement searchRawLastName = driver.findElement(By.id("fieldobjfamilyName"));
        System.out.println(searchRawLastName.getText().equals("horosho"));*/

        //----------------Go to the family page--------------
        driver.findElement(By.id("family")).click();
        waitUntilElementIsVisible(By.id("idfamilyinfoimg"), 30);
        System.out.println("Last name of the family verification: " + driver.findElement(By.id("titleprofile")).getText().
      contains("horosho"));

        //---------------Return to the profile---------------
        driver.findElement(By.id("profile")).click();
        Thread.sleep(2000);
        //waitUntilElementIsVisible(By.id("idbtneditprofile"),30);
        //waitUntilElementIsClickable(By.id("idbtneditprofile"), 40);


        //----------------Open in edit mode---------
        driver.findElement(By.id("idbtneditprofile")).click();
        waitUntilElementIsVisible(By.xpath(" //div[@id='idbtneditavatar']//div//i[@class='fa fa-plus-circle']"), 30); // + avatar

        //---------------Enter new last name--------------------
        lastNameField = driver.findElement(By.xpath("//span[@id='fieldobjfamilyName']//input"));
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys("Shuster");
        waitUntilElementIsVisible(By.id("idbtnsaveprofile"),30);
        waitUntilElementIsClickable(By.id("idbtnsaveprofile"),30);


        //-----------------Save profile-----------

        driver.findElement(By.id("idbtnsaveprofile")).click();
        waitUntilElementIsVisible(By.id("idbtneditprofile"),30);
        waitUntilElementIsClickable(By.linkText("Shuster"), 20);

        Assert.assertTrue(driver.findElement(By.linkText("Shuster")).isDisplayed(),"There is no an element which can be find be linkText('Shuster')");



    }

    @Test
    public void profileAndFamilyPageComparing() throws InterruptedException {

         /*---------Find login button and press it -------------

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
        Thread.sleep(2000);*/

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
        //waitUntilElementIsClickable(By.id("family"), 30);


        //---------------------Go to the family--------------
        driver.findElement(By.id("family")).click();
       Thread.sleep(5000);
       // waitUntilElementIsVisible(By.xpath("//div[contains(text(),'Member family')]"), 30);

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

                //-----Comparing results----------

        System.out.println("Confession: " + confessionP.equals(confessionF));
        System.out.println("Language: " + languageP.equals(languageF));
        System.out.println("Food preference: " + foodP.equals(foodF));
        System.out.println("Email: " + emailP.equals(emailF));
        System.out.println(("Phone number: " + phoneP.equals(phoneF)));

       int counter = 0;
        if(confessionP.equals(confessionF)){
            counter++;
        }
        if(languageP.equals(languageF)){
            counter++;
        }
        if(foodP.equals(foodF)){
            counter++;
        }
        if(emailP.equals(emailF)){
            counter++;
        }
        if(phoneP.equals(phoneF)){
            counter++;
        }

        Assert.assertEquals(counter, 5);

      /* Assert.assertEquals(confessionP,confessionF, "Confession values are equal");
        Assert.assertEquals(languageP, languageF, "Language values are equal" );
        Assert.assertEquals(foodP, foodF, "Food values are equal" );
        Assert.assertEquals(emailP, emailF, "Email values are equal" );
        Assert.assertEquals(phoneP, phoneF, "Phone values are equal" );
        */


    }
 }
