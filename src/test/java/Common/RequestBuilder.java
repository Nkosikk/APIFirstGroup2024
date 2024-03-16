package Common;

import groovy.xml.StreamingDOMBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Common.BasePaths.*;
import static Common.ContentTypes.json_contentType;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static String stationID;
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
    public static Response getDogByBreedsResponse() {
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breed/hound/images").
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
    public static Response getUserlistResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(ReqRes_BaseURL+"/api/users?page=2").
                then().
                log().all().
                extract().response();
    }
    public static Response updateUserResponse(){
        return given().
                when().
                body(updateUserObject()).
                contentType(json_contentType).
                log().all().
                put(ReqRes_BaseURL+"/api/users/689").
                then().
                log().all().
                extract().response();
    }

    public static Response getListResourceResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(ReqRes_BaseURL+"/api/unknown").
                then().
                log().all().
                extract().response();
    }
    public static Response patchUserResponse() {
        return given().
                when().
                body(updateUserObject()).
                contentType(json_contentType).
                log().all().
                patch(ReqRes_BaseURL + "/api/users/689").
                then().
                log().all().
                extract().response();
    }
    public static Response deleteUserResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                delete(ReqRes_BaseURL+"/api/users/689").
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

    public static Response getBreedsListResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(Dogs_BaseURL+"/breed/affenpinscher/images/random").
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

    public static Response registerNewWeatherStationResponse(){
        Response response =  given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerWeatherStationObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
        stationID = response.jsonPath().getString("ID");
        return response;
    }


}
