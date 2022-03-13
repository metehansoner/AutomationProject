package DriverFactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver createInstance(String browser) throws Exception {
        WebDriver driver;
        DriverType browserType = DriverType.valueOf(browser.toUpperCase());

        switch (browserType) {

            case CHROME:
                driver = new ChromeDriverManager().createDriver();
                break;
            default:
                throw new Exception();
        }
        return driver;
    }
}