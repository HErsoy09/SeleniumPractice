package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_FirstTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //Ebay sitesi
        driver.get("https://ebay.com");

        //Title test, ekrana yazdır
        //Electronics, Cars, Fashion, Collectibles & More | eBay
        System.out.println("Title = " + driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title Test Pass");
        } else {
            System.err.println("Title Test Fail");
        }

        //URL test, ekrana yazdır
        System.out.println("Current Url = " + driver.getCurrentUrl());

        String actualUrl = driver.getTitle();
        String expectedUrl = "https://ebay.com";

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url Test Pass");
        } else {
            System.err.println("Url Test Fail");
        }

        //pagesource test, ekrana yazdır
        System.out.println("PageSource = " + driver.getPageSource());

        driver.quit();
    }
}