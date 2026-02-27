package tests.api_ui_oauth.ui_heroku;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.provider.SHA;
import tests.api_ui_oauth.ui.pom.BasePage;


public class Heroku_shadowDom extends BasePage {

    private static final String SHADOWDOM_URL = "https://the-internet.herokuapp.com/shadowdom";
    public void verifyCorrectPage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().equals(SHADOWDOM_URL));
    }

    @Test
    public void getTextFromShadowElement() throws InterruptedException {
        verifyCorrectPage();
        String shadowHostString = "*//div[@id='content']/my-paragraph[1]";
        WebElement shadowHost = driver.findElement(By.xpath(shadowHostString));
       // WebElement shadowHost = driver.findElements(By.cssSelector("my-paragraph")).get(0);
        SearchContext context = shadowHost.getShadowRoot();
        WebElement shadowElement = context.findElement(By.cssSelector("p"));
        System.out.println(shadowElement.getText());
    }
}
