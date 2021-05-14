package incident_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Resolve_Incident {

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
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[text()='Create New']")).click();

		Thread.sleep(2000);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();
		
		Thread.sleep(2000);
		
		WebElement forTextNum = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']")); 
		new Select(forTextNum).selectByIndex(1);

		WebElement searchField=driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchField.sendKeys("INC0010928");
		searchField.sendKeys(Keys.ENTER);

		Thread.sleep(2000);
		
		driver.findElement(By.linkText("INC0010928")).click();
		
		Thread.sleep(2000);
		
		WebElement incidentstate = driver.findElement(By.id("incident.state")); 
		Select state1=new Select(incidentstate);
		state1.selectByIndex(3);
		Thread.sleep(2000);
		WebElement stateText = state1.getFirstSelectedOption();
		String state=stateText.getText();
		System.out.println(state);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Resolution Information']")).click();
		
		WebElement incidentclosecode = driver.findElement(By.id("incident.close_code")); 
		new Select(incidentclosecode).selectByIndex(7);
		
		driver.findElement(By.id("incident.close_notes")).sendKeys("Updating the resolution state and it's information");
		
		driver.findElement(By.id("sysverb_update")).click();
		

		String state2=driver.findElement(By.xpath("//td[text()='Resolved']")).getText();

		if(state.equals(state2))
		{
			System.out.println("State in Resoved Status");
		}
		else
		{
			System.out.println("State Not Equals");
		}
		
		driver.close();

	}

}
