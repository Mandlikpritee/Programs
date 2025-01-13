package AutomationScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword {
public static void main(String[] args) throws InterruptedException {
	//Open the browser
	ChromeDriver driver=new ChromeDriver();
	//Maximize the browser
	driver.manage().window().maximize();
	String expected_result="https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(expected_result);
	//verify the page using url
	String actual_result=driver.getCurrentUrl();
	if (expected_result.contains(actual_result)) {
		System.out.println("We are In Nokodr platform page..!!");
		WebElement forgot_password = driver.findElement(By.linkText("Forgot Password?"));
		if (forgot_password.isDisplayed()) {
			System.out.println("We are in NoKodr forgot password page..");
			forgot_password.click();
			WebElement email=driver.findElement(By.xpath("(//input[@name=\"username\"])[2]"));
			if (email.isEnabled()) {
				email.sendKeys("priteemandlik57@gmail.com");
				Thread.sleep(2000);
				WebElement proceedBtn = driver.findElement(By.cssSelector("div[title=\"Proceed\"]"));
				if (proceedBtn.isEnabled()) {
					proceedBtn.click();
					WebElement suceess_msg=driver.findElement(By.xpath("//h2[text()='Verification code sent successfully']"));
					String message=suceess_msg.getText();
					System.out.println(message);	}
				else {
					System.out.println("Proceed button is not working..");	}
					}
			else {
				System.out.println("Email field is not enabled...");}}
	}
	else {
		System.out.println("Not in Nokodr platform page..");
	}}
}

