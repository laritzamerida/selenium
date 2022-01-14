package tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MercuryToursAutomatedTestTest {

    private WebDriver driver;
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By userName = By.id("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By send = By.name("submit");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By singInBntLocater = By.name("submit");
    By loginSuccessfully = By.xpath("//h3[text()='Login Successfully']");


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/ChromeWebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/newtours/");
    }
    @After
     public void tearDown(){
    driver.close();
    }

    @Test
    public void testName() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(registerPageLocator).isDisplayed()) {
            driver.findElement(userName).sendKeys("Laritza");
            driver.findElement(password).sendKeys("lm960522");
            driver.findElement(confirmPassword).sendKeys("lm960522");
            driver.findElement(send).click();
        } else {
            System.out.println("Register page was not found");
        }

        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is Laritza.", fonts.get(5).getText());

    }
    @Test
    public void singIn() throws InterruptedException {
        if (driver.findElement(userLocator).isDisplayed()){
            driver.findElement(userLocator).sendKeys("Laritza");
            driver.findElement(passLocator).sendKeys("lm960522");
            driver.findElement(singInBntLocater).click();
            Thread.sleep(2000);
            assertTrue(driver.findElement(loginSuccessfully).isDisplayed());
        } else {
            System.out.println("Username text box was not present");
        }

    }
}


