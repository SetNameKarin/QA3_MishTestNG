package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {

        //---------Home Page verification. User is not authorized------------
        WebElement loginButton = driver.findElement(By.id("idsignin"));
        //System.out.println("Login icon is available: " + loginButton.getAttribute("class").contains("fa fa-lock"));
        System.out.println("Login icon is available: " + loginButton.getText().equals("Login"));

        //---------Find login button and press it -------------

        WebElement loginIcon = driver.findElement(By.id("idsignin"));
        loginIcon.click();
        Thread.sleep(3000);


    }

   @Test
    protected void loginNegativeTest() throws InterruptedException {

       // ----------- Find login and password fields fill them ------------

       WebElement loginField = driver.findElement(By.id("logininput"));
       WebElement passwordField = driver.findElement(By.id("passwordinput"));
       loginField.click();
       loginField.sendKeys("karinn");
       Thread.sleep(5000);
       passwordField.click();
       passwordField.sendKeys("123");
       Thread.sleep(5000);

       //------------Click Sign in button-------------------

       WebElement signIn = driver.findElement(By.id("signinrequest"));
       signIn.click();
       Thread.sleep(3000);

       //-------------Error notification verification-----------------

       WebElement error = driver.findElement((By.id(("wrongloginorpassword"))));
       //System.out.println("Error message: " + error.getText().equals("Wrong Authorization!"));
       System.out.println(("Error message: " + error.getText().contains("Wrong Authorization!")));

       //---------Find cancel button and press it -------------

       WebElement cancelButton = driver.findElement((By.id("closedsignin")));
       cancelButton.click();
       Thread.sleep(3000);

       //---------Home Page verification. User is not authorized------------
       WebElement loginButtonTwo = driver.findElement(By.id("idsignin"));
       //System.out.println("Login icon is available: " + loginButton.getAttribute("class").contains("fa fa-lock"));
       System.out.println("Login icon is available: " + loginButtonTwo.getText().equals("Login"));


   }
   @Test
   public void loginExitByCancelTest() throws InterruptedException {


        //---------Find cancel button and press it -------------

        WebElement cancelButton = driver.findElement((By.id("closedsignin")));
        cancelButton.click();
        Thread.sleep(3000);

        //---------Home Page verification. User is not authorized------------
        WebElement loginButtonTwo = driver.findElement(By.id("idsignin"));
        //System.out.println("Login icon is available: " + loginButtonTwo.getAttribute("class").contains("fa fa-lock"));
        System.out.println("Login icon is available: " + loginButtonTwo.getText().equals("Login"));


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
        Thread.sleep(5000);

        //----------- Find sign in button and press it ----------

        driver.findElement(By.id("signinrequest")).click();
        Thread.sleep(3000);

        //----------- Go to the Home Page Auth ---------------

        WebElement profileIcon = driver.findElement(By.id("profile"));

        // --------- Check that we on the HomePage authorized user ----------
        System.out.println("We logged in: " + profileIcon.getAttribute("title").contains("karin"));





    }

    }

