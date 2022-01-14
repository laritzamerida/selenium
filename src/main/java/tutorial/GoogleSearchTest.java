package tutorial;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;
import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    
    private WebDriver driver;
    
    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "./src/main/resources/ChromeWebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

    }

    @Test
    public void searchGooglePage(){
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys("Laritza Merida");
        search.submit();
        //Implicitly Wait
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Explicitly Wait
        //WebDriverWait ewait = new WebDriverWait(driver, 10);
        //ewait.until(ExpectedConditions.titleContains("Laritza"));
        //assertEquals("Laritza Merida - Buscar con Google", driver.getTitle());

        //Fluent Wait
        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    
    
}
