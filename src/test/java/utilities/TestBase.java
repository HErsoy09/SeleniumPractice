package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeEach
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("BeforeEach");
    }

    @AfterEach
    protected void tearDown() {
        //sayfayı kapat
        driver.quit();
        System.out.println("AfterEach");
    }
}