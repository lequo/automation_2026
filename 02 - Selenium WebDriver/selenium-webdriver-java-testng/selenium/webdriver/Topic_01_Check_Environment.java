package webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() throws InterruptedException {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "//browserDrivers/chromedriver.exe");
        } else {
            System.out.println("");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(5000); // đợi 5 giây để xem trình duyệt

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Url() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
    }

    @Test
    public void TC_02_Logo() {
        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }

    @Test
    public void TC_03_Form() {
        Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
    }

    @Test
    public void TC_04() {
        // ...
        System.out.println("Hello");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}