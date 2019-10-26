package Tests;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageAuthHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;


public class LoginPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    HomePageAuthHelper homePageAuth;



    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        homePageAuth = new HomePageAuthHelper(driver);


        homePage.waitUntilPageIsLoaded();
        loginPage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();

    }

    @Test
    public void loginScreenVerificationTest(){

        Assert.assertTrue(loginPage.correctPageIsLoaded(),
                "It is not login screen or there is no 'registration' on login screen");
    }

    @Test
    public void loginNegativeTest()  {

        loginPage.loginToTheSystem(LOGIN,"123");
        Assert.assertTrue(loginPage.loginToTheSystemIncorrect());

        loginPage.closeLoginWindowByX();
        homePage.waitUntilPageIsLoaded();
        Assert.assertTrue(homePage.correctPageIsLoaded());

    }

    @Test
    public void loginExitByCancelTest()  {

        loginPage.closeLoginWindowByX();
        homePage.waitUntilPageIsLoaded();
        Assert.assertTrue(homePage.correctPageIsLoaded());


    }
    @Test
    public void loginPositiveTest()  {
        loginPage.loginToTheSystem(LOGIN,PASSWORD);
        homePageAuth.waitUntilPageIsLoaded();
        Assert.assertTrue(homePageAuth.correctPageIsLoaded());
    }

}