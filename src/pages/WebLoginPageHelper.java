package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebLoginPageHelper extends PageBase {
    @FindBy(id = "signinrequest")WebElement signinRequest;
    @FindBy(id = "idsignin")WebElement loginIcon;

    public WebLoginPageHelper(WebDriver driver) {
        super(driver);
    }
    public WebLoginPageHelper waitUntilPageIsLoaded(){
        waitUntilElementIsClickable(signinRequest,20);
        return this;
    }

    public WebLoginPageHelper loginPageOpen(){
       loginIcon.click();
       return this;
    }



}