package pages;

import co.za.capitecbank.testing.utilities.Misc;
import config.Configuration;
import net.datafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class LeadManagementPage {

    private static WebDriverWait wait;
    public static  String id= Misc.generateRandomIDNumberSA("891103", "Female");
    public static void Leads_Tab() throws InterruptedException {

        Thread.sleep(1000);
        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
        for (WebElement closeButton : closeButtons) {
            try {
                closeButton.click();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
        wait = new WebDriverWait(Configuration.driver, 10);
        //  String id = Misc.generateRandomIDNumberSA("891103", "Female");
        Thread.sleep(4000);
        //String id = Misc.generateRandomIDNumber();

//        Actions actions = new Actions(Configuration.driver);
//        actions.sendKeys(Keys.ESCAPE).build().perform();

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement Nav_Menu_ = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));

        Nav_Menu_.click();
        Thread.sleep(2000);
        WebElement btn_Lead = Configuration.driver.findElement(By.xpath("//a[@data-label='Leads']"));
        WebElement btn_Lead_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Lead));
        btn_Lead_.click();
        Thread.sleep(2000);

        WebElement btn_Cases = Configuration.driver.findElement(By.xpath("//a[@title='Leads']"));
        WebElement btn_Cases_ = wait.until(ExpectedConditions.elementToBeClickable(btn_Cases));
        btn_Cases_.click();
        Thread.sleep(4000);
    }
    public static void Opportunity_Tab() throws InterruptedException {

        wait = new WebDriverWait(Configuration.driver, 10);
        //  String id = Misc.generateRandomIDNumberSA("891103", "Female");
        Thread.sleep(2000);
        //String id = Misc.generateRandomIDNumber();

//        Actions actions = new Actions(Configuration.driver);
//        actions.sendKeys(Keys.ESCAPE).build().perform();

        WebElement Nav_Menu = Configuration.driver.findElement(By.xpath("//div[@data-aura-class='navexAppNavMenu']"));
        WebElement Nav_Menu_ = wait.until(ExpectedConditions.elementToBeClickable(Nav_Menu));

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

    public static void New_client() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement btn_New = Configuration.driver.findElement(By.xpath("//a[@title='New Lead']"));
        WebElement btn_New_ = wait.until(ExpectedConditions.elementToBeClickable(btn_New));
        Thread.sleep(2000);
        btn_New_.click();
        Thread.sleep(7000);
    }

    public void iCheckedGeneralLead() throws InterruptedException {

        WebElement btn_General = Configuration.driver.findElement(By.xpath("//*[contains(text(),'General Lead')]"));
        Thread.sleep(2000);
        btn_General.click();


        //*[contains(text(),'Internal Referral')]

//*[contains(text(),'General Lead')]
    }

    public void iClickNext() throws InterruptedException {

        WebElement btn_General = Configuration.driver.findElement(By.xpath(" //span[contains(text(),'Next')]"));
        Thread.sleep(2000);
        btn_General.click();

    }

    public static void iSelectBusinessTypeAsBusiness(String BusinessType, String LeadSource, String ProductInterest) throws InterruptedException {



        Thread.sleep(4000);
        String Registration_number = generateRandomRegistrationNumber();

        wait = new WebDriverWait(Configuration.driver, 10);

        Faker faker = new Faker(new Locale("en-ZA"));
        String FName = faker.name().firstName();
        String LName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        //  String Phone = String.valueOf(faker.phoneNumber());
        String companyName = faker.company().name();
        String Phone = generatePhoneNumber();

        // String id = Misc.generateRandomIDNumber();
        String[] title = {"Mr.", "Mrs.", "Ms."};
        String Title = GetRandomTitle(title);

        Thread.sleep(2000);
        WebElement iframe = Configuration.driver.findElement(By.xpath(" //*[@id='brandBand_1']/div/div/div/force-aloha-page/div/iframe"));
        WebElement Frame = wait.until(ExpectedConditions.elementToBeClickable(iframe));
        Configuration.driver.switchTo().frame(Frame);
        Thread.sleep(5000);
        List<WebElement> Lead_Source = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!Lead_Source.isEmpty()) {

            WebElement Leads = Lead_Source.get(1);
            String leads = Leads.getText();

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Leads));
            EleWait.click();


            Select dropdown = new Select(Leads);

            if(LeadSource.equalsIgnoreCase(leads))
            {
                dropdown.selectByIndex(26);
            } else {
                dropdown.selectByIndex(25);
            }


        } else {
            System.out.println("No select elements found.");
        }
        Thread.sleep(5000);


        List<WebElement> Product_interest = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!Product_interest.isEmpty()) {

            WebElement Leads = Product_interest.get(2);


            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Leads));
            EleWait.click();


            Select dropdown = new Select(Leads);
if(ProductInterest.contains("Business Current Account"))
{
    dropdown.selectByIndex(2);
}else
{
    dropdown.selectByIndex(9);
}


        } else {
            System.out.println("No select elements found.");
        }
        Thread.sleep(5000);


        List<WebElement> EleOb = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (BusinessType.contains("Sole Proprietor")) {
            if (!EleOb.isEmpty()) {

                WebElement eleList = EleOb.get(3);

                WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

                WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(eleList));
                EleWait.click();


                Select dropdown = new Select(eleList);


                dropdown.selectByIndex(1);
            } else {
                System.out.println("No select elements found.");
            }

        } else if (BusinessType.contains("Simple Structure")) {
            if (!EleOb.isEmpty()) {

                WebElement eleList = EleOb.get(3);

                WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

                WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(eleList));
                EleWait.click();


                Select dropdown = new Select(eleList);


                dropdown.selectByIndex(2);

                Thread.sleep(2000);



            } else {
                System.out.println("No select elements found.");
            }

        }

        Thread.sleep(5000);


        List<WebElement> Structure_Type = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!Structure_Type.isEmpty()) {

            WebElement Leads = Structure_Type.get(4);

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Leads));
            EleWait.click();


            Select dropdown = new Select(Leads);


            dropdown.selectByIndex(1);
        } else {
            System.out.println("No select elements found.");
        }

        List<WebElement> DirectMarketing = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!DirectMarketing.isEmpty()) {

            WebElement marketing = DirectMarketing.get(5);

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(marketing));
            EleWait.click();


            Select dropdown = new Select(marketing);


            dropdown.selectByIndex(1);
        } else {
            System.out.println("No select elements found.");
        }

        List<WebElement> PersonalizedMarketing = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

        if (!PersonalizedMarketing.isEmpty()) {

            WebElement marketing = PersonalizedMarketing.get(6);

            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(marketing));
            EleWait.click();


            Select dropdown = new Select(marketing);


            dropdown.selectByIndex(1);
        } else {
            System.out.println("No select elements found.");
        }




//        List<WebElement> EleOb = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));
//        WebElement eleList = EleOb.get(3);
//
//        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//
//        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(eleList));
//        EleWait.click();
//
//        WebElement checkbox = null;
//
//        switch (BusinessType) {
//            case "Sole Proprietor":
//                checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Sole Proprietor')]")));
//                break;
//            case "Simple Structure":
//                checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Simple Structure')]")));
//                break;
//            case "Other":
//                checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Other')]")));
//                break;
//        }
//
//        checkbox.click();

        Thread.sleep(2000);

        WebElement Salutation = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Salutation')]"));
        WebElement salutation_ = wait.until(ExpectedConditions.elementToBeClickable(Salutation));

//        Thread.sleep(2000);
        salutation_.click();


        Select dropdown = new Select(Salutation);

        Thread.sleep(1000);
        dropdown.selectByVisibleText(Title);

//        String commonIdPart = Title;
//        WebElement dynamicElement = Configuration.driver.findElement(By.xpath("//*[contains(@value, 'Salutation_values."+ commonIdPart +"%2E')]"));
//        WebElement Clickable_DynamicEle = wait.until(ExpectedConditions.elementToBeClickable(dynamicElement));
//
//        if (Clickable_DynamicEle != null) {
//
//            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
//            js.executeScript("arguments[0].scrollIntoView();", Clickable_DynamicEle);
//
//
//            Clickable_DynamicEle.click();
//        }
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
        js.executeScript("window.scrollBy(0, 100);");

        WebElement btn_FirstName = Configuration.driver.findElement(By.xpath(" //input[contains(@name,'First_Name_ini')]"));
        Thread.sleep(2000);
        btn_FirstName.sendKeys(LName);


        WebElement btn_lastName = Configuration.driver.findElement(By.xpath(" //input[contains(@name,'Last_Name_ini')]"));
        Thread.sleep(2000);
        btn_lastName.sendKeys(FName);

        WebElement btn_Email = Configuration.driver.findElement(By.xpath(" //input[contains(@name,'Email_ini')]"));
        Thread.sleep(2000);
        btn_Email.sendKeys(Email);


        WebElement btn_Phone = Configuration.driver.findElement(By.xpath("//input[contains(@name,'Mobile_Number_ini')]"));
        Thread.sleep(2000);
        btn_Phone.sendKeys(Phone);

        Thread.sleep(5000);

if(BusinessType.contains("Sole Proprietor"))
{
    List<WebElement> ID_Type = Configuration.driver.findElements(By.xpath("//select[contains(@id,'select-')]"));

    if (!ID_Type.isEmpty()) {

        WebElement Id = ID_Type.get(7);

        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);

        WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Id));
        EleWait.click();


        Select drop = new Select(Id);


        drop.selectByIndex(1);
    } else {
        System.out.println("No select elements found.");
    }

    WebElement btn_Id = Configuration.driver.findElement(By.xpath("//input[contains(@name,'South_African_Identity_Number_ini')]"));
    Thread.sleep(2000);
    btn_Id.sendKeys(id);

}else
{
    WebElement BusinessName = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Business_Name_ini')]"));
    WebElement BusinessN = wait.until(ExpectedConditions.elementToBeClickable(BusinessName));
    BusinessN.sendKeys(companyName);

    Thread.sleep(2000);


    WebElement BusinessRegistration = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Business_Registration_Number_ini')]"));
    WebElement BusinessRegistration_ = wait.until(ExpectedConditions.elementToBeClickable(BusinessRegistration));
    BusinessRegistration_.sendKeys(Registration_number);
    Thread.sleep(2000);
}

        JavascriptExecutor js1 = (JavascriptExecutor) Configuration.driver;
        js1.executeScript("window.scrollBy(0, 700);");
        WebElement Next = Configuration.driver.findElement(By.xpath("//*[@id='flowContainer']/article/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button"));
        Thread.sleep(2000);
        Next.click();
        Thread.sleep(15000);
    }

    public static void NewLead() throws InterruptedException {
        //*[contains(@data-refid,'recordId')]
        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@data-refid,'recordId')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            EleWait.click();

        }
        Thread.sleep(7000);

    }

    public static void MarkStatus() throws InterruptedException {
        Thread.sleep(4000);
        try {


            List<WebElement> markStatusButton = Configuration.driver.findElements(By.xpath("//button[@class='slds-button slds-button--brand slds-path__mark-complete stepAction current uiButton']"));

            if (!markStatusButton.isEmpty()) {
                if (markStatusButton.size() > 1) {
                    WebElement mark = markStatusButton.get(1);
                    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", mark);
                } else {
                    WebElement mark = markStatusButton.get(0);
                    ((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", mark);
                }
                Thread.sleep(3000);
            }


            //((JavascriptExecutor) Configuration.driver).executeScript("arguments[0].click();", markStatusButton);
        } catch (StaleElementReferenceException e) {


            WebElement markStatusButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button slds-button--brand slds-path__mark-complete stepAction current uiButton']")));
            markStatusButton.click();

        }

        Thread.sleep(7000);
    }
    public static void ConvertLead() throws InterruptedException {
//
//        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//        List<WebElement> dropdown = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon-border-filled')]"));
//        if (!dropdown.isEmpty()) {
//            WebElement convert = dropdown.get(3);
//
//            WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(convert));
//
//            elaWait.click();
//
//        }


//        List<WebElement> closeButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container')]"));
//        for (WebElement closeButton : closeButtons) {
//            try {
//                closeButton.click();
//            } catch (NoSuchElementException e) {
//                System.out.println(e.getMessage());
//            }
//        }

        Thread.sleep(8000);

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
                    WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(dropdown.get(4)));
                    Thread.sleep(5000);
                    elaWait.click();
                } else {
                    System.out.println("Element not found after retry.");
                }
            }
        }
        Thread.sleep(5000);

        WebElement Click_Convert = Configuration.driver.findElement(By.xpath("//*[contains(@apiname,'Convert')]"));

        WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(Click_Convert));

        elaWait.click();

        Thread.sleep(15000);

        List<WebElement> convertButtons = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_brand')]"));

        if (!convertButtons.isEmpty()) {
            WebElement convertButton;

            if (convertButtons.size() > 1) {
                convertButton = convertButtons.get(1);
            } else {
                convertButton = convertButtons.get(0);
            }

            WebElement eleWait = wait.until(ExpectedConditions.elementToBeClickable(convertButton));
            eleWait.click();
        } else {

            System.out.println("No convert button found");
        }





        //Assert that the lead has been converted
//Your lead has been converted
        // <div class="title" data-aura-rendered-by="30:3158;a"><h2 data-aura-rendered-by="31:3158;a">Your lead has been converted</h2></div>
        Thread.sleep(8000);

    }


    public static void iClickGoToLeads() throws InterruptedException {

        //<button type="button" class="slds-button slds-button_brand" data-aura-rendered-by="15:3158;a"><!--render facet: 16:3158;a-->Go to Leads<!--render facet: 19:3158;a--></button>
        WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
//        List<WebElement> GoToLeads = Configuration.driver.findElements(By.xpath("//*[contains(@class,'slds-button slds-button_brand')]"));
//        if (!GoToLeads.isEmpty()) {
//            WebElement convert = GoToLeads.get(0);
//
//            WebElement elaWait = wait.until(ExpectedConditions.elementToBeClickable(convert));
//            Thread.sleep(2000);
//            elaWait.click();
////*[contains(@title,'Close this window')]
//        }
        Thread.sleep(2000);
        WebElement close = Configuration.driver.findElement(By.xpath("//*[contains(@title,'Close this window')]"));
        WebElement closeWindow = wait.until(ExpectedConditions.elementToBeClickable(close));
        Thread.sleep(2000);
        closeWindow.click();

        Thread.sleep(7000);


    }
    public static void Next() throws InterruptedException {

        WebElement Next = Configuration.driver.findElement(By.xpath("//*[@id='flowContainer']/article/flowruntime-flow/flowruntime-navigation-bar/footer/div[2]/lightning-button"));
        Thread.sleep(2000);
        Next.click();
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
    public static String GetRandomTitle(String[] titles) {
        Random random = new Random();

        int index = random.nextInt(titles.length);
        return titles[index];
    }


    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder PhoneNumber = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            if (i < 1) {
                PhoneNumber.append("0");
            } else {
                int digits = random.nextInt(10);
                PhoneNumber.append(digits);

            }

        }

        return PhoneNumber.toString();
    }


    public static void iClickSave() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(Configuration.driver, 10);
        WebElement save2 = Configuration.driver.findElement(By.xpath("//*[@name='SaveEdit']"));
        WebElement BtnDynamicEle = wait.until(ExpectedConditions.elementToBeClickable(save2));
        BtnDynamicEle.click();
        Thread.sleep(5000);
    }

    public static void verifyThatANewLeadIsCreated(String Business_Type,String Product_interest) throws InterruptedException {

        Opportunity_Tab();
        Thread.sleep(1000);

        List<WebElement> Leads = Configuration.driver.findElements(By.xpath("//*[contains(@data-refid,'recordId')]"));
        if (!Leads.isEmpty()) {
            WebElement Lead = Leads.get(0);
            WebDriverWait wait = new WebDriverWait(Configuration.driver, 10);
            WebElement EleWait = wait.until(ExpectedConditions.elementToBeClickable(Lead));
            EleWait.click();
            Thread.sleep(3000);
        }

        try {


            wait = new WebDriverWait(Configuration.driver, 30);
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) Configuration.driver;
            js.executeScript("window.scrollBy(0, 100);");

            WebElement ButinessType = Configuration.driver.findElement(By.xpath("//span[text()='" + Business_Type + "']"));
            String businessType = ButinessType.getText();

            if (businessType.contains("Sole Proprietor")) {

                Assert.assertTrue(businessType.contains("Sole Proprietor"), "Element text does not contain 'Sole Proprietor'");
            } else if(businessType.contains("Simple Structure/Registered Business")){

                Assert.assertTrue(businessType.contains("Simple Structure/Registered Business"), "Element text does not contain 'Simple Structure/Registered Business'");
            }else
            {

                System.out.println("Wrong Business type");
            }

//            WebElement Product_interest_ = Configuration.driver.findElement(By.xpath("//span[text()='" + Product_interest + "']"));
//            String product_interest_ = Product_interest_.getText();
//
//            if (product_interest_.contains("Sole Proprietor")) {
//
//                Assert.assertTrue(product_interest_.contains("Sole Proprietor"), "Element text does not contain 'Sole Proprietor'");
//            } else if(businessType.contains("Simple Structure/Registered Business")){
//
//                Assert.assertTrue(product_interest_.contains("Simple Structure/Registered Business"), "Element text does not contain 'Simple Structure/Registered Business'");
//            }else
//            {
//
//                System.out.println("Wrong product");
//            }



//            List<WebElement> LeadStatus = Configuration.driver.findElements(By.xpath("//*[contains(@role,'listitem')]"));
//            if (!LeadStatus.isEmpty()) {
//
//                WebElement btnToClick = LeadStatus.get(3);
//                WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
//
//                String text = btnToClick_.getText();
//
//                Assert.assertTrue(btnToClick_.getText().contains("Converted"), "Element text does not contain 'Converted'");
//
//            } else {
//
//                System.out.println("wrong name");
//
//            }
            Thread.sleep(2000);


//            List<WebElement> BusinessType = Configuration.driver.findElements(By.xpath("//*[contains(@ field-label,'Business Type')]"));
//            if (!BusinessType.isEmpty()) {
//
//                WebElement btnToClick = BusinessType.get(0);
//                WebElement btnToClick_ = wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
//
//                String businessTypeText = btnToClick_.getText();
//
//                if (businessTypeText.contains("Sole Proprietor")) {
//                    Assert.assertTrue(true, "Business type is 'Sole Proprietor'");
//
//                } else if (businessTypeText.contains("Registered Business")) {
//                    Assert.assertTrue(true, "Business type is 'Structured Business'");
//
//                } else {
//                    Assert.fail("Unexpected business type: " + businessTypeText);
//                }
//
//                // Assert.assertTrue(btnToClick_.getText().contains("Sole Proprietor"), "Element text does not contain 'Converted'");
//
//            } else {
//
//                System.out.println("wrong name");
//
//            }
//            Thread.sleep(2000);
//
//
//            List<WebElement> LeadSource = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));
//
//            WebElement Source = LeadSource.get(1);
//
//            String textOwner = Source.getText();
//            Thread.sleep(8000);
//            Assert.assertFalse(textOwner.isEmpty(), "The element is empty");


//            Thread.sleep(8000);
//
//
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

public static void CloneLead() throws InterruptedException {

    Thread.sleep(4000);
    WebElement clone = Configuration.driver.findElement(By.xpath("//*[contains(@name,'Clone')]"));
    WebElement cloneLead = wait.until(ExpectedConditions.elementToBeClickable(clone));
    Thread.sleep(2000);
    cloneLead.click();

}

    public static void VerifyClone() throws InterruptedException {
        Thread.sleep(4000);

            List<WebElement> clonedLead = Configuration.driver.findElements(By.xpath("//a[contains(@class, 'flex-wrap-ie11')]//span"));

            WebElement cloned = clonedLead.get(1);

            String textOwner = cloned.getText();
            Thread.sleep(8000);
            Assert.assertFalse(textOwner.isEmpty(), "The element is empty");
            ;
    }


}
