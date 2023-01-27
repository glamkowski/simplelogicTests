package tests;

import models.Lang;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

public class HomePageTest extends Pages {

    @Test(invocationCount = 1)
    public void shouldSwitchBetweenLang() {

        homePage.changeLanguageTo(Lang.POLISH);

        homePage.printServices(homePage.getListOfServices(), "Results for polish lang:");

        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("OUTSOURCING ZASOBÓW IT")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("SZKOLENIA")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("QUALITY ASSURANCE")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("CONTINUOUS TESTING")));

        homePage.changeLanguageTo(Lang.ENGLISH);

        homePage.printServices(homePage.getListOfServices(), "Results for english lang:");

        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("OUTSOURCING OF IT RESOURCES")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("TRAININGS")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("QUALITY ASSURANCE")));
        Assert.assertTrue(homePage.getListOfServices().stream().anyMatch(a -> a.equals("CONTINUOUS TESTING")));

    }

    @Test(invocationCount = 1)
    public void shoudlDisplaySmallLogoBeforeScroll() {

        topMenuPage.printLogoWidthAndHeight(topMenuPage.getLogoDeminsion());
        Assert.assertTrue(topMenuPage.getLogoDeminsion().getWidth() == 77 && topMenuPage.getLogoDeminsion().getHeight() == 90);

    }

    @Test
    public void shouldDisplayBigLogoAfterScroll() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 7000)");

        topMenuPage.printLogoWidthAndHeight(topMenuPage.getLogoDeminsion());
        Assert.assertTrue(topMenuPage.getLogoDeminsion().getWidth() == 43 && topMenuPage.getLogoDeminsion().getHeight() == 50);

    }

    @Test
    public void shouldDisplayCounters() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000)");

        Assert.assertEquals(homePage.getProjectsCounter("210"), "210");
        Assert.assertEquals(homePage.getSpecialist("37"), "37");
        Assert.assertEquals(homePage.getServiceCounter("125"), "125");

    }


}
