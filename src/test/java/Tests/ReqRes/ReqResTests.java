package Tests.ReqRes;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Create_Success_Status_Code;
import static Common.CommonTestData.Success_Status_Code;
import static Common.RequestBuilder.createUserResponse;
import static Common.RequestBuilder.getListOfAllBreedsResponse;
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
}
