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

public class homePageData {
  

@Test
  public void functionality2() throws IOException {
	  String cromedriverpath = "D:\\Selenium\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", cromedriverpath);
		WebDriver driver = new ChromeDriver();
		driver.get("file:\\\\D:\\New Workspace\\Seleniumtest\\ipsnew\\index.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Driver initialized and page loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String marq= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]")).getText();
		String marq_act = "We at Indraprasth Public School would like to thank parents for their trust and overwhelming response in IPS. We request you to complete admission formalities for the session 2016-2017 as soon as possible to get your child's seat confirmed.";
		if (marq_act.equalsIgnoreCase(marq)) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case Fail");
		}
		System.out.println(marq_act.equals(marq));
		TakesScreenshot scrsht = ((TakesScreenshot) driver);
		File SrcFile = scrsht.getScreenshotAs(OutputType.FILE);
		Files.copy(SrcFile, new File("C:\\Users\\rajat\\OneDrive\\Desktop\\Screenshot\\scrreenshot6.jpg"));
		assertEquals(marq_act, marq);
		driver.quit();
  }
}
