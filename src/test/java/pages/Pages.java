package pages;

import org.testng.annotations.BeforeMethod;
import tests.BaseTest;

public class Pages extends BaseTest {

    public HomePage homePage;
    public TopMenuPage topMenuPage;
    public CareerPage careerPage;

    @BeforeMethod
    public void loadPages () {

        homePage = new HomePage(driver);
        topMenuPage = new TopMenuPage(driver);
        careerPage = new CareerPage(driver);

    }


}
