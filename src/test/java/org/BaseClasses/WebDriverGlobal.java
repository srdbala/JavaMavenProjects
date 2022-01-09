package org.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverGlobal {
	
	public static WebDriver driver;
	Actions ac;
	Alert al;
	JavascriptExecutor js;
	
	//WebDriver
	public WebDriver launchBrowser(String browser) {
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();			
		}
		else if (browser.equals("ie")) 
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();			
		} 
		else
		{
			System.out.println("Browser Invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	public String getCurrentUrlText() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public String getTitleText() {
		String title = driver.getTitle();
		return title;
	}	

	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	//WebElement
	public void setText(WebElement element,String data) {
		element.sendKeys(data);
	}
	
	public void btnClick(WebElement element) {
		element.click();
	}
	
	public String getTextValue(WebElement element) {
		String text = element.getText();
		return text;
	}
	
	public String getAttributeValue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	
	public boolean checkIsDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;

	}
	
	public boolean checkIsEnabled(WebElement element) {
		boolean enabled = element.isEnabled();
		return enabled;
	}

	public boolean checkIsSelected(WebElement element) {
		boolean selected = element.isSelected();
		return selected;
	}
	
	public void clearElement(WebElement element) {
		element.clear();
	}
	
	
	//TargetLocator
	public TargetLocator switchToElement() {
		TargetLocator locator = driver.switchTo();
		return locator;
	}
	
	//Navigation
	public void toNavigateUrl(Navigation navigate,String url) {
		navigate.to(url);
	}
	public void doRefresh(Navigation navigate) {
		navigate.refresh();
	}
	
	public void doForward(Navigation navigate) {
		navigate.forward();
	}
	
	public void doBack(Navigation navigate) {
		navigate.back();
	}
	
	//Alert
	public Alert switchToAlert() {
		Alert al = switchToElement().alert();
		return al;
	}
	public void alertAccept() {
		al=switchToAlert();
		al.accept();
	}
	
	public void alertDismiss(Alert al) {
		al=switchToAlert();
		al.dismiss();
	}
	
	public String alertGetText(Alert al) {
		al=switchToAlert();
		String text = al.getText();
		return text;
	}
	
	public void alertSendKeys(String data) {
		al.sendKeys(data);
	}
	
	//Actions
	public void actionMoveToElement(WebElement element) {
		ac=new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	public void actionDragAndDrop(WebElement src,WebElement dest) {
		ac=new Actions(driver);
		ac.dragAndDrop(src, dest).perform();
	}
	
	public void actionRightClick(WebElement element) {
		ac=new Actions(driver);
		ac.contextClick(element).perform();
	}
	
	public void actionDoubleClick(WebElement element) {
		ac=new Actions(driver);
		ac.doubleClick(element).perform();
	}
	
	//Frames
	public void switchToFrameById(String id) {
		switchToElement().frame(id);
	}
	
	public void switchToFrameByWebElement(WebElement frameElement) {
		switchToElement().frame(frameElement);
	}
	
	public void switchToFrameByIndex(int index) {
		switchToElement().frame(index);
	}
	
	public void switchToDefaultContent() {
		switchToElement().defaultContent();
	}
	
	//Drop Down
	public void selectOptionByIndex(WebElement ddElement,int index) {
		Select s=new Select(ddElement);
		s.selectByIndex(index);
	}
	
	public void selectOptionByValue(WebElement ddElement,String value) {
		Select s=new Select(ddElement);
		s.selectByValue(value);
	}
	
	public void selectOptionByVisibleText(WebElement ddElement,String visibleText) {
		Select s=new Select(ddElement);
		s.selectByVisibleText(visibleText);
	}
	
	public void deSelectOptionByIndex(WebElement ddElement,int index) {
		Select s=new Select(ddElement);
		s.deselectByIndex(index);
	}
	
	public void deSelectOptionByValue(WebElement ddElement,String value) {
		Select s=new Select(ddElement);
		s.deselectByValue(value);
	}
	
	public void deSelectOptionByVisibleText(WebElement ddElement,String visibleText) {
		Select s=new Select(ddElement);
		s.deselectByVisibleText(visibleText);
	}
	
	public void deSelectByAll(WebElement ddElement) {
		Select s=new Select(ddElement);
		s.deselectAll();
	}
	
	public boolean dropDownIsMultiple(WebElement ddElement) {
		Select s=new Select(ddElement);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	
	public String getFirstSelectedOption(WebElement ddElement) {
		Select s=new Select(ddElement);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	
	public List<WebElement> getAllSelectedOptions(WebElement ddElement) {
		Select s=new Select(ddElement);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	public List<WebElement> getSelectedOptions(WebElement ddElement) {
		Select s=new Select(ddElement);
		List<WebElement> options = s.getOptions();
		return options;
	}
	
	//Windows Handling
	public String getWindowHandle() {
		String parentWindowId = driver.getWindowHandle();
		return parentWindowId;
	}
	
	public Set<String> getWindowHandles() {
		Set<String> allWindowIds = driver.getWindowHandles();
		return allWindowIds;
	}
	
	public void switchToWindow(String windowId) {
		switchToElement().window(windowId);
	}
	
	//JavaScriptExecutor
	public void setTextByJavaScript(WebElement element,String data) {
		// TODO Auto-generated method stub
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+data+"')", element);
	}
	
	public void btnClickByJavaScript(WebElement element) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public void getAttributeByJavaScript(WebElement element) {
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].getAttribute('value')", element);
	}
	
	//Excel integration with Selenium Read
	public String getDataFromExcel(String sheet,int rowIndex,int cellIndex) throws IOException {
		String value=null;
		File file=new File("D:\\bala\\example_workspace\\MavenFirst\\ExcelData\\adactin.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rowIndex);
		Cell c = r.getCell(cellIndex);
		int type = c.getCellType();
		
		if(type==1)
		{
			value = c.getStringCellValue();
		}
		
		if(type==0)
		{
			if(DateUtil.isCellDateFormatted(c))
			{
				Date date = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
				value = sim.format(date);
			}
			else
			{
				double d = c.getNumericCellValue();
				long l=(long)d;
				value = String.valueOf(l);
			}
		}
		return value;
	}
	
	//Excel integration with Excel Write
	public void updateDataInExcel(String sheet,int rowIndex,int cellIndex,String data) throws IOException {
		File file=new File("D:\\bala\\example_workspace\\MavenFirst\\ExcelData\\adactin.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook w=new XSSFWorkbook(fis);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rowIndex);
		Cell c = r.createCell(cellIndex);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(file);
		w.write(fos);
	}
}
