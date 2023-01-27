package pages;

import models.Lang;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumHelper;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Pages {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[@class='h1-flash font-abril']/p")
    private WebElement mainHeaderText;

    @FindBy(xpath = "//div[@class='service-item-title']")
    private List<WebElement> servicesList;

    @FindBy(css = ".nav-toggle-title")
    private WebElement menuLink;

    @FindBy(xpath = "//span[@class='icl_lang_sel_native' and text()='English']")
    private WebElement englishLink;

    @FindBy(xpath = "//span[text()='polski']")
    private WebElement polishLink;

    @FindBy (xpath = "(//div[@class='col-md-4 fact-item']/*[1])[1]")
    private WebElement projectsCounter;

    @FindBy (xpath = "(//div[@class='col-md-4 fact-item']/*[1])[2]")
    private WebElement specialistCounter;

    @FindBy (xpath = "(//div[@class='col-md-4 fact-item']/*[1])[3]")
    private WebElement servicesCounter;

    public String getMainHeaderText() {
        return mainHeaderText.getText();
    }

    public HomePage changeLanguageTo(Lang lang) {

        menuLink.click();

        if (lang == Lang.POLISH) {
            SeleniumHelper.waitForElementToBeVisible(this.driver, polishLink);
            click(polishLink);
        } else {
            SeleniumHelper.waitForElementToBeVisible(this.driver, englishLink);
            click(englishLink);
        }
        return this.homePage;
    }

    public void printServices (List<String> services, String text) {
        System.out.println(text);
        for (String service : services) {
            System.out.println(service);
        }
    }

    public List<String> getListOfServices() {
        return servicesList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getProjectsCounter (String ForHowMuchShouldWait) {
        SeleniumHelper.waitForTextToBePresentInElement(this.driver, projectsCounter, ForHowMuchShouldWait);
        return projectsCounter.getText();
    }

    public String getServiceCounter (String ForHowMuchShouldWait) {
        SeleniumHelper.waitForTextToBePresentInElement(this.driver, servicesCounter, ForHowMuchShouldWait);
        return servicesCounter.getText();
    }

    public String getSpecialist (String ForHowMuchShouldWait) {
        SeleniumHelper.waitForTextToBePresentInElement(this.driver, specialistCounter, ForHowMuchShouldWait);
        return specialistCounter.getText();
    }

}
