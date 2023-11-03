package api.endpoints;
import api.payload.Book;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class BookEndPoints {

    public static Response createBookUser(Book payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("user", "password")
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);

        return response;
    }
    public static Response createBookAdmin(Book payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password")
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response createBook(int author, String title)
    {
        String requestBody = String.format("{ \"author\": %d, \"title\": \"%s\" }", author, title);

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password")
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response createBook(String author, int title)
    {
        String requestBody = String.format("{ \"author\": %s, \"title\": \"%d\" }", author, title);

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password")
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response updateBook(int id, Book payload)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password")
                .accept(ContentType.JSON)
                .pathParam("id",id)
                .body(payload)
                .when()
                .put(Routes.put_url);

        return response;
    }
}
