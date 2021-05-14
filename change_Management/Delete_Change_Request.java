package change_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Change_Request {

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
		searchIncident.sendKeys("Change");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@class='form-control']"));
		searchField.sendKeys("CHG0030626");
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);

		driver.findElement(By.linkText("CHG0030626")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("sysverb_delete")).click();

		driver.findElement(By.id("ok_button")).click();

		Thread.sleep(2000);

		String noRecordsTo = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();

		if(noRecordsTo.equals("No records to display"))
		{
			System.out.println("Deleted Successfully");
		}

		driver.close();

	}

}
