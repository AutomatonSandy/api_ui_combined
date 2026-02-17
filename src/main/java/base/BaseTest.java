package base;

import config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.AuthManager;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = ConfigReader.get("base.url");

    }
}