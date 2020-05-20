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

public class contentAbout {
	@Test
	public void functionality3() throws IOException {
		String cromedriverpath = "D:\\Selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cromedriverpath);
		WebDriver driver = new ChromeDriver();
		driver.get("file:\\\\D:\\New Workspace\\Seleniumtest\\ipsnew\\index.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Driver initialized and page loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String para1= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/p[1]")).getText();
		String act_para1= "IPS provides an education that enables our students to fulfill their potential - be it social, intellectual, academic, sporting or cultural. We do so not because these potentials, fully developed, are useful, economically marketable or aesthetically rewarding but because we want every single one of our students to find something that they are good at.";
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File("C:\\Users\\rajat\\OneDrive\\Desktop\\Screenshot\\scrreenshot7.jpg"));
		if (act_para1.equals(para1)) {
			System.out.println("Test cas Pass");
		} else {
			System.out.println("Test case Fail");
		}
		assertEquals(act_para1, para1, "Test case Pass");
		driver.quit();
	}
}
