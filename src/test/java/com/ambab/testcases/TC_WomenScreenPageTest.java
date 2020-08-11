package com.ambab.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ambab.pageobject.WomenPage;

public class TC_WomenScreenPageTest extends BaseClass {
	@Test(priority = 1)
	public void verifyWomenPage() throws InterruptedException {

		WomenPage wp = new WomenPage(driver);

		driver.navigate().to("https://fm.a2zportals.co.in/women.html");
		Thread.sleep(5000);
		// System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Women")) {
			Assert.assertTrue(true);
			logger.info("Women Page Title Verified");
		} else {
			try {
				captureScreen(driver, "WomenPageTitleTest");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.error("Women Page Title failed");
		}

		wp.clickhoodies_swatShirtst();

	}

	@Test(priority = 2, dependsOnMethods = { "verifyWomenPage" })
	public void verifyProductCount() throws InterruptedException {
		Thread.sleep(10000);
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(text(),'Simple Product')]"));
		// Count the total Link
		int linkCount = links.size();
		String actualCount = Integer.toString(linkCount);
		// Print the total count of product
		System.out.println("Total Number  = " + linkCount);
		String expectedCount = driver.findElement(By.xpath("//*[@id='toolbar-amount']/span[2]")).getText();

		if (actualCount.equalsIgnoreCase(expectedCount)) {
			Assert.assertTrue(true);
			logger.info("Expected Count is displayed");
		} else {
			try {
				captureScreen(driver, "Count Error");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.error("Expected Count is not displayed");
		}

	}

}
