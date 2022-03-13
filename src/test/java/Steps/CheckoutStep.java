package Steps;
import Base.BaseTest;
import Log.Log;
import Page.CartPage;
import Page.HomePage;
import Page.MenuDetailPage;
import Page.ProducDetaiPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStep extends BaseTest {

    private HomePage homePage = null;
    private MenuDetailPage menuDetailPage=null;
    private ProducDetaiPage producDetaiPage=null;
    private CartPage cartPage=null;

    public CheckoutStep() throws Exception {
    }

    @Before
    public void initTest() {
        homePage= PageFactory.initElements(driver, HomePage.class);
        menuDetailPage=PageFactory.initElements(driver,MenuDetailPage.class);
        producDetaiPage=PageFactory.initElements(driver,ProducDetaiPage.class);
        cartPage=PageFactory.initElements(driver,CartPage.class);
    }

    @Given("^a web browser is at home page$")
    public void aWebBrowserIsAtDefactoHomePage() {
       homePage.redirectUrl("https://www.defacto.com.tr/");
    }

    @And("^check if the homepage is opened$")
    public void checkIfTheHomepageIsOpened() {
        Assert.assertTrue("Anasayfa açılması başarılı",homePage.waitForPageLoaded());
        Assert.assertTrue(homePage.getUrl("https://www.defacto.com.tr/"));
        Assert.assertTrue(homePage.elementIsDisplayed());
    }

    @And("Click on the {string} menu on the homepage")
    public void clickOnTheMenuOnTheHomepage(String gender) {
        homePage.clickMenu(gender);
        Assert.assertTrue(menuDetailPage.checkCurrentUrl("https://www.defacto.com.tr/kadin"));
    }

    @And("click on the {string} menu on the menu")
    public void clickOnTheMenuOnTheMenu(String menu) throws InterruptedException {
        menuDetailPage.clickWomanMenu(menu);
    }

    @And("size {string} is selected from the filters")
    public void sizeIsSelectedFromTheFilters(String size) {
        menuDetailPage.selectSize(size);
    }

    @And("Random product is selected")
    public void randomProductIsSelected() throws InterruptedException {
        menuDetailPage.selectRandomProduct();
    }

    @And("The loading of the product detail screen is controlled")
    public void theLoadingOfTheProductDetailScreenIsControlled() {
        Assert.assertTrue(producDetaiPage.isLoaded());
    }

    @And("A random size selection is made")
    public void aRandomSizeSelectionIsMade() {
        producDetaiPage.selectRandomProductSize();
    }

    @And("Click add to cart")
    public void clickAddToCart() {
      cartPage.addToCartClick();
    }

    @And("Basket Summary from the right side of the screen by clicking the My Cart button at the top right of the screen menu appears")
    public void basketSummaryFromTheRightSideOfTheScreenByClickingTheMyCartButtonAtTheTopRightOfTheScreenMenuAppears() {
        cartPage.clickMyCart();
        Assert.assertTrue(cartPage.isOpenMyCart());
    }

    @And("Click go to cart")
    public void clickGoToCart() {
        cartPage.clickGoToCart();
    }

    @And("My basket is checked for loading the ramp")
    public void myBasketIsCheckedForLoadingTheRamp() {
        Assert.assertTrue(cartPage.getUrl("https://www.defacto.com.tr/shopping"));
        Assert.assertTrue(cartPage.isDisplayedBill());
    }

    @And("The product is removed from the basket with the help of the Delete button on the My Basket screen")
    public void theProductIsRemovedFromTheBasketWithTheHelpOfTheDeleteButtonOnTheMyBasketScreen() {
        cartPage.deleteProduct();
    }

    @Then("Check that the basket is empty")
    public void checkThatTheBasketIsEmpty() {
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @After
    public void after(){
        driver.quit();
    }
}
