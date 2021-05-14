package caller;

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

public class TC002_Update_Existing_Caller {

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
		searchIncident.sendKeys("Callers");
		Thread.sleep(2000);
		searchIncident.sendKeys(Keys.ENTER);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(2);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys("AR");
		Thread.sleep(1000);
		searchField.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		Thread.sleep(2000);

		WebElement phone=driver.findElement(By.id("sys_user.phone"));
		phone.clear();
		phone.sendKeys("9500702222");

		driver.findElement(By.id("sysverb_update")).click();

		forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(2);
		
		searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys("AR");
		Thread.sleep(3000);
		searchField.sendKeys(Keys.ENTER);
		
		String B_Phone=driver.findElement(By.xpath("//td[text()='(950) 070-2222']")).getText();
		
		Thread.sleep(2000);

		if(B_Phone.equals("(950) 070-2222"))
		{
			System.out.println("Caller Updated");
		}

		driver.close();

	}

}
