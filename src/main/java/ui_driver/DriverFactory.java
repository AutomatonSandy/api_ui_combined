package ui_driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import config.ConfigReader;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static WebDriver driver;
    private static final String RemoteDriver = "remote";

    public static WebDriver initDriver(String browser) {

        if(!ConfigReader.get("ui.browser").equals(RemoteDriver)){
            initializeLocalBrowsers(browser);
        }else{
            try {
                initializeRemoteBrowsers(browser);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
    }

    private static void initializeRemoteBrowsers(String browser) throws MalformedURLException {
        String gridUrl = System.getProperty(
                "grid.url",
                "http://localhost:4444/wd/hub"
        );

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(gridUrl), options);
        }

    }




    private static void initializeLocalBrowsers(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }
}
