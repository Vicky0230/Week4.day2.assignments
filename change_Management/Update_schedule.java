package change_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update_schedule {

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

		WebElement searchField=driver.findElement(By.xpath("//input[@class='form-control']"));
		searchField.sendKeys("CHG0030626");
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);

		driver.findElement(By.linkText("CHG0030626")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[@class='tab_caption_text'])[2]")).click();

		driver.findElement(By.xpath("(//button[@id='change_request.start_date.ui_policy_sensitive'])[2]")).click();

		driver.findElement(By.linkText("22")).click();

		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		String changerequeststartdate = driver.findElement(By.id("change_request.start_date")).getAttribute("value");

		driver.findElement(By.xpath("(//button[@id='change_request.end_date.ui_policy_sensitive'])[2]")).click();

		driver.findElement(By.linkText("23")).click();

		driver.findElement(By.id("GwtDateTimePicker_ok")).click();
		
		driver.findElement(By.id("label.ni.change_request.cab_required")).click();

		driver.findElement(By.xpath("//a[@data-date_time_format='yyyy-MM-dd']//span[1]")).click();

		driver.findElement(By.linkText("25")).click();
		
		String changerequestenddate = driver.findElement(By.id("change_request.end_date")).getAttribute("value");
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		String StartDate=driver.findElement(By.xpath("//div[@class='datex date-calendar']")).getText();
		
		System.out.println("Start Date " +StartDate);
		
		String EndDate=driver.findElement(By.xpath("(//div[@class='datex date-calendar'])[2]")).getText();
		
		System.out.println("End Date " +EndDate);
		
		if(StartDate.equals(changerequeststartdate))
		{
			System.out.println("Start Date is Equal");
		}else
		{
			System.out.println("Start Date Not Equal");
		}
		
		if(EndDate.equals(changerequestenddate))
		{
			System.out.println("End Date is Equal");
		}else
		{
			System.out.println("End Date Not Equal");
		}


		driver.close();
		
	}

}
