package practice02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_CheckBox extends TestBase {
    @Test
    void test01() throws InterruptedException {
        //https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");


        WebElement cb1 = driver.findElement(By.cssSelector("#vfb-6-0"));
        WebElement cb2 = driver.findElement(By.cssSelector("#vfb-6-1"));
        WebElement cb3 = driver.findElement(By.cssSelector("#vfb-6-2"));
        Thread.sleep(2000);

        //checkbox1 ve checkbox3 secili değilse secin
        if (!cb1.isSelected()) {
            cb1.click();
        }
        Thread.sleep(1000);
        if (!cb3.isSelected()) {
            cb3.click();
        }
        Thread.sleep(1000);

        //checkbox1 ve checkbox3 secili olduğunu test edein
        Assertions.assertTrue(cb1.isSelected(), "CB1 işaretli değil");
        Assertions.assertTrue(cb3.isSelected(), "CB3 işaretli değil");

        //checkbox2 elementinin secili olmadığını test edin
        Assertions.assertFalse(cb2.isSelected(), "CB2 işaretli");
    }
}