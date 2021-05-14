package change_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_new_change {

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

		driver.findElement(By.xpath("(//div[text()='Create New'])[3]")).click();

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[@class='chg-model-model-description change-model-truncate'])[2]")).click();

		String getIncident=driver.findElement(By.id("change_request.number")).getAttribute("value");
		System.out.println("GetIncident Number :"+getIncident);

		driver.findElement(By.id("sysverb_insert")).click();

		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("(//div[text()='Open'])[3]")).click();
		
		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		WebElement searchField=driver.findElement(By.xpath("//input[@class='form-control']"));
		searchField.sendKeys(getIncident);
		Thread.sleep(2000);
		searchField.sendKeys(Keys.ENTER);
		
		String text=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();

		System.out.println(text);
		
		if(getIncident.equals(text))
		{
			System.out.println("Incident Verifed Successfully");
		}

		driver.close();

	}

}
