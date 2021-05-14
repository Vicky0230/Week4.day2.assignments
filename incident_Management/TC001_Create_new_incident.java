package incident_Management;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Create_new_incident

{

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
		searchIncident.sendKeys("Incident");
		
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		String getIncident=driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("GetIncident Number :"+getIncident);
		
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		
		Thread.sleep(2000);
		
		Set<String> newWindow=driver.getWindowHandles();
		List<String> allWindow=new ArrayList<String>(newWindow);
		
		String secondWindow=allWindow.get(1);
		
		driver.switchTo().window(secondWindow);
		
		driver.findElement(By.linkText("System Administrator")).click();
		
		driver.switchTo().window(allWindow.get(0));		
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.id("incident.short_description")).sendKeys("Automation Testing Basics");

		driver.findElement(By.id("sysverb_insert_bottom")).click();

		Thread.sleep(2000);
		
		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys(getIncident);
		searchField.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		String text=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		if(text.equals(getIncident))
		{
			System.out.println("Incident Number is Equal");
		}
		
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		
		driver.close();

	}

}
