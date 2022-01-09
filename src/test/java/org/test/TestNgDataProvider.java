package org.test;

import org.BaseClasses.WebDriverGlobal;
import org.dataProvider.DataProviderSample;
import org.pageFactory.LoginPage;
import org.testng.annotations.Test;

public class TestNgDataProvider extends WebDriverGlobal{
	
	@Test(dataProvider="res",dataProviderClass=DataProviderSample.class)
	private void testLoginPage(String uname,String pass) {
		
		launchBrowser("chrome");
		loadUrl("http://adactinhotelapp.com/");
		LoginPage loginPage=new LoginPage();
		loginPage.Login(uname, pass);
	}

}
