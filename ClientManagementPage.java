package pages;

import co.za.capitecbank.testing.pages.BasePage;
import co.za.capitecbank.testing.utilities.EmailOTP;
import co.za.capitecbank.testing.utilities.Misc;
import com.github.mkolisnyk.cucumber.reporting.utils.helpers.JsonUtils;
import config.Configuration;


import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static co.za.capitecbank.testing.utilities.EmailOTP.wait;

public class ClientManagementPage extends BasePage {

    static JavascriptExecutor jsDriver = (JavascriptExecutor) Configuration.driver;
    public static WebElement lastElement;
    public static Actions actions;
    private static int randomNum;
    private static WebDriverWait wait;
    public static String lastName;

    //public static  String id = Misc.generateRandomIDNumber();
    public static String id = Misc.generateRandomIDNumber();

    public static void Case_Tab() throws InterruptedException {


        Thread.sleep(1000);
        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            try {
                closeButton.click();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }

        wait = new WebDriverWait(Configuration.driver, 30);
        // Thread.sleep(2000);
        Actions actions = new Actions(Configuration.driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement clickableMenu = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));

        Thread.sleep(2000);
        clickableMenu.click();

        WebElement btn_case = Configuration.driver.findElement(By.xpath("//a[@data-label='Cases']"));

        WebElement clickableCase = wait.until(ExpectedConditions.elementToBeClickable(btn_case));


//        Thread.sleep(2000);
        clickableCase.click();

//        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Cases']"));
//        WebElement clickableCases = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
////        Thread.sleep(2000);
//        clickableCases.click();


    }

    public static void New_case() throws InterruptedException {


        try {

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 30);
            WebElement btn_New = Configuration.driver.findElement(By.xpath("//a[@title='New']"));
            WebElement new_btn = wait.until(ExpectedConditions.elementToBeClickable(btn_New));
            new_btn.click();
        } catch (Exception e) {


            System.out.println("New button not available  " + e.getMessage());


            WebElement btn_case = Configuration.driver.findElement(By.xpath("//a[contains(@title,'Cases')]"));
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

    public static void ExistingContact_Name() throws InterruptedException
    {


        Thread.sleep(2000);
        List<WebElement> matchingElements = Configuration.driver.findElements(By.xpath("//*[contains(@placeholder, 'Search Contacts...')]"));

        if (matchingElements.size() == 1) {
            WebElement btnToClick = matchingElements.get(0);
            WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
            btnToClick_.click();


            btnToClick_.sendKeys("Mugabe");
            Thread.sleep(2000);
            //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Hart']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);

            Thread.sleep(2000);

        } else if (matchingElements.size() > 1) {
            WebElement button_new = matchingElements.get(1);
            WebElement button_new_ = wait.until(ExpectedConditions.elementToBeClickable(button_new));
            button_new_.click();



            button_new_.sendKeys("Mugabe");
            Thread.sleep(2000);
            //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Mugabe']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);
            //EleWait2.click();
        }
    }
    public static void ExistingClient_Name() throws InterruptedException
    {
        Thread.sleep(2000);
        List<WebElement> matchingElements = Configuration.driver.findElements(By.xpath("//*[contains(@placeholder, 'Search Clients...')]"));

        if (matchingElements.size() == 1) {
            WebElement btnToClick = matchingElements.get(0);
            WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
            btnToClick_.click();


            btnToClick_.sendKeys("Mugabe");
            Thread.sleep(2000);
            //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Mugabe']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);

            Thread.sleep(2000);

        } else if (matchingElements.size() > 1) {
            WebElement button_new = matchingElements.get(1);
            WebElement button_new_ = wait.until(ExpectedConditions.elementToBeClickable(button_new));
            button_new_.click();



            button_new_.sendKeys("Mugabe");
            Thread.sleep(2000);
            //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Mugabe']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);
            //EleWait2.click();
        }
    }
    public static void Client_Name() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);

        Thread.sleep(4000);
        WebElement btn_new = Configuration.driver.findElement(By.xpath("//*[contains(@placeholder,'Search Clients')]"));
        WebElement btn_newName = wait.until(ExpectedConditions.elementToBeClickable(btn_new));

        Thread.sleep(2000);

        btn_newName.click();


//        String commonIdPart = "dropdown-element-";
//        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@id, '" + commonIdPart + "')]"));
        Thread.sleep(4000);
        String commonIdPart = "actionCreateNew";
        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));
        WebElement dynamicElewait = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));

        if (dynamicElewait != null) {

            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("arguments[0].scrollIntoView();", dynamicElewait);
            Thread.sleep(1000);

            dynamicElewait.click();
        }
        Thread.sleep(2000);
//        List<WebElement> NewClient = Configuration.driver.findElements(By.xpath(xpath));
//
//        if (NewClient.size() == 1) {
//
//            lastElement = NewClient.get(0);
//
//
//            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//            js.executeScript("arguments[0].scrollIntoView();", lastElement);
//
//
//            js.executeScript("arguments[0].click();", lastElement);
//
//
//
//        } else if (NewClient.size() > 1) {
//
//            lastElement = NewClient.get(NewClient.size() - 1);
////         actions = new Actions(Configuration.driver);
////            actions.moveToElement(lastElement).click().build().perform();
//        }

    }

    public static void CheckRecordType(String RecordType) throws InterruptedException {


        wait = new WebDriverWait(Configuration.driver, 60);
        String Registration_number = generateRandomRegistrationNumber();
        //    String id = Misc.generateRandomIDNumberSA("891103", "Female");


        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;

        Faker faker = new Faker(new Locale("en-ZA"));
        String FName = faker.name().firstName();
        String LName = faker.name().lastName();

        String[] title_ = {"Mr.", "Mrs.", "Ms."};
        String Title = GetRandomTitle(title_);


        lastName = faker.name().lastName();

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
            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--neutral slds-button slds-button_brand uiButton')]"));
            WebElement nextclickable = wait.until(ExpectedConditions.elementToBeClickable(Next));

            Thread.sleep(2000);

            nextclickable.click();
            Thread.sleep(2000);
            WebElement RegClientName = Configuration.driver.findElement(By.xpath("//*[@name='Name']"));
            WebElement RegClientNameC = wait.until(ExpectedConditions.elementToBeClickable(RegClientName));
            Thread.sleep(2000);
            RegClientNameC.sendKeys(lastName);

            WebElement BusinessRegc = Configuration.driver.findElement(By.xpath("//input[@name='BB_Business_Registration_Number__c']"));
            WebElement RegClientName_ = wait.until(ExpectedConditions.elementToBeClickable(BusinessRegc));
//                Thread.sleep(2000);
            RegClientName_.sendKeys(Registration_number);


//                WebElement save = Configuration.driver.findElement(By.xpath("//*[@data-target-selection-name='sfdc:StandardButton.Account.SaveEdit']"));
            Thread.sleep(2000);
//                save.click();

            List<WebElement> save_btn = Configuration.driver.findElements(By.xpath("//*[@name='SaveEdit']"));

            WebElement save_btn1 = save_btn.get(1);
            WebElement save_btn_ = wait.until(ExpectedConditions.elementToBeClickable(save_btn1));
//                Thread.sleep(2000);

            save_btn_.click();
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


            WebElement Next = Configuration.driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--neutral slds-button slds-button_brand uiButton')]"));
            WebElement Next_ = wait.until(ExpectedConditions.elementToBeClickable(Next));
//                Thread.sleep(2000);
            Next_.click();

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

            List<WebElement> save_btn = Configuration.driver.findElements(By.xpath("//*[@name='SaveEdit']"));

            WebElement save_btn1 = save_btn.get(1);

            WebElement RSA_ID_ = wait.until(ExpectedConditions.elementToBeClickable(save_btn1));

            Thread.sleep(2000);

            RSA_ID_.click();
            Thread.sleep(9000);
        }

    }

    public static String generateRandomRegistrationNumber() {
        Random random = new Random();
        StringBuilder registrationNumber = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            if (i < 2) {
                registrationNumber.append("0");
            } else {
                int digits = random.nextInt(10);
                registrationNumber.append(digits);

            }

        }

        return registrationNumber.toString();
    }


    public static void EnterID() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);

        //    String ID = Misc.generateRandomIDNumberSA("881206", "Male");
        //  String ID = "8707069016089";

        WebElement SA_ID = Configuration.driver.findElement(By.xpath("//*[@name='SA_ID__c']"));
        WebElement SA_ID_ = wait.until(ExpectedConditions.elementToBeClickable(SA_ID));

//            Thread.sleep(2000);
        SA_ID_.sendKeys(id);

    }

    public static void ContactDetails() throws InterruptedException {



        Thread.sleep(300);


//        List<WebElement> rodio_btn = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-radio--faux')]"));
//
//        WebElement g = rodio_btn.get(0);
//      //  WebElement g2 = rodio_btn.get(4);
//        WebElement gclickable = wait.until(ExpectedConditions.elementToBeClickable(g));
//       // WebElement g2clickable = wait.until(ExpectedConditions.elementToBeClickable(g2));
//
//
//            gclickable.click();
        List<WebElement> Next = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button--neutral slds-button slds-button_brand uiButton')]"));

        if (!Next.isEmpty()) {
            WebElement next = Next.get(0);

            next.click();

        }


        wait = new WebDriverWait(Configuration.driver, 60);


        Faker faker = new Faker(new Locale("en-ZA"));
        String FName = faker.name().firstName();
        String Emailadress = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();

        //  String title = faker.name().title();
        String[] title_ = {"Mr.", "Mrs.", "Ms."};
        String title = GetRandomTitle(title_);

        Thread.sleep(2000);

        WebElement Salutation = Configuration.driver.findElement(By.xpath("//button[@name='salutation']"));
        WebElement salutation_ = wait.until(ExpectedConditions.elementToBeClickable(Salutation));

//        Thread.sleep(2000);
        salutation_.click();

        String commonIdPart = title;
        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));
        WebElement Clickable_DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));

        if (Clickable_DynamicEle != null) {

            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("arguments[0].scrollIntoView();", Clickable_DynamicEle);


            Clickable_DynamicEle.click();
        }
        Thread.sleep(2000);

//        WebElement parentElement = Configuration.driver.findElement(By.xpath("//button[contains(@data-value, " + Title + "')]"));
//
//        Select titleSelect = new Select(parentElement);
//
//        titleSelect.selectByVisibleText(Title);

        WebElement lastN = Configuration.driver.findElement(By.xpath("//input[@name='lastName']"));
        WebElement Lastname = wait.until(ExpectedConditions.elementToBeClickable(lastN));

        Thread.sleep(2000);
        Lastname.sendKeys(lastName);

        WebElement ID = Configuration.driver.findElement(By.xpath(" //*[contains(@name, 'SA_ID_Number')]"));
        WebElement idNum = wait.until(ExpectedConditions.elementToBeClickable(ID));
        Thread.sleep(2000);
        idNum.sendKeys(id);

        WebElement cell = Configuration.driver.findElement(By.xpath(" //input[@name='Phone']"));
        WebElement CellNumber = wait.until(ExpectedConditions.elementToBeClickable(cell));
        Thread.sleep(2000);
        CellNumber.sendKeys(phone);

        WebElement email = Configuration.driver.findElement(By.xpath(" //input[@name='Email']"));
        WebElement Email2 = wait.until(ExpectedConditions.elementToBeClickable(email));

        Thread.sleep(2000);
        Email2.sendKeys(Emailadress);


//        Thread.sleep(2000);
//        List<WebElement> matchingElements = Configuration.driver.findElements(By.xpath("//*[contains(@placeholder, 'Search Clients...')]"));
//
//        if (matchingElements.size() == 1) {
//            WebElement btnToclick = matchingElements.get(0);
//            WebElement btnToclick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToclick));
//            btnToclick_.click();
//
//        } else if (matchingElements.size() > 1) {
//            WebElement button_new = matchingElements.get(1);
//            WebElement button_new_ = wait.until(ExpectedConditions.elementToBeClickable(button_new));
//
//            button_new_.click();
//
//        }


        Thread.sleep(2000);
        List<WebElement> matchingElements = Configuration.driver.findElements(By.xpath("//*[contains(@placeholder, 'Search Clients...')]"));

        if (matchingElements.size() == 1) {
            WebElement btnToClick = matchingElements.get(0);
            WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
            btnToClick_.click();


            btnToClick_.sendKeys("Mugabe");
            Thread.sleep(4000);
        //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Mugabe']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);

//
//            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//            WebElement divElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown-element-1394")));
//
//
//            WebElement mugabeElement = divElement.findElement(By.xpath(".//span[contains(text(),'Mugabe')]"));
//
//
//            mugabeElement.click();
//
//
//
//
//
//
//
//
//
//            WebElement element = Configuration.driver.findElement(By.xpath("//*[contains(@data-value,'Mugabe')]"));
//
//            Actions actions = new Actions(Configuration.driver);
//            actions.moveToElement(element).click().build().perform();
//
//
//            WebElement AppNames = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@data-value,'Mugabe')]")));
//
//
//
//            actions.moveToElement(AppNames).click().perform();
//
//
//
//
//            WebElement AppName = Configuration.driver.findElement(By.xpath("//*[contains(@data-value,'Mugabe')]"));
//            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));
//
//
//
//            Thread.sleep(2000);
//            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", EleWait2);
//            EleWait2.click();
//
            Thread.sleep(2000);

        } else if (matchingElements.size() > 1) {
            WebElement button_new = matchingElements.get(1);
            WebElement button_new_ = wait.until(ExpectedConditions.elementToBeClickable(button_new));
            button_new_.click();



            button_new_.sendKeys("Mugabe");
            Thread.sleep(2000);
            //    btnToClick_.sendKeys(Keys.ENTER);


            WebElement AppName = Configuration.driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='Mugabe']"));
            WebElement EleWait2 = wait.until(ExpectedConditions.visibilityOf(AppName));


            Thread.sleep(2000);
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", EleWait2);
            //EleWait2.click();
        }


//*[contains(@data-value,'Mugabe')]


//--------------------------------
//        Thread.sleep(2000);
//
//        List<WebElement> existingClientNames = Configuration.driver.findElements(By.xpath("//li[contains(@class, 'slds-listbox__item')]//span[contains(@class, 'slds-truncate')]"));
//
//        if (!existingClientNames.isEmpty()) {
//            WebElement elementToClick = existingClientNames.get(0);
//            String text = elementToClick.getText();
//            JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;
//            int attempts = 0;
//            boolean clicked = false;
//            while (attempts < 3 && !clicked) {
//                try {
//                    executor.executeScript("arguments[0].click();", elementToClick);
//                    clicked = true;
//                } catch (Exception e) {
//                    System.out.println("Failed to click, retrying");
//                    Thread.sleep(2000);
//                    existingClientNames = Configuration.driver.findElements(By.xpath("//li[contains(@class, 'slds-listbox__item')]//span[contains(@class, 'slds-truncate')]"));
//                    if (!existingClientNames.isEmpty()) {
//                        elementToClick = existingClientNames.get(0);
//                    } else {
//                        System.out.println("No items found in the list.");
//                        break;
//                    }
//                }
//                attempts++;
//            }
//            if (!clicked) {
//                System.out.println("Failed to click after 3 attempts");
//            }
//        } else {
//            System.out.println("No items found in the list");
//        }
//
//        Thread.sleep(2000);

//--------------------------------
//        if (!existingClientNames.isEmpty()) {
//            boolean lastNameFound = false;
//            for (WebElement element : existingClientNames) {
//                String existingName = element.getAttribute("title").trim();
//
//
//                if (existingName.contains(lastName)) {
//                    WebElement btnToClick = wait.until(ExpectedConditions.elementToBeClickable(element));
//                    btnToClick.click();
//                    lastNameFound = true;
//                    break;
//                }
//            }
//
//
//            if (!lastNameFound) {
//                WebElement firstElement = existingClientNames.get(0);
//                WebElement btnToClick = wait.until(ExpectedConditions.elementToBeClickable(firstElement));
//                btnToClick.click();
//            }
//        } else {
//            System.out.println("No elements found in the list.");
//        }

        Thread.sleep(4000);


        List<WebElement> save_btn = Configuration.driver.findElements(By.xpath("//*[@name='SaveEdit']"));

        WebElement save_btn1 = save_btn.get(1);
        WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(save_btn1));

//        Thread.sleep(2000);
        Thread.sleep(2000);
        Save.click();
        Thread.sleep(5000);
    }

    public static void existingCase() throws InterruptedException {
        Thread.sleep(2000);


        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@data-refid,'recordId')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            Thread.sleep(1000);
            EleWait.click();

        }
        Thread.sleep(2000);

    }

    public static void ChangeOwner() throws InterruptedException {

        Thread.sleep(3000);
        Faker faker = new Faker(new Locale("en-ZA"));

        String id = Misc.generateRandomIDNumberSA("891103", "Female");


        String Fname = faker.name().firstName();
        String Lname = faker.name().lastName();

        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
        List<WebElement> dropdown = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon-border-filled')]"));

        if (!dropdown.isEmpty()) {
            WebElement convert = dropdown.get(0);

            try {
                Thread.sleep(3000);
                WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(convert));
                Thread.sleep(5000);
                elaWait.click();
            } catch (Exception e) {

                System.out.println("StaleElementReferenceException");
                dropdown = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon-border-filled')]"));
                if (!dropdown.isEmpty()) {
                    WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(dropdown.get(0)));
                    Thread.sleep(5000);
                    elaWait.click();
                } else {
                    System.out.println("Element not found after retry.");
                }
            }
        }

        WebElement MigrateCaseToLead = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Migrate Case to Lead')]"));

        WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(MigrateCaseToLead));

        elaWait.click();

        Thread.sleep(2000);


        WebElement MigrationReason = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label,'Migration Reason - Current Selection: --None--')]"));
        MigrationReason.click();

        List<WebElement> options = Configuration.driver.findElements(By.xpath("//*[contains(@aria-label, 'Migration Reason')]"));
        options.get(1).click();


        WebElement textarea = Configuration.driver.findElement(By.xpath("//textarea[contains(@class, 'slds-textarea')]"));


        textarea.sendKeys("Test");






        List<WebElement> next_1 = Configuration.driver.findElements(By.xpath("//*[contains(@class, 'slds-button flow-button__NEXT')]"));

        if (!next_1.isEmpty()) {
            WebElement Next_ = next_1.get(1);

            Next_.click();

        }



        Thread.sleep(3000);





        WebElement LeadFirstName = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Lead_First_Name')]"));
LeadFirstName.sendKeys(Fname);


//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", LeadFirstName);
//        actions.moveToElement(LeadFirstName).click().sendKeys(Fname).perform();


        WebElement LeadLastName = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Lead_Last_Name')]"));
        LeadLastName.sendKeys(Lname);

//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", LeadLastName);
//        actions.moveToElement(LeadLastName).click().sendKeys(Lname).perform();


//        List<WebElement> LeadProductInterest = Configuration.driver.findElements(By.xpath("//*[contains(@name, 'Lead_Product_Interest')]"));
//        LeadProductInterest.get(0).click();


        WebElement selectElement = Configuration.driver.findElement(By.xpath("//*[contains(@name, 'Lead_Product_Interest')]"));
        selectElement.click();

        Thread.sleep(1000);

        Select select = new Select(selectElement);
        select.selectByVisibleText("Credit");


        WebElement businesstype = Configuration.driver.findElement(By.xpath("//*[contains(@name, 'Business_Type')]"));
        businesstype.click();

        Thread.sleep(1000);

        Select select1 = new Select(businesstype);
        select1.selectByVisibleText("Sole Proprietor");





        WebElement ID = Configuration.driver.findElement(By.xpath("//*[contains(@name,'South_African_Identity_Number')]"));
        ID.sendKeys(id);

//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", ID);
//        actions.moveToElement(ID).click().sendKeys(id).perform();


//    List<WebElement> convertButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_brand')]"));
//
//    if (!convertButtons.isEmpty()) {
//        WebElement convertButton;
//
//        if (convertButtons.size() > 1) {
//            convertButton = convertButtons.get(1);
//        } else {
//            convertButton = convertButtons.get(0);
//        }
//
//        WebElement eleWait = wait.until(ExpectedConditions.elementToBeClickable(convertButton));
//        eleWait.click();
//    } else {
//
//        System.out.println("No convert button found");
//    }


        List<WebElement> Nexts = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_brand')]"));

        if (!Nexts.isEmpty()) {
            WebElement lastNext = Nexts.get(Nexts.size() - 1);
            lastNext.click();
        }


//-----

//        WebElement AmountClaims = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Amount_Claimes')]"));
//
//
//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", AmountClaims);
//
//
//        Actions actions = new Actions(Configuration.driver);
//        actions.moveToElement(AmountClaims).click().sendKeys("2000").perform();
//
//
//        WebElement TotalClaimed = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Total_Claimed_Case')]"));
//
//
//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", TotalClaimed);
//
//
//        actions.moveToElement(TotalClaimed).click().sendKeys("3000").perform();

//        List<WebElement> Next = Configuration.driver.findElements(By.xpath("//button[contains(text(),'Next')]"));
//
//        if (!Next.isEmpty()) {
//            WebElement next1 = Next.get(1);
//
//            next1.click();
//
//        }


        Thread.sleep(8000);
    }


    public static String GetRandomTitle(String[] titles) {
        Random random = new Random();

        int index = random.nextInt(titles.length);
        return titles[index];
    }

    public static void Contact_Name_() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 60);

        Thread.sleep(2000);
        WebElement btn_new = Configuration.driver.findElement(By.xpath("//label[text()='Contact Name']"));

        WebElement BtnNew = wait.until(ExpectedConditions.elementToBeClickable(btn_new));
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", BtnNew);

        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(BtnNew).click().perform();

        Thread.sleep(4000);
        List<WebElement> DropdownItem = Configuration.driver.findElements(By.xpath("//li[contains(@class, 'slds-listbox__item')]"));
        WebElement lastdropdownitem = DropdownItem.get(DropdownItem.size() - 1);
        WebElement dynamicDropdown = wait.until(ExpectedConditions.elementToBeClickable(lastdropdownitem));
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", dynamicDropdown);

        Thread.sleep(8000);

        String commonIdPart = "actionCreateNew";
        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("(//*[contains(@data-value, '" + commonIdPart + "')])[2]"));
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", dynamicElement);

//        WebElement dynamicElement = null;
//        for (int attempts = 0; attempts < 3; attempts++) {
//            try {
//                dynamicElement = Configuration.driver.findElement(By.xpath("(//*[contains(@data-value, '" + commonIdPart + "')])[2]"));
//                ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", dynamicElement);
//                actions.moveToElement(dynamicElement).click().perform();
//                break;
//            } catch (Exception e) {
//                System.out.println("Failed to click, retrying...");
//            }
//        }




//        Thread.sleep(4000);
//        WebElement lastDropdownItem = dropdownItems.get(dropdownItems.size() - 1);
//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", lastDropdownItem);
//

//        Thread.sleep(4000);
//        String commonIdPart = "actionCreateNew";
//        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));
//        WebElement dynamicElewait = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));
//
//        if (dynamicElewait != null) {
//            try {
//                dynamicElewait.click();
//            } catch (Exception e) {
//                System.out.println("Exception occurred: " + e.getMessage());
//            }
//        }
//        Thread.sleep(2000);
    }

    public static void Contact_Name() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 60);

        Thread.sleep(2000);
        WebElement btn_new = Configuration.driver.findElement(By.xpath("//label[text()='Contact Name']"));

        WebElement BtnNew = wait.until(ExpectedConditions.elementToBeClickable(btn_new));
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", BtnNew);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(BtnNew).click().perform();


        Thread.sleep(20000);
        String commonIdPart = "actionCreateNew";

        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));
        WebElement dynamicElewait = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));

        if (dynamicElewait != null) {
            Thread.sleep(4000);
            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", dynamicElewait);
            Thread.sleep(4000);
            actions.moveToElement(dynamicElewait).click().perform();

//
//
//            dynamicElewait.click();
        }
        Thread.sleep(2000);


//--------------

//        Thread.sleep(5000);
//
//        WebElement inlinePanel = Configuration.driver.findElement(By.xpath("//*[contains(@class,'inlinePanel oneRecordActionWrapper')]"));
//
//
//        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' });", inlinePanel);
//
//
//        JavascriptExecutor jse = (JavascriptExecutor) Configuration.driver;
//
//        Thread.sleep(4000);
//
//        List<WebElement> newElement = Configuration.driver.findElements(By.xpath("//*[@data-value='actionCreateNew']"));
//
//        WebElement newBtn;
//
//        if (newElement.size() < 1) {
//
//            System.out.println("No elements found ");
//        } else {
//            if (newElement.size() == 1) {
//                newBtn = newElement.get(0);
//            } else {
//                newBtn = newElement.get(1);
//            }
//
//
//            jse.executeScript("arguments[0].scrollIntoView();", newBtn);
//            Thread.sleep(4000);
//
//            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//            WebElement newElementClickable = wait.until(ExpectedConditions.elementToBeClickable(newBtn));
//
//            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", newElementClickable);
//
//
//            Actions actions = new Actions(Configuration.driver);
//            actions.moveToElement(newElementClickable).click().perform();


        //    Thread.sleep(5000);


        //newElementClickable.click();
    }


//        List<WebElement> dropdownElements = Configuration.driver.findElements(By.xpath("//*[@id='dropdown-element-933']/ul/li"));
//
//        for (WebElement element : dropdownElements) {
//            String text = element.getAttribute("data-value");
//
//
//            if (text != null && text.trim().equalsIgnoreCase("actionCreateNew")) {
//                JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//                js.executeScript("arguments[0].scrollIntoView();", element);
//
//                Thread.sleep(2000);
//                element.click();
//                break;
//            }
//        }

//        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//span[text()='New Contact']"));
//        js0.executeScript("arguments[0].scrollBy(0, 250);", dynamicElement);
//        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));
//
//
//        if (BtnDynamicEle != null) {
//
//            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//            js.executeScript("arguments[0].scrollIntoView();", BtnDynamicEle);
//
//            Thread.sleep(2000);
//            BtnDynamicEle.click();
//        }


//        Thread.sleep(2000);

//        Thread.sleep(2000);
//
    //   WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//span[text()='New Contact']"));
//        dynamicElement.click();

//        if (dynamicElement != null) {
//
//            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//            js.executeScript("arguments[0].scrollIntoView();", dynamicElement);
//

//            dynamicElement.click();
//        }
//        List<WebElement> NewClient = Configuration.driver.findElements(By.xpath(xpath));
//
//        if (NewClient.size() == 1) {
//
//            lastElement = NewClient.get(0);
//
//
//            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//            js.executeScript("arguments[0].scrollIntoView();", lastElement);
//
//
//            js.executeScript("arguments[0].click();", lastElement);
//
//
//
//        } else if (NewClient.size() > 1) {
//
//            lastElement = NewClient.get(NewClient.size() - 1);
////         actions = new Actions(Configuration.driver);
////            actions.moveToElement(lastElement).click().build().perform();
//        }


//    public static int generateRandomSevenDigitNumber() {
//        Random rand = new Random();
//        randomNum = rand.nextInt(9000) + 1000;
//        return randomNum;
//    }


    public static void iClickSave() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement save2 = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(save2));
        BtnDynamicEle.click();
        Thread.sleep(5000);
    }


    public static void verifySuccessfulClientCreation() {

        try {

//            Thread.sleep(8000);
//
//            Assert.assertTrue(true);

//            wait = new WebDriverWait(Configuration.driver, 30);
//            WebElement VerifyClientName = Configuration.driver.findElement(By.xpath("//span[@id='window']"));
//         //   a[contains(@class, 'flex-wrap-ie11')]//span[text()='Frans Watson']

            wait = new WebDriverWait(Configuration.driver, 30);
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("window.scrollBy(0, 100);");

            Thread.sleep(2000);

            List<WebElement> Case_ClientName = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));

            WebElement clientName = Case_ClientName.get(2);
            wait.until(ExpectedConditions.visibilityOf(clientName));
            Thread.sleep(2000);
            String textName = clientName.getText();

            Assert.assertFalse(textName.isEmpty(), "The element is empty");

            Thread.sleep(2000);


            List<WebElement> Case_Owner = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));

            WebElement OwnerName = Case_Owner.get(1);

            String textOwner = OwnerName.getText();
            Thread.sleep(8000);
            Assert.assertFalse(textOwner.isEmpty(), "The element is empty");

            Thread.sleep(8000);

            List<WebElement> Contact_Name = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));

            WebElement ContactName = Contact_Name.get(4);

            String textContact = ContactName.getText();
            Thread.sleep(8000);
            Assert.assertFalse(textContact.isEmpty(), "The element is empty");

            List<WebElement> Case_number = Configuration.driver.findElements(By.xpath("//*[contains(@id, 'sectionContent-')]/div/slot/records-record-layout-row[1]/slot/records-record-layout-item[1]/div/div/dl/dd/div/span"));

            WebElement CaseName = Case_number.get(1);

            String textCase = CaseName.getText();
            Thread.sleep(8000);
            Assert.assertFalse(textCase.isEmpty(), "The element is empty");

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }


    }

    public static void iSelectCaseTypeAs(String CaseType) throws InterruptedException {
        Thread.sleep(2000);

//        WebElement element = Configuration.driver.findElement(By.xpath("//*[@id='brandBand_2']/div/div/div"));
//        JavascriptExecutor js9 = (JavascriptExecutor) Configuration.driver;
//        js9.executeScript("arguments[0].scrollTop += 200;", element);


        List<WebElement> caseDown = Configuration.driver.findElements(By.xpath("//*[contains(@id, 'brandBand')]/div/div/div"));

        WebElement caseDown2 = caseDown.get(1);
        JavascriptExecutor js9 = (JavascriptExecutor) Configuration.driver;
        js9.executeScript("arguments[0].scrollTop += 200;", caseDown2);



        if (CaseType.equals("Complaint")) {
            WebElement Case_type = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Category - Current Selection: --None--')]"));
            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("arguments[0].scrollIntoView();", Case_type);

            Case_type.click();

            WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + CaseType + "')]"));

            if (dynamicElement != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElement);
                dynamicElement.click();
            }
            Thread.sleep(2000);
            WebElement Case_category = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Category - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js3 = (JavascriptExecutor) Configuration.driver;
            js3.executeScript("arguments[0].scrollIntoView();", Case_category);

            Case_category.click();

            String commonIdParts = "Credit";
            WebElement dynamicElements = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdParts + "')]"));

            if (dynamicElements != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElements);
                dynamicElements.click();
            }


            Thread.sleep(2000);
            WebElement Case_sub = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Sub Category - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js4 = (JavascriptExecutor) Configuration.driver;
            js4.executeScript("arguments[0].scrollIntoView();", Case_sub);

            Case_sub.click();

            String commonIdPart = "Bond Accounts";
            WebElement dynamicElement2 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart + "')]"));

            if (dynamicElements != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElement2);
                dynamicElement2.click();
            }
            Thread.sleep(2000);
            WebElement Case_issue = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Issue - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js5 = (JavascriptExecutor) Configuration.driver;
            js5.executeScript("arguments[0].scrollIntoView();", Case_issue);

            Case_issue.click();

            Thread.sleep(2000);
            String commonIdPart3 = "Audit Certificate";
            WebElement dynamicElement3 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart3 + "')]"));

            if (dynamicElements != null) {
                JavascriptExecutor js6 = (JavascriptExecutor) Configuration.driver;
                js6.executeScript("arguments[0].scrollIntoView();", dynamicElement3);
                dynamicElement3.click();
            }
            Thread.sleep(2000);

        } else {

            WebElement Case_type_ = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Type - Current Selection: --None--')]"));
            Thread.sleep(2000);

            JavascriptExecutor js_ = (JavascriptExecutor) Configuration.driver;
            js_.executeScript("arguments[0].scrollIntoView();", Case_type_);

            Case_type_.click();

            WebElement dynamicElement_ = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + CaseType + "')]"));

            if (dynamicElement_ != null) {
                JavascriptExecutor js0_ = (JavascriptExecutor) Configuration.driver;
                js0_.executeScript("arguments[0].scrollIntoView();", dynamicElement_);
                dynamicElement_.click();
            }
            Thread.sleep(2000);
            WebElement Case_category_ = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Category - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js3 = (JavascriptExecutor) Configuration.driver;
            js3.executeScript("arguments[0].scrollIntoView();", Case_category_);

            Case_category_.click();

            String commonIdParts_ = "Credit (Query)";
            WebElement dynamicElements_ = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdParts_ + "')]"));

            if (dynamicElements_ != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElements_);
                dynamicElements_.click();
            }
            WebElement Case_category_1 = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Sub Category - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js6 = (JavascriptExecutor) Configuration.driver;
            js6.executeScript("arguments[0].scrollIntoView();", Case_category_1);

            Case_category_1.click();
            Thread.sleep(2000);
            String CommonIdPart = "Installment Finance (ISA) Account";
            WebElement DynamicElements = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + CommonIdPart + "')]"));

            if (DynamicElements != null) {
                JavascriptExecutor js7 = (JavascriptExecutor) Configuration.driver;
                js7.executeScript("arguments[0].scrollIntoView();", DynamicElements);
                DynamicElements.click();
            }


            WebElement Case_issue = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Issue - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js5 = (JavascriptExecutor) Configuration.driver;
            js5.executeScript("arguments[0].scrollIntoView();", Case_issue);

            Case_issue.click();
            Thread.sleep(2000);
            String commonIdPart3 = "Audit Certificate";
            WebElement dynamicElement3 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdPart3 + "')]"));

            if (dynamicElement3 != null) {
                JavascriptExecutor js6_ = (JavascriptExecutor) Configuration.driver;
                js6_.executeScript("arguments[0].scrollIntoView();", dynamicElement3);
                dynamicElement3.click();
            }
            Thread.sleep(2000);

            js9.executeScript("arguments[0].scrollTop += 200;", caseDown2);


            WebElement TCF = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'TCF Outcome - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js10 = (JavascriptExecutor) Configuration.driver;
            js10.executeScript("arguments[0].scrollIntoView();", TCF);

            TCF.click();

            String commonIdParts_3 = "Outcome 2 (a) - Product Design";
            WebElement dynamicElements_3 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdParts_3 + "')]"));

            if (dynamicElements_3 != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElements_3);
                dynamicElements_3.click();
            }


            WebElement rootCause = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Root Cause - Current Selection: --None--')]"));
            Thread.sleep(2000);
            JavascriptExecutor js11 = (JavascriptExecutor) Configuration.driver;
            js11.executeScript("arguments[0].scrollIntoView();", rootCause);

            rootCause.click();

            String commonIdParts_4 = "Capitec Error - Attitude";
            WebElement dynamicElements_4 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + commonIdParts_4 + "')]"));

            if (dynamicElements_4 != null) {
                JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
                js0.executeScript("arguments[0].scrollIntoView();", dynamicElements_4);
                dynamicElements_4.click();
            }

            WebElement AmountClaims = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Amount_Claimes')]"));


           // ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", AmountClaims);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(AmountClaims).click().sendKeys("2000").perform();


            WebElement TotalClaimed = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Total_Claimed__c')]"));


       //     ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", TotalClaimed);


            actions.moveToElement(TotalClaimed).click().sendKeys("3000").perform();




        }


    }

    public static void verifyMilestones() {

        try {


            Thread.sleep(7000);

          //  Assert.assertTrue(true);

            wait = new WebDriverWait(Configuration.driver, 30);
            Thread.sleep(5000);
            JavascriptExecutor js1 = (JavascriptExecutor) Configuration.driver;
            js1.executeScript("window.scrollBy(0, 808);");

            Thread.sleep(3000);
            WebElement element = Configuration.driver.findElement(By.className("milestoneTimerText"));
            String text = element.getText();

            Assert.assertFalse(text.isEmpty(), "The element is empty");



//            List<WebElement> Case_Status = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement Status = Case_Status.get(4);
//
//            String textStatus = Status.getText();
//
//            Assert.assertFalse(textStatus.isEmpty(), "The element is empty");
//
//            Thread.sleep(2000);
//
//            List<WebElement> Case_Type = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CaseType = Case_Type.get(5);
//
//            String textType = CaseType.getText();
//
//            Assert.assertFalse(textType.isEmpty(), "The element is empty");
//
//            Thread.sleep(2000);
//
//            List<WebElement> Case_Email = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CaseEmail = Case_Email.get(6);
//
//            String textEmail = CaseEmail.getText();
//
//            Assert.assertFalse(textEmail.isEmpty(), "The element is empty");
//            Thread.sleep(2000);
//
//            List<WebElement> Case_SubCategory = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CaseSub = Case_SubCategory.get(7);
//
//            String textSub = CaseSub.getText();
//
//            Assert.assertFalse(textSub.isEmpty(), "The element is empty");
//
//            Thread.sleep(2000);
//
//            List<WebElement> Case_Priority = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CasePriority = Case_Priority.get(9);
//
//            String textPriority = CasePriority.getText();
//
//            Assert.assertFalse(textPriority.isEmpty(), "The element is empty");
//
//            Thread.sleep(2000);
//
//            List<WebElement> Case_Issue = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CaseIssue = Case_Issue.get(9);
//
//            String textIssue = CaseIssue.getText();
//
//            Assert.assertFalse(textIssue.isEmpty(), "The element is empty");
//
//
//            Thread.sleep(2000);
//
//            List<WebElement> Subject = Configuration.driver.findElements(By.xpath("//lightning-formatted-text[@slot='outputField']"));
//
//            WebElement CaseISubject = Subject.get(10);
//
//            String textSubject = CaseISubject.getText();
//
//            Assert.assertFalse(textSubject.isEmpty(), "The element is empty");

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }


    }

    public static void iClickExistingCaseNumber() throws InterruptedException {
        Thread.sleep(5000);
        wait = new WebDriverWait(Configuration.driver, 20);
        WebElement existingCase = Configuration.driver.findElement(By.xpath("//*[contains(@data-refid ,'recordId')]"));
        WebElement gclickable = wait.until(ExpectedConditions.elementToBeClickable(existingCase));
//        JavascriptExecutor js5 = (JavascriptExecutor) Configuration.driver;
//        js5.executeScript("arguments[0].scrollIntoView();", existingCase);

        gclickable.click();


    }

    public static void iEditCaseStatusAsAndCaseTypeAs(String status, String CaseType) throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 30);

        List<WebElement> Statuses = Configuration.driver.findElements(By.xpath("//*[contains(@aria-controls, 'sectionContent-')]"));
        Thread.sleep(1000);
        WebElement statusSection = Statuses.get(0);

        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
        js.executeScript("arguments[0].scrollIntoView();", statusSection);
       // Thread.sleep(5000);
      //  js.executeScript("window.scrollBy(0, 400);");
        Thread.sleep(2000);


        WebElement Status = Configuration.driver.findElement(By.xpath("//*[contains(@title, 'Edit Status')]"));
        WebElement clickable_Status = wait.until(ExpectedConditions.elementToBeClickable(Status));
        clickable_Status.click();
        Thread.sleep(5000);

        WebElement Case_type_ = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Type - Current Selection: --None--')]"));
        Thread.sleep(2000);

        JavascriptExecutor js_ = (JavascriptExecutor) Configuration.driver;
       // js_.executeScript("arguments[0].scrollIntoView();", Case_type_);

        Case_type_.click();

        WebElement dynamicElement_ = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + CaseType + "')]"));

        if (dynamicElement_ != null) {
            JavascriptExecutor js0_ = (JavascriptExecutor) Configuration.driver;
            js0_.executeScript("arguments[0].scrollIntoView();", dynamicElement_);
            dynamicElement_.click();
        }




//        WebElement SelectStatus = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Status, ')]"));
//        WebElement clickable_ = wait.until(ExpectedConditions.elementToBeClickable(SelectStatus));
//        clickable_.click();
//        Thread.sleep(5000);
//        WebElement dynamicElement1 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + status + "')]"));
//        WebElement Dynamic_clickable = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement1));
//        if (Dynamic_clickable != null) {
//
//            jsDriver.executeScript("arguments[0].scrollIntoView();", Dynamic_clickable);
//            Dynamic_clickable.click();
//        }


//        Thread.sleep(2000);
//
//        WebElement SelectCategory = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Type, ')]"));
//        WebElement clickable_Category = wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));
//        clickable_Category.click();
//
//        Thread.sleep(5000);
//        WebElement dynamicElement3 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + Case_type + "')]"));
//        WebElement Category = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement3));
//        if (Category != null) {
//
//            jsDriver.executeScript("arguments[0].scrollIntoView();", Category);
//            Category.click();
//        }


        Thread.sleep(5000);

    }

    public static void iEditCaseCategoryAsAndCaseSubAsAndCaseIssueAs(String Case_Category, String Case_sub, String Case_Issue) throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 30);
        WebElement SelectCategory = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Category - Current Selection: --None--')]"));
        WebElement Category = wait.until(ExpectedConditions.elementToBeClickable(SelectCategory));
        Category.click();
        Thread.sleep(5000);

        WebElement dynamicElement3 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + Case_Category + "')]"));
        WebElement Dynamic = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement3));
        if (Dynamic != null) {

            jsDriver.executeScript("arguments[0].scrollIntoView();", Dynamic);
            Dynamic.click();
        }
        Thread.sleep(5000);
        WebElement Case = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Sub Category - Current Selection: --None--')]"));
        WebElement case_ = wait.until(ExpectedConditions.elementToBeClickable(Case));
        case_.click();

        Thread.sleep(5000);
        WebElement dynamicElement4 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + Case_sub + "')]"));
        WebElement Dynamic_ = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement4));
        if (Dynamic_ != null) {

            jsDriver.executeScript("arguments[0].scrollIntoView();", Dynamic_);
            Dynamic_.click();
        }
        Thread.sleep(2000);
        WebElement Case2 = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Issue - Current Selection: --None--')]"));
        WebElement Case_ = wait.until(ExpectedConditions.elementToBeClickable(Case2));
        Case_.click();
        Thread.sleep(2000);
        WebElement dynamicElement5 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + Case_Issue + "')]"));
        WebElement DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement5));
        if (DynamicEle != null) {

            jsDriver.executeScript("arguments[0].scrollIntoView();", DynamicEle);
            DynamicEle.click();
        }
        Thread.sleep(2000);


    }

    public static void iEditCasePriorityAndCaseOrigin(String priority, String origin) throws InterruptedException {
        Thread.sleep(5000);
        wait = new WebDriverWait(Configuration.driver, 30);
        WebElement Case2 = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Case Origin - Current Selection: --None--')]"));
        WebElement case_ = wait.until(ExpectedConditions.elementToBeClickable(Case2));
        case_.click();
        Thread.sleep(3000);
        WebElement dynamicElement5 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + origin + "')]"));
        WebElement DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement5));
        if (DynamicEle != null) {

            jsDriver.executeScript("arguments[0].scrollIntoView();", DynamicEle);
            DynamicEle.click();
        }
        Thread.sleep(3000);

        WebElement Case3 = Configuration.driver.findElement(By.xpath("//*[contains(@aria-label, 'Priority - Current Selection:')]"));
        WebElement Case_ = wait.until(ExpectedConditions.elementToBeClickable(Case3));
        Case_.click();


        WebElement dynamicElement6 = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, '" + priority + "')]"));
        WebElement Dynamic_ = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement6));

        if (Dynamic_ != null) {

            JavascriptExecutor js7_ = (JavascriptExecutor) Configuration.driver;
         //   js7_.executeScript("arguments[0].scrollIntoView();", Dynamic_);


            if (priority.equalsIgnoreCase("Low")) {

                WebElement mediumElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, 'Medium')]"));
                mediumElement.click();
            } else if (priority.equalsIgnoreCase("Medium")) {

                WebElement lowElement = Configuration.driver.findElement(By.xpath("//*[contains(@data-value, 'Low')]"));
                lowElement.click();
            }
        }

        Thread.sleep(2000);

    }

    //*[contains(@id, 'input-,')]
    public static void iEnterCaseSubjectAsAndDescriptionAs(String Subject) throws InterruptedException {
        Thread.sleep(2000);
        WebElement subject = Configuration.driver.findElement(By.xpath("//*[@name='Subject']"));
        Thread.sleep(2000);
        subject.sendKeys(Subject);


    }


    public static void verifyCaseHistory() throws InterruptedException {

        Thread.sleep(8000);



        wait = new WebDriverWait(Configuration.driver, 30);
        Thread.sleep(5000);
        JavascriptExecutor js1 = (JavascriptExecutor) Configuration.driver;
        js1.executeScript("window.scrollBy(0, -900);");

        Thread.sleep(5000);

        List<WebElement> history = Configuration.driver.findElements(By.xpath("//a[@class='slds-tabs_default__link' and @data-tab-value='relatedListsTab']"));

        WebElement history_ = history.get(0);
//        WebElement History = wait.until(ExpectedConditions.elementToBeClickable(history_));
        JavascriptExecutor js2 = (JavascriptExecutor) Configuration.driver;
        js2.executeScript("arguments[0].click();", history_);

        JavascriptExecutor js6 = (JavascriptExecutor) Configuration.driver;
        js6.executeScript("window.scrollBy(0, 700);");



//
//
//        WebElement element = Configuration.driver.findElement(By.xpath("//*[contains(@data-label, 'New Value')]"));
//        Thread.sleep(5000);
//        String text = element.getText();
//
//        Assert.assertFalse(text.isEmpty(), "The element is empty");
//
//        //  Assert.assertTrue(!element.getText().trim().isEmpty());
//
//        wait = new WebDriverWait(Configuration.driver, 30);
//        WebElement VerifyCaseType = Configuration.driver.findElement(By.xpath("//*[contains(@title, 'Type')]"));
//
//        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(VerifyCaseType));
//
//        String text0 = BtnDynamicEle.getText();
//
//        Assert.assertFalse(text0.isEmpty(), "The field should not be empty");
//
//        Thread.sleep(3000);
//        WebElement VerifyCaseSub = Configuration.driver.findElement(By.xpath("//span[text()='Case Sub Category']"));
//
//        WebElement BtnCaseNumber = wait.until(ExpectedConditions.elementToBeClickable(VerifyCaseSub));
//
//        String text1 = BtnCaseNumber.getText();
//        Assert.assertFalse(text1.isEmpty(), "The field should not be empty");
//
//
//        Thread.sleep(2000);
//        WebElement VerifyCaseIssue = Configuration.driver.findElement(By.xpath("//span[text()='Case Sub Category']"));
//
//        WebElement BtnContact = wait.until(ExpectedConditions.elementToBeClickable(VerifyCaseIssue));
//
//        String text2 = BtnContact.getText();
//        Assert.assertFalse(text2.isEmpty(), "The field should not be empty");
//
//        Thread.sleep(2000);
//        WebElement VerifyCasePriority = Configuration.driver.findElement(By.xpath("//span[text()='Case Sub Category']"));
//
//        WebElement BtnCasdPriority = wait.until(ExpectedConditions.elementToBeClickable(VerifyCasePriority));
//
//        String text3 = BtnContact.getText();
//        Assert.assertFalse(text3.isEmpty(), "The field should not be empty");


    }


}









