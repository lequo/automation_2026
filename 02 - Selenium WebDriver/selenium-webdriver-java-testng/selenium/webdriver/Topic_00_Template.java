package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.get(" ");
        driver.quit();
    }

    @Test
    public void Tc_02_Run_On_Chrome(){
        driver = new ChromeDriver();
        driver.get("https://staging-manage2.mangoforsalon.com");
        driver.quit();
    }

}
