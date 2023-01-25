package tests;

import models.Lang;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

public class HomePageTest extends Pages {

    @Test (invocationCount = 1)
    public void shouldSwitchBetweenLang() {

        homePage.changeLanguageTo(Lang.POLISH);

        System.out.println("Results for polish lang:");
        for (String service : homePage.getListOfServices()) {
            System.out.println(service);
        }

        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("OUTSOURCING ZASOBÓW IT")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("SZKOLENIA")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("QUALITY ASSURANCE")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("CONTINUOUS TESTING")));

        homePage.changeLanguageTo(Lang.ENGLISH);

        System.out.println("Results for english lang:");
        for (String service : homePage.getListOfServices()) {
            System.out.println(service);
        }

        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("OUTSOURCING OF IT RESOURCES")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("TRAININGS")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("QUALITY ASSURANCE")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("CONTINUOUS TESTING")));

    }



}
