package base;

import ui_driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.UnknownHostException;

public class BaseUITest {
        protected WebDriver driver;

        @Parameters("browser")
        @BeforeMethod
        public void setup(String browser){
            driver = DriverFactory.initDriver(browser);
            driver.get("https://the-internet.herokuapp.com/");
            Assert.assertTrue(driver.getTitle().equals("The Internet"));
            try {
                System.out.println("Host: " +
                        java.net.InetAddress.getLocalHost().getHostName());
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        }

        @AfterMethod
        public void tearDown() {
            DriverFactory.quitDriver();
        }
}
