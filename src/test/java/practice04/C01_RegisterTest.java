package practice04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_RegisterTest extends TestBase {

    @Test
    void registerTest() {

        driver.get("https://www.trvlcar.com/");
        Assertions.assertEquals("TrvlCar | Premium Car Rental", driver.getTitle());

        WebElement loginRegisterButton = driver.findElement(By.xpath("//a[@href='/auth']"));
        loginRegisterButton.click();

        WebElement registerButton = driver.findElement(By.xpath("//*[@data-rr-ui-event-key='register']"));
        registerButton.click();

        Faker faker = new Faker();

        WebElement firstNameTextBox = driver.findElement(By.name("firstName"));
        firstNameTextBox.sendKeys(faker.name().firstName());

        WebElement lastNameTextBox = driver.findElement(By.name("lastName"));
        lastNameTextBox.sendKeys(faker.name().lastName());

        WebElement phoneNumberTextBox = driver.findElement(By.name("phoneNumber"));
        phoneNumberTextBox.click();
        phoneNumberTextBox.sendKeys(faker.number().digits(10));

        WebElement addressTextBox = driver.findElement(By.name("address"));
        addressTextBox.sendKeys(faker.address().fullAddress());

        WebElement zipCodeTextBox = driver.findElement(By.name("zipCode"));
        zipCodeTextBox.sendKeys(faker.address().zipCode());


        WebElement emailTextBox = driver.findElement(By.xpath("(//*[@name='email'])[2]"));
        //emailTextBox.click();
        emailTextBox.sendKeys("he1@qa.io");

        WebElement passwordTextBox = driver.findElement(By.xpath("(//*[@name='password'])[2]"));
        WebElement passwordConfirmTextBox = driver.findElement(By.name("confirmPassword"));
        String psswrd = "hE12340!";
        passwordTextBox.sendKeys(psswrd);
        passwordConfirmTextBox.sendKeys(psswrd);

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).submit();
        waitForSecond(3);

        WebElement success = driver.findElement(By.xpath("//*[.='You are registered successfully']"));
        Assertions.assertTrue(success.isDisplayed());
    }
}