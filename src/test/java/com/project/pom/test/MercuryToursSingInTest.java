package com.project.pom.test;

import com.project.pom.page.MercuryToursSingInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MercuryToursSingInTest {

    private WebDriver driver;
    MercuryToursSingInPage singInPage;

    @Before
    public void setUp(){
        singInPage = new MercuryToursSingInPage(driver);
        driver = singInPage.chromeDriverConnection();
        singInPage.visit("http://demo.guru99.com/test/newtours/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void setSingInPageTest(){
        singInPage.singIn();
        assertTrue(singInPage.isHomePageDisplayed());
    }
}
