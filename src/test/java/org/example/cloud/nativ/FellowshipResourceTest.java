package org.example.cloud.nativ;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class FellowshipResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/welcome")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

}