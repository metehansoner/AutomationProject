package Page;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[text()='Sepete Ekle']")
    private WebElement cartButton;

    @FindBy(xpath = "//span[text()='Sepetim']")
    private WebElement myCartButton;

    @FindBy(className = "fly-cart__items")
    private WebElement rigtCartMenu;

    @FindBy(xpath = "//button[text()=' SEPETE GİT ']")
    private  WebElement buttonCart;

    @FindBy(id = "summaryCompletedButton")
    private  WebElement buttonPayment;

    @FindBy(xpath = "//span[text()='Sil']")
    private  WebElement buttonDelete;

    @FindBy(xpath = "//button[text()='Sil']")
    private  WebElement buttonAcceptDelete;

    @FindBy(xpath = "//div[text()='Sepetinizde ürün yok.']")
    private  WebElement emptyCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addToCartClick() {
        cartButton.click();
    }

    public void clickMyCart() {
        myCartButton.click();
    }

    public boolean isOpenMyCart() {
        return rigtCartMenu.isDisplayed();
    }

    public void clickGoToCart() {
        buttonCart.click();
    }

    public boolean isDisplayedBill() {
        return buttonPayment.isSelected() || buttonPayment.isDisplayed();
    }

    public void deleteProduct() {
        buttonDelete.click();
        buttonAcceptDelete.click();
    }

    public boolean isCartEmpty() {
        return emptyCart.isDisplayed() || emptyCart.isEnabled();
    }
}
