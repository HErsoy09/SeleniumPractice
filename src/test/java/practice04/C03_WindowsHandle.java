package practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_WindowsHandle extends TestBase {

    @Test
    void test01() {

        //ANA SAYFAYA GİT
        driver.get("https://allovercommerce.com/");

        //SAYFAYA GİDİLDİĞİNİ DOĞRULA
        Assertions.assertEquals("https://allovercommerce.com/", driver.getCurrentUrl());
        Assertions.assertEquals("Allover Commerce", driver.getTitle());

        //REGISTER
        driver.findElement(By.cssSelector(".register.inline-type")).click();

        //BECOME A VENDOR
        driver.findElement(By.linkText("Become a Vendor")).click();
        waitForSecond(1);

        //WINDOWSHANDLE ALLOVER
        String allOverCommerceHandle = driver.getWindowHandle();

        //FAKEMAIL
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.fakemail.net/");

        //WINDOWSHANDLE FAKEMAIL
        String fakeMailHandle = driver.getWindowHandle();

        //COPY EMAIL
        //driver.findElement(By.xpath("(//*[@title='Copy this email address'])[2]")).click();
        String emailAddress = driver.findElement(By.xpath("//span[@id='email']")).getText();
        waitForSecond(1);

        //PASTE EMAIL
        driver.switchTo().window(allOverCommerceHandle);
        driver.findElement(By.id("user_email")).sendKeys(emailAddress, Keys.TAB);

        //DOĞRULAMA KODU GÖNDERİLDİ METNİ KONTROLÜ
        WebElement emailDogrulamaMetni = driver.findElement(By.cssSelector(".wcfm-message.email_verification_message.wcfm-success"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailDogrulamaMetni));

        Assertions.assertTrue(emailDogrulamaMetni.getText().contains(emailAddress));

        //SWITCHTO FAKEMAIL
        driver.switchTo().window(fakeMailHandle);

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id='schranka']")),"Allover Commerce"));
        driver.findElement(By.xpath("//tbody[@id='schranka']/tr[1]")).click();

        //IFRAME
        WebElement iframeMail = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeMail);

        //SAYFA YÜKLEMESİNİ BEKLEME
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));

        WebElement verificationCode = driver.findElement(By.tagName("b"));
        String vCodeText = verificationCode.getText();

        driver.switchTo().parentFrame();

        //SWITCHTO ALLOVER
        driver.switchTo().window(allOverCommerceHandle);
        driver.findElement(By.xpath("//*[@name='wcfm_email_verified_input']")).sendKeys(vCodeText);

        //ŞİFRE GİRME
        driver.findElement(By.id("passoword")).sendKeys("hE123!");
        driver.findElement(By.id("confirm_pwd")).sendKeys("hE123!");

        //REGISTER
        driver.findElement(By.id("wcfm_membership_register_button")).click();

    }
}