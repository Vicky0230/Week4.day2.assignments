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

public class TC002_Update_My_request {

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
		searchField.sendKeys("REQ0010152");
		searchField.sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();

		driver.findElement(By.id("lookup.sc_request.location")).click();

		Set<String> newWindow=driver.getWindowHandles();
		List<String> allWindow=new ArrayList<String>(newWindow);

		String secondWindow=allWindow.get(1);

		driver.switchTo().window(secondWindow);

		driver.findElement(By.xpath("//div[@id='treenode_0']/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/img[1]")).click();
		
		driver.findElement(By.xpath("//div[@id='treenode_0']/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/img[1]")).click();
		
		driver.findElement(By.linkText("Rhode Island")).click();

		driver.switchTo().window(allWindow.get(0));		

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@data-date_time_format='yyyy-MM-dd HH:mm:ss']//span)[3]")).click();
		
		driver.findElement(By.linkText("15")).click();
		
		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		driver.findElement(By.id("sysverb_update")).click();
		
		String Date=driver.findElement(By.xpath("//div[@class='datex date-calendar']")).getText();
		System.out.println(Date);
		String Location=driver.findElement(By.xpath("(//a[@class='linked'])[2]")).getText();
		System.out.println(Location);
		
		if(Location.equals("Rhode Island"))
		{
			System.out.println("Request Updated Successfully");
		}

		driver.close();
		

	}

}
