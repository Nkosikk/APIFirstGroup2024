package Common;

import groovy.xml.StreamingDOMBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.BasePaths.Dogs_BaseURL;
import static Common.BasePaths.ReqRes_BaseURL;
import static Common.ContentTypes.json_contentType;
import static Common.PayloadBuilder.createUserObject;
import static io.restassured.RestAssured.given;

public class RequestBuilder {

    public static Response getListOfAllBreedsResponse() {
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breeds/list/all").
                then().
                log().all().
                extract().response();
    }

    public static Response getDisplaySingleRandomImageFromAllDogsCollectionResponse() {
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breeds/image/random").
                then().
                log().all().
                extract().response();
    }

    public static Response getDogsByBreedResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breed/hound/images").
                then().
                log().all().
                extract().response();
    }

    public static Response getListofAllSubBreedResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breed/hound/list").
                then().
                log().all().
                extract().response();
    }

    //*** REQRES STARTS HERE***
    public static Response createUserResponse(){
        return given().
                when().
                body(createUserObject()).
                contentType(json_contentType).
                log().all().
                post(ReqRes_BaseURL+"/api/users").
                then().
                log().all().
                extract().response();
    }




}
