package clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class RestClient {

    public static Response post(RequestSpecification spec, String endpoint, Object body) {
        return spec.body(body).when().post(endpoint);

    }

    public static Response get(RequestSpecification spec, String endpoint, int id) {
        return spec.given()
                .log().all()
                .pathParam("id", id)
                .when()
                .get(endpoint);
    }
}