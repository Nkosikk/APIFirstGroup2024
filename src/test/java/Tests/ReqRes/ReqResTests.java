package Tests.ReqRes;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Create_Success_Status_Code;
import static Common.CommonTestData.Success_Status_Code;
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
                body("name",containsStringIgnoringCase("Nkosi")).
                body("job",containsStringIgnoringCase("Tester")).
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
}
