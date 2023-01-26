package tests;

import models.Lang;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.grid.config.DescribedOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Pages;

import java.time.Duration;
import java.util.List;

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

    @Test (invocationCount = 1)
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
    public void shouldDisplayCounters () {

        homePage.getProjectsCounter("210");

    }


}
