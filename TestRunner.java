
import co.za.capitecbank.testing.config.Constants;
import co.za.capitecbank.testing.utilities.Reports;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;
import config.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.Reporter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/** The execution Engine is resposible to run the cucumber features
 * exucutable as mvn job using mvn clean test -P <Environment>
 * @lastupdate 2022-12-28
 * @author Vusi Pelo
 * @version 1.0
 * @since 2022-12-20
 */

@ExtendedCucumberOptions(
        jsonReport = "target/cucumber-report.json",
        retryCount = 3,
        detailedReport = true,
        overviewReport = true,
        consolidatedReport = false,
        toPDF = true,
        excludeCoverageTags = {""},
        includeCoverageTags = {""},
        outputFolder = "target/cucumber-pdf-reports"
)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",
                "html:target/cucumber-report.html"
                //"com.avenstack.extendedreports.cucumber.adapter.ExtentCucumberAdepter",
        },
        features = {"src/test/resources/features"},
        glue = {""},
        tags = "@Client360"
)

public class TestRunner  extends ExtendedTestNGRunner {

        private static String environment;
        private static Reports cucumberReport;
        static Logger log = LogManager.getLogger(TestRunner.class);

        @DataProvider(name="features")


        @Parameters("environment")
        @BeforeSuite
        public static void setup() throws Exception {
                log.info("Initialize Test");
                String config_file = "config.json";

               // ITestContext ctx = Reporter.getCurrentTestResult().getTestContext();


                environment = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("environment");
                System.out.println("Environment : "+environment);
                if (environment == null)
                        environment = "dev";


                JSONParser parser = new JSONParser();
                JSONObject common = (JSONObject)parser.parse(new FileReader("src/test/resources/config/" + environment + "/" + config_file));
                JSONObject envs = (JSONObject)common.get("Environment");
                JSONObject configuration = (JSONObject)common.get("Configuration");
                JSONObject report = (JSONObject)common.get("Report");
                Iterator it = envs.entrySet().iterator();

                while(it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        log.info("key: " + pair.getKey().toString() + "Value: " + pair.getValue().toString());
                        System.out.println("key: "+pair.getKey().toString()+ "Value: " +pair.getValue().toString());
                }

                Constants.Environments = envs;
                Constants.Config = configuration;
                Constants.Report = report;


        }

        @AfterSuite
        public static void tearDown() throws IOException {

                log.info("Test Closure");
                cucumberReport = new Reports(
                        Constants.Report.get("ProjectName"),
                        Constants.Report.get("BuildName"),
                        Constants.Report.get("TrendsPath"), Integer.valueOf((String)Constants.Report.get("TrendsLimit")));
                cucumberReport.CreateReport();

        }

       private  static List<String> copyTrendFiles() throws IOException {
               int fileCount;
               int nextFile;
               File original = new File(
                       "target/cucumber-report.json");


               List<String> fileNames = new ArrayList<>();
               try {
                       DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("src/test/trends"));
                       for (Path path : directoryStream) {
                               fileNames.add(path.toString());
                       }
               } catch (IOException ex) {
               }
               fileCount = fileNames.size();

               if(fileCount==1) {
                       nextFile = fileCount;
               }else{
                       nextFile =+ fileCount;
               }

               File copied = new File(
                       "src/test/trends/cucumber-report" +nextFile+".json");

               FileUtils.copyFile(original, copied);

               return fileNames;

       }


}
