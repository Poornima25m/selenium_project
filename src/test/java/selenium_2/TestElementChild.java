package selenium_2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static selenium_1.TestElement.getDriver;

public class TestElementChild {

    @Test
    public void openSite(){
        WebDriver drv = getDriver();
        drv.quit();
    }
}
