package pages;

import config.Configuration;
import config.UserFunctions;
import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static co.za.capitecbank.testing.utilities.EmailOTP.wait;


import static pages.LeadManagementPage.generateRandomRegistrationNumber;

public class RetentionManagementPage {
    public static String lastName;
//

    public static void Bankers_Tab() throws InterruptedException {


        Thread.sleep(2000);
        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            try {
                closeButton.click();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            WebElement Dissmiss_notification = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Dismiss notification')]"));
            if (Dissmiss_notification.isDisplayed()) {
                Dissmiss_notification.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


        wait = new WebDriverWait(Configuration.driver, 10);
        //  String id = Misc.generateRandomIDNumberSA("891103", "Female");
        Thread.sleep(2000);

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement Nav_Menu_ = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));

        Nav_Menu_.click();
        Thread.sleep(2000);
        WebElement btn_Lead = Configuration.driver.findElement(By.xpath("//a[@data-label='Bankers']"));
        WebElement btn_Lead_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Lead));
        btn_Lead_.click();
        Thread.sleep(2000);

        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Bankers']"));
        WebElement btn_Cases_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
        btn_Cases_.click();
        Thread.sleep(4000);
    }

    public static void ExistingBanker(String ExistingName) throws InterruptedException {

        Thread.sleep(2000);

        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement Search = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Banker-search-input')]"));
        WebElement Search2 = wait.until(ExpectedConditions.elementToBeClickable(Search));
        Search2.click();
        Thread.sleep(2000);
        WebElement EnterName = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Banker-search-input')]"));
        WebElement EnterName2 = wait.until(ExpectedConditions.elementToBeClickable(EnterName));
        EnterName2.sendKeys(ExistingName);
        EnterName2.sendKeys(Keys.ENTER);

    }

    public static void ClickName() throws InterruptedException {
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

    public static void RecentlyViewed() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(text(), 'Recently Viewed')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(2);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            EleWait.click();


        }
        Thread.sleep(2000);
        WebElement AllBankers = Configuration.driver.findElement(By.xpath("//*[contains(text(),'All Bankers')]"));
        WebElement AllBankers2 = wait.until(ExpectedConditions.elementToBeClickable(AllBankers));
        AllBankers2.click();
    }

    public static void BankerRole(String Banker_Role) throws InterruptedException {

        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;

//        WebElement EditBanker = Configuration.driver.findElement(By.xpath("//*[contains(text(),'Edit Banker Role')]"));
//        WebElement EditBanker2 = wait.until(ExpectedConditions.elementToBeClickable(EditBanker));
//        executor.executeScript("arguments[0].click();", EditBanker2);

        List<WebElement> EditBanker = Configuration.driver.findElements(By.xpath("//*[contains(text(),'Edit Banker Role')]"));
        if (!EditBanker.isEmpty()) {
            WebElement bankerRole = EditBanker.get(0);


            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(bankerRole).click().perform();

            // Now find the clickable element within the parent element and click it
//            WebElement clickableElement = bankerRole.findElement(By.xpath("your_xpath_here"));
//            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
//            EleWait.click();
        }

        Thread.sleep(2000);
        List<WebElement> Role = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-form-element__control')]"));
        if (!Role.isEmpty()) {
            WebElement bankerRole = Role.get(7);

            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(bankerRole).click().perform();

        }

        Thread.sleep(2000);

        WebElement Banker = Configuration.driver.findElement(By.xpath("//*[contains(@data-value,'" + Banker_Role + "')]"));
        WebElement Bankers2 = wait.until(ExpectedConditions.elementToBeClickable(Banker));
        Bankers2.click();
    }

    public static void Clients_Tab() throws InterruptedException {
        Thread.sleep(1000);
        List < WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            closeButton.click();
        }
        wait = new WebDriverWait(Configuration.driver, 10);
        //  String id = Misc.generateRandomIDNumberSA("891103", "Female");
        Thread.sleep(2000);

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement Nav_Menu_ = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));

        Nav_Menu_.click();
        Thread.sleep(2000);
        WebElement btn_Lead = Configuration.driver.findElement(By.xpath("//a[@data-label='Clients']"));
        WebElement btn_Lead_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Lead));
        btn_Lead_.click();
        Thread.sleep(2000);

        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Clients']"));
        WebElement btn_Cases_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
        btn_Cases_.click();
        Thread.sleep(2000);
    }

    public static void New_client() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement btn_New = Configuration.driver.findElement(By.xpath("//a[@title='New']"));
        WebElement btn_New_ = wait.until(ExpectedConditions.elementToBeClickable(btn_New));

        btn_New_.click();
        Thread.sleep(2000);

        List<WebElement> next = Configuration.driver.findElements(By.xpath("//*[contains(text(),'Next')]"));
        if (!next.isEmpty()) {
            WebElement bankerRole = next.get(1);

            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(bankerRole).click().perform();

        }

        Thread.sleep(2000);


    }

    public static void Clients_details() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        //  String id = Misc.generateRandomIDNumberSA("891103", "Female");
        Faker faker = new Faker(new Locale("en-ZA"));
        String RegistrationNumber = generateRandomRegistrationNumber();

           lastName = faker.name().lastName();
        WebElement name = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Name')]"));


        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", name);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(name).click().perform();
        name.sendKeys(lastName);
        Thread.sleep(2000);

        Thread.sleep(2000);
        WebElement Reg = Configuration.driver.findElement(By.xpath("//*[contains(@name,'BB_Business_Registration_Number__c')]"));


        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", Reg);

        actions.moveToElement(Reg).click().perform();

        Reg.sendKeys(RegistrationNumber);

        Thread.sleep(2000);

        WebElement save2 = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(save2));
        BtnDynamicEle.click();
        Thread.sleep(5000);

    }


    public static void SelectApp(String ApplicationName) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> Apps = Configuration.driver.findElements(By.xpath("//*[contains(@aria-label,'App')]"));
        if (!Apps.isEmpty()) {
            WebElement Applications = Apps.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Applications));
            EleWait.click();
            Thread.sleep(2000);
        }

        WebElement Search = Configuration.driver.findElement(By.xpath("//*[contains(@placeholder,'Search apps and items')]"));
        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Search));
        EleWait.click();
        Thread.sleep(2000);

        WebElement AppName = Configuration.driver.findElement(By.xpath("//*[contains(@placeholder,'Search apps and items')]"));
        WebElement EleWait1 = wait.until(ExpectedConditions.elementToBeClickable(AppName));
        EleWait1.sendKeys(ApplicationName);
        Thread.sleep(2000);

        if (ApplicationName.contains("Financial Accounts")) {

            WebElement AppNames = Configuration.driver.findElement(By.xpath("//*[contains(@data-label,'Financial Accounts')]"));
            WebElement EleWait2 = wait.until(ExpectedConditions.elementToBeClickable(AppNames));

            JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;
            executor.executeScript("arguments[0].click();", EleWait2);
            Thread.sleep(2000);

        } else {
            System.out.println("Cant find app");
        }



    }

public static void New_Account () throws InterruptedException {

    Thread.sleep(2000);
    List<WebElement> btn_new = Configuration.driver.findElements(By.xpath("//a[@title='New']"));
    if (!btn_new.isEmpty()) {
        WebElement bankerRole = btn_new.get(1);

        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(bankerRole).click().perform();

    }
    Thread.sleep(2000);


    Thread.sleep(2000);
    wait = new WebDriverWait(Configuration.driver, 10);
    WebElement BankAccount = Configuration.driver.findElement(By.xpath("//*[contains(text(),'Bank Account')]"));
    WebElement BankAccounts = wait.until(ExpectedConditions.elementToBeClickable(BankAccount));

    BankAccounts.click();
    Thread.sleep(2000);

    List<WebElement> next = Configuration.driver.findElements(By.xpath("//*[contains(text(),'Next')]"));
    if (next.size()>1) {
        WebElement bankerRole = next.get(2);

        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(bankerRole).click().perform();

    }else{

        WebElement bankerRole = next.get(1);

        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", bankerRole);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(bankerRole).click().perform();
    }






    Thread.sleep(2000);

}
    public static void AccountDetails (String AccountName) throws InterruptedException
    {

        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement BankAccountNames = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Name')]"));
        WebElement BankAccountName = wait.until(ExpectedConditions.elementToBeClickable(BankAccountNames));

        BankAccountName.sendKeys(AccountName);
        Thread.sleep(2000);

        List<WebElement> matchingElements = Configuration.driver.findElements(By.xpath("//*[contains(@placeholder, 'Search Clients...')]"));
//to be fixed
        if (matchingElements.size() == 1) {
            WebElement btnToclick = matchingElements.get(0);
            WebElement btnToclick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToclick));
            btnToclick_.click();

        } else if (matchingElements.size() > 1) {
            WebElement button_new = matchingElements.get(0);
            WebElement button_new_ = wait.until(ExpectedConditions.elementToBeClickable(button_new));

            button_new_.click();

        }

        Thread.sleep(2000);
        List<WebElement> ExistingClientName = Configuration.driver.findElements(By.xpath("//li[contains(@class, 'slds-listbox__item')]//span[contains(@class, 'slds-truncate')]"));

        if (!ExistingClientName.isEmpty()) {


            for (WebElement element : ExistingClientName) {

                String ExistingName = element.getAttribute("title").trim();

                List<WebElement> existingClientNames = null;
                WebElement list;

                if (ExistingName.equals(lastName)) {

                    existingClientNames = Configuration.driver.findElements(By.xpath("//li[contains(@class, 'slds-listbox__item')]//span[contains(@class, 'slds-truncate')][@title='" + lastName + "']"));

                    if (!existingClientNames.isEmpty()) {

                        if (existingClientNames.size() > 1) {
                            WebElement lastElementToClick = existingClientNames.get(existingClientNames.size() - 1);
                            WebElement btnToClick = wait.until(ExpectedConditions.elementToBeClickable(lastElementToClick));
                            btnToClick.click();
                        } else {
                            WebElement elementToClick = existingClientNames.get(0);
                            WebElement btnToClick = wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
                            btnToClick.click();
                            break;
                        }
                    } else {

                        System.out.println("Element with lastName '" + lastName + "' not found.");
                    }
                }

            }
        }

        Thread.sleep(2000);


        List<WebElement> TriggerActionPlans = Configuration.driver.findElements(By.xpath("//*[contains(@name, 'TriggerActionPlans__c')]"));
        if (!TriggerActionPlans.isEmpty()) {
            WebElement actionPlan = TriggerActionPlans.get(0);

            ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", actionPlan);


            Actions actions = new Actions(Configuration.driver);
            actions.moveToElement(actionPlan).click().perform();

        }

        LocalDate currentDate = LocalDate.now();

LocalDate fiveDaysPrior = currentDate.minusDays(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = fiveDaysPrior.format(formatter);


        WebElement DateOpened = Configuration.driver.findElement(By.xpath("//*[contains(@name, 'FinServ__OpenDate__c')]"));
        ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", DateOpened);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(DateOpened).click().perform();
DateOpened.sendKeys(formattedDate);




        WebElement save2 = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(save2));
        BtnDynamicEle.click();
        Thread.sleep(5000);
    }

public static void primaryOwner() throws InterruptedException {

    Thread.sleep(2000);

    List<WebElement> TriggerActionPlans = Configuration.driver.findElements(By.xpath("//a[contains(@href, '/lightning/r/Account/')]"));
    if (!TriggerActionPlans.isEmpty()) {
        WebElement actionPlan = TriggerActionPlans.get(TriggerActionPlans.size()-1);

       // ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", actionPlan);


        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(actionPlan).click().perform();

    }
    JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
    js.executeScript("window.scrollBy(0, 200);");


    WebElement checkBox = Configuration.driver.findElement(By.xpath("//*[@class='taskStatusCheckbox slds-media__figure']"));
  //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);

    Actions actions = new Actions(Configuration.driver);
    actions.moveToElement(checkBox).click().perform();
    Thread.sleep(1000);

    Configuration.driver.navigate().refresh();
    Thread.sleep(1000);
    js.executeScript("window.scrollBy(0, 200);");


    List<WebElement> validation = Configuration.driver.findElements(By.xpath("//div[@class='slds-grid slds-size_1-of-1']/div[@class='slds-col slds-truncate timelineGridItemLeft']/a[@class='subjectLink slds-truncate']"));
    if (!validation.isEmpty()) {
        for (WebElement element : validation) {
            String text = element.getText();
            if (text.contains("5 Day")) {

                Assert.assertTrue(text.contains("5 Day"));
                break;
            }
        }
    }





}



    public static void FiveWeek() throws InterruptedException {

        Thread.sleep(5000);

        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            try {
                closeButton.click();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }

        Thread.sleep(2000);

        SelectApp("Financial Accounts");

        Thread.sleep(5000);
        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@title,'"+lastName+"')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 20);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            Thread.sleep(1000);
            EleWait.click();

        }
//        ClickName();
//
//        List<WebElement> TriggerActionPlans = Configuration.driver.findElements(By.xpath("//a[contains(@href, '/lightning/r/Account/') and contains(@href, '/view')]"));
//        if (!TriggerActionPlans.isEmpty()) {
//            WebElement actionPlan = TriggerActionPlans.get(1);
//
//            // ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", actionPlan);
//
//
//            Actions actions = new Actions(Configuration.driver);
//            actions.moveToElement(actionPlan).click().perform();
//
//        }
        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
        js.executeScript("window.scrollBy(0, 200);");


        WebElement checkBox = Configuration.driver.findElement(By.xpath("//*[@class='taskStatusCheckbox slds-media__figure']"));
        //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);

        Actions actions = new Actions(Configuration.driver);
        actions.moveToElement(checkBox).click().perform();
        Thread.sleep(1000);

        Configuration.driver.navigate().refresh();
        js.executeScript("window.scrollBy(0, 200);");
        Thread.sleep(5000);

        List<WebElement> validation = Configuration.driver.findElements(By.xpath("//div[@class='slds-grid slds-size_1-of-1']/div[@class='slds-col slds-truncate timelineGridItemLeft']/a[@class='subjectLink slds-truncate']"));
        if (!validation.isEmpty()) {
            for (WebElement element : validation) {
                String text = element.getText();
                if (text.contains("5 Day")) {

                    Assert.assertTrue(text.contains("5 Day"));
                    break;
                }
            }
        }

        List<WebElement> FiveWeekValidation = Configuration.driver.findElements(By.xpath("//div[@class='slds-grid slds-size_1-of-1']/div[@class='slds-col slds-truncate timelineGridItemLeft']/a[@class='subjectLink slds-truncate']"));
        if (!FiveWeekValidation.isEmpty()) {


            WebElement FiveWeek = FiveWeekValidation.get(0);

            String text = FiveWeek.getText();
            if (text.contains("5 Week")) {


                Assert.assertTrue(text.contains("5 Week"));


            }
        }

        JavascriptExecutor js1 = (JavascriptExecutor) Configuration.driver;
        js1.executeScript("window.scrollBy(0, 200);");


        WebElement checkBox2 = Configuration.driver.findElement(By.xpath("//*[@class='taskStatusCheckbox slds-media__figure']"));
        //  ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].scrollIntoView(true);", checkBox);


        actions.moveToElement(checkBox2).click().perform();
        Thread.sleep(1000);

        Configuration.driver.navigate().refresh();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 200);");

        List<WebElement> fiveMonths = Configuration.driver.findElements(By.xpath("//div[@class='slds-grid slds-size_1-of-1']/div[@class='slds-col slds-truncate timelineGridItemLeft']/a[@class='subjectLink slds-truncate']"));
        if (!fiveMonths.isEmpty()) {
            for (WebElement element : fiveMonths) {
                String text = element.getText();
                if (text.contains("5 Months")) {

                    Assert.assertTrue(text.contains("5 Months"));
                    break;
                }
            }
        }

        Configuration.driver.navigate().refresh();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 200);");




    }







}
















