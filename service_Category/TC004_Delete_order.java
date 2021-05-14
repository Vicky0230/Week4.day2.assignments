package service_Category;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Delete_order {

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
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();
		
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		
		WebElement iOebedaadeeda = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']")); 
		new Select(iOebedaadeeda).selectByIndex(2);
		
		WebElement iObedaadeeda1 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")); 
		new Select(iObedaadeeda1).selectByIndex(3);
		
		WebElement iOebedaadeeda2 = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]")); 
		new Select(iOebedaadeeda2).selectByIndex(2);
		
		driver.findElement(By.id("oi_order_now_button")).click();
		
		String text=driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		System.out.println(text);
		
		String R_Number=driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).getText();
		System.out.println(R_Number);
		
		driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_delete")).click();
		
		driver.findElement(By.id("ok_button")).click();
		
		Thread.sleep(2000);
		
		String noRecordsTo =driver.findElement(By.xpath("//div[@class='notification notification-warning']")).getText();

		if(noRecordsTo.equals("Order: Empty"))
		{
			System.out.println("Deleted Successfully");
		}

		driver.close();


	}

}
