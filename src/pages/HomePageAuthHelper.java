
    package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class HomePageAuthHelper extends PageBase {
        @FindBy(id = "profile") WebElement profileIcon;

        public HomePageAuthHelper(WebDriver driver) {
            super(driver);
        }

        public HomePageAuthHelper waitUntilPageIsLoaded(){

            waitUntilElementIsClickable(profileIcon, 30);
            return this;
        }

        public Boolean correctPageIsLoaded(){
           return profileIcon.getAttribute("title").contains(LOGIN);
        }
    }

