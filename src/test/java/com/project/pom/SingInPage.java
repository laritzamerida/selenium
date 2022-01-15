package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage extends Base{

    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By singInBntLocater = By.name("submit");
    By loginSuccessfully = By.xpath("//h3[text()='Login Successfully']");


	public SingInPage(WebDriver driver) {
		super(driver);
		//TODO Auto-generated constructor stub
	}
    public void singIn() {
        if(isDisplayed(userLocator)){
            type("Laritza", userLocator);
            type("lm960522", passLocator);
            click(singInBntLocater);
        } else {
            System.out.println("username textbox was not present");
        }
    }

    public boolean isHomePageDisplayed(){
        return isDisplayed(loginSuccessfully);
    }

    
}
