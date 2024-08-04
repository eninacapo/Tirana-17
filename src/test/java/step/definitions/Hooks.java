package step.definitions;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class Hooks  {

    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        //In case your google version is 102 use chromedriver
        //in case your google version is 107 use chromerdriver2
         System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver3.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

//     @AfterMethod
//     public void takeScreenShotOnFailure(ITestResult TestScenarios) throws IOException {
//         if (TestScenarios.getStatus() == ITestResult.FAILURE) {
//             System.out.println(TestScenarios.getStatus());
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//              FileUtils.copyFile(scrFile, new File("src/test/java/errorScreenshots/" + TestScenarios.getName() + "-"
//                   + Arrays.toString(TestScenarios.getParameters()) + ".jpg"));
//       }
//
//     }


//    @AfterAll
//    public static void end() {
//        driver.quit();
//    }
    }