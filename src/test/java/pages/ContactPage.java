package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;
import utils.SeleniumHelper;

public class ContactPage extends Pages {

    public ContactPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//img[contains(@src, '171')]")
    private WebElement contactLogo;

    @FindBy (xpath = "//h3/a[@class='phone-link']")
    private WebElement phoneNumber;

    @FindBy (xpath = "//div[@class='mb60']/h4")
    private WebElement address;

    public String getPhoneNumber () {
        SeleniumHelper.waitForElementToBeVisible(this.driver, phoneNumber);
        return  getTextFromElement(this.phoneNumber);
    }

    public String getAddress () {
        SeleniumHelper.waitForElementToBeVisible(this.driver, address);
        return getTextFromElement(this.address);
    }

    public Dimension getLogoDimension () {
        return contactLogo.getSize();
    }

}
