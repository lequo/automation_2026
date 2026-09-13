package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_06_WebBrowser_Commands {
    WebDriver driver;
    WebElement element;

    @Test
    public void Tc_01_Run_On_Firefox(){
        // NullPointerException biến chưa được khởi tạo đã gọi ra sử dụng
        driver = new FirefoxDriver();
        driver.get("https://staging-manage2.mangoforsalon.com");
        driver.manage().window().maximize();
        driver.quit();
    }

    @Test
    public void Tc_02_Run_On_Chrome(){
        driver = new ChromeDriver();
        driver.get("https://staging-manage2.mangoforsalon.com");
        driver.manage().window().maximize();
        driver.quit();
    }

    @Test
    public void Tc_03_Basic(){
        driver.get("fb.com");
    }
    
}
