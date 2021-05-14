package queue_Entry;

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

public class TC003_Configure_exsisting {

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
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys("CHAT0010050");
		searchField.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		
		WebElement chatqueueentrypriority = driver.findElement(By.id("chat_queue_entry.priority")); 
		Select select=new Select(chatqueueentrypriority);
		select.selectByIndex(1);
		String priority=select.getFirstSelectedOption().getText();
		System.out.println(priority);
		
		WebElement chatqueueentrystate = driver.findElement(By.id("chat_queue_entry.state"));  
		Select select1=new Select(chatqueueentrystate);
		select1.selectByIndex(2);
		String state=select1.getFirstSelectedOption().getText();
		System.out.println(state);
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("lookup.chat_queue_entry.cmdb_ci")).click();
		
		Set<String> newWindow=driver.getWindowHandles();
		List<String> allWindow=new ArrayList<String>(newWindow);

		String secondWindow=allWindow.get(1);

		driver.switchTo().window(secondWindow);

		WebElement forName = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forName).selectByIndex(0);

		WebElement searchField1=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField1.sendKeys("PS Apache02");
		searchField1.sendKeys(Keys.ENTER);

		driver.findElement(By.linkText("PS Apache02")).click();
		
		driver.switchTo().window(allWindow.get(0));		

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.id("sysverb_update")).click();
		
		System.out.println("Updated Config Chat Query");
		
		driver.close();

	}

}
