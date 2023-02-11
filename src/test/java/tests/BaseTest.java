package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {

    public static final String URL = "https://simplelogic.pl?lang=en";
    public WebDriver driver;

    @BeforeMethod
    public void setup () {
        driver = DriverFactory.getDriver("chrome");
        driver.get(URL);
    }

    @AfterMethod
    public void celanup () {
        driver.quit();
    }

    public void click(WebElement element) {
        System.out.println("Click: " + element.getTagName());
        element.click();
    }

    public String getTextFromElement (WebElement element) {
        return element.getText();
    }

}
