package Common;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.BasePaths.Dogs_BaseURL;
import static Common.ContentTypes.json_contentType;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static Response getListOfAllBreeds() {
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breeds/list/all").
                then().
                log().all().
                extract().response();
    }

}
