package incident_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_Create_new_incident_without_filling_mandatory_field {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver =new ChromeDriver(); 

		driver.get("https://dev103117.service-now.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		Thread.sleep(2000);

		driver.findElement(By.id("user_name")).sendKeys("admin");

		driver.findElement(By.id("user_password")).sendKeys("India@123");

		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		Thread.sleep(4000);

		WebElement searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Incident");
		Thread.sleep(2000);
		searchIncident.sendKeys(Keys.ENTER);

		
		Thread.sleep(3000);
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_new")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_insert")).click();


		String theFollowingMandatory = driver.findElement(By.xpath("//span[text()='The following mandatory fields are not filled in: Short description']")).getText();
		System.out.println(theFollowingMandatory);
		
		if(theFollowingMandatory.equalsIgnoreCase("The following mandatory fields are not filled in: Short description")) 
		{
			System.out.println("Error Message Verified");
		}

		driver.close();

	}

}
