package selenium_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.lang.String;


import java.util.List;

public class TestElement {

    int longWait = 8000;
    int shortWait = 2000;

    //import org.testng.annotations.Test;
    public static Logger logger = Logger.getLogger(TestElement.class);
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vpvis\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
    }

    public static WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/?m=1");
        return driver;
    }

    @Test
    public void clickElement() {
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        WebDriver driver = new ChromeDriver();
        browserWait(shortWait);
        driver.get("https://demoqa.com");
        ChromeOptions options = new ChromeOptions();
        //browserWait(longWait);
        logger.info("Browser page successfully loaded");
        WebElement elementButton = driver.findElement(By.xpath("//html/body/div[2]/div/div/div[2]/div/div/div/div[2]"));
        //browserWait(shortWait);
        elementButton.click();
        //browserWait(shortWait);
        logger.info("Element button successfully clicked");
        WebElement textButton = driver.findElement(By.className("text"));
        textButton.click();
        browserWait(longWait);
        driver.findElement(By.id("userName")).sendKeys("Murugan");
        driver.findElement(By.id("userEmail")).sendKeys("abc123@gmail.com");
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("143", Keys.ENTER, "Lady Love Avenue", Keys.ENTER, "Palmshore 94589");
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.sendKeys("143", Keys.ENTER, "Lady Love Avenue", Keys.ENTER, "Palmshore 94589");
        browserWait(longWait);
        WebElement submitButton = driver.findElement(By.id("submit"));
        logger.info("Fields action completed.. clicking submit button");
        submitButton.click();
        logger.info("Successfully submitted");
        browserWait(shortWait);
        driver.quit();
    }

    @Test
    public void webElementMultiple() {
        WebDriver driver = openWebPage("https://testautomationpractice.blogspot.com/");
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
    public void testW3HomePageSearchElement(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        driver.findElement(By.id("search2")).sendKeys("Java ", Keys.ENTER);
        driver.quit();
    }

    @Test
    public void elementUsingCSSSelectorAttribute() {
    }

    @Test
    public void herokuApp(){
        PropertyConfigurator.configure(ClassLoader.getSystemResource("log4j.properties"));
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        browserWait(3000);
        logger.info("Opens herokuapp page");
        driver.findElement(By.linkText("A/B Testing")).click();
        driver.navigate().back();
        logger.info("Checks navigations");
        driver.findElement(By.linkText("Add/Remove Elements")).click();
        //xpath using text
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.className("added-manually")).click();
        driver.navigate().to("https://the-internet.herokuapp.com");
//        driver.findElement(By.linkText("Basic Auth")).click();
//        Actions actions = new Actions(driver);
//        actions.sendKeys(Keys.TAB).sendKeys("admin")
//                .sendKeys(Keys.TAB).sendKeys("admin")
//                .sendKeys(Keys.ENTER).perform();
        browserWait(3000);
        driver.quit();
    }

    @Test
    public void getTodayGoldRatePerGram(){
        WebDriver driver = openWebPage("https://www.grtjewels.com");
        WebElement rate = driver.findElement(
                By.xpath("//html/body/div/div/div/div[2]/div/ul/li/div/div[2]/button"));
        String value = rate.getText();
        logger.info("Today's gold rate is " +value);
        driver.quit();
    }

    @Test
    public void getPriceAndNameFromAmazonTopSearchResults() {
        WebDriver driver = openWebPage("https://www.amazon.com");
        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button")).click();
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("wireless mouse", Keys.ENTER);
        logger.info("Located the search bar and submitted the search");
//        WebElement firstResult = driver.findElement(By.partialLinkText("G305"));
//        logger.info("located the correct name");
//        String name = firstResult.getText();
//        logger.info("First search result is " +name);
//        WebElement firstPrice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div"));
//        String price = firstPrice.getText();


        // ✅ Extract the Product Name
        WebElement productTitle = driver.findElement(By.xpath("//span[contains(text(), 'Wireless')]")); // Update with more specific identifier
        String name1 = productTitle.getText();

        // 💲 Extract the List Price
        WebElement listPriceElement = driver.findElement(By.xpath("//span[contains(text(),'List:')]/following-sibling::span"));
        String price = listPriceElement.getText();

        // 📤 Output the results
        System.out.println("Product Name: " + name1);
        System.out.println("List Price: " + price);

        logger.info(price);
        //firstPrice.click();
        //WebElement target = driver.findElement(By.xpath("//input[@id='duplicateId' and @name='username']"));
        //WebElement firstSearch = driver.findElement(By.xpath("//input[@id='productTitle' and @class='a-size-large product-title-word-break']"));
//        WebElement firstSearch = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/a/h2/span/text()"));
//        String name1 = firstSearch.getText();
//        logger.info(name1);
        browserWait(2000);
        driver.quit();
    }

    @Test
    public void openLinkedInMainPage(){
        WebDriver myDriver = openWebPage("https://www.linkedin.com");
        myDriver.quit();
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