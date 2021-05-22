
package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSteps {
	
	public WebDriver driver;
//1st step
	
@Given("^User has already opened the browser window$")
public void user_has_already_opened_the_browser_window() {
    // Initiate chrome browser
	String path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver",path+"\\src\\main\\java\\resources\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	//Created an object of driver
	driver = new ChromeDriver(options);
}

@When("^Browser is visible to user$")
public void browser_is_visible_to_user() {
    // Once chrome is launched,make it full screen
	driver.manage().window().maximize();
}

@Then("^Enter the url and press enter$")
public void enter_the_url_and_press_enter(){
    // Enter the url of the website which needs to be navigated
	driver.get("https://www.facebook.com/");
	//Wait for 10 seconds to load the page
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

@Then("^Login page of facebook should appear$")
public void signup_page_of_facebook_should_appear() {
    // Verify the page title to make sure that we are on correct page
	String title = driver.getTitle();
	Assert.assertEquals("Facebook – log in or sign up", title);

}

@Then("^Enter \"([^\"]*)\" \"([^\"]*)\" in Loginform$")
public void enter_in_SignUpform(String Phonenumber,  String password) {
    // Enter the data of the user from the table in feature into relevant fields for submission
	
	driver.findElement(By.xpath("//*[@id='email']")).clear();
	driver.findElement(By.xpath("//*[@id='email']")).sendKeys(Phonenumber);
	driver.findElement(By.xpath("//*[@id='pass']")).clear();
	driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
					
}

@Then("^I click \"([^\"]*)\"$")
public void i_click(String buttontext) {
    // Click on button having the buttontext

	driver.findElement(By.xpath("//button[contains(text(),buttontext)]")).click();
	
}

public void closebrowser() {
	driver.quit();
}
}
