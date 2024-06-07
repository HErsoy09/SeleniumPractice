package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSE1 extends TestBase {

    @Test
    void test01() {

        // https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");
        waitForSecond(1);

        // username: Admin ve password: admin123 girin, Login butonuna tıklayın
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Type-Casting: Dönüştürme
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement loginButton = driver.findElement(By.tagName("button"));
        waitForSecond(3);

        //JS ile sayfada örnek değişimler
        jse.executeScript("arguments[0].style.backgroundColor = 'black';", loginButton);
        waitForSecond(2);

        jse.executeScript("arguments[0].style.backgroundColor = 'red';", loginButton);
        waitForSecond(2);

        //Tıkla
        jse.executeScript("arguments[0].click()", loginButton);
        waitForSecond(3);
    }
}