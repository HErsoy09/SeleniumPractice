package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C02_HelloSeleniumEdge {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(2000);
        driver.quit();

    }

}
