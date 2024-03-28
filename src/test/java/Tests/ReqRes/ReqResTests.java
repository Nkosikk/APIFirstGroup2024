package Tests.ReqRes;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Req Res")
@Story("Create new user")
public class ReqResTests {
    @Description("As an api user I want to get List of Users")
    @Severity(SeverityLevel.CRITICAL)
    public void getListUsersTests(){
        getListUsersResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("Michael")).
                body(containsString("Lindsay")).
                body(containsString("Tobias"));
    }

    @Description("As an api user I want to get a single user")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleUserTest(){
        getSingleUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("Janet"));

    }

    @Description("As an api user I want to get the single user that is not found")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleUserNotFoundTest(){
        getSingleUserNotFoundResponse().
                then().
                assertThat().
                statusCode(Not_Found_Status_Code);

    }

    @Description("As an API user I want to display a list of resources")
    @Severity(SeverityLevel.CRITICAL)
    public void getListResourcesTests(){
        getListResourcesResponse ().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("cerulean")).
                body(containsString("fuchsia rose")).
                body(containsString("true red"));
    }


    @Description("As an API user I want to display a single resources")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleResourceTests(){
        getSingleResourceResponse ().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("fuchsia rose"));
    }

    @Description("As an API user I want to display a single resources")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleResourceNotFoundTests(){
        getSingleResourceNotFoundResponse ().
                then().
                assertThat().
                statusCode(Not_Found_Status_Code);
    }

    @Description("As an api user I want to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserTests(){
        createUserResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("name",containsStringIgnoringCase("Nkosi")).
                body("job",containsStringIgnoringCase("Tester")).
                body("id", notNullValue()).
                body("createdAt", notNullValue());
    }

    @Description("As an api user I want to update user's information")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserTests() {
        updateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase("Letho")).
                body("job", containsStringIgnoringCase("Tester")).
                body("Address", containsStringIgnoringCase("34 Aberdeen road")).
                body("updatedAt", notNullValue());
    }

    @Description("As an api user I want to add a missing required field for the user")
    @Severity(SeverityLevel.CRITICAL)
    public void patchUserTests() {
        patchUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase("Letho")).
                body("job", containsStringIgnoringCase("Tester")).
                body("updatedAt", notNullValue());
    }

    public void deleteUserTests() {
        deleteUserResponse().
                then().
                assertThat().
                statusCode(delete_Status_Code);
    }

    public void registerSuccessfullyTests() {
        registerSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("id", notNullValue ()).
                body("token", containsStringIgnoringCase("QpwL5tke4Pnpja7X4"));
    }

    public void registerUnSuccessfullyTests() {
        registerUnSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("error", containsStringIgnoringCase ("Missing password"));
    }

    public void loginSuccessfullyTests() {
        loginSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("token", containsStringIgnoringCase("QpwL5tke4Pnpja7X4"));
    }

    public void loginUnSuccessfullyTests() {
        loginUnSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("error", containsStringIgnoringCase ("Missing password"));
    }

    @Description("As an API user I want to delay the response by 3 seconds")
    @Severity(SeverityLevel.CRITICAL)
    public void getDelayedResponseTests(){
        getDelayedResponse ().
                then().
                assertThat().
                statusCode(Success_Status_Code);
        //body(containsString("George"));
    }
}
