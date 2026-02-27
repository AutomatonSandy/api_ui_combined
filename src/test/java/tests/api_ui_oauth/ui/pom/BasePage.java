package tests.api_ui_oauth.ui.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePage {
    public  static WebDriver driver;

    private static final String WIREMOCK_URL = "https://oauth.wiremockapi.cloud/oauth/authorize";
    private static final String  HEROKU_THEINTERNET_URL = "https://the-internet.herokuapp.com/";
    @BeforeSuite (alwaysRun = true)
     public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(HEROKU_THEINTERNET_URL);
        driver.manage().window().maximize();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
