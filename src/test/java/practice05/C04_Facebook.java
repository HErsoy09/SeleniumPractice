package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Facebook extends TestBase {

    @Test
    void test01() {

        driver.get("https://www.facebook.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("document.getElementById('email').value='abc@def.ghi';");
        jse.executeScript("document.getElementById('pass').value='pass';");

        waitForSecond(3);
    }
}