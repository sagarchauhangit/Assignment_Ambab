package com.ambab.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

	WebDriver ldriver;

	public WomenPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Hoodies & Sweatshirts')]")
	WebElement hoodies_swatShirts;
	
	public void clickhoodies_swatShirtst() {
		hoodies_swatShirts.click();
		
	}

}
