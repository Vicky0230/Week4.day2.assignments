package proposal;

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

public class TC001_Create_new_Proposal {

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
		searchIncident.sendKeys("Proposal");
		Thread.sleep(2000);
		searchIncident.sendKeys(Keys.ENTER);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_new")).click();
		
		String Number =driver.findElement(By.id("std_change_proposal.number")).getAttribute("value");
		System.out.println(Number);
		
		driver.findElement(By.xpath("//span[@class='icon icon-lightbulb']")).click();
		
		Set<String> listWindows=driver.getWindowHandles();
	
		List<String> allWindows=new ArrayList<String>(listWindows);
		
		driver.switchTo().window(allWindows.get(1));
		
		driver.findElement(By.linkText("Issue with email")).click();
		
		driver.switchTo().window(allWindows.get(0));
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_insert")).click();
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(Number);
		searchField.sendKeys(Keys.ENTER);
		
		String getNumber =driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		
		if(getNumber.equals(Number)) 
		{
			System.out.println("Proposal Number is equal");
		}
		else
		{
			System.out.println("Proposal Number is not equal");
		}
		
		driver.close();
		
		

	}

}
