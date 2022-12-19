package AutomationpracticeGT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bigbasket {
	public static void browserlaunch()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SHARMILA\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.bigbasket.com/");
        driver.manage().window().maximize();

	}

	public static void main(String[] args) {
		browserlaunch();
		productsearch();
	
	}
	public static void productsearch ()
	{
		
        By driver;
		WebElement product= driver.findElement(By.xpath("//input[@qa=searchBar]"));
		
        
	}

}
