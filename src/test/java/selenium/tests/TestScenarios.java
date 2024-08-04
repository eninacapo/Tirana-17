package selenium.tests;


import io.qameta.allure.*;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.*;
import step.definitions.Hooks;
//import step.definitions.ScreenshotOnFailure;
import step.definitions.ScreenshotOnFailure;
import utils.EmailGenerator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Epic(" Java - Miniproject")
@Feature("nopCommerce Test Scenarios")

public class TestScenarios extends ScreenshotOnFailure {

    private static String email ="eninacapo@gmail.com";
    LoginPage loginPage;
    MainPage mainPage;
    RegisterPage registerPage;
    RegisterSuccess registerSuccess;
    NotebooksPage notebooksPage;
    ShoppingCartPage shoppingCartPage;
    private String password = "Enina123!.";

   // @BeforeAll
    //public static void setRandomEmail() {
    //  email = EmailGenerator.generateRandomEmail();
   // }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Order(1)
    @Step("1")
    @Description("Register Test")


    public void registerTest() {

        //	Navigate to : https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        //2.	Click LogIn - Menu
        mainPage = new MainPage(driver);
        mainPage.clickOnLoginLink();
        //3.	Click  Register - button
        loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        //4.	Check the title of the page after clicking Register button
        registerPage = new RegisterPage(driver);
        assertEquals(driver.getTitle(), "nopCommerce demo store. Register");
        //5.	Fill the register form as below:
        registerPage.checkGenderFemale();
        registerPage.enterGeneralities("Gezim", "Cako", email, password);
        registerPage.enterDateOfBirth(14, 1, 97);
        registerPage.enterCompanyName("Online Shopping Sale");
        registerPage.clickRegisterButton();
        //6.	Verify that register is successful
        String expectedResult = "Your registration completed";
        registerSuccess = new RegisterSuccess(driver);
        assertEquals(expectedResult, registerSuccess.returnResultMessage());
        //7.	Click Log out - Menu
        mainPage.logout();
    }


    @Test
    @Step
    @Severity(SeverityLevel.NORMAL)
    @Order(2)
    @Description("Login Test")
    public void loginTest()  {
        //1.Navigate to : https://demo.nopcommerce.com/
        driver.get("https://demo.nopcommerce.com/");
        //2.Click LogIn - Menu
        mainPage = new MainPage(driver);
        mainPage.clickOnLoginLink();
        //3.	Login with the credentials created from Test 1
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        //4.Verify that login is successful:   -“Welcome to our store text” - is displayed    -Log out - Menu is displayed
        assertEquals(mainPage.getWelcomeMessage(), "Welcome to our store");
        assertTrue(mainPage.isLogoutVisible());
        //5.	Log out is implemented in the last testCase
    }

    @Test
    @Step
    @Order(3)
    @Description("Dashboard Test")
    public void dashboardTest() throws Exception {
        // Precondition: Log in nopCommerce Application
        //1.	Hover over Computers Menu
        // 2.	Click Notebooks
        driver.get("https://demo.nopcommerce.com/");
        //driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.hoverComputerMenu();
        //3.	Verify that we have navigate to Notebooks Page
        notebooksPage = new NotebooksPage(driver);
        System.out.println("Gjendja e produkteve eshte:" + "" + notebooksPage.getQuantityOfProducts());
        assertEquals(driver.getTitle(), "nopCommerce demo store. Notebooks");
        //4.	Choose 9 on Display dropdown
        notebooksPage.clickOnQuantityOfProducts();
        notebooksPage.clickOnNineOption();
        //5.	Verify that only 6 items are displayed
        assertEquals(6, notebooksPage.getQuantityOfProducts());
        //6.	On Filter by attributes check 16GB
        notebooksPage.clickOnMemory16GB();
        //7.	Verify that only 1 item is displayed
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".item-grid > div:nth-of-type(2)")));
        assertEquals(1, notebooksPage.getQuantityOfProducts());
        //8.Uncheck the 16GB checkbox
        notebooksPage.clickOnMemory16GB();
        //9.	Verify that 6 items are displayed now
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item-grid .item-box:nth-of-type(2)")));
        assertEquals(6, notebooksPage.getQuantityOfProducts());
        //10.	Add the second and the third item on wishlist
        //11.	Verify that after every item added a notification with text : The product has been added to your wishlist – is displayed
        notebooksPage.clickSecondWishlistButton();
        assertEquals(notebooksPage.checkWishlistSuccessNotification(), "The product has been added to your wishlist");
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        notebooksPage.clickSuccessCloseButton();

        notebooksPage.clickThirdWishlistButton();
        assertEquals(notebooksPage.checkWishlistSuccessNotification(), "The product has been added to your wishlist");
        notebooksPage.clickSuccessCloseButton();
        Thread.sleep(2000);
        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        //12.	Add the fourth, fifth and sixth item on Shopping Cart
        //13.	Verify that after every item added a notification with text : The product has been added to your shopping cart
        //14.	Verify that Wishlist on Menu bar displays 2
        //15.	Verify that Shopping Cart on Menu bar displays 3
        wait.until(ExpectedConditions.textToBe(By.className("wishlist-qty"), "(2)"));
        notebooksPage.clickFourthAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessCloseButton();
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(1)"));
        notebooksPage.clickFifthAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessCloseButton();
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(2)"));
        notebooksPage.clickSixthAddToCartButton();
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));
        notebooksPage.clickSuccessCloseButton();

        wait.until(ExpectedConditions.textToBe(By.className("cart-qty"), "(3)"));
        wait.until(ExpectedConditions.textToBePresentInElement(notebooksPage.getShoppingCartSuccessNotification(), "The product has been added to your shopping cart"));

        assertEquals(notebooksPage.checkWishlistQuantity(), "(2)");
        assertEquals(notebooksPage.checkShoppingCartQuantity(), "(3)");
        //16.	Close the browser
    }

    @Test
    @Order(4)
    @Description("Shopping Cart Test")
    public void shoppingCartTest() throws Exception {

        //Precondition: Test 3
        //1.	Hover over Shopping Cart –Menu
        //2.	Verify that ‘Go To Cart’ – button is displayed
        //3.	Click ‘Go To Cart’ – button
        notebooksPage = new NotebooksPage(driver);
        Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        notebooksPage.hoverShoppingCartMenu();
        //4.	Verify that we have navigate to Shopping Cart Page
        shoppingCartPage = new ShoppingCartPage(driver);
        assertEquals(driver.getTitle(), "nopCommerce demo store. Shopping Cart");
        //5.	Verify that following buttons are displayed
        assertTrue(shoppingCartPage.isUpdateShoppingCartButtonVisible());
        assertTrue(shoppingCartPage.isContinueShoppingButtonVisible());
        assertTrue(shoppingCartPage.isEstimateShippingButtonVisible());
        //6.	Verify that the prices sum for all items is equal to Total Price in the end of the page
        assertEquals(shoppingCartPage.summary(), shoppingCartPage.sumOfTheSales());
        System.out.println(shoppingCartPage.summary());// test
        System.out.println(shoppingCartPage.sumOfTheSales());
        //7.	Close the browser is implemented in the fifth test case
    }

    @Test
    @Order(5)
    @Description("Empty Shopping Cart Test")

    public void emptyShoppingCartTest() throws IOException {
        // Precondition: Test 3 & Test 4
        //1.	Delete the first item on shopping cart
         shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickDeleteButton();
        //2.	Verify that the number of elements in Shopping Cart table is decreased by 1
        notebooksPage = new NotebooksPage(driver);
        assertEquals(notebooksPage.checkShoppingCartQuantity(), "(2)");
        //3.	Repeat steps 1&2 until the last item is deleted
        shoppingCartPage.clickDeleteButton();
        assertEquals(notebooksPage.checkShoppingCartQuantity(), "(1)");
        shoppingCartPage.clickDeleteButton();
        assertEquals(notebooksPage.checkShoppingCartQuantity(), "(0)");
        //4.	Verify that Shopping Cart is empty
        assertTrue(shoppingCartPage.isNoProductsInShoppingCartVisible());
        assertEquals(shoppingCartPage.noProductsInShoppingCart(), "Your Shopping Cart is empty!");
        //5.	Close the browser
        mainPage = new MainPage(driver);
        // It comes from the second test Case
        mainPage.logout();
    }
}
