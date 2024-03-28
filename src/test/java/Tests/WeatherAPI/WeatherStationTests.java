package Tests.WeatherAPI;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;


@Test
@Feature("OpenWeatherMap")
@Story("Register new Weather Station")
public class WeatherStationTests {
    @Description("As an api user i want to Register a new Weather Station")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationTests() {
        registerNewWeatherStationResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("ID", notNullValue()).
                body("updated_at", notNullValue()).
                body("created_at", notNullValue()).
                body("external_id", containsStringIgnoringCase("MD_Testing01")).
                body("name", containsStringIgnoringCase("Midrand Test Station")).
                body("latitude", notNullValue()).
                body("longitude", notNullValue()).
                body("altitude", notNullValue()).
                body("rank", notNullValue()).
                body("source_type", notNullValue());
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("This is to get information of the newly created Weather Station")
    @Severity(SeverityLevel.CRITICAL)
    public void getNewWeatherStationInfoTests(){
        getNewWeatherStationInfoResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("id",notNullValue()).
                body("created_at",notNullValue()).
                body("updated_at", notNullValue()).
                body("external_id",notNullValue()).
                body("name", notNullValue()).
                body("longitude", notNullValue()).
                body("latitude", notNullValue()).
                body("altitude", notNullValue()).
                body("rank", notNullValue());
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update the newly created weather station")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationInfoTests() {
        updateWeatherStationInfoResponse().
                then ().
                assertThat ().
                statusCode (Success_Status_Code).
                body ("created_at", notNullValue ()).
                body ("updated_at", notNullValue ()).
                body ("external_id", containsStringIgnoringCase ("MD_UpdTesting01")).
                body ("name", containsStringIgnoringCase ("Midrand Test Updated Station")).
                body ("latitude", notNullValue ()).
                body ("longitude", notNullValue ()).
                body ("altitude", notNullValue ()).
                body ("rank", notNullValue ());
    }

    @Test(dependsOnMethods = "updateWeatherStationInfoTests")
    @Description("As an api user I want to delete the newly created weather station")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteWeatherStationTests() {
        deleteWeatherStationResponse().
                then().
                assertThat().
                statusCode(delete_Status_Code);
    }

    //*** NEGATIVE TEST HERE***

    @Description("As an api user I want to Register a new Weather Station with a Missing Name Field")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationWithMissingFieldTests() {
        registerNewWeatherStationWithMissingFieldResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("code", notNullValue ()).
                body("message", containsStringIgnoringCase("Bad or zero length station name"));
    }

    @Description("As an api user I want to Register a new Weather Station with a Missing External ID Field")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationWithMissingExternalIDFieldTests() {
        registerNewWeatherStationWithMissingExternalIDFieldResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("code", notNullValue ()).
                body("message", containsStringIgnoringCase("Bad external id"));
    }

    @Description("As an api user I want to Register a new Weather Station with longitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationWithLongitudeAsStringTests() {
        registerNewWeatherStationWithLongitudeAsStringResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("code", notNullValue ());
        //body("message", containsStringIgnoringCase("unmarshal type error: expected=float64, got=string, offset=105"));
    }

    @Description("As an api user I want to Register a new Weather Station with latitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationWithLatitudeAsStringTests() {
        registerNewWeatherStationWithLatitudeAsStringResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("code", notNullValue ());
        //body("message", containsStringIgnoringCase("unmarshal type error: expected=float64, got=string, offset=105"));
    }

    @Description("As an api user I want to Register a new Weather Station with altitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationWithAltitudeAsStringTests() {
        registerNewWeatherStationWithAltitudeAsStringResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("code", notNullValue ());
        //body("message", containsStringIgnoringCase("unmarshal type error: expected=float64, got=string, offset=105"));
    }

    @Description("As an api user I want to verify that the response is 405")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyTheResponseIs405Tests() {
        verifyTheResponseIs405Response().
                then().
                assertThat().
                statusCode(Method_Not_Allowed_Status_Code).
                body("code", notNullValue ());
        //body("message", containsStringIgnoringCase("unmarshal type error: expected=float64, got=string, offset=105"));
    }

    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithInvalidLongitudeValuesTests() {
        updateWeatherStationWithInvalidLongitudeValuesResponse ().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
        //body("code", notNullValue ()).
        //body("message", containsStringIgnoringCase("Station id not valid"));
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void getNewWeatherStationWithNonExistingStationIDTests() {
        getNewWeatherStationWithNonExistingStationIDResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void getNewWeatherStationWithInvalidStationIDFormatTests() {
        getNewWeatherStationWithInvalidStationIDFormatResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update Weather Station Information With Altitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithAltitudeAsStringTests() {
        updateWeatherStationWithAltitudeAsStringResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update Weather Station Information With Latitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithLatitudeAsStringTests() {
        updateWeatherStationWithLatitudeAsStringResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update Weather Station Information With Missing Field - External ID")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithMissingFieldExternalIDTests() {
        updateWeatherStationWithMissingFieldExternalIDResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update Weather Station Information With Longitude As String")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithLongitudeAsStringTests() {
        updateWeatherStationWithLongitudeAsStringResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to delete the Weather Station With Non-Existing Station ID")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteWeatherStationWithNonExistingStationIDTests() {
        deleteWeatherStationWithNonExistingStationIDResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code);
    }
}

