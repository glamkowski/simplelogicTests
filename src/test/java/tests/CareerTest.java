package tests;

import models.Lang;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

public class CareerTest extends Pages {

    @Test
    public void shouldShowMainOffers () {
        homePage.changeLanguageTo(Lang.POLISH)
                .goToCareerPage();

        Assert.assertEquals(careerPage.getVisibleListOffer().size(), 5);
    }

    @Test
    public void shouldShowWarsawOffers () {
        homePage.changeLanguageTo(Lang.POLISH)
                .goToCareerPage()
                .goToWarsawLink();

        Assert.assertEquals(careerPage.getVisibleListOffer().size(), 2);
    }

    @Test
    public void shouldShowWroclawOffers () {
        homePage.changeLanguageTo(Lang.POLISH)
                .goToCareerPage()
                .goToWroclawLink();

        Assert.assertEquals(careerPage.getVisibleListOffer().size(), 1);
    }

    @Test
    public void shouldShowRemoteOffers () {
        homePage.changeLanguageTo(Lang.POLISH)
                .goToCareerPage()
                .goToRemoteLink();

        Assert.assertEquals(careerPage.getVisibleListOffer().size(), 5);
    }

}
