package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSE2 extends TestBase {

    @Test
    void test01() {

        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) jse.executeScript( "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")"); //Shadow DOM içinde olduğu için direkt alamıyoruz. Element'in inspect kodu "Copy JS path" ile kopyalanır ve buraya yapıştırılır ve başına return yazılır.

        searchBox.sendKeys("Bu Kadar");
        waitForSecond(3);
    }
}