package com.amazon.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.ekart.Helpers;

import Utility.Utility;
import pageclass.LoginPage;

public class loginTest extends Helpers {
	//static LoginPage lp;
	

	@BeforeMethod
	public static void setup() throws IOException {
		
		startBrowser();
		startApplication();
		
	}
	
	@Test
	public void login_with_validcred() throws IOException {

		Utility ul = new Utility();
		ul.logIn();
		screenShort("login");
	}
	
	@AfterMethod
	public static void teardown() {
		driver.close();
	}
	

}
