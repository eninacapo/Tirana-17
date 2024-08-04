package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login1Page {
    WebDriver driver;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(css = "button-1 login-button")
    WebElement loginButton
            ;

public Login1Page (WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver,this);
}
public void clickLoginButton() {
    clickLoginButton();
}
    public void login(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        loginButton.click();
    }

}


