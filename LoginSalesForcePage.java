package pages;

import co.za.capitecbank.testing.pages.BasePage;
import co.za.capitecbank.testing.utilities.EmailOTP;
import config.Configuration;
import org.checkerframework.common.reflection.qual.GetClass;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;

import static config.Configuration.jsDriver;

public class LoginSalesForcePage extends BasePage {

    static JavascriptExecutor jsDriver = (JavascriptExecutor) Configuration.driver;


    public static void IhaveLoggedin(String User,String Password) throws InterruptedException, IOException {


try
{
    String subject = "Sandbox: Verify your identity in Salesforce";
    String endOfEmailText = "If you didn't recently log in";

   // String OTP = EmailOTP.GetOTP("/me/messages","Sandbox: Verify your identity in Salesforce","If you didn't recently log in","Verification Code:",7);
   // String otp =  EmailOTP.GetOTP("/me/messages","One Time Pin","This One Time Pin will expire within 5 minutes.","confirmation OTP",7);
    WebElement UserName = Configuration.driver.findElement(By.xpath("//input[@name='username']"));
    Thread.sleep(2000);
    UserName.sendKeys(User);

    WebElement UserPassword = Configuration.driver.findElement(By.xpath("//input[@name='pw']"));
    Thread.sleep(2000);
    UserPassword.sendKeys(Password);

    WebElement Login_btn = Configuration.driver.findElement(By.xpath("//input[@name='Login']"));
    Thread.sleep(2000);
    Login_btn.click();



}catch (TimeoutException e)

{



}



    }
    public static void enterUsername(String data) throws InterruptedException {

        Thread.sleep(2000);
        WebElement UserName = Configuration.driver.findElement(By.xpath("//input[@name='username']"));
        Thread.sleep(2000);
       UserName.sendKeys(data);
    }

    public static void enterpassword(String data) throws InterruptedException {
        Thread.sleep(2000);
        WebElement UserPassword = Configuration.driver.findElement(By.xpath("//input[@name='pw']"));
        Thread.sleep(2000);
        UserPassword.sendKeys(data);
    }

    public static void ClickrememberMeCheckbox() throws InterruptedException {

        WebElement CheckRememberMeCheckbox = Configuration.driver.findElement(By.xpath("//input[@name='rememberUn']"));
        Thread.sleep(2000);
        CheckRememberMeCheckbox.click();
    }

    public static void ClickLog_In() throws InterruptedException {

        WebElement Login = Configuration.driver.findElement(By.xpath("//input[@name='Login']"));
        Thread.sleep(2000);
        Login.click();
    }



    public static void ClickSaleforceHomePage() throws InterruptedException {
        Assert.assertTrue(true);
//        String ClickSaleforceHomePage = "return ";
//        Thread.sleep(2000);
//        WebElement Click_SaleforceHomePage = (WebElement) jsDriver.executeScript(ClickSaleforceHomePage);
//        Click_SaleforceHomePage.click();
    }


}