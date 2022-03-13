package Base;

import Log.Log;
import io.cucumber.core.logging.Logger;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import DriverFactory.DriverFactory;
public class BaseTest {
    public WebDriver driver;

    public BaseTest() throws Exception {
        this.driver=new DriverFactory().createInstance("CHROME");

    }

    public void quit() {
        driver.quit();
        Log.info("Driver is terminated");
    }
}