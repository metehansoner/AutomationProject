package Page;

import Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuDetailPage extends BasePage
{
    @FindBy(xpath = "//span[text()='Ceketler']")
    private WebElement womanJacket;

    public MenuDetailPage(WebDriver driver) {
        super(driver);
    }

    public  boolean checkCurrentUrl(String url){
        return getUrl(url);
    }

    public void clickWomanMenu(String menu) throws InterruptedException {
        pageScrool();
    }

    public void pageScrool() throws InterruptedException {
        scroolDownAndClickMenu();
    }

    public void selectSize(String size) {
        WebElement element=driver.findElement(By.xpath("//*[@id='catalog-filter__nav']/ul/li[2]/ul/li[2]/ul/li[3]/div/label[@data-value='"+size+"']"));
        element.click();

    }

    public void selectRandomProduct() {
        try {
            WebElement element = driver.findElement(By.xpath("//div[@data-index='4']"));
            element.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            WebElement element = driver.findElement(By.xpath("//div[@data-index='4']"));
            element.click();
        }
    }
}
