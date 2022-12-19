package Utility;

import java.io.IOException;

import org.apache.commons.io.IOExceptionList;
import org.openqa.selenium.support.PageFactory;

import com.amazon.ekart.Helpers;

import pageclass.LoginPage;

public class Utility extends Helpers {
	
	public void logIn() throws IOException {
		LoginPage loginpage = new LoginPage();
		String email = readData(2, 0);
		PageFactory.initElements(driver, loginpage);
		loginpage.getHelloSigninTab().click();
		loginpage.getUserEmailTextBox().sendKeys(email);
		loginpage.getContinueButton().click();
	}

}
