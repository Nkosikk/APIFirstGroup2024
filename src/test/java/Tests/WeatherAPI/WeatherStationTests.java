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
}

