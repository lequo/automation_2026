package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty9.util.security.Password;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.zeromq.timer.ZTimer;

public class Topiic_05_Run_More_Browser {
    WebDriver chrom_driver;
    JavascriptExecutor jsExecutor;

    @BeforeClass
    public void beforeClass() {
        chrom_driver = new ChromeDriver();

        // ép kiểu tường minh
        // TỪ kiểu này qua kiểu khác
        jsExecutor = (JavascriptExecutor) chrom_driver;
    }

    @Test
    public void Tc_01_Run_On_Firefox() {
        chrom_driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        chrom_driver.getCurrentUrl();
    }

    @Test
    public void Tc_02_log_in()  {
        String mk = "Admin";
        String Password="admin123";
        chrom_driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(mk);
        chrom_driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
        chrom_driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

//        mk.scrollIntoView(false);
    }

}
