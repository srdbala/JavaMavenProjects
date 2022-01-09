package org.pageFactory;

import org.BaseClasses.WebDriverGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends WebDriverGlobal{
	
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement selectLocation;
	
	@FindBy(id="hotels")
	private WebElement selectHotels;
	
	@FindBy(id="room_type")
	private WebElement selectRoomType;
	
	@FindBy(id="room_nos")
	private WebElement selectNumberOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement txtDatePickIn;
	
	@FindBy(id="datepick_out")
	private WebElement txtDatePickOut;
	
	@FindBy(id="adult_room")
	private WebElement selectAdults;
	
	@FindBy(id="child_room")
	private WebElement selectChilds;
	
	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	@FindBy(id="Reset")
	private WebElement btnReset;

	public WebElement getSelectLocation() {
		return selectLocation;
	}

	public WebElement getSelectHotels() {
		return selectHotels;
	}

	public WebElement getSelectRoomType() {
		return selectRoomType;
	}

	public WebElement getSelectNumberOfRooms() {
		return selectNumberOfRooms;
	}

	public WebElement getTxtDatePickIn() {
		return txtDatePickIn;
	}

	public WebElement getTxtDatePickOut() {
		return txtDatePickOut;
	}

	public WebElement getSelectAdults() {
		return selectAdults;
	}

	public WebElement getSelectChilds() {
		return selectChilds;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public WebElement getBtnReset() {
		return btnReset;
	}
	
	public void searchHotel(String location,String hotels,String roomType,String numberOfRooms,String datePickIn,String datePickOut,String adults,String childs) {
		selectOptionByVisibleText(getSelectLocation(), location);
		selectOptionByVisibleText(getSelectHotels(), hotels);
		selectOptionByVisibleText(getSelectRoomType(), roomType);
		selectOptionByVisibleText(getSelectNumberOfRooms(), numberOfRooms);
		clearElement(getTxtDatePickIn());
		setText(getTxtDatePickIn(), datePickIn);
		clearElement(getTxtDatePickOut());
		setText(getTxtDatePickOut(), datePickOut);
		selectOptionByVisibleText(getSelectAdults(), adults);
		selectOptionByVisibleText(getSelectChilds(), childs);
		btnClick(getBtnSearch());
		//btnClick(getBtnReset());

	}

}
