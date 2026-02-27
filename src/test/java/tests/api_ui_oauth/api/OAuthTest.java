package tests.api_ui_oauth.api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import tests.api_ui_oauth.ui.pom.LoginPage;

public class OAuthTest {

    @Test
    public void useOAuthToken(){
        String token = new LoginPage().getToken();
        System.out.println(token);
        Response response = RestAssured.given().auth().oauth2(token).contentType("application/json").get("url");
    }
}
