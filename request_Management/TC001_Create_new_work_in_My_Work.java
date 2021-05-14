package request_Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Create_new_work_in_My_Work {

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
		searchIncident.sendKeys("My Work");
		Thread.sleep(2000);
		searchIncident.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[text()='My Work']")).click();

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.id("sysverb_new")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//form[@name='wizard']/div[23]/a[1]")).click();

		String ReqNum=driver.findElement(By.id("sc_request.number")).getAttribute("value");
		System.out.println(ReqNum);

		driver.findElement(By.id("sysverb_insert")).click();

		Thread.sleep(2000);
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(ReqNum);
		searchField.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		String text=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if(text.equals(ReqNum))
		{
			System.out.println("Request Number is Equal");
		}

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		driver.close();


	}

}
