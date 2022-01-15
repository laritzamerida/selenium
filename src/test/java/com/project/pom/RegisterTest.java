package com.project.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class RegisterTest  {


	private WebDriver driver;
    RegisterPageF registerPage;

    @Before
    public void setUp() throws Exception {
        registerPage = new RegisterPageF(driver);
        driver = registerPage.chromeDriverConnection();
        registerPage.visit("http://demo.guru99.com/test/newtours/");
    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test 
    public void test() throws InterruptedException {
        registerPage.registerUser();
        assertEquals("Note: Your user name is Laritza.", registerPage.registeredMessage());
    }

    
}
