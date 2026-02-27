package tests.api_ui_oauth.ui_heroku;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.api_ui_oauth.ui.pom.BasePage;

public class TheInternet_LandingPage extends BasePage {

    private static final String pageTitle = "The Internet";

    public void verifyTitle(){
        Assert.assertTrue(driver.getTitle().equals(pageTitle));
    }

    @Test
    public void clickOnShadowDom(){
        verifyTitle();
        driver.findElement(By.linkText("Shadow DOM")).click();
    }
}
