package pageclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.ekart.Helpers;

public class LoginPage extends Helpers {

	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebElement getHelloSigninTab() {
		return helloSigninTab;
	}

	public WebElement getUserEmailTextBox() {
		return userEmailTextBox;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	@FindBy(id="nav-link-accountList")
	WebElement helloSigninTab;
	
	@FindBy(name="email")
	WebElement userEmailTextBox;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(name="password")
	WebElement passwordTextBox;
	
	@FindBy(id = "signInSubmit")
	WebElement signInButton;
	
}
