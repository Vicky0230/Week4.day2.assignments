package service_Category;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_Cancel_Order {

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

		Thread.sleep(5000);

		WebElement searchIncident=driver.findElement(By.id("filter"));
		searchIncident.sendKeys("Service catalog");
		Thread.sleep(2000);
		searchIncident.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Requests']")).click();

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys("REQ0010113");
		searchField.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement screquestapproval = driver.findElement(By.id("sc_request.approval")); 
		new Select(screquestapproval).selectByIndex(3);
		
		WebElement screquestrequeststate = driver.findElement(By.id("sc_request.request_state")); 
		new Select(screquestrequeststate).selectByIndex(5);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[contains(@class,'form_action_button header')])[2]")).click();
		
		System.out.println("Cancelled Successfully");
		
		driver.close();
		
		
		


	}

}
