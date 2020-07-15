package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.common.test.adapter.rest.RestAssuredSystemTestFixture;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

/**
 * System test that verifies that the REST endpoint works as expected.
 * <p>
 * Assumes that a remote server hosting the REST endpoint is up and running.
 * </p>
 */
public class HelloEndpointSystemTest {

    private static final RestAssuredSystemTestFixture fixture = new RestAssuredSystemTestFixture();

    @BeforeAll
    public static void onBeforeClass() {
        fixture.onBefore();
    }

    @AfterAll
    public static void onAfterClass() {
        fixture.onAfter();
    }

    @Test
    public void testGetWelcomeMessage() {
        given().get("api/v1/hello")
                .then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("text", response -> startsWith("Welcome to Cloud Native Java with "));
    }
}
