package com.luna.food;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ArticleResourceTest {

    @Test
    public void testGetArticleResourcesEndpoint() {
        given()
          .when().get("/articles")
          .then()
             .statusCode(200)
             .body(is("[]"));
    }

    @Test
    public void testPostArticleResourcesEndpoint() {
        given()
                .when().contentType(MediaType.APPLICATION_JSON).body("{\"name\":\"Pepito\",\"type\":\"Biscuit\"}").post("/articles")
                .then()
                .statusCode(200);
                //.body(is("Pepito"));

        given()
                .when().get("/articles")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"Pepito\",\"type\":\"Biscuit\"}]"));
    }

}