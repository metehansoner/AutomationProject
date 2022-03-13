package Page;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "header__container")
    private WebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean elementIsDisplayed(){
      return isElementDisplayed(header);
    }

    public boolean getCurrentUrl(String url){
        return getUrl(url);
    }

    public void clickMenu(String gender) {
        clickElement(gender);
    }
}
