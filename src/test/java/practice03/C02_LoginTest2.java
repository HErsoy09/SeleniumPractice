package practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_LoginTest2 extends TestBase {

    @Test
    void test01() {

        orangeHRMLogin();

        //3) Sayfaya giriş yapıldığını doğrula
        Assertions.assertNotNull(driver.findElement(By.cssSelector(".oxd-userdropdown")));

        //4) Admin butonunun görüdüğünü doğrula
        Assertions.assertNotNull(driver.findElement(By.linkText("Admin")));

        //5) Sayfadan cıkış yap
        WebElement userMenu = driver.findElement(By.cssSelector(".oxd-userdropdown-name"));
        userMenu.click();
        waitForSecond(1);
        driver.findElement(By.xpath("//*[.='Logout']")).click();
        waitForSecond(1);

        //6) Sayfadan Çıkış Yapıldığını Doğrula
        Assertions.assertNotNull(driver.findElement(By.xpath("//*[.='Login']")));
    }
}