package tests;

import models.Lang;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

public class ContactFormTest extends Pages {

    @Test
    public void shouldValidAddress () {
        homePage.changeLanguageTo(Lang.POLISH).goToContactPage();

        Assert.assertEquals(contactPage.getPhoneNumber(), "+48 786 100 355");
        Assert.assertEquals(contactPage.getAddress(), "Aleje Jerozolimskie 96, 00-807 Warszawa");
    }

}
