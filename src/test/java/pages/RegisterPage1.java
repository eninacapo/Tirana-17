package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage1 {
    WebDriver driver;
    @FindBy(className = "ico-register")
    WebElement register;
    @FindBy (id = "gender-male")
    WebElement genderMale;
    @FindBy (id = "gender-female")
    WebElement genderFemale;
    @FindBy (id = "FirstName")
    WebElement firstname;
    @FindBy (id = "LastName")
    WebElement lastname;
    @FindBy(name ="DateOfBirthDay")
    WebElement dayOfBirth;
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirth;
    @FindBy(name ="DateOfBirthYear")
    WebElement yearOfBirth;
    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement password;
    @FindBy(id="ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "Company")
    WebElement company;
    @FindBy(id = "register-button")
    WebElement registerButton;

    Select yearOfBirthSelect;
    Select monthOfYearSelect;
    Select dateOfBirthSelect;

public RegisterPage1(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    yearOfBirthSelect = new Select(yearOfBirth);
    monthOfYearSelect = new Select(monthOfBirth);
    dateOfBirthSelect = new Select(dayOfBirth);
}

    public void enterGeneralities(String firstName, String lastName, String email, String password, String confirmPassword){
        this.firstname.sendKeys(firstName);
        this.lastname.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);

    }


    public void enterDateOfBirth2(Integer day, Integer month, Integer year){
        dateOfBirthSelect.selectByIndex(day+5);
        monthOfYearSelect.selectByIndex(month+5);
        yearOfBirthSelect.selectByIndex(year+4);
    }
    public void checkGenderMale(){
        genderMale.click();
    }

    public void checkGenderFemale(){
    genderFemale.click();
    }

    public void enterCompanyName(String company){
        this.company.sendKeys(company);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
}
