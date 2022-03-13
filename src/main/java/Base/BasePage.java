package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean getUrl(String url){
        return driver.getCurrentUrl().equals(url);
    }

    public void redirectUrl(String url){
        driver.get(url);
    }
    public boolean  waitForPageLoaded() {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        WebDriverWait wait = new WebDriverWait(driver,30);
        try {
            wait.until(expectation);
        } catch(Throwable error) {
          return false;
        }
        return true;
    }

    protected boolean isElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    public void clickElement(String gender){
        driver.findElement(By.xpath("//div/a[1]/div/span[contains(text(),'"+gender+"')]")).click();
    }

    public void scroolDownAndClickMenu() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//span[text()='Ceketler']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[text()='Ceketler']")));
        Thread.sleep(1000);
    }
}
