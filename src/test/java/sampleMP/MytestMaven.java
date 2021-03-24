package sampleMP;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MytestMaven {
	@Test
	public void magentoregister1()
	{
		WebDriverManager.chromedriver().setup(); // take care of jar files corresponding to the OS
	System.out.println("my testng line");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
		
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("prajna");
		
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("nandyala");
		
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("prajna.nandyala@gmail.com");
		
		Select companyprimary=new Select(driver.findElement(By.id("company_type")));
		companyprimary.selectByValue("development");
		
		//companyprimary.deselectByVisibleText("Analyst/Media");   //for another way of choosing
		//companyprimary.selectByIndex(3);
		
		Select role=new Select(driver.findElement(By.id("individual_role")));
		role.selectByVisibleText("Technical/developer");
		
		
		

		Select country=new Select(driver.findElement(By.id("country")));
		country.selectByIndex(15);
		
		driver.findElement(By.id("password")).sendKeys("selenium@2244");		
		driver.findElement(By.id("password-confirmation")).sendKeys("selenium@2244");		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"msp-recaptcha-d84b65fc916e7398083ea5f17089d8f1\"]/div/div/iframe")));	
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[//@role='presentation']")));        //********another way of getting xpath ************
		
		
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		driver.switchTo().defaultContent();
		
		
		if(!driver.findElement(By.id("agree_terms")).isSelected())
        
		{
	        driver.findElement(By.id("agree_terms")).click();
         }
		
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div/button/span")).click();
		driver.quit();
		
	}

	}


