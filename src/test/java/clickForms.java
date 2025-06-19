import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class clickForms {

    ChromeOptions options = new ChromeOptions();

    @BeforeClass
    public void firstRun() {
        System.setProperty("webdriver.chrome.driver", "C:\\temp\\Softs\\ChromeDriver\\chromedriver.exe");
    }


    @Test
    public void formElement() {
        options.addExtensions(new File("C:\\Users\\pvk20\\Downloads\\adblock.crx"));
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-ads");
        options.addArguments("--disable-infobars");
        options.addArguments("--blink-settings=imagesEnabled=false"); // disables images too (speeds up tests)
        WebDriver driver = new ChromeDriver(options);
        browserWait(2000);
        driver.get("https://demoqa.com");
        browserWait(2000);
        WebElement elementButton = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/div[2]/div/div[2]"));
        elementButton.click();
        browserWait(2000);
        driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div/div/div/div[2]/div")).click();
        browserWait(2000);
        driver.findElement(By.id("firstName")).sendKeys("Jhanaki");
        driver.findElement(By.id("lastName")).sendKeys("Raman");
        driver.findElement(By.id("userEmail")).sendKeys("jraman@gmail.com");
//        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        driver.findElement(By.id("gender-radio-1")).click();
//        driver.findElement(By.className("col-md-9 col-sm-12")).click();

        driver.quit();
    }

    private static void browserWait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
