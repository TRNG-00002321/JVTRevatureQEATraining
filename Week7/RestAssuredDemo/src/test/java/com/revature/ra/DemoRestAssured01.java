package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoRestAssured01 {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }

    @Test
    public void firstRequestDemo() {
        given()
                .log().all()
        .when()
                .get("/posts/1")
        .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void testWithMoreDetails() {
        given()
                .log().parameters()
                .queryParam("userId", 1)
        .when()
                .get("/posts") // posts?userId=1
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));
    }

    @Test
    public void testUser1() {
        given()
                .log().parameters()
        .when()
                .get("/users/1")
        .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Leanne Graham"))
                .body("email", matchesPattern("^[A-Za-z0-9._%+-]+@april\\.biz$"))
                .body("address.city", equalTo("Gwenborough"))
                .body("address.geo.lat", equalTo("-37.3159"));
    }
}
