package change_Management;

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

public class Assess_the_Change_Request {

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

		WebElement incidentstate = driver.findElement(By.id("change_request.state")); 
		Select state2=new Select(incidentstate);
		state2.selectByIndex(1);
		Thread.sleep(2000);
		WebElement stateText = state2.getFirstSelectedOption();
		String state=stateText.getText();
		System.out.println(state);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='lookup.change_request.assignment_group']//span[1]")).click();

		Thread.sleep(2000);

		Set<String> newWindow=driver.getWindowHandles();
		List<String> allWindow=new ArrayList<String>(newWindow);

		String secondWindow=allWindow.get(1);

		driver.switchTo().window(secondWindow);

		driver.findElement(By.linkText("Software")).click();

		driver.switchTo().window(allWindow.get(0));	

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@data-for='sys_display.change_request.assigned_to']//span[1]")).click();

		Thread.sleep(2000);

		newWindow=driver.getWindowHandles();
		allWindow=new ArrayList<String>(newWindow);

		secondWindow=allWindow.get(1);
		driver.switchTo().window(secondWindow);

		Thread.sleep(2000);

		driver.findElement(By.linkText("ITIL User")).click();
		driver.switchTo().window(allWindow.get(0));	
		Thread.sleep(2000);

		driver.switchTo().frame("gsft_main");
		Thread.sleep(2000);

		driver.findElement(By.id("sysverb_update")).click();
		
		String state1=driver.findElement(By.xpath("//td[text()='Assess']")).getText();

		if(state.equals(state1))
		{
			System.out.println("State Equals");
		}
		else
		{
			System.out.println("State Not Equals");
		}

		String incidentAssignedTo = driver.findElement(By.linkText("ITIL User")).getText();
		System.out.println(incidentAssignedTo);
		
		if(incidentAssignedTo.equals("ITIL User"))
		{
			System.out.println("Assigned To is verified");
		}
		else
		{
			System.out.println("Assigned To is not verified");
		}

		driver.switchTo().defaultContent();
		
		driver.close();

	}

}
