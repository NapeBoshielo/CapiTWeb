
import co.za.capitecbank.testing.config.Constants;
import co.za.capitecbank.testing.driver_factory.DriverFactory;


import config.Configuration;
import cucumber.api.Scenario;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




import java.time.Duration;

public class HooksTest {


    static Logger Log = LogManager.getLogger(HooksTest.class);


    @Before
    public void setup(){

        Log.info("Setting up driver");
        Configuration.driver = DriverFactory.getBrowser(Constants.Environments.get("Browser"));
        Configuration.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Configuration.driver.get(Constants.Environments.get("TestURL"));

    }

    public static WebDriver getDriver(){
        return Configuration.driver;
    }

    @After
    public void closure(Scenario scenario) throws InterruptedException {

        Log.info("Take ScreenShot");
        final byte[] screenshot = ((TakesScreenshot) Configuration.driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot,scenario.getName());

        Log.info("Closing all test activities");
        Configuration.driver.quit();
    }
}
