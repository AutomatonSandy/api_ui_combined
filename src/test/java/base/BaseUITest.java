package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseUITest {
        protected WebDriver driver;

        @Parameters("browser")
        @BeforeMethod
        public void setup(String browser) {
            driver = DriverFactory.initDriver(browser);
            driver.get("https://the-internet.herokuapp.com/");
            Assert.assertTrue(driver.getTitle().equals("The Internet"));
        }

        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
}
