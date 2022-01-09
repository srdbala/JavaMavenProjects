package org.pageFactory;

import org.BaseClasses.WebDriverGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingConfirmPage extends WebDriverGlobal{

	
	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement txtOrderNum;
	
	@FindBy(id="search_hotel")
	private WebElement btnSearch;
	
	@FindBy(id="my_itinerary")
	private WebElement btnMyItinerary;
	
	@FindBy(id="logout")
	private WebElement btnLogout;

	public WebElement getTxtOrderNum() {
		return txtOrderNum;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnMyItinerary() {
		return btnMyItinerary;
	}

	public WebElement getBtnLogout() {
		return btnLogout;
	}
	
	public String bookingConfirm() {
		
		String orderNum = getAttributeValue(getTxtOrderNum());
		//setText(txtOrderNum, attributeValue);
		System.out.println("Order Number : "+orderNum);
		return orderNum;
	}
}
