package utils;

import config.ConfigReader;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AuthManager {
    private static final String USER_AGENT = "Mozilla/5.0";

    public static RequestSpecification getAuthSpec() {

        String authType = ConfigReader.get("auth.type").toLowerCase();
        String xauth_apiToken= ConfigReader.get("auth.xtoken");

        switch (authType) {

            case "x-auth-api":
                System.out.println("inside auth x token option" + xauth_apiToken);
                return given().
                        log().all()
                        .header("Content-Type", "application/json")
                        .header("User-Agent", USER_AGENT)
                        .header("X-API-KEY",xauth_apiToken);

            case "basic":
                return given()
                        .auth().preemptive()
                        .basic(
                                ConfigReader.get("auth.username"),
                                ConfigReader.get("auth.password")
                        )
                        .header("User-Agent", USER_AGENT)
                        .contentType("application/json");

            case "bearer":
                return given()
                        .auth().oauth2(ConfigReader.get("auth.token"))
                        .header("User-Agent", USER_AGENT)
                        .contentType("application/json");

            case "none":
            default:
                return given()
                        .header("User-Agent", USER_AGENT)
                        .contentType("application/json");
        }
    }
}

