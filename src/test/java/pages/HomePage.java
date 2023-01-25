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

    @FindBy(css = ".logo-light")
    private WebElement lightLogo;

    @FindBy(xpath = "//div[@class='service-item-title']")
    private List<WebElement> servicesList;

    @FindBy(css = ".nav-toggle-title")
    private WebElement menuLink;

    @FindBy(xpath = "//span[@class='icl_lang_sel_native' and text()='English']")
    private WebElement englishLink;

    @FindBy(xpath = "//span[text()='polski']")
    private WebElement polishLink;

    public Dimension getLogoDeminsion() {
        return lightLogo.getSize();
    }

    public String getMainHeaderText() {
        return mainHeaderText.getText();
    }

    public HomePage changeLanguageTo(Lang lang) {

        menuLink.click();

        if (lang == Lang.POLISH) {
            SeleniumHelper.waitForElementToBeVisible(this.driver, polishLink);
            polishLink.click();
        } else {
            SeleniumHelper.waitForElementToBeVisible(this.driver, englishLink);
            englishLink.click();
        }
        return this.homePage;
    }

    public List<String> getListOfServices() {
        return servicesList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
