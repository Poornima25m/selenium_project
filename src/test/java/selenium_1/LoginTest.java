package selenium_1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    static Logger logger = Logger.getLogger(LoginTest.class);


    public static void main(String[] args) {
        PropertyConfigurator.configure("log4j.properties");

        logger.info("Starting test case: LoginTest");
        logger.debug("Opening browser");

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpvis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.w3schools.com/");
            driver.findElement(By.id("search2")).sendKeys("Java ", Keys.ENTER);
            driver.quit();
        // Your Selenium code here
        // WebDriver driver = new ChromeDriver();

        logger.warn("This is a warning message");
        logger.error("This is an error message");
    }
}