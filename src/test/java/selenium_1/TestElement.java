package selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TestElement {
    //import org.testng.annotations.Test;
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpvis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    }

    public static WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?m=1");
        return driver;
    }

    @Test
    public void clickElement() {
        WebDriver driver = new ChromeDriver();
        browserWait(2000);
        driver.get("https://demoqa.com");
        ChromeOptions options = new ChromeOptions();
        browserWait(2000);
        WebElement elementButton = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/div/div/div[2]"));
        elementButton.click();
        WebElement textButton = driver.findElement(By.className("text"));
        textButton.click();
        driver.findElement(By.id("userName")).sendKeys("Murugan");
        driver.findElement(By.id("userEmail")).sendKeys("abc123@gmail.com");
        WebElement textArea = driver.findElement(By.id("currentAddress"));
        textArea.sendKeys("143", Keys.ENTER, "Lady Love Avenue", Keys.ENTER, "Palmshore 94589");
        WebElement padd = driver.findElement(By.id("permanentAddress"));
        padd.sendKeys("143", Keys.ENTER, "Lady Love Avenue", Keys.ENTER, "Palmshore 94589");
        browserWait(2000);
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        driver.quit();
    }

    @Test
    public void webElementMultiple() {
        WebDriver driver = getDriver();
        driver.findElement(By.cssSelector("#name")).sendKeys("Murugan");
        //driver.findElement(By.id("name")).sendKeys("Murugan");
        driver.findElement(By.id("email")).sendKeys("mgn@yahoo.com");
        driver.findElement(By.id("phone")).sendKeys("9840199401");
        driver.findElement(By.id("textarea")).sendKeys("27, Ghandhi Road", Keys.ENTER, "Triplicane, Chennai -01");
        driver.findElement(By.xpath("//*[@id='post-body-1307673142697428135']/div[3]/div[1]/label")).click();
        driver.findElement(By.id("wednesday")).click();
        WebElement dropDown = driver.findElement(By.id("country"));
        dropDown.sendKeys("India");
        //Select select = new Select(dropDown);
        //select.selectByValue("india");
        driver.findElement(By.xpath("//*[@id='colors']/option[2]")).click();
        driver.findElement(By.xpath("//*[@id='animals']/option[5]")).click();
        driver.findElement(By.id("datepicker")).sendKeys("02/01/2025");
        driver.findElement(By.id("txtDate")).sendKeys("12/06/2025", Keys.ENTER);
        driver.findElement(By.id("start-date")).sendKeys("02/01/2025", Keys.ENTER);
        driver.findElement(By.id("end-date")).sendKeys("06/12/2025", Keys.ENTER);
        driver.findElement(By.className("submit-btn")).click();
        driver.quit();
    }

    /**
     * This test verifies the use of CSS selectors in locating elements.
     * <p>
     * It initializes the WebDriver, selects an element using its ID via CSS selectors,
     * inputs text, and then closes the browser.
     * </p>
     */
    @Test
    public void elementUsingCSSSelectorName(){
        WebDriver driver = getDriver();
        // syntax: "#<id>"
        driver.findElement(By.cssSelector("#name")).sendKeys("Murugan");
        driver.quit();
    }

    @Test
    public void elementUsingCSSSelectorClass() {
        WebDriver driver = getDriver();
        // syntax: ".<classname>"
        List<WebElement> formControl = driver.findElements(By.cssSelector(".form-control"));
        formControl.get(1).sendKeys("jackrobert@gmail.com");
        driver.quit();
    }

    @Test
    public void elementUsingCSSSelectorAttribute() {
    }


    private static void browserWait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}