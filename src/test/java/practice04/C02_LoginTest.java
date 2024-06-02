package practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_LoginTest extends TestBase {

    @Test
    void loginTest() {

        driver.get("https://www.trvlcar.com/");
        Assertions.assertEquals("TrvlCar | Premium Car Rental", driver.getTitle());

        WebElement loginRegisterButton = driver.findElement(By.xpath("//a[@href='/auth']"));
        loginRegisterButton.click();

        WebElement loginEmailTextBox = driver.findElement(By.xpath("(//*[@name='email'])[1]"));
        loginEmailTextBox.sendKeys("he1@qa.io");

        WebElement loginPasswordTextBox = driver.findElement(By.xpath("(//*[@name='password'])[1]"));
        loginPasswordTextBox.sendKeys("hE12340!");

        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).submit();
        waitForSecond(3);

        WebElement userDropdownMenu = driver.findElement(By.cssSelector(".dropdown-toggle.nav-link"));
        Assertions.assertTrue(userDropdownMenu.isDisplayed());

    }
}
