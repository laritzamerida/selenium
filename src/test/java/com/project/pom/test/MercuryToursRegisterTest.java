package com.project.pom.test;

import com.project.pom.page.MercuryToursRegisterPage;
import com.project.pom.page.MercuryToursSingInPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class MercuryToursRegisterTest {


	private WebDriver driver;
    MercuryToursRegisterPage registerPage;


    @Before
    public void setUp() {
        registerPage = new MercuryToursRegisterPage(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("http://demo.guru99.com/test/newtours/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test 
    public void register_test() throws InterruptedException {
        registerPage.registerUser();
        assertEquals("Note: Your user name is Laritza.", registerPage.registeredMessage());
    }

    
}
