package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

@UtilityClass
public class StringManipulator {

    public Float currencyStringToFloat(WebElement value) {
        String valueOfString = value.getText()
                .replace("$", "")
                .replace(",", "");
        return Float.valueOf(valueOfString);
    }

}
