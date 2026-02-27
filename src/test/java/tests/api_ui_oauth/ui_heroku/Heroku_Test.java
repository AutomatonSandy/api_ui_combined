package tests.api_ui_oauth.ui_heroku;

import org.testng.annotations.Test;

public class Heroku_Test {

    TheInternet_LandingPage internetLandingPage = new TheInternet_LandingPage();
    Heroku_shadowDom shadowDom = new Heroku_shadowDom();
    @Test
    public void testsShadowDom() throws InterruptedException {
        internetLandingPage.clickOnShadowDom();
        shadowDom.getTextFromShadowElement();
    }
}
