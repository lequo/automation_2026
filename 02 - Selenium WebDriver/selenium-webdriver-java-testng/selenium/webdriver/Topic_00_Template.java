package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @Test
    public void Tc_01_Run_On_Firefox(){
        driver = new FirefoxDriver();
        driver.get("https://staging-manage2.mangoforsalon.com");
        driver.quit();
    }

    @Test
    public void Tc_02_Run_On_Chrome(){
        driver = new ChromeDriver();
        driver.get("https://staging-manage2.mangoforsalon.com");
        driver.quit();
    }

}
