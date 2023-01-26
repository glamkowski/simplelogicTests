package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class TopMenuPage extends BaseTest {

    public TopMenuPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".logo-light")
    private WebElement lightLogo;

    public Dimension getLogoDeminsion() {
        return lightLogo.getSize();
    }

    public void printLogoWidthAndHeight (Dimension dimension) {
        System.out.println("Logo width: " + dimension.width);
        System.out.println("Logo height: " + dimension.height);
    }


}
