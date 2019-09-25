import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

                //------------Enter to the system---------------
                WebDriver driver = new ChromeDriver();
                Thread.sleep(1000);
                driver.get("https://mishpahug.co.il/");
                driver.manage().window().fullscreen();
                driver.findElement(By.id("closedIntro")).click();


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



                driver.quit();


            }
        }



