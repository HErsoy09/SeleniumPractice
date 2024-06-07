package practice05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    void test01() {

        // https://opensource-demo.orangehrmlive.com/ sitesine gidin
        orangeHRMLogin();

        // PIM butonuna tıkla
        driver.findElement(By.xpath("//a[.='PIM']")).click();

        // Add tıkla
        driver.findElement(By.xpath("//button[.=' Add ']")).click();

        // Locate
        driver.findElement(By.name("firstName")).sendKeys("Alice");
        driver.findElement(By.name("middleName")).sendKeys("in");
        driver.findElement(By.name("lastName")).sendKeys("Wonderland");
        driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")).sendKeys("5");

        // Foto Ekleme
        WebElement addPhotoButton = driver.findElement(By.cssSelector(".oxd-icon-button.oxd-icon-button--solid-main.employee-image-action"));
        addPhotoButton.click();

        String dynamicPath = System.getProperty("user.dir");
        String photoPath = dynamicPath + "\\src\\test\\resources\\avatar.png";
        uploadFilePath(photoPath);

        //Foto eklendiğini doğrulama
        //String srcBeforePhotoUpload = "/web/images/default-photo.png";
        String srcExpected = "data:image/png";

        String srcActual = driver.findElement(By.xpath("//div/img[@alt='profile picture']")).getAttribute("src");

        Assertions.assertTrue(srcActual.contains(srcExpected));

        // Save Tuşu
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        //Success Kontrolü
        WebElement successMessage = driver.findElement(By.xpath("//*[text()='Success']"));
        Assertions.assertEquals("Success", successMessage.getText());

        waitForSecond(2);
    }
}