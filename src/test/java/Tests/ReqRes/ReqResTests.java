package Tests.ReqRes;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.PayloadBuilder.generateTestData;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Req Res")
@Story("Create new user")
public class ReqResTests {

    @Description("As an api user i want to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserTests(){
        createUserResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("name",containsStringIgnoringCase(generateTestData.FirstName)).
                body("job",containsStringIgnoringCase(generateTestData.JobTitle)).
                body("id", notNullValue()).
                body("createdAt", notNullValue());
    }

@Description("As an api user i want to get List of Users ")
@Severity(SeverityLevel.CRITICAL)
    public void getListUsersTest(){
        getListUsersResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("page",is(2)).
                body("per_page",is(6)).
                body("total", is(12)).
                body("total_pages", is(2)).
                body("data", hasSize(6)).
                body("support", notNullValue());
    }

    public void getSingleUserTest(){
        getSingleUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("support", notNullValue());
    }
    public void updateUserTests() {
        updateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase(generateTestData.FirstName)).
                body("surname", containsStringIgnoringCase(generateTestData.LastName)).
                body("job", containsStringIgnoringCase(generateTestData.JobTitle)).
                body("updatedAt", notNullValue());
    }

    @Description("As an api user i want to update User")
    @Severity(SeverityLevel.CRITICAL)
    public void patchUpdateUserTests() {
        patchUpdateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase(generateTestData.FirstName)).
                body("job", containsStringIgnoringCase(generateTestData.JobTitle)).
                body("updatedAt", notNullValue());
    }

    @Description("This is to display a list of resources")
    @Severity(SeverityLevel.CRITICAL)
    public void getListResourceTests(){
        getListResourceResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("page",is(1)).
                body("per_page",is(6)).
                body("total", is(12)).
                body("total_pages", is(2)).
                body("data", hasSize(6)).
                body("support", notNullValue());
    }

    @Description("This is to log in successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfullyTests() {
        loginSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("token", containsStringIgnoringCase("QpwL5tke4Pnpja7X4"));
    }
    @Description("This is to log in unsuccessfully")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUnSuccessfullyTests() {
        loginUnSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("error", containsStringIgnoringCase ("Missing password"));
    }

    @Description("As an api user i want to get 'Not Found' error for single user ")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleUserNotFoundTest(){
        getSingleUserNotFoundResponse().
                then().
                assertThat().
                statusCode(Not_Found_Status_Code);
    }
    @Description("As an api user i want to get 'Resource Not Found' error ")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleResourceNotFoundTest(){
        getSingleResourceNotFoundResponse().
                then().
                assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Description("This is to display a single resource")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleResource() {
        getSingleResourceResponse().
                then().
                assertThat().

                statusCode(Success_Status_Code).
                body("data", notNullValue()).
                body("support", notNullValue());
    }
}
