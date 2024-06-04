package pages;

import config.Configuration;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static co.za.capitecbank.testing.utilities.EmailOTP.wait;

public class OpportunityManagementPage {

    public static void Opportunity_Tab() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);

        Thread.sleep(2000);
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
        Thread.sleep(2000);
        Nav_Menu_.click();
        Thread.sleep(2000);
        WebElement btn_Lead = Configuration.driver.findElement(By.xpath("//a[@data-label='Opportunities']"));
        WebElement btn_Lead_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Lead));
        btn_Lead_.click();
        Thread.sleep(2000);

        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Opportunities']"));
        WebElement btn_Cases_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
        btn_Cases_.click();
        Thread.sleep(2000);
    }

    public static void NewOpportunity() throws InterruptedException {


        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@data-refid,'recordId')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            EleWait.click();
           Thread.sleep(2000);
        }

    }


    public static void OpDetails() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
        js.executeScript("window.scrollBy(0, 326);");

        String taxNumber = generateRandomRegistrationNumber();


        WebElement editTax = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Edit Income Tax Number')]"));
        WebElement editTax_ = wait.until(ExpectedConditions.elementToBeClickable(editTax));
        editTax_.click();




        WebElement labelElement = Configuration.driver.findElement(By.xpath("//label[contains(., 'Income Tax Number')]"));

        WebElement inputElement = labelElement.findElement(By.xpath("./following-sibling::input"));


        inputElement.sendKeys(taxNumber);


        WebElement nature = Configuration.driver.findElement(By.xpath("//label[contains(., 'Nature of Business')]"));

        WebElement nature_ = nature.findElement(By.xpath("./following-sibling::input"));


        nature_.sendKeys("test");


        List<WebElement> account = Configuration.driver.findElements(By.xpath("//a[contains(text(), '--None--')]"));

        if (!account.isEmpty()) {

            WebElement acc = account.get(0);
            JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;
            //  js0.executeScript("arguments[0].scrollIntoView();", acc);
            js0.executeScript("arguments[0].click();", acc);

            WebElement dynamicElement5 = Configuration.driver.findElement(By.xpath("//*[contains(text(), 'Micro-lender')]"));
            WebElement DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement5));
            if (DynamicEle != null) {

                js0.executeScript("arguments[0].scrollIntoView();", DynamicEle);
                DynamicEle.click();
            }


        }


        List<WebElement> dynamicElement5 = Configuration.driver.findElements(By.xpath("//*[contains(@class,'input uiInputSmartNumber')]"));

        if (dynamicElement5 != null) {
            WebElement acc = dynamicElement5.get(0);
            js.executeScript("arguments[0].scrollIntoView();", acc);
            acc.sendKeys("1000");


        }

        List<WebElement> industry = Configuration.driver.findElements(By.xpath("//a[contains(text(), '--None--')]"));

        if (!industry.isEmpty()) {

            WebElement industry_ = industry.get(0);
            JavascriptExecutor js0 = (JavascriptExecutor) Configuration.driver;

            js0.executeScript("arguments[0].click();", industry_);

            WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(text(), 'Agriculture')]"));
            WebElement DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));
            if (DynamicEle != null) {

                js0.executeScript("arguments[0].scrollIntoView();", DynamicEle);
                DynamicEle.click();
            }


            List<WebElement> Source0fWealth = Configuration.driver.findElements(By.xpath("//a[contains(text(), '--None--')]"));

            WebElement source = Source0fWealth.get(0);
            js0.executeScript("arguments[0].click();", source);

            WebElement sourceWealth = Configuration.driver.findElement(By.xpath("//*[contains(text(), 'Rental Income')]"));
            WebElement sourceWealth_ = wait.until(ExpectedConditions.elementToBeClickable(sourceWealth));
            if (sourceWealth_ != null) {

                js0.executeScript("arguments[0].click();", sourceWealth_);

            }

        }


        WebElement Charitable = Configuration.driver.findElement(By.xpath("//label[contains(., 'Charitable Status')]"));

        WebElement Charitable_ = Charitable.findElement(By.xpath("./following-sibling::input"));


        Charitable_.sendKeys("test");


        WebElement RegistrationNumber = Configuration.driver.findElement(By.xpath("//label[contains(., 'Business Registration Number')]"));

        WebElement RegistrationNumber_ = RegistrationNumber.findElement(By.xpath("./following-sibling::input"));


        RegistrationNumber_.sendKeys(taxNumber);


        WebElement datePickerIcon = Configuration.driver.findElement(By.xpath("//a[@class='datePicker-openIcon display']"));

        datePickerIcon.click();


        WebElement dateElement = Configuration.driver.findElement(By.xpath("//span[contains(@class, 'day') and text()='2' and not(contains(@class, 'slds-disabled-text'))]"));
        dateElement.click();


        WebElement RegistrationCountry = Configuration.driver.findElement(By.xpath("//label[contains(., 'Business Registered Country')]"));

        WebElement RegistrationCountry_ = RegistrationCountry.findElement(By.xpath("./following-sibling::input"));

        RegistrationCountry_.sendKeys("South Africa");


        WebElement Directors = Configuration.driver.findElement(By.xpath("//label[contains(., 'Number of Directors')]"));

        WebElement Directors_ = Directors.findElement(By.xpath("./following-sibling::input"));

        Directors_.sendKeys("3");


        WebElement Email = Configuration.driver.findElement(By.xpath("//label[contains(., 'Email Address')]"));

        WebElement Email_ = Email.findElement(By.xpath("./following-sibling::input"));

        Email_.sendKeys("nape@gmail.com");


        js.executeScript("window.scrollBy(0, 35);");

        WebElement branch = Configuration.driver.findElement(By.xpath("//*[contains(@title, 'Search Business Centers')]"));

        //    WebElement branch_ = branch.findElement(By.xpath("./following-sibling::input"));

        branch.sendKeys("Sandton");
        branch.click();
        branch.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement branch2 = Configuration.driver.findElement(By.linkText("SANDTON"));
        branch2.click();




        List<WebElement> SearchAddress = Configuration.driver.findElements(By.xpath("//*[contains(@class, 'searchLabel')]"));

        if (SearchAddress != null) {
            WebElement Address = SearchAddress.get(0);
           // js.executeScript("arguments[0].scrollIntoView();", Address);
            Address.click();
            Thread.sleep(2000);


            WebElement enterAddress = Configuration.driver.findElement(By.xpath(" //*[contains(@placeholder, 'Enter address')]"));
            WebElement enterAddress_ = wait.until(ExpectedConditions.elementToBeClickable(enterAddress));
            enterAddress_.click();
            enterAddress_.sendKeys("sandton");
            enterAddress_.click();
enterAddress_.clear();
            enterAddress_.sendKeys("sandton");
            enterAddress_.click();


           List<WebElement>  options = Configuration.driver.findElements(By.xpath("//li[@role='presentation']//span[@class='match uiOutputText'][text()='Sandton']"));
            WebElement option = options.get(1);

            option.click();
        }

        List<WebElement> SearchAddress2 = Configuration.driver.findElements(By.xpath("//*[contains(@class, 'searchLabel')]"));

        if (SearchAddress2 != null) {
            WebElement Address = SearchAddress2.get(0);
            // js.executeScript("arguments[0].scrollIntoView();", Address);
            Address.click();
            Thread.sleep(2000);


            WebElement enterAddress = Configuration.driver.findElement(By.xpath(" //*[contains(@placeholder, 'Enter address')]"));
            WebElement enterAddress_ = wait.until(ExpectedConditions.elementToBeClickable(enterAddress));
            enterAddress_.click();
            enterAddress_.sendKeys("sandton");
            enterAddress_.click();

            List<WebElement>  options = Configuration.driver.findElements(By.xpath("//li[@role='presentation']//span[@class='match uiOutputText'][text()='Sandton']"));
            WebElement option = options.get(1);

            option.click();
        }

        WebElement save2 = Configuration.driver.findElement(By.xpath("//*[@title='Save']"));
        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(save2));
        BtnDynamicEle.click();





        WebElement editSIC = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Edit SICSection')]"));
        WebElement editSIC_ = wait.until(ExpectedConditions.elementToBeClickable(editSIC));
        editSIC_.click();


        WebElement Manager_Code = Configuration.driver.findElement(By.xpath("//*[contains(@name,'BB_Manager_Code__c')]"));
        WebElement Manager_Code_ = wait.until(ExpectedConditions.elementToBeClickable(Manager_Code));
        Thread.sleep(2000);
        Manager_Code_.sendKeys(taxNumber);
        Thread.sleep(1000);

// Using following axis
        WebElement SICSectionEle = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICSection')]/following::input"));

// Using combination of conditions
    //    WebElement SICSectionEle = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICSection')]/following::*[self::input]"));



//        WebElement SICSection = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICSection')]"));
//        Thread.sleep(2000);
//        WebElement SICSectionEle = SICSection.findElement(By.xpath("./following-sibling::input"));


        SICSectionEle.sendKeys("test");


        WebElement SICDivision = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICDivision')]"));

        WebElement SICDivisionEle = SICDivision.findElement(By.xpath("./following-sibling::input"));


        SICDivisionEle.sendKeys("test");


        WebElement SICIndustryGroup = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICIndustryGroup')]"));

        WebElement SICIndustryGroup_ = SICIndustryGroup.findElement(By.xpath("./following-sibling::input"));


        SICIndustryGroup_.sendKeys("test");


        WebElement SICClass = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICClass')]"));

        WebElement SICClass_ = SICClass.findElement(By.xpath("./following-sibling::input"));


        SICClass_.sendKeys("test");



        WebElement SICSubclass = Configuration.driver.findElement(By.xpath("//label[contains(., 'SICClass')]"));

        WebElement SICSubclass_ = SICSubclass.findElement(By.xpath("./following-sibling::input"));


        SICSubclass_.sendKeys("test");


        WebElement checkbox = Configuration.driver.findElement(By.xpath("//*[contains(@name, 'LLC_BI__Existing_Customer__c')]"));
        WebElement checkbox_ = wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        Thread.sleep(2000);
        checkbox_.click();







        WebElement save3 = Configuration.driver.findElement(By.xpath("//*[@title='Save']"));
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(save3));
        save.click();



        WebElement btn_Related = Configuration.driver.findElement(By.xpath("//*[contains(@data-label,'Related')]"));
        WebElement btn_Related_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Related));
        Thread.sleep(2000);
        btn_Related_.click();






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


    public static void iClickRelated() throws InterruptedException {
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement btn_Related = Configuration.driver.findElement(By.xpath("//*[contains(@data-label,'Related')]"));
        WebElement btn_Related_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Related));
        Thread.sleep(2000);
        btn_Related_.click();
        Thread.sleep(1000);
    }

    public static void AddAProduct() throws InterruptedException {
        wait = new WebDriverWait(Configuration.driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
        js.executeScript("window.scrollBy(0, 400);");

        Thread.sleep(2000);
        WebElement btn_AddProduct = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Add Products')]"));
        WebElement AddProduct = wait.until(ExpectedConditions.elementToBeClickable(btn_AddProduct));

        if (AddProduct != null) {

            Thread.sleep(2000);
            AddProduct.click();
        } else {

            List<WebElement> btn_none = Configuration.driver.findElements(By.xpath("//*[contains(text(),'None')]"));

            if (!btn_none.isEmpty()) {
                WebElement none = btn_none.get(7);
                WebElement none_ = wait.until(ExpectedConditions.elementToBeClickable(none));
                none_.click();

                Actions actions = new Actions(Configuration.driver);
                WebElement Ele = Configuration.driver.findElement(By.xpath("//*[contains(text(),'Standard Price Book')]"));
                actions.moveToElement(Ele).click().perform();
            }
        }


        boolean standardPriceBookFound = false;
        try {
            WebElement standardPriceBookButton = Configuration.driver.findElement(By.xpath("//a[contains(@class, 'select') and text()='Standard Price Book']"));
            JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;
            executor.executeScript("arguments[0].click();", standardPriceBookButton);
            executor.executeScript("arguments[0].click();", standardPriceBookButton);
            standardPriceBookFound = true;
        } catch (NoSuchElementException e) {
            System.out.println("Standard Price Book button not found");
        }

        if (!standardPriceBookFound) {
            try {
                WebElement capitecButton = Configuration.driver.findElement(By.xpath("//a[contains(@class, 'select') and text()='Capitec Business']"));
                JavascriptExecutor executor = (JavascriptExecutor) Configuration.driver;
                executor.executeScript("arguments[0].click();", capitecButton);
            } catch (NoSuchElementException e) {
                System.out.println("Capitec Business button not found");
            }
        }


        WebElement Next = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton')]"));
        WebElement Next_ = wait.until(ExpectedConditions.elementToBeClickable(Next));
        Thread.sleep(2000);
        Next_.click();
        Thread.sleep(2000);

        List<WebElement> SalesPrice = Configuration.driver.findElements(By.xpath("//*[contains(@class,'uiInput forceVirtualCheckbox uiInput--default')]"));

        if (!SalesPrice.isEmpty()) {
            WebElement price = SalesPrice.get(2);
            WebElement SalesPrice_ = wait.until(ExpectedConditions.elementToBeClickable(price));

            Actions builder = new Actions(Configuration.driver);
            builder.click(SalesPrice_).perform();

            WebElement save1 = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton')]"));
            WebElement save_1 = wait.until(ExpectedConditions.elementToBeClickable(save1));
            Thread.sleep(2000);
            save_1.click();
            Thread.sleep(2000);

        } else {
            System.out.println("No buttons found, proceeding to SalesPrice interaction");
        }


//        WebElement save = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton')]"));
//        WebElement save_ = wait.until(ExpectedConditions.elementToBeClickable(save));
//        Thread.sleep(2000);
//        save_.click();

//List <WebElement> ProductNames = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-grid slds-grid--align-spread slds-align_absolute-center checkbox-container slds-checkbox uiInput forceVirtualCheckbox uiInput--default')]"));
//
//if(!ProductNames.isEmpty())
//{
//    WebElement product = ProductNames.get(2);
//
//    WebElement product_ = wait.until(ExpectedConditions.elementToBeClickable(product));
//    product_.click();
//
//}


        // List<WebElement> SalesPrice = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button trigger slds-button_icon-border')]"));
//
//        if(!SalesPrice.isEmpty())
//        {
//            WebElement price = SalesPrice.get(1);
//            WebElement SalesPrice_ = wait.until(ExpectedConditions.elementToBeClickable(price));
//            JavascriptExecutor js2 = (JavascriptExecutor) Configuration.driver;
//            js2.executeScript("arguments[0].innerText = '';", SalesPrice_);
//
//            js.executeScript("arguments[0].innerText = '10000';", SalesPrice_);
//
//        }
        List<WebElement> Salesprice = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button trigger slds-button_icon-border')]"));

        if (!Salesprice.isEmpty()) {
            WebElement price = Salesprice.get(1);
            WebElement SalesPrice_ = wait.until(ExpectedConditions.elementToBeClickable(price));

            Actions builder = new Actions(Configuration.driver);
            builder.doubleClick(SalesPrice_).sendKeys(SalesPrice_, "10000").perform();


        }

        WebElement save1 = Configuration.driver.findElement(By.xpath("//*[contains(@class,'slds-button slds-button--neutral uiButton--default uiButton--brand uiButton')]"));
        WebElement save_1 = wait.until(ExpectedConditions.elementToBeClickable(save1));
        Thread.sleep(2000);
        save_1.click();


    }

    public static void verifyAddedProduct() throws InterruptedException {

        Thread.sleep(3000);


        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@data-refid,'recordId')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            EleWait.click();

        }


        try {


            wait = new WebDriverWait(Configuration.driver, 30);
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("window.scrollBy(0, 100);");


            List<WebElement> LeadStatus = Configuration.driver.findElements(By.xpath("//*[contains(@role,'listitem')]"));
            if (!LeadStatus.isEmpty()) {

                WebElement btnToClick = LeadStatus.get(3);
                WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));

                String text = btnToClick_.getText();

                Assert.assertTrue(btnToClick_.getText().contains("Converted"), "Element text does not contain 'Converted'");

            } else {

                System.out.println("wrong name");

            }
            Thread.sleep(2000);


            List<WebElement> BusinessType = Configuration.driver.findElements(By.xpath("//*[contains(@ field-label,'Business Type')]"));
            if (!BusinessType.isEmpty()) {

                WebElement btnToClick = BusinessType.get(0);
                WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));

                String businessTypeText = btnToClick_.getText();

                if (businessTypeText.contains("Sole Proprietor")) {
                    Assert.assertTrue(true, "Business type is 'Sole Proprietor'");

                } else if (businessTypeText.contains("Registered Business")) {
                    Assert.assertTrue(true, "Business type is 'Structured Business'");

                } else {
                    Assert.fail("Unexpected business type: " + businessTypeText);
                }

                // Assert.assertTrue(btnToClick_.getText().contains("Sole Proprietor"), "Element text does not contain 'Converted'");

            } else {

                System.out.println("wrong name");

            }
            Thread.sleep(2000);


            List<WebElement> LeadSource = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));

            WebElement Source = LeadSource.get(1);

            String textOwner = Source.getText();
            Thread.sleep(8000);
            Assert.assertFalse(textOwner.isEmpty(), "The element is empty");


            Thread.sleep(8000);


//            List<WebElement> BusinessType = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));
//
//            WebElement Business_type = BusinessType.get(4);
//
//            String textContact = Business_type.getText();
//            Thread.sleep(8000);
//            Assert.assertFalse(textContact.isEmpty(), "The element is empty");


        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }


    }
}

