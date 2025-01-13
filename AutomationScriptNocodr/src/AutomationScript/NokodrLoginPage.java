package AutomationScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NokodrLoginPage {
public static void main(String[] args) {
	//Open the chrome browser
	ChromeDriver driver=new ChromeDriver();
	//maximize the browser
	driver.manage().window().maximize();
	String expected_result="https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
	//Providing waiting condition
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(expected_result);
	//verify the page using url
	String actual_result=driver.getCurrentUrl();
	if (expected_result.contains(actual_result)) {
		System.out.println("We are In Nokodr login platform page..!!");
		WebElement username=driver.findElement(By.name("username"));
		if (username.isDisplayed()) {
			System.out.println("User name field is enabled..");
			username.sendKeys("priteemandlik57@gmail.com");
			WebElement password_field=driver.findElement(By.xpath("//input[@type=\"password\"]"));
			if (password_field.isEnabled()) {
				System.out.println("Password field is enabled..");

				password_field.sendKeys("Renu@12345678");
				driver.findElement(By.id("rememberMe")).click();
				WebElement loginBtn=driver.findElement(By.xpath("//div[text()='Log In']"));
				if (loginBtn.isEnabled()) {
					System.out.println("Login button is working..");
					loginBtn.click();
					System.out.println("Login successfully to Nokodr platform...!");	
						}	}
			else {
				System.out.println("Password field is not enabled..");}}
		else {
			System.out.println("Username field is not enabled");}
	}
	else {
		System.out.println("Not in Nokodr platform page..");}
}	
}

