package org.Assgnt.objectRepository.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiMovie_InformationPage {

	public WikiMovie_InformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//th[.='Release date']/following-sibling::td//li")

	private WebElement actualReleaseDateText;
	
	@FindBy(xpath = "//th[.='Country']/following-sibling::td")

	private WebElement actualCountryOfOriginText;


//business library
	/**
	 * This method is used to click on the create Campaign button
	 * 
	 * @return
	 */
	public String getActualReleaseDate() {
		return actualReleaseDateText.getText();
	}
	public String getActualCountryName() {
		return actualCountryOfOriginText.getText();
	}
}
