package com.project.pom;

import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {

    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By userName = By.id("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By singInBntLocater = By.name("submit");
    By registerMessage = By.tagName("font");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerUser() throws InterruptedException {
        click(registerLinkLocator);
        Thread.sleep(2000);
        if(isDisplayed(registerPageLocator)){
            type("Laritza", userName);
            type("lm960522", password);
            type("lm960522", confirmPassword);
            click(singInBntLocater);
        } else {
            System.out.println("Register Page was not found");
        }
    }
    
    public String registeredMessage(){

        List<WebElement> fonts = findElements(registeredMessage);
        return getText(fonts.get(5));
    }
}