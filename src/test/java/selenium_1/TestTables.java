package selenium_1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.lang.String;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestTables {

    //import org.testng.annotations.Test;
    public static Logger logger = Logger.getLogger(TestElement.class);
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpvis\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    }

    @AfterTest
    public void cleanUp() {
        // clean up after each test
        driver.quit();
    }

    public static WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?m=1");
        return driver;
    }

    @Test
    public void getTableRecord() {
       WebDriver driver = new ChromeDriver();
        PropertyConfigurator.configure(ClassLoader.getSystemResource("Log4j.properties"));
        driver.get("https://letcode.in/table");
        // get the tables
        // Locate the table by its ID
        WebElement table = driver.findElement(By.id("shopping"));

        // legend --
        // thead -- table head
        // tr -- table row
        // th -- table header
        // tbody -- table body

        // Get all rows in the table
        // even headers and values all in tr only
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            // Get all cells in the current row
            List<WebElement> cells = row.findElements(By.xpath("./*")); // Handles both <td> and <th>

            for (WebElement cell : cells) {
                System.out.print(cell.getText() + " | ");
            }
            System.out.println();
        }
        browserWait(2000);
    }

    private static WebDriver openWebPage(String url) {
        WebDriver driver = new ChromeDriver();
        PropertyConfigurator.configure(ClassLoader.getSystemResource("Log4j.properties"));
        driver.get(url);
        logger.info("Webpage: " + url + " -- opened successfully");
        browserWait(2000);
        return driver;
    }

    private static void browserWait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}