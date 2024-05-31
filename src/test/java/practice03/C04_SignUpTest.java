package practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_SignUpTest extends TestBase {

    @Test
    void test01() {

        Faker faker = new Faker();

        //1) 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");
        waitForSecond(1);

        //2) Sayfaya girildigini dogrulavin
        String expectedTitle = "Automation Exercise";
        Assertions.assertEquals(expectedTitle, driver.getTitle());

        //3) "Signup / Login" butonuna TIKLAYIN
        driver.findElement(By.partialLinkText("Signup")).click();
        waitForSecond(1);

        //4) "Signup / Login" sayfasina girildigini dogrulavin
        String expectedUrl = "https://automationexercise.com/login";
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());

        //5) "New User Signup!" Name ve Email Address gir
        WebElement userName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement userEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        userName.sendKeys(faker.name().fullName());
        waitForSecond(1);
        userEmail.sendKeys(faker.internet().emailAddress());
        waitForSecond(1);

        //6) "Signup" buttonuna TIKLA
        driver.findElement(By.xpath("//button[.='Signup']")).click();
        waitForSecond(1);

        //7) "ENTER ACCOUNT INFORMATION" bilgilerini gir
        driver.findElement(By.cssSelector("#id_gender1")).click();
        waitForSecond(1);

        WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
        password.sendKeys(faker.internet().password());
        waitForSecond(1);

        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys(faker.name().firstName());
        waitForSecond(1);

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys(faker.name().lastName());
        waitForSecond(1);

        //8) "Sign up for our newsletter!" onay kutusunu secin.
        driver.findElement(By.id("newsletter")).click();
        waitForSecond(1);

        //9) "Receive special offers from our partners!" onay kutusunu seçin.
        driver.findElement(By.id("optin")).click();
        waitForSecond(1);

        //10) "ADDRESS INFORMATION" bilgilerini gir
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys(faker.address().fullAddress());
        waitForSecond(1);

        WebElement country = driver.findElement(By.id("country"));
        Select options = new Select(country);
        options.selectByVisibleText("United States");
        waitForSecond(1);

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys(faker.address().state());
        waitForSecond(1);

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(faker.address().city());
        waitForSecond(1);

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys(faker.address().zipCode());
        waitForSecond(1);

        WebElement mobile = driver.findElement(By.id("mobile_number"));
        mobile.sendKeys(faker.phoneNumber().cellPhone());
        waitForSecond(1);

        driver.findElement(By.xpath("//*[.='Create Account']")).click();
        waitForSecond(1);

        //11) Hesap olusturuldugunu dogrula
        String expectedUrl2 = "https://automationexercise.com/account_created";
        Assertions.assertEquals(expectedUrl2, driver.getCurrentUrl());
    }
}