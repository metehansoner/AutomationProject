package Page;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProducDetaiPage extends BasePage {
    @FindBy(className = "product-card")
    private WebElement element;

    public ProducDetaiPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
      return element.isDisplayed();
    }

    public void selectRandomProductSize() {
        try {
            randomSize();
        }
        catch (org.openqa.selenium.NoSuchElementException ex){
            randomSize();
        }
    }

    public void randomSize(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Random randomize = new Random();
        List<WebElement> size=driver.findElements(By.xpath("//*[@id='product-main-container']/div[1]/div/div[1]/div/div/div[3]/div/div[4]/div[3]/button"));
        int i = randomize.nextInt(size.size());
        size.get(i).click();
    }
}
