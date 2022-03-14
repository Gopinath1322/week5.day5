package week5.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewIncident {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("https://dev93361.service-now.com");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.switchTo().frame(0);
	 driver.findElement(By.id("user_name")).sendKeys("admin");
	 driver.findElement(By.id("user_password")).sendKeys("Like&Share22");
	 driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	 driver.switchTo().defaultContent();
	 Thread.sleep(3000);
	 WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		filter.sendKeys("Incidents");
		Thread.sleep(3000);
		filter.sendKeys(Keys.ENTER);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		String num = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(num);
		driver.switchTo().defaultContent();
		 driver.switchTo().frame(0);
		 driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Issue with the webpage");
		 driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		// String text = driver.findElement(By.xpath("//a[text()='INC0010009']")).getText();
		 WebElement findElement = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		findElement.sendKeys(num,Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		
		String text = driver.findElement(By.xpath("//td[@class='vt']//a")).getText();
		System.out.println(text);
		if(num.equals(text))
			System.out.println("incident is created");
		else
			System.out.println("incident is not created");
			}

}
