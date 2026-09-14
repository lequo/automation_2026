package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_41_Handle_uploa_file {
    WebDriver driver;
    JavascriptExecutor jsExcutor;

    @BeforeClass
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
    }

    @Test
    public void TC_01_Single_File(){
        String path = "D:\\hoctap\\Automation_FC\\02 - Selenium WebDriver\\Uploadfile\\baotang.jpg";
        //file nằm thư mục uploadFiles
        By upload = By.cssSelector("input[name='files[]']");
        driver.findElement(upload).sendKeys(path);
    }

    @Test
    public void TC_02_Muitple_File(){
       String hinh1= "D:\\hoctap\\Automation_FC\\02 - Selenium WebDriver\\Uploadfile\\baotang.jpg";
       String hinh2 = "D:\\hoctap\\Automation_FC\\02 - Selenium WebDriver\\Uploadfile\\thac_tay_nguyen.jpg";
       String CV_01 = "D:\\hoctap\\Automation_FC\\02 - Selenium WebDriver\\Uploadfile\\Le Quoc Thang_Tester.pdf";
       By upload = By.cssSelector("input[name='files[]']");
       driver.findElement(upload).sendKeys(hinh1 + "\n" + hinh2 + "\n" +CV_01);
    }


    public Object executeForBrowser(String javaScript) {
        return jsExcutor.executeScript(javaScript);
    }

    public String getInnerText() {
        return (String) jsExcutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean isExpectedTextInInnerText(String textExpected) {
        String textActual = (String) jsExcutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage() {
        jsExcutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void sleepInSecond(int timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void navigateToUrlByJS(String url) {
        jsExcutor.executeScript("window.location = '" + url + "'");
        sleepInSecond(3);
    }

    public void hightlightElement(String locator) {
        WebElement element = getElement(locator);
        String originalStyle = element.getAttribute("style");
        jsExcutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExcutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(String locator) {
        jsExcutor.executeScript("arguments[0].click();", getElement(locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(String locator) {
        return (String) jsExcutor.executeScript("return arguments[0].textContent;", getElement(locator));
    }

    public void scrollToElementOnTop(String locator) {
        jsExcutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
    }

    public void scrollToElementOnDown(String locator) {
        jsExcutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

    public void setAttributeInDOM(String locator, String attributeName, String attributeValue) {
        jsExcutor.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(locator));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        jsExcutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
    }

    public void sendkeyToElementByJS(String locator, String value) {
        jsExcutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
    }

    public String getAttributeInDOM(String locator, String attributeName) {
        return (String) jsExcutor.executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(locator));
    }

    public String getElementValidationMessage(String locator) {
        return (String) jsExcutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
    }

    public boolean isImageLoaded(String locator) {
        boolean status = (boolean) jsExcutor.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(locator));
        return status;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }
}
