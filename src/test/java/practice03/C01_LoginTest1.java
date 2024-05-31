package practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_LoginTest1 extends TestBase {

    @Test
    void test01() {

        //1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");
        waitForSecond(1);

        //2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        driver.findElement(By.name("username")).sendKeys("Admin");
        waitForSecond(1);
        driver.findElement(By.name("password")).sendKeys("admin123");
        waitForSecond(1);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        waitForSecond(1);

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