package functionalitiesTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class contactUsform {
	@Test
	public void functionality1() throws IOException, InterruptedException {
		String cromedriverpath = "D:\\Selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cromedriverpath);
		WebDriver driver = new ChromeDriver();
		driver.get("file:\\\\D:\\New Workspace\\Seleniumtest\\ipsnew\\index.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Driver initialized and page loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[5]/a")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("Deepak Chaturramalingam");
		driver.findElement(By.name("userEmail")).sendKeys("contact@test.com");
		driver.findElement(By.name("userMsg")).sendKeys("This is a user Message");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div/form/div[4]/span/input")).click();
		// driver.wait(3);
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File("C:\\Users\\rajat\\OneDrive\\Desktop\\Screenshot\\scrreenshot5.jpg"));
		assertEquals("Data Submitted Successfully, Routinga to home page",
				driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div/h3[2]")).getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
}
