package pages;

import co.za.capitecbank.testing.utilities.Misc;
import config.Configuration;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

import static co.za.capitecbank.testing.utilities.EmailOTP.wait;
import static pages.ClientManagementPage.GetRandomTitle;
import static pages.ClientManagementPage.generateRandomRegistrationNumber;

public class Client360 {
    public static void Client(String MileStonesType) throws InterruptedException {


        if (MileStonesType.equals("Life Events")) {


//    WebElement combo_btn = Configuration.driver.findElement(By.xpath("//a[contains(@title,'Business Milestones')]"));
//    WebElement combo_btn_ = wait.until(ExpectedConditions.elementToBeClickable(combo_btn));
//    String MType =combo_btn_.getText();


            List<WebElement> progressList = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-ple-progress__list')]"));

            assert !progressList.isEmpty() : "Progress list is empty";


        } else {


            List<WebElement> progressList = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-ple-progress__list')]"));

            assert !progressList.isEmpty() : "Progress list is empty";


        }


    }


    public static void NextBestAction() throws InterruptedException {

        Thread.sleep(1000);


        WebElement NextBestAction = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-m-top_xx-small nbaAcceptRejectBlock')]"));
      //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", NextBestAction);
        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(NextBestAction));

        EleWait.click();

        List<WebElement> Product_interest = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!Product_interest.isEmpty()) {

            WebElement Leads = Product_interest.get(0);


            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait_ = wait.until(ExpectedConditions.elementToBeClickable(Leads));
            EleWait_.click();


            Select dropdown = new Select(Leads);

            dropdown.selectByIndex(2);
        }


        WebElement AnnualTurnOver = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Annual_Turnover')]"));
      //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", AnnualTurnOver);
        WebElement AnnualTurnOver_ = wait.until(ExpectedConditions.elementToBeClickable(AnnualTurnOver));
        AnnualTurnOver_.sendKeys("1000");

        Thread.sleep(1000);

        WebElement BusinessSummary = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-form-element__control slds-grow textarea-container')]"));
     //   ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", BusinessSummary);
        WebElement BusinessSummary_ = wait.until(ExpectedConditions.elementToBeClickable(BusinessSummary));
        BusinessSummary_.sendKeys("Automation Test");

        Thread.sleep(1000);

        WebElement Finish = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-button flow-button__NEXT')]"));
      //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", Finish);
        WebElement Finish_ = wait.until(ExpectedConditions.elementToBeClickable(Finish));
        Finish_.click();


    }

}
