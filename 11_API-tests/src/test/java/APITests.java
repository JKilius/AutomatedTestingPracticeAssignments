
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class APITests {

    @Test
    public void receiveAllTest(){

        given().
                when().
                get("https://gorest.co.in/public/v2/users").
                then().
                log().body().
                assertThat().statusCode(200);

    }

    @Test
    public void receiveOneSpecificUser(){
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users/6180429")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("id", equalTo(6180429))
                .body("gender", equalTo("male"))
                .body("status", equalTo("inactive"));
    }

    @Test
    public void receiveUserListFromPage5(){
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users?page=5&per_page=20")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("users",hasSize(20));
    }

    @Test
    public void test_APIWithOAuthentication_ShouldBeGivenAccess(){
        given()
                .auth().oauth2("71056034e9e4accaf9bb85d1046c20890ddc115e608d57c48c253dbe989e3b08")
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void test_CreateUserWithRequiredAttributesAndExtractUserId(){

        String user = """
                {
                        "name": "Pukis Baisus",
                        "email": "kukutis@beier.test",
                        "gender": "male",
                        "status": "active"
                    }
                """;

        given().headers("Authorization", "Bearer " + "71056034e9e4accaf9bb85d1046c20890ddc115e608d57c48c253dbe989e3b08")
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log().body()
                .assertThat().statusCode(201);
    }


    @Test
    public void test_UserIsRetrievableAndUserNameMatches(){

        Integer id = when().get("https://gorest.co.in/public/v2/users/6140289").then().log().body().extract().path("id");

        given().headers("Authorization", "Bearer " + "71056034e9e4accaf9bb85d1046c20890ddc115e608d57c48c253dbe989e3b08")
                .contentType(ContentType.JSON)
                .when()
                .get("https://gorest.co.in/public/v2/users/{id}")
                .then()
                .log().body()
                .assertThat().statusCode(200)
                .body("name", equalTo("Mike Pukotukas"));

        System.out.println(id);
    }
}
