package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {

        //---------Home Page verification. User is not authorized------------
       // WebElement loginButton = driver.findElement(By.id("idsignin"));
        //System.out.println("Login icon is available: " + loginButton.getAttribute("class").contains("fa fa-lock"));
       // System.out.println("Login icon is available: " + loginButton.getText().equals("Login"));
        //Assert.assertTrue(loginButton.getText().equals("Login")); NO NEED??

        //---------Find login button and press it -------------

        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        //Thread.sleep(3000);
        waitUntilElementIsClickable(By.id("signinrequest"),20);
    }
    @Test
    public void loginScreenVerificationTest(){
        Assert.assertTrue(driver.findElement(By.id("clickreg")).getText().contains("registration"),("It is not login screen or there is no 'registration' on login screen"));
    }

   @Test
    protected void loginNegativeTest() throws InterruptedException {

       // ----------- Enter incorrect login/psw ------------

       /*WebElement loginField = driver.findElement(By.id("logininput"));        -----  old code  -----
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
       loginField.click();
       loginField.sendKeys("karinn");
       passwordField.click();
       passwordField.sendKeys("123");
       Thread.sleep(5000);*/

       driver.findElement(By.id("logininput")).sendKeys("karinn");
       driver.findElement(By.id("passwordinput")).sendKeys("123");
       WebElement signInButton = driver.findElement(By.id("signinrequest"));
       signInButton.click();
       waitUntilElementIsVisible(By.id("wrongloginorpassword"), 10);

             //-------------Error message 'wrong authorization is displayed' -----------------

       /*System.out.println("Error message: " + error.getText().equals("Wrong Authorization!"));  -----  old code  -----
       System.out.println(("Error message: " + error.getText().contains("Wrong Authorization!")));*/

       System.out.println("The system displays an error message" + driver.findElement(By.id("wrongloginorpassword")));



       //---------Close login window -------------

       driver.findElement((By.id("closedsignin"))).click();
       //Thread.sleep(3000);
       waitUntilElementIsClickable(By.id("idsignin"), 20);
       waitUntilElementIsVisible(By
               .xpath("//span[@id='idtitletypesearchevents']"),20);


       //---------User is on the HomePage for the unauthorized user------------
       System.out.println("User is on the HomePage unauthorized: " + driver.findElement(By.id("idsignin")).getText().equals("Login"));
       Assert.assertEquals(driver.findElement(By.id("idsignin")).getText(),"Login", "Name of the login button is not 'Login'");


   }
   @Test
   public void loginExitByCancelTest() throws InterruptedException {


        //---------Close login window-------------
       driver.findElement(By.id("closedsignin")).click();
       waitUntilElementIsClickable(By.id("idsignin"),20);
       waitUntilElementIsVisible(By
               .xpath("//span[@id='idtitletypesearchevents']"),20);




        //---------User is on the HomePage for the unauthorized ------------
       Assert.assertEquals(driver.findElement(By.id("idsignin")).getText(), "Login","Name of the login button is not 'Login'");

        /*WebElement loginButtonTwo = driver.findElement(By.id("idsignin"));     -----  old code  -----
        System.out.println("Login icon is available: " + loginButtonTwo.getAttribute("class").contains("fa fa-lock"));
        System.out.println("Login icon is available: " + loginButtonTwo.getText().equals("Login"));*/


    }

    @Test
    public void loginPositiveTest() throws InterruptedException {
               // ----------- Find login and password fields fill them ------------

        WebElement loginField = driver.findElement(By.id("logininput"));
        WebElement passwordField = driver.findElement(By.id("passwordinput"));
        loginField.click();
        loginField.sendKeys("karin");
        passwordField.click();
        passwordField.sendKeys("12345.com");


        //----------- Find sign in button and press it ----------

        driver.findElement(By.id("signinrequest")).click();



        //----------- Go to the Home Page Auth ---------------

        waitUntilElementIsClickable(By.id("profile"), 30);
        WebElement profileIcon = driver.findElement(By.id("profile"));


        // --------- Check that we on the HomePage authorized user----------------------
        //System.out.println("We logged in: " + profileIcon.getAttribute("title").contains("karin"));
        Assert.assertTrue(profileIcon.getAttribute("title").contains("karin"), "ProfileIcon does not contain login");






    }

    }

