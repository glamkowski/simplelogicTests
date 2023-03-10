package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CareerPage extends Pages {

    public CareerPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".nav-toggle-title")
    private WebElement menuLink;

    @FindBy (css = "h4.job-item-title > a")
    List<WebElement> mainPageOffer;

    @FindBy (xpath = "//li[@id='menu-item-198']//a[text()='Kariera']")
    WebElement careerLink;

    @FindBy (xpath = "//strong")
    WebElement strongText;

    @FindBy (xpath = "//a[text()='Warszawa']")
    WebElement warsawLink;

    @FindBy (xpath = "//a[text()='Wrocław']")
    WebElement wroclawLink;

    @FindBy (xpath = "//a[text()='Zdalnie']")
    WebElement remoteLink;

    public List<String> getVisibleListOffer() {

        menuLink.click();

        SeleniumHelper.waitForElementToBeVisible(this.driver, careerLink);
        click(careerLink);

        SeleniumHelper.waitForTextToBePresentInElement(this.driver, strongText, "Współpracuj z nami dla najlepszych projektów");

        for (int i = 0; i < mainPageOffer.size(); i++) {
            System.out.println("[" + (i+1) + "]" + mainPageOffer.get(i).getText());
        }

        return mainPageOffer.stream().filter( x-> x.isDisplayed()).map(x -> x.getText()).collect(Collectors.toList());

    }

    public CareerPage goToWarsawLink () {
        SeleniumHelper.waitForElementToBeVisible(this.driver, warsawLink);
        click(warsawLink);
        return this;
    }

    public CareerPage goToWroclawLink () {
        SeleniumHelper.waitForElementToBeVisible(this.driver, wroclawLink);
        click(wroclawLink);
        return this;
    }

    public CareerPage goToRemoteLink () {
        SeleniumHelper.waitForElementToBeVisible(this.driver, remoteLink);
        click(remoteLink);
        return this;
    }

}
