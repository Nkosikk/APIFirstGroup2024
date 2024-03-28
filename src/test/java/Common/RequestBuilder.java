package Common;

import groovy.xml.StreamingDOMBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Common.BasePaths.*;
import static Common.CommonTestData.delete_Status_Code;
import static Common.ContentTypes.json_contentType;
import static Common.PayloadBuilder.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {
    public static String stationID;
    public static String UserID;

    ///***DOGS START HERE***///
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

    public static Response getByBreedResponse() {
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

    public static Response getListUsersResponse() {
        return given ().
                when ().
                contentType (json_contentType).
                log ().all ().
                get (ReqRes_BaseURL + "/api/users?page=2").
                then ().
                log ().all ().
                extract ().response ();
    }

    public static Response getSingleUserResponse() {
        return given ().
                when ().
                contentType (json_contentType).
                log ().all ().
                get (ReqRes_BaseURL + "/api/users/2").
                then ().
                log ().all ().
                extract ().response ();
    }

    public static Response getSingleUserNotFoundResponse() {
        return given ().
                when ().
                contentType (json_contentType).
                log ().all ().
                get (ReqRes_BaseURL + "/api/users/23").
                then ().
                log ().all ().
                extract ().response ();
    }

    public static Response createUserResponse(){
        Response response = given().
                when().
                body(createUserObject()).
                contentType(json_contentType).
                log().all().
                post(ReqRes_BaseURL+"/api/users").
                then().
                log().all().
                extract().response();
        UserID = response.jsonPath().getString("ID");
        return response;
    }
    public static Response getListResourcesResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(ReqRes_BaseURL+"/api/unknown").
                then().
                log().all().
                extract().response();
    }

    public static Response getSingleResourceResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(ReqRes_BaseURL+"/api/unknown").
                then().
                log().all().
                extract().response();
    }

    public static Response getSingleResourceNotFoundResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get(ReqRes_BaseURL+"/api/unknown/23").
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
                put(ReqRes_BaseURL+"/api/users/" + UserID).
                then().
                log().all().
                extract().response();
    }

    public static Response patchUserResponse(){
        return given().
                when().
                body(patchUserObject()).
                contentType(json_contentType).
                log().all().
                patch (ReqRes_BaseURL+"/api/users/" + UserID).
                then().
                log().all().
                extract().response();
    }

    public static Response deleteUserResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                delete (ReqRes_BaseURL+"/api/users/" + UserID).
                then().
                log().all().
                extract().response();
    }

    public static Response registerSuccessfullyResponse(){
        return given().
                when().
                body(registerSuccessfullyObject()).
                contentType(json_contentType).
                log().all().
                post (ReqRes_BaseURL+"/api/register").
                then().
                log().all().
                extract().response();
    }

    public static Response registerUnSuccessfullyResponse(){
        return given().
                when().
                body(registerUnSuccessfullyObject()).
                contentType(json_contentType).
                log().all().
                post (ReqRes_BaseURL+"/api/register").
                then().
                log().all().
                extract().response();
    }

    public static Response loginSuccessfullyResponse(){
        return given().
                when().
                body(loginSuccessfullyObject()).
                contentType(json_contentType).
                log().all().
                post (ReqRes_BaseURL+"/api/login").
                then().
                log().all().
                extract().response();
    }

    public static Response loginUnSuccessfullyResponse(){
        return given().
                when().
                body(loginUnSuccessfullyObject()).
                contentType(json_contentType).
                log().all().
                post (ReqRes_BaseURL+"/api/login").
                then().
                log().all().
                extract().response();
    }

    public static Response getDelayedResponse(){
        return given().
                when().
                contentType(json_contentType).
                log().all().
                get (ReqRes_BaseURL+"/api/users?delay=3").
                then().
                log().all().
                extract().response();
    }

    //*** WEATHER STARTS HERE***
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

    public static Response getNewWeatherStationInfoResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                contentType(json_contentType).
                log().all().
                get(Weather_BaseURL+"/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();
    }

    public static Response updateWeatherStationInfoResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationInfoObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response deleteWeatherStationResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                contentType(json_contentType).
                log().all().
                delete (Weather_BaseURL+"/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();
    }

    //*** NEGATIVE TESTS START HERE***

    public static Response registerNewWeatherStationWithMissingFieldResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerNewWeatherStationWithMissingFieldObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
    }

    public static Response registerNewWeatherStationWithMissingExternalIDFieldResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerNewWeatherStationWithMissingExternalIDFieldObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
    }

    public static Response registerNewWeatherStationWithLongitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerNewWeatherStationWithLongitudeAsStringObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
    }

    public static Response registerNewWeatherStationWithLatitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerNewWeatherStationWithLatitudeAsStringObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
    }

    public static Response registerNewWeatherStationWithAltitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(registerNewWeatherStationWithAltitudeAsStringObject()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations").
                then().
                log().all().
                extract().response();
    }

    public static Response verifyTheResponseIs405Response(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                body(verifyTheResponseIs405Object()).
                contentType(json_contentType).
                log().all().
                post(Weather_BaseURL+"/data/3.0/stations/" + stationID).
                then().
                log().all().
                extract().response();
    }

    public static Response updateWeatherStationWithInvalidLongitudeValuesResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithInvalidLongitudeValuesObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response getNewWeatherStationWithNonExistingStationIDResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                contentType(json_contentType).
                log().all().
                get(Weather_BaseURL+"/data/3.0/stations/123567890").
                then().
                log().all().
                extract().response();
    }

    public static Response getNewWeatherStationWithInvalidStationIDFormatResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                contentType(json_contentType).
                log().all().
                get(Weather_BaseURL+"/data/3.0/stations/S7987NHJG767").
                then().
                log().all().
                extract().response();
    }

    public static Response updateWeatherStationWithAltitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithAltitudeAsStringObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response updateWeatherStationWithLatitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithLatitudeAsStringObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response updateWeatherStationWithMissingFieldNameResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithMissingFieldNameObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response updateWeatherStationWithMissingFieldExternalIDResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithMissingFieldExternalIDObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response updateWeatherStationWithLongitudeAsStringResponse(){
        return given().
                queryParam("appid","8dc92b60f521a3fb9e771348c8016c32").
                when ().
                body(updateWeatherStationWithLongitudeAsStringObject ()).
                contentType (json_contentType).
                log ().all ().
                put (Weather_BaseURL + "/data/3.0/stations/" + stationID).
                then().
                log().all ().
                extract ().response ();
    }

    public static Response deleteWeatherStationWithNonExistingStationIDResponse(){
        return given().
                queryParam ("appid","8dc92b60f521a3fb9e771348c8016c32").
                when().
                contentType(json_contentType).
                log().all().
                delete (Weather_BaseURL+"/data/3.0/stations/98765432100").
                then().
                log().all().
                extract().response();
    }
}
