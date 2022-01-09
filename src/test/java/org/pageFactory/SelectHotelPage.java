package org.pageFactory;

import org.BaseClasses.WebDriverGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends WebDriverGlobal {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="cancel")
	private WebElement btnCancel;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public void selectHotel() {
		btnClick(getBtnRadio());
		btnClick(getBtnContinue());
		//btnClick(getBtnCancel());

	}

}
