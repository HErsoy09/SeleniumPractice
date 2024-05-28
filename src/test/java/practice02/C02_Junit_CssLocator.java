package practice02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Junit_CssLocator {

    @Test
    void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://testpages.herokuapp.com/styled/calculator
        driver.get("https://testpages.herokuapp.com/styled/calculator");
        Thread.sleep(2000);

        //ilk kutucuga 30 gir
        driver.findElement(By.cssSelector("#number1")).sendKeys("30");
        Thread.sleep(2000);

        //ikinci kutucuga 15 gir
        driver.findElement(By.cssSelector("#number2")).sendKeys("15");
        Thread.sleep(2000);

        //calculate'e tıkla
        driver.findElement(By.cssSelector("#calculate")).click();
        Thread.sleep(2000);

        //sonucu yazdır
        System.out.println("Answer = " + driver.findElement(By.cssSelector("#answer")).getText());
        Thread.sleep(2000);

        //sayfayı kapat
        driver.quit();

    }
}