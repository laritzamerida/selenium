package com.project.pom.page;

import java.util.List;

import com.project.pom.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercuryToursRegisterPage extends Base {

    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By userName = By.id("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By singInBntLocater = By.name("submit");
    By registerMessage = By.tagName("font");


	public MercuryToursRegisterPage(WebDriver driver) {
		super(driver);
		//TODO Auto-generated constructor stub
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

        List<WebElement> fonts = findElements(registerMessage);
        return getText(fonts.get(5));
    }

    
}
