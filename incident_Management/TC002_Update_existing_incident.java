package incident_Management;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Update_existing_incident {

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

		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		
		WebElement incidenturgency = driver.findElement(By.id("incident.urgency")); 
		Select urgency2 =new Select(incidenturgency);
		urgency2.selectByIndex(0);
		Thread.sleep(2000);
		WebElement urgencyText = urgency2.getFirstSelectedOption();
		String urgency=urgencyText.getText();
		System.out.println(urgency);

		WebElement incidentstate = driver.findElement(By.id("incident.state")); 
		Select state2=new Select(incidentstate);
		state2.selectByIndex(1);
		Thread.sleep(2000);
		WebElement stateText = state2.getFirstSelectedOption();
		String state=stateText.getText();
		System.out.println(state);
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		String Priority=driver.findElement(By.xpath("//td[text()='3 - Moderate']")).getText();
		System.out.println(Priority);
		
		String Priority1=driver.findElement(By.xpath("//td[text()='3 - Moderate']")).getText();
		
		String state1=driver.findElement(By.xpath("//td[text()='In Progress']")).getText();

		if(state.equals(state1))
		{
			System.out.println("State Equals");
		}
		else
		{
			System.out.println("State Not Equals");
		}


		if(Priority.equals(Priority1))
		{
			System.out.println("Priority Equals");
		}
		else
		{
			System.out.println("Priority Not Equals");
		}

		Thread.sleep(2000);

		driver.switchTo().defaultContent();

		driver.close();

	}


}
