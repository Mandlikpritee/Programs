package AutomationScript;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.input.model.DragDataItem;
import org.openqa.selenium.remote.service.DriverFinder;

public class BasicScript {
	public static void main(String[] args) {
		//Navigate to the chrome browser
		ChromeDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		String expected_result="https://app-staging.nokodr.com/super/apps/auth/v1/index.html#/login";
		//Waiting condition
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Verifiy the page using url
		driver.get(expected_result);
		String actual_result=driver.getCurrentUrl();
		if (expected_result.contains(actual_result)) {
			System.out.println("We are In Nokodr platform page..!!");
		}
		else {
			System.out.println("Not in Nokodr platform page..");
		}
	}
}
