package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;

public class DemoRestCRUD {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;
    private static int createdPostId;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Custom-Header", "RestAssuredDemo")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }

    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }

    @Test
    @Order(1)
    @DisplayName("CREATE - POST new post")
    public void create_post_returnsCreatedResource() {
        String requestBody = """
                {
                    "title": "Test Post from REST Assured",
                    "body": "This post was created during our demo",
                    "userId": 1
                }
                """;

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", Matchers.equalTo("Test Post from REST Assured"))
                .body("body", Matchers.containsString("demo"))
                .body("userId", Matchers.equalTo(1))
                .body("id", Matchers.notNullValue())
                .extract()
                .response();

        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    @Test
    @Order(2)
    @DisplayName("CREATE - Post with Java Object")
    public void testSerialObject() {
        // Simple inner class for demo (normally in separate file)
        record Post(String title, String body, int userId) {} // Feature introduced in JDK 14 and finalized in JDK 16
        Post requestBody = new Post("POJO Test", "Testing a POJO Object", 1);

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", Matchers.equalTo("POJO Test"))
                .body("body", Matchers.containsString("POJO Object"))
                .body("userId", Matchers.equalTo(1))
                .body("id", Matchers.notNullValue())
                .extract()
                .response();

        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    /*
     * DONE: Write a new case to test the get method for an individual post,
     *  using a number from a value source (parameterized test)
     */
    @ParameterizedTest(name = "GET /posts/{0} returns 200")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Order(3)
    @DisplayName("READ - Get Multiple Posts by ID")
    public void read_postParameterized_returns200(int postId) {
        given()
                .spec(requestSpec)
        .when()
                .get("/posts/" + postId)
        .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(postId));
    }

    @ParameterizedTest(name = "User {0} has name {1}")
    @CsvFileSource(resources = "/testGetData.csv", numLinesToSkip = 1)
    @Order(4)
    @DisplayName("READ - Get Multiple Users by ID from CSV File")
    public void read_userParameterizedFromCSV_returns200(int userId, String expectedName) {
        given()
                .spec(requestSpec)
        .when()
                .get("/users/" + userId)
        .then()
                .statusCode(200)
                .body("name", Matchers.equalTo(expectedName));
    }

    @Test
    @Order(5)
    @DisplayName("READ - Get Post by ID")
    public void read_post_returnsResource() {
        given()
                .spec(requestSpec)
        .when()
                .get("/posts/1")
        .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test
    @DisplayName("Extract and assert with JUnit")
    public void extractAndAssert_withJUnit() {
        Response response = given()
            .when()
                .get("/users")
            .then()
                .extract()
                .response();

        // JUnit assertions
        int statusCode = response.statusCode();
        Assertions.assertEquals(200, statusCode, "Status should be 200");

        int userCount = response.jsonPath().getList("$").size();
        Assertions.assertEquals(10, userCount, "Should have 10 users");

        String firstUserName = response.jsonPath().getString("[0].name");
        Assertions.assertNotNull(firstUserName, "First user should have a name");
        Assertions.assertFalse(firstUserName.isEmpty(), "Name should not be empty");
    }

    @Test
    @Order(6)
    @DisplayName("UPDATE - Put new info into post")
    public void update_post_returnsUpdatedResource() {
        // TODO: Implement
    }

    @Test
    @Order(7)
    @DisplayName("DELETE - Delete post")
    public void delete_post_returnsEmptyObject() {
        // TODO: Implement
    }

    @Test
    @Order(13)
    @DisplayName("Complete CRUD flow in single test")
    public void completeCrudFlow_createReadUpdateDelete() {

        // CREATE
        String createBody = """
            {
                "title": "CRUD Test Post",
                "body": "Testing complete CRUD flow",
                "userId": 1
            }
            """;

        int newId = given()
                .spec(requestSpec)
                .body(createBody)
            .when()
                .post("/posts")
            .then()
                .statusCode(201)
                .body("title", Matchers.equalTo("CRUD Test Post"))
                .extract()
                .path("id");

        System.out.println("Created ID: " + newId);

        // READ
        given()
                .spec(requestSpec)
        .when()
                .get("/posts/" + newId)
        .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(newId));

        // UPDATE
        String updateBody = """
            {
                "id": %d,
                "title": "Updated CRUD Test",
                "body": "Body was updated",
                "userId": 1
            }
            """.formatted(newId);

        given()
                .spec(requestSpec)
                .body(updateBody)
        .when()
                .put("/posts/" + newId)
        .then()
                .statusCode(200)
                .body("title", Matchers.equalTo("Updated CRUD Test"));

        // DELETE
        given()
                .spec(requestSpec)
        .when()
                .delete("/posts/" + newId)
        .then()
                .statusCode(200);

        System.out.println("CRUD flow completed successfully!");
    }
}
