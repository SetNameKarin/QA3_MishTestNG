package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.ProfilePageHelper;

public class ProfilePageTests extends TestBase {
    ProfilePageHelper profilePage;
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;


    @BeforeMethod
    public void initTests() throws InterruptedException {
        profilePage = new ProfilePageHelper(driver);
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);

        homePage.waitUntilPageIsLoaded();
        loginPage.openLoginPage();
        loginPage.loginToTheSystem(LOGIN,PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        profilePage.goToTheProfile();
    }

    @Test
public  void lastNameOfFamilyChanging() throws InterruptedException {
              //--------------Open in edit mode-------------
       profilePage.openProfileInEditMode();
       profilePage.lastNameChanging("Petrov");
       profilePage.saveProfile();
        Assert.assertEquals(driver.findElement(By.linkText("Petrov")).getText(),"Petrov");


        //----------------Go to the family page--------------
       profilePage.goToTheFamilyPage();
        Assert.assertTrue(driver.findElement(By.id("titleprofile")).getText().contains("Petrov")); //DOES NOT WORK!!!!((((


        //---------------Return to the profile---------------
        profilePage.goToTheProfilePage();


        //----------------Open in edit mode---------
        profilePage.openProfileInEditMode();

        //---------------Enter new last name and save--------------------

        profilePage.lastNameChanging("Shuster");
        profilePage.saveProfile();
        Assert.assertTrue(driver.findElement(By.linkText("Shuster")).isDisplayed(),"There is no an element which can be find be linkText('Shuster')");



    }

    @Test
    public void profileAndFamilyPageComparing(){
        profilePage.confessionProfile();
        profilePage.languagesProfile();
        profilePage.foodPreferenceProfile();
        profilePage.EmailProfile();
        profilePage.phoneNumberProfile();

        profilePage.waitingForFamilyIconIsClickable();

        profilePage.goToTheFamilyPage();
        Assert.assertTrue(profilePage.comparingResults());
    }
 }
