package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProfilePageTests extends TestBase {
    ProfilePageHelper profilePage;
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;
    FamilyPageHelper familyPage;


    @BeforeMethod
    public void initTests() throws InterruptedException {
        profilePage = new ProfilePageHelper(driver);
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);
        familyPage = new FamilyPageHelper(driver);

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
       Assert.assertEquals("My Family: Petrov", familyPage.getTitle());


        //---------------Return to the profile---------------
        profilePage.goToTheProfilePage();


        //----------------Open in edit mode---------
        profilePage.openProfileInEditMode();

        //---------------Enter new last name and save--------------------

        profilePage.lastNameChanging("Shuster");
        profilePage.saveProfile();
        Assert.assertEquals("Shuster", profilePage.getFamilyName());
        //Assert.assertTrue(driver.findElement(By.linkText("Shuster")).isDisplayed(),"There is no an element which can be find be linkText('Shuster')");



    }

    @Test
    public void profileAndFamilyPageComparing() {
        String confession = profilePage.confessionProfile();

        String languages = profilePage.languagesProfile();

        String foodPreference = profilePage.foodPreferenceProfile();

        String email = profilePage.EmailProfile();

        String phone = profilePage.phoneNumberProfile();

        profilePage.waitingForFamilyIconIsClickable();
        familyPage.goToTheFamilyPage();


        int counter = 0;
        if (confession.equals(familyPage.confessionFamily())) {
            counter++;
        }
        if (languages.equals(familyPage.languagesFamily())) {
            counter++;
        }
        if (foodPreference.equals(familyPage.foodPreferenceFamily())) {
            counter++;
        }
        if (email.equals(familyPage.emailFamily())) {
            counter++;
        }
        if (phone.equals(familyPage.phoneNumberFamily())) {
            counter++;
        }


        Assert.assertTrue(counter == 5);
    }
 }
