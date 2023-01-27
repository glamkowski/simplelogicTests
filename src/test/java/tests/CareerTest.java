package tests;

import models.Lang;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

public class CareerTest extends Pages {

    @Test
    public void shouldShowMainOffers () {
        homePage.changeLanguageTo(Lang.POLISH);
        Assert.assertEquals(careerPage.getMainListOffers(), 5);
    }

    @Test
    public void shouldShowWarsawOffer () {
        homePage.changeLanguageTo(Lang.POLISH);
        careerPage.getMainListOffers();
        careerPage.goToWarsawLink();
    }

}
