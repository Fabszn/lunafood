package com.luna.food;

import io.quarkus.test.junit.QuarkusTest;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ArticleResourceTest {

    @Inject
    Flyway flyway;


    final String articleJson = "{\"name\":\"%s\",\"type\":\"%s\"}";

    final String article1 = String.format(articleJson, "Finger", "Biscuit");
    final String article2 = String.format(articleJson, "Oasis", "Boisson");
    final String article3 = String.format(articleJson, "CocaCola", "Boisson");

    @AfterEach
    public void cleanDB(){
        flyway.clean();
        flyway.migrate();
    }

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

        given()
                .when().get("/articles")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"Pepito\",\"type\":\"Biscuit\"}]"));
    }

    @Test
    public void testReadArticleByIdResourcesEndpoint() {
        given()
                .when().contentType(MediaType.APPLICATION_JSON).body("{\"name\":\"Pepito\",\"type\":\"Biscuit\"}").post("/articles")
                .then()
                .statusCode(200);

        given()
                .when().get("/articles")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"Pepito\",\"type\":\"Biscuit\"}]"));
    }

    @Test
    public void testDeleteArticleByIdResourcesEndpoint() {
        //add 3 articles
        given()
                .when().contentType(MediaType.APPLICATION_JSON).body(article1).post("/articles")
                .then()
                .statusCode(200);
        given()
                .when().contentType(MediaType.APPLICATION_JSON).body(article2).post("/articles")
                .then()
                .statusCode(200);
        given()
                .when().contentType(MediaType.APPLICATION_JSON).body(article3).post("/articles")
                .then()
                .statusCode(200);
        given()
                .when().get("/articles/2")
                .then()
                .statusCode(200)
                .body(is("{\"id\":2,\"name\":\"Oasis\",\"type\":\"Boisson\"}"));
        given()
                .when().delete("/articles/2")
                .then()
                .statusCode(200)
                .body(is("1"));
    }


}