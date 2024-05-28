package practice02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_TestBaseUsage extends TestBase {

    @Test
    void test01() throws InterruptedException {

        //https://testpages.herokuapp.com/styled/calculator
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        Thread.sleep(1000);

        //ilk kutucuga 30 gir
        driver.findElement(By.cssSelector("#number1")).sendKeys("30");
        Thread.sleep(1000);

        //ikinci kutucuga 15 gir
        driver.findElement(By.cssSelector("#number2")).sendKeys("15");
        Thread.sleep(1000);

        //calculate'e tıkla
        driver.findElement(By.cssSelector("#calculate")).click();
        Thread.sleep(1000);

        //sonucu yazdır
        System.out.println("Answer = " + driver.findElement(By.cssSelector("#answer")).getText());
    }
}