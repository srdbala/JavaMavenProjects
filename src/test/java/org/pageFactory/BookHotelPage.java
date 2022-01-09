package org.pageFactory;

import org.BaseClasses.WebDriverGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends WebDriverGlobal{
	
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;
	
	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement txtCardNumber;
	
	@FindBy(id="cc_type")
	private WebElement selectCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement selectExpMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement selectExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCvv;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	@FindBy(id="cancel")
	private WebElement btnCancel;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNumber() {
		return txtCardNumber;
	}

	public WebElement getSelectCardType() {
		return selectCardType;
	}

	public WebElement getSelectExpMonth() {
		return selectExpMonth;
	}

	public WebElement getSelectExpYear() {
		return selectExpYear;
	}

	public WebElement getTxtCvv() {
		return txtCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	public void bookHotel(String firstName,String lastName,String address,String cardNumber
			,String cardType,String expMonth,String expYear,String cvv) {
		setText(getTxtFirstName(), firstName);
		setText(getTxtLastName(), lastName);
		setText(getTxtAddress(), address);
		setText(getTxtCardNumber(), cardNumber);
		selectOptionByVisibleText(getSelectCardType(), cardType);
		selectOptionByVisibleText(getSelectExpMonth(), expMonth);
		selectOptionByVisibleText(getSelectExpYear(), expYear);
		setText(getTxtCvv(), cvv);
		btnClick(getBtnBookNow());
		//btnClick(getBtnCancel());

	}
}
