package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class NotebooksPage {
    WebDriver driver;
    @FindBy(id = "products-pagesize")
    WebElement quantityOfProducts;

    @FindBy(css = "[value='9']")
    WebElement nineOption;


    @FindBy(id = "attribute-option-10")
    WebElement memory16GB;

    @FindBy(css = "div:nth-of-type(2) > .product-item button[title='Add to wishlist']")
    WebElement secondWishlistButton;



    @FindBy(css = "div:nth-of-type(3) > .product-item button[title='Add to wishlist']")
    WebElement thirdIWishlistButton;

    @FindBy(css = "div:nth-of-type(4) > .product-item .button-2.product-box-add-to-cart-button")
    WebElement fourthAddToCartButton;

    @FindBy(css = "div:nth-of-type(5) > .product-item .button-2.product-box-add-to-cart-button")
    WebElement fifthAddToCartButton;

    @FindBy(css = "div:nth-of-type(6) > .product-item .button-2.product-box-add-to-cart-button")
    WebElement sixthAddToCartButton;

    @FindBy(className = "content")
    WebElement wishlistSuccessNotification;

    @FindBy(className = "close")
    WebElement successNotificationCloseButton;

    @FindBy(className = "content")
    WebElement shoppingCartSuccessNotification;

    @FindBy(className = "wishlist-qty")
    WebElement wishlistQuantity;

    @FindBy(className = "cart-qty")
    WebElement shoppingCartQuantity;
    //All elements that have the class name item-grid and all div are in the same level
    @FindBys({
            @FindBy(className = "item-grid"),
            @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div")


    })
    public List<WebElement> products;

    @FindBy(id = "topcartlink")
    WebElement shoppingCartMenuBar;

    @FindBy(css = "#flyout-cart > div > div.buttons > button")
    WebElement toCartButton;

    Actions action;

    public NotebooksPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

    public void clickOnQuantityOfProducts() {
        quantityOfProducts.click();
    }

    public void clickOnNineOption() {
        nineOption.click();
    }

    public void clickOnMemory16GB() {
        memory16GB.click();
    }

    public void clickSecondWishlistButton() {
        secondWishlistButton.click();
    }

    public void clickThirdWishlistButton() {
        thirdIWishlistButton.click();
    }

    public void clickFourthAddToCartButton() {
        fourthAddToCartButton.click();
    }

    public void clickFifthAddToCartButton() {
        fifthAddToCartButton.click();
    }

    public void clickSixthAddToCartButton() {
        sixthAddToCartButton.click();
    }

    public String checkWishlistSuccessNotification() {
        return wishlistSuccessNotification.getText();
    }

    public void clickSuccessCloseButton() {
        successNotificationCloseButton.click();
    }

    public WebElement getShoppingCartSuccessNotification() {
        return shoppingCartSuccessNotification;
    }

    public String checkWishlistQuantity() {

        return wishlistQuantity.getText();
    }

    public String checkShoppingCartQuantity() {

        return shoppingCartQuantity.getText();
    }

    public void hoverShoppingCartMenu() {
        action.moveToElement(shoppingCartMenuBar);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        action.moveToElement(toCartButton);
        action.click().build().perform();
    }

    public int getQuantityOfProducts(){
        return products.size();
    }
}