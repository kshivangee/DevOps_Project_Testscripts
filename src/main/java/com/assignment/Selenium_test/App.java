package com.assignment.Selenium_test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello World!");
        
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);

        driver.get("http://52.203.51.246:8081/contact.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        WebElement name = driver.findElement(By.name("your_name"));
        
        WebElement mobilenum = driver.findElement(By.name("phone_number"));
        
        WebElement email = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[2]/div/form/input[3]"));
        
        WebElement message = driver.findElement(By.id("inputMessage"));
        
        WebElement submitButton = driver.findElement(By.id("my-button"));
        
        name.sendKeys("Shivangee");
        
        mobilenum.sendKeys("9738234776");
        
        email.sendKeys("shivangee@gmail.com");

        message.sendKeys("Thanks for the good service");

        submitButton.click();

        TakesScreenshot screenshot = ((TakesScreenshot)driver);
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("output_screenshot.jpg");
		FileUtils.copyFile(srcFile, destFile);
        WebElement outputmessage = driver.findElement(By.id("response"));
        System.out.println("Message is: "+message.getText());
        System.out.println("Scripts executed and recorded. Application is in usable state!!!");
        driver.quit();

    }
}
