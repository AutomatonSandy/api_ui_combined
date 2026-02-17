package tests.api;

import base.BaseTest;
import clients.RestClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.UserPayload;
import utils.AuthManager;
import utils.Endpoints;

public class UserApiTest extends BaseTest {


    @Test
    public void createUserTest() {
        UserPayload payload = new UserPayload("Joy", "QA Lead");
        Response response = RestClient.post(AuthManager.getAuthSpec(), Endpoints.CREATE_USER, payload);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("name"), "Joy");
    }

    @Test
    public void getUserTest() {
        Response response = RestClient.get(AuthManager.getAuthSpec(), Endpoints.GET_USER, 2);
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertNotNull(response.jsonPath().getString("data.id"));
    }

}
