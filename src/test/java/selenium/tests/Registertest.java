package selenium.tests;

import org.junit.jupiter.api.Test;
import org.testng.reporters.jq.Main;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage1;
import pages.RegisterSuccess;
import step.definitions.ScreenshotOnFailure;

import static step.definitions.Hooks.driver;

public class Registertest extends ScreenshotOnFailure {
    private static String email = "eninacapo3@gmail.com";
    private String name ="Enina";
    private String lastname="Capo";
    private  String pass="Ene12345!";
    private String confirmpassword="Ene12345!";
    MainPage MainPage;
    RegisterPage1 registerPage1;
    RegisterSuccess RegisterSuccess;
@Test
    public void registerTest(){
        driver.get("https://demo.nopcommerce.com/");
        MainPage = new MainPage(driver);
        MainPage.clickOnRegisterLink();
        registerPage1 = new RegisterPage1(driver);
        registerPage1.enterGeneralities(name,lastname,email,pass,confirmpassword);
        registerPage1.checkGenderFemale();
        registerPage1.enterDateOfBirth2(1,1,98);
        registerPage1.enterCompanyName("KL");
        registerPage1.clickRegisterButton();
    }
}
