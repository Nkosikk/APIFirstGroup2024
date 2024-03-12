package Tests.Dogs;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Success_Status_Code;
import static Common.RequestBuilder.getListOfAllBreeds;
import static org.hamcrest.Matchers.containsString;

@Test
@Feature("Dogs API")
@Story("Get list of all breeds")
public class DogsAPiTests {

    @Description("As an api user i want to get the list of all breeds")
    @Severity(SeverityLevel.CRITICAL)
    public void getListOfAllBreedsTests(){
        getListOfAllBreeds().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("borzoi")).
                body(containsString("mountain")).
                body(containsString("wolfhound"));
    }

}
