package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    WebDriver driver;
    @FindBy(className = "ico-register")
    WebElement register;

    @FindBy(className = "ico-login")
    WebElement login;

    @FindBy(className = "wishlist-label")
    WebElement wishlistLabel;

    @FindBy(css = ".topic-block-title > h2")
    WebElement welcomeLabel;

    @FindBy(className = "ico-logout")
    WebElement logout;

    @FindBy(css = ".notmobile [href='\\/computers']")
    WebElement computersMenu;

    @FindBy(css = ".notmobile [href='\\/notebooks']")
    WebElement notebooksMenu;

    Actions action;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }
    public void clickOnWishlistLink(){
        wishlistLabel.click();
    }
    public void clickOnRegisterLink(){
        register.click();
    }

    public void clickOnLoginLink(){
        login.click();
    }

    public boolean isLogoutVisible(){
        return logout.isDisplayed();
    }

    public void logout(){
        logout.click();
    }

    public String getWelcomeMessage(){
        return  welcomeLabel.getText();
    }

    public void hoverComputerMenu(){
        action.moveToElement(computersMenu);
        action.moveToElement(notebooksMenu);
        action.click().build().perform();
    }

}
