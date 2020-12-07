package org.demoguru;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question4 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/write-xpath-table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File("D:\\Mani\\Selenium\\Day11\\Q4(2).png");
		FileUtils.copyFile(src, dst);

		WebElement bodyDetails = driver.findElement(By.tagName("tbody"));
		List<WebElement> rowDetails = bodyDetails.findElements(By.tagName("tr"));
		for (WebElement webElement : rowDetails) {
			List<WebElement> tableData = webElement.findElements(By.tagName("td"));
			int size = tableData.size();
			WebElement webElement2 = tableData.get(size-1);
			System.out.println(webElement2.getText());
			
		}
//		int size = rowDetails.size();
//		WebElement tableDetails = rowDetails.get(size-1);
//		List<WebElement> tableData = tableDetails.findElements(By.tagName("td"));
//		for (WebElement webElement : tableData) {
//			System.out.println(webElement.getText());
//			
//		}

		driver.quit();
	}

}
