package AutomationScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NokodrSignUpPage {
public static void main(String[] args) throws InterruptedException {
	//Navigate to the chrome browser
	ChromeDriver driver=new ChromeDriver();
	//Maximize the browser
	driver.manage().window().maximize();
	//Providing waiting condition
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	String expected_result="noKodr";
	String password="Renu@12345678";
	//Navigate to the Nokodr platform
	driver.get("https://app-staging.nokodr.com/");
	//verify Nokodr page using title
	String actual_result=driver.getTitle();
	if (expected_result.contains(actual_result)) {
		System.out.println("We are In Nokodr platform page..");
		WebElement sign_up=driver.findElement(By.linkText("Sign up"));
		//Verification of Sign up page
		if (sign_up.isDisplayed()) {
			sign_up.click();
			System.out.println("We are In Nokodr sign-up page..");
			//Entering Email for receiving OTP
		 driver.findElement(By.xpath("(//input[@type=\"email\"])[2]")).sendKeys("priteemandlik57@gmail.com");
			//Click on checkbox
			driver.findElement(By.xpath("//span[@class=\"slds-checkbox_faux\"]")).click();
			//Clicking on proceed button
			driver.findElement(By.xpath("//div[text()='Proceed']")).click();
			Actions actions=new Actions(driver);
			Thread.sleep(5000);
			WebElement verification_code=driver.findElement(By.name("code"));
			actions.moveToElement(verification_code).click().sendKeys("456789").perform();
			driver.findElement(By.xpath("//div[text()='Verify Code']")).click();
			Thread.sleep(2000);
			driver.findElement(By.name("firstName")).sendKeys("Pritee");
			driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Mandlik");
			WebElement password_field = driver.findElement(By.name("password"));
			password_field.sendKeys(password);
			WebElement confirmPassword=driver.findElement(By.cssSelector("input[name=\"password-confirmpassword\"]"));
			confirmPassword.sendKeys("Renu@12345678");
			String pwd_conf=confirmPassword.getText();
			System.out.println(pwd_conf);
			//verify password matches with confirm password
			if (password.equals(pwd_conf)) {
				System.out.println("Password  and confirm password matches succesfully..");
				WebElement register_button = driver.findElement(By.xpath("//div[contains(text(),'Register')]"));
				if (register_button.isEnabled()) {
					register_button.click();
					System.out.println("Account created sucessfully...");	}
				else {
					System.out.println("Not in register page..");}
				System.out.println("password not matches..");}
			}
		else {
			System.out.println("Not in sign up page");	}}
	else {
		System.out.println("Not in Nokodr platform page");}
}
}
