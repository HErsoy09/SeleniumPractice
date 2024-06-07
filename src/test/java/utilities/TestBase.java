package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
        waitForSecond(2);
        //sayfayı kapat
        driver.quit();
        System.out.println("AfterEach");
    }

    //Hard Wait
    public void waitForSecond(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void orangeHRMLogin() {
        //1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");
        waitForSecond(1);

        //2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();
        waitForSecond(1);
    }

    //DDM'den Visible Text ile Seçim
    public void selectVisibleTest(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //DDM'den index ile Seçim
    public void selectIndex(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);

    }

    //Index ile Window'a geçiş yapmak
    public void switchToWindow (int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }

    //File Upload ROBOT CLASS
    public void uploadFilePath(String dosyaYolu) {
        try {
            waitForSecond(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.

            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            StringSelection stringSelection = new StringSelection(dosyaYolu);

            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere siste
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini
            Robot robot = new Robot();

            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            // CTRL ve V tuşlarından elini kaldirir
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);

            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.delay(1000);

            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            // Sonraki işlemler için ek 3 saniye bekler.
            robot.delay(1000);
        } catch (Exception ignored) {
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }

}