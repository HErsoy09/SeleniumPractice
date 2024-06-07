package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSE3 extends TestBase {

    @Test
    void test01() {

        driver.get("https://shop.polymer-project.org/");
        waitForSecond(2);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement shopNowButton1 = (WebElement) jse.executeScript("return document.querySelector(\"body > shop-app\").shadowRoot.querySelector(\"iron-pages > shop-home\").shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\")");

        shopNowButton1.click();
        waitForSecond(2);
    }
}