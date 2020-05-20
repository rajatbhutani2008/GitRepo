package frontPage;

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

public class menuBarGalerry {
	@Test
	public void gallery() throws IOException {
		String cromedriverpath = "D:\\Selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cromedriverpath);
		WebDriver driver = new ChromeDriver();
		driver.get("file:\\\\D:\\New Workspace\\Seleniumtest\\ipsnew\\index.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Driver initialized and page loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/ul/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File("C:\\Users\\rajat\\OneDrive\\Desktop\\Screenshot\\scrreenshot3.jpg"));
		driver.quit();
	}
}