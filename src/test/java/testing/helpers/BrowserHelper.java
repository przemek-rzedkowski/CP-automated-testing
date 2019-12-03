package testing.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static testing.helpers.PropertiesHelper.properties;
import static java.lang.Boolean.parseBoolean;

public class BrowserHelper {

    private static String browser = properties.getProperty("config.browser").toLowerCase();

    private static boolean headless = parseBoolean(properties.getProperty("config.browser.headless"));

    private static FirefoxOptions firefoxOptions;

    private static ChromeOptions chromeOptions;

    private static EdgeOptions edgeOptions;

    private static SafariOptions safariOptions;

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setupDriver() {
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(headless);
        }

        else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(headless);
            chromeOptions.addArguments("start-maximized");
        }

        else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            edgeOptions = new EdgeOptions();
        }

        else if (browser.equals("safari")) {
            safariOptions = new SafariOptions();
        }

        else {
            throw new RuntimeException("choose one of available browsers");
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null || ((RemoteWebDriver) driver.get()).getSessionId() == null) {
            createNewDriver();
        }
        return driver.get();
    }

    private static void createNewDriver() {
        if (browser.equals("firefox")) {
            driver.set(new FirefoxDriver(firefoxOptions));
        }

        else if (browser.equals("chrome")) {
            driver.set(new ChromeDriver(chromeOptions));
        }

        else if (browser.equals("edge")) {
            driver.set(new EdgeDriver(edgeOptions));
        }

        else if (browser.equals("safari")) {
            driver.set(new SafariDriver(safariOptions));
        }
    }

}
