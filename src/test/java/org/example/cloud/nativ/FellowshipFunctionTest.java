package org.example.cloud.nativ;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import javax.ws.rs.core.MediaType;

@QuarkusTest
@Disabled
public class FellowshipFunctionTest {

    @Test
    public void testHelloEndpoint() {
        given().when().get("/greet")
                .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(notNullValue());
    }
}
