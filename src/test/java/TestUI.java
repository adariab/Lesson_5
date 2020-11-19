import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;


public class TestUI {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.name("wg")).sendKeys("123");
        Select dropdown = new Select(driver.findElement(By.name("opt2")));
        dropdown.selectByValue("2");
        driver.findElement(By.name("cc")).click();

        String ActualText = driver.findElement(By.name("desc")).getAttribute("value");
        System.out.println("ActualText = " + ActualText);
        String ExpectedText = "Your category is Obese";
        Assert.assertEquals(ExpectedText, ActualText);
        driver.close();
    }

}
