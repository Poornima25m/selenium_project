import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class automationTest1 {

    @BeforeClass
    public void firstRun(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpvis\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    }

    @Test
    public void automationPractice(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?m=1");
        driver.findElement(By.cssSelector("#name")).sendKeys("Murugan");
        //driver.findElement(By.id("name")).sendKeys("Murugan");
        driver.findElement(By.id("email")).sendKeys("mgn@yahoo.com");
        driver.findElement(By.id("phone")).sendKeys("9840199401");
        driver.findElement(By.id("textarea")).sendKeys("27, Ghandhi Road",Keys.ENTER,"Triplicane, Chennai -01");
        driver.findElement(By.xpath("//*[@id='post-body-1307673142697428135']/div[3]/div[1]/label")).click();
        driver.findElement(By.id("wednesday")).click();
        //driver.findElement(By.id("country")).click();
        WebElement dropDown = driver.findElement(By.id("country"));
        dropDown.sendKeys("India");
        // Select select = new Select(dropDown);
        //select.selectByValue("india");
        driver.findElement(By.xpath("//*[@id='colors']/option[2]")).click();
        driver.findElement(By.xpath("//*[@id='animals']/option[5]")).click();
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.click();
        datepicker.sendKeys("2025-06-01");
        // //*[@id='ui-datepicker-div']
//        WebElement datepicker = driver.findElement(By.xpath("//*[@id='datepicker']"));
        driver.quit();
    }
}
