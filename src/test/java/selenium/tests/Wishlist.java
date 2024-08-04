package selenium.tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import step.definitions.ScreenshotOnFailure;

public class Wishlist extends ScreenshotOnFailure {
    MainPage MainPage;

    @Test
    public void Wishlist() {
        driver.get("https://demo.nopcommerce.com/");
        MainPage = new MainPage(driver);
        MainPage.clickOnWishlistLink();
    }
}
