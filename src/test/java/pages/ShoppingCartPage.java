package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.StringManipulator;


public class ShoppingCartPage {
    WebDriver driver;

    @FindBy(css = ".cart tr:nth-of-type(1) .remove-btn")
    WebElement firstDeleteButton;

    @FindBy(id = "updatecart")
    WebElement updateCartButton;

    @FindBy(name = "continueshopping")
    WebElement continueShoppingButton;

    @FindBy(id = "open-estimate-shipping-popup")
    WebElement estimateShippingButton;

    @FindBy(css = ".cart tr:nth-of-type(1) .product-subtotal")
    WebElement value1;

    @FindBy(xpath = "//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[2]/td[6]/span")
    WebElement value2;

    @FindBy(xpath = "//*[@id='shopping-cart-form']/div[1]/table/tbody/tr[3]/td[6]/span")
    WebElement value3;

    @FindBy(className = "value-summary")
    WebElement summaryValue;

    @FindBy(className = "no-data")
    WebElement noDataInShoppingCard;


    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDeleteButton() {
        firstDeleteButton.click();
    }

    public boolean isUpdateShoppingCartButtonVisible() {
        return updateCartButton.isDisplayed();
    }

    public boolean isContinueShoppingButtonVisible() {
        return continueShoppingButton.isDisplayed();
    }

    public boolean isEstimateShippingButtonVisible() {
        return estimateShippingButton.isDisplayed();
    }

    public boolean isNoProductsInShoppingCartVisible() {
        return noDataInShoppingCard.isDisplayed();
    }

    public String noProductsInShoppingCart() {
        return noDataInShoppingCard.getText();
    }

    public Float summary() {
        return StringManipulator.currencyStringToFloat(summaryValue);

    }

    public Float sumOfTheSales() {
        return StringManipulator.currencyStringToFloat(value1) +
                StringManipulator.currencyStringToFloat(value2) +
                StringManipulator.currencyStringToFloat(value3);


    }

}