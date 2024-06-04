package pages;

import co.za.capitecbank.testing.utilities.Misc;
import config.Configuration;
import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

import static co.za.capitecbank.testing.utilities.EmailOTP.wait;
import static pages.ClientManagementPage.GetRandomTitle;
import static pages.ClientManagementPage.generateRandomRegistrationNumber;

public class AccountManagementPage
{

    public enum FlagState {
        GREEN, RED;

        public static FlagState fromSrc(String src) {
            if (src.contains("flag_green.gif")) {
                return GREEN;
            } else if (src.contains("flag_red.gif")) {
                return RED;
            } else {
                throw new IllegalArgumentException("Unknown flag source: " + src);
            }
        }
    }
    public static void Client_Tab() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);


        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            try {
                closeButton.click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }

        // Thread.sleep(2000);

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement Nav_Menu_ = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));
        Thread.sleep(1000);
        Nav_Menu_.click();
        Thread.sleep(1000);
        WebElement btn_Lead = Configuration.driver.findElement(By.xpath("//a[@data-label='Clients']"));
        WebElement btn_Lead_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Lead));
        btn_Lead_.click();
        Thread.sleep(1000);

        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Clients']"));
        WebElement btn_Cases_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
        btn_Cases_.click();
        Thread.sleep(1000);
    }


    public static void NewClient() throws InterruptedException {


        try {

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 30);
            WebElement btn_New = Configuration.driver.findElement(By.xpath("//a[@title='New']"));
            WebElement new_btn = wait.until(ExpectedConditions.elementToBeClickable(btn_New));
            new_btn.click();
        } catch (Exception e) {


            System.out.println("New button not available  " + e.getMessage());


            WebElement btn_case = Configuration.driver.findElement(By.xpath("//a[contains(@title,'Clients')]"));
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 30);
            WebElement clickableCase = wait.until(ExpectedConditions.elementToBeClickable(btn_case));
            clickableCase.click();


            try {
                WebElement btn_NewAgain = Configuration.driver.findElement(By.xpath("//a[@title='New']"));
                WebElement new_btnAgain = wait.until(ExpectedConditions.elementToBeClickable(btn_NewAgain));

                new_btnAgain.click();
            } catch (NoSuchElementException | TimeoutException ex) {

                System.out.println("Unable to click 'New' button after clicking 'Cases': " + ex.getMessage());

            }
        }

    }

    public static void CheckRecordType(String RecordType) throws InterruptedException {


        wait = new WebDriverWait(Configuration.driver, 60);
        String Registration_number = generateRandomRegistrationNumber();
            String id = Misc.generateRandomIDNumberSA("891103", "Female");


        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;

        Faker faker = new Faker(new Locale("en-ZA"));
        String FName = faker.name().firstName();
        String LName = faker.name().lastName();

        String[] title_ = {"Mr.", "Mrs.", "Ms."};
        String Title = GetRandomTitle(title_);


      //  lastName = faker.name().lastName();

        Thread.sleep(2000);


        List<WebElement> rodio_btn = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-radio--faux')]"));

        WebElement g = rodio_btn.get(0);
        WebElement g2 = rodio_btn.get(3);
        WebElement gclickable = wait.until(ExpectedConditions.elementToBeClickable(g));
        WebElement g2clickable = wait.until(ExpectedConditions.elementToBeClickable(g2));

        if (RecordType.equals("Registered Business")) {
            gclickable.click();
        } else {
            g2clickable.click();
        }


//        WebElement select = Configuration.driver.findElement(By.xpath("//*[contains(text(),'" + RecordType + "')]"));
//        JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;
//        executor.executeScript("arguments[0].click();", select);

        Thread.sleep(2000);
        if (RecordType.equals("Registered Business")) {
            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral slds-button slds-button_brand uiButton')]"));
            WebElement nextclickable = wait.until(ExpectedConditions.elementToBeClickable(Next));

            Thread.sleep(2000);

            nextclickable.click();
            Thread.sleep(2000);
            WebElement RegClientName = Configuration.driver.findElement(By.xpath("//*[@name='Name']"));
            WebElement RegClientNameC = wait.until(ExpectedConditions.elementToBeClickable(RegClientName));
            Thread.sleep(2000);
            RegClientNameC.sendKeys(LName);

            WebElement BusinessRegc = Configuration.driver.findElement(By.xpath("//input[@name='BB_Business_Registration_Number__c']"));
            WebElement RegClientName_ = wait.until(ExpectedConditions.elementToBeClickable(BusinessRegc));
//                Thread.sleep(2000);
            RegClientName_.sendKeys(Registration_number);


//                WebElement save = Configuration.driver.findElement(By.xpath("//*[@data-target-selection-name='sfdc:StandardButton.Account.SaveEdit']"));
            Thread.sleep(2000);
//                save.click();

//            List<WebElement> save_btn = Configuration.driver.findElements(By.xpath("//*[@name='SaveEdit']"));
//
//            WebElement save_btn1 = save_btn.get(1);
//            WebElement save_btn_ = wait.until(ExpectedConditions.elementToBeClickable(save_btn1));
//
//            save_btn_.click();


//            WebElement save = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
//            WebElement savess = wait.until(ExpectedConditions.elementToBeClickable(save));
//
//            Thread.sleep(2000);
//            savess.click();




            Thread.sleep(4000);

        } else if (RecordType.equals("Group")) {

            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--neutral slds-button slds-button_brand uiButton')]"));
            WebElement Next_ = wait.until(ExpectedConditions.elementToBeClickable(Next));

//                Thread.sleep(2000);
            Next_.click();
//                Thread.sleep(2000);
            WebElement RegClientName = Configuration.driver.findElement(By.xpath("//*[@name='Name']"));
            WebElement RegClientName_ = wait.until(ExpectedConditions.elementToBeClickable(RegClientName));

//                Thread.sleep(2000);
            RegClientName_.sendKeys(FName);

            WebElement BusinessReg = Configuration.driver.findElement(By.xpath("//input[@name='BB_Business_Registration_Number__c']"));
            WebElement BusinessReg_ = wait.until(ExpectedConditions.elementToBeClickable(BusinessReg));

            Thread.sleep(2000);
            BusinessReg_.sendKeys(Registration_number);


            WebElement save = Configuration.driver.findElement(By.xpath("//*[@data-target-selection-name='sfdc:StandardButton.Account.SaveEdit']"));
            WebElement saves = wait.until(ExpectedConditions.elementToBeClickable(save));

            Thread.sleep(2000);
            saves.click();
            Thread.sleep(2000);


        } else if (RecordType.equals("Individual")) {

            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--neutral slds-button slds-button_brand uiButton')]"));
            WebElement Next_ = wait.until(ExpectedConditions.elementToBeClickable(Next));

//                Thread.sleep(2000);
            Next_.click();

            WebElement combo_btn = Configuration.driver.findElement(By.xpath("//button[@name='salutation']"));
            WebElement combo_btn_ = wait.until(ExpectedConditions.elementToBeClickable(combo_btn));

//                Thread.sleep(2000);
            combo_btn_.click();

            String xpath = "//*[contains(@aria-activedescendant, 'combobox-button-')]";

//                WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));


            WebElement Lastname = Configuration.driver.findElement(By.xpath("//*[@name='lastName']"));
            WebElement Lastname_ = wait.until(ExpectedConditions.elementToBeClickable(Lastname));

//                Thread.sleep(2000);
            Lastname_.sendKeys(LName);


            WebElement save = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
            WebElement savess = wait.until(ExpectedConditions.elementToBeClickable(save));

            Thread.sleep(2000);
            savess.click();

//                Thread.sleep(2000);

        } else {


            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_neutral slds-button slds-button_brand uiButton')]"));
            WebElement Next_ = wait.until(ExpectedConditions.elementToBeClickable(Next));
//                Thread.sleep(2000);
            Next_.click();
            Thread.sleep(4000);
            js.executeScript("window.scrollBy(0,170);");

            WebElement combo_btn = Configuration.driver.findElement(By.xpath("//button[@name='salutation']"));
            WebElement combo_btn_ = wait.until(ExpectedConditions.elementToBeClickable(combo_btn));
//                Thread.sleep(2000);
//            combo_btn_.click();

            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", combo_btn_);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(combo_btn_).click().perform();


            String commonIdPart = Title;
            WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));
            WebElement dynamicElement_ = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));

            if (dynamicElement_ != null) {

                js.executeScript("arguments[0].scrollIntoView();", dynamicElement_);


                dynamicElement_.click();
            }
            Thread.sleep(2000);
            WebElement firstName = Configuration.driver.findElement(By.xpath("//*[@name='firstName']"));
            WebElement firstName_ = wait.until(ExpectedConditions.elementToBeClickable(firstName));
//                Thread.sleep(2000);
            firstName_.sendKeys(FName);

            WebElement Lastname = Configuration.driver.findElement(By.xpath("//*[@name='lastName']"));
            WebElement Lastname_ = wait.until(ExpectedConditions.elementToBeClickable(Lastname));

//                Thread.sleep(2000);
            Lastname_.sendKeys(LName);


            WebElement Business_Registration = Configuration.driver.findElement(By.xpath("//input[@name='BB_Business_Registration_Number__c']"));
            WebElement Business_Registration_ = wait.until(ExpectedConditions.elementToBeClickable(Business_Registration));
//                Thread.sleep(2000);
            Business_Registration_.sendKeys(Registration_number);

            WebElement SA_ID = Configuration.driver.findElement(By.xpath("//input[@name='BB_SA_ID_Number__pc']"));
            WebElement SA_ID_ = wait.until(ExpectedConditions.elementToBeClickable(SA_ID));

            Thread.sleep(2000);
            SA_ID_.sendKeys(id);


        }

    }

public static void KYC_Validation(String status) throws InterruptedException {


    Thread.sleep(2000);
    WebElement combo_btn = Configuration.driver.findElement(By.xpath("//input[contains(@name,'BB_Relationship_Manager__pc')]"));
    WebElement combo_btn_ = wait.until(ExpectedConditions.elementToBeClickable(combo_btn));

    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", combo_btn_);


    List<WebElement> KYC_flag = Configuration.driver.findElements(By.xpath("//*[contains(@aria-label,'Entity KYC Flag')]"));

    WebElement KYC_btn1 = KYC_flag.get(0);

    WebElement KYC_flag_ = wait.until(ExpectedConditions.elementToBeClickable(KYC_btn1));

    Thread.sleep(2000);

    KYC_flag_.click();


    if (status.equals("Yes")) {
        WebElement YesNO = Configuration.driver.findElement(By.xpath("//*[contains(@data-value,'Yes')]"));
        WebElement coYesNO_ = wait.until(ExpectedConditions.elementToBeClickable(YesNO));

        coYesNO_.click();

    } else {

        WebElement YesNO = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-item[contains(@data-value,'No')]"));
        WebElement coYesNO_ = wait.until(ExpectedConditions.elementToBeClickable(YesNO));

        coYesNO_.click();


    }


    WebElement datePickerIcon = Configuration.driver.findElement(By.xpath("//*[contains(@name,'BB_KYC_Date_Change__pc')]"));

    datePickerIcon.click();


    WebElement dateElement = Configuration.driver.findElement(By.xpath("//span[contains(@class, 'day') and text()='2' and not(contains(@class, 'slds-disabled-text'))]"));
    dateElement.click();





    SystemInformation();



    WebElement save = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
    save.click();

Thread.sleep(2000);
    WebElement flagElement;
    if (status.equals("Yes")) {
        flagElement = Configuration.driver.findElement(By.xpath("//img[@alt='Green Flag']"));
    } else {
        flagElement = Configuration.driver.findElement(By.xpath("//img[@alt='Red Flag']"));
    }
    WebElement flag_ = wait.until(ExpectedConditions.elementToBeClickable(flagElement));

    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", flag_);

    String src = flagElement.getAttribute("src");

    FlagState flagState = FlagState.fromSrc(src);

    if (status.equals("Yes") && flagState == FlagState.GREEN) {
        System.out.println("Validation passed: Flag is green.");
    } else if (status.equals("No") && flagState == FlagState.RED) {
        System.out.println("Validation passed: Flag is red.");
    } else {
        System.out.println("Validation failed: Unexpected flag state.");
    }
}


public static void SystemInformation()
{


    List<WebElement> DirectMarketing = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value')]"));

    if (!DirectMarketing.isEmpty()) {

        WebElement marketing = DirectMarketing.get(8);

        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", marketing);
        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(marketing));

        EleWait.click();

        WebElement optionYes = Configuration.driver.findElement(By.xpath("//span[contains(@title, 'Yes')]"));
        optionYes.click();
//
//        Select dropdown = new Select(marketing);
//
//
//        dropdown.selectByIndex(1);
    } else {
        System.out.println("No select elements found.");
    }

    List<WebElement> PersonalizedMarketing = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value')]"));

    if (!PersonalizedMarketing.isEmpty()) {

        WebElement marketing = PersonalizedMarketing.get(9);

        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", marketing);
        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(marketing));
        EleWait.click();

        List<WebElement> optionYes = Configuration.driver.findElements(By.xpath("//span[contains(@title, 'Yes')]"));
      WebElement option =  optionYes.get(1);
        option.click();
    } else {
        System.out.println("No select elements found.");
    }


    String Registration_number = generateRandomRegistrationNumber();

    WebElement cif = Configuration.driver.findElement(By.xpath("//input[contains(@name, 'BB_CIF_Number__c')]"));
    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", cif);
    WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(cif));
    EleWait.sendKeys(Registration_number);


    WebElement ManagerCode = Configuration.driver.findElement(By.xpath("//input[contains(@name, 'Manager_Code__pc')]"));
    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", ManagerCode);
    WebElement ManagerCode_ = wait.until(ExpectedConditions.elementToBeClickable(ManagerCode));
    ManagerCode_.sendKeys("924001");



    WebElement BranchCode = Configuration.driver.findElement(By.xpath("//input[contains(@name, 'FinServ__BranchCode__c')]"));
    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", BranchCode);
    WebElement BranchCode_ = wait.until(ExpectedConditions.elementToBeClickable(BranchCode));
    BranchCode_.sendKeys("240");


}
 public static void Consent() throws InterruptedException {

     Thread.sleep(3000);


     WebElement UpdateConsent = Configuration.driver.findElement(By.xpath("//*[contains(@name, 'Account.Update_Consent')]"));
     ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", UpdateConsent);
     WebElement UpdateConsent_ = wait.until(ExpectedConditions.elementToBeClickable(UpdateConsent));
     ((JavascriptExecutor) Configuration.driver).executeScript("window.scrollTo(0, 0);");
     Thread.sleep(3000);
     UpdateConsent_.click();
     Thread.sleep(3000);

 }










}




















