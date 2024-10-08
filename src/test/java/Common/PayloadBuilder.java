package Common;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PayloadBuilder {

    public static GenerateTestData generateTestData = new GenerateTestData();

    public static JSONObject createUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",generateTestData.FirstName);
        jsonObject.put("job",generateTestData.JobTitle);

        return jsonObject;
    }
    public static JSONObject updateUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", generateTestData.FirstName);
        jsonObject.put("surname", generateTestData.LastName);
        jsonObject.put("job", generateTestData.JobTitle);
        jsonObject.put("Address",generateTestData.PostalAddress);

        return jsonObject;
}

    public static JSONObject patchUpdateUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", generateTestData.FirstName);
        jsonObject.put("job", generateTestData.JobTitle);

        return jsonObject;
    }

    public static JSONObject loginSuccessfullyObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("email","eve.holt@reqres.in");
        jsonObject.put("password","cityslicka");

        return jsonObject;
    }

    public static JSONObject loginUnSuccessfullyObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("email","sydney@fife");

        return jsonObject;
    }

    public static JSONObject registerWeatherStationObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("name","Midrand Test Station");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject updateWeatherStationInfoObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", 150);

        return jsonObject;
    }

    //*** NEGATIVE TEST HERE*** ToBeUpdated :(
    public static JSONObject updateWeatherStationWithInvalidLongitudeValuesObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("longitude", 200.50);

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithMissingFieldObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", 150);

        return jsonObject;
    }

    public static JSONObject registerNewWeatherStationWithLongitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude","dbl-to-string");
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject postWeatherStationWithNameEmptyObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put ("name","");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }
    public static JSONObject updateWeatherStationWithLongitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", "SAD");
        jsonObject.put ("altitude", 150);

        return jsonObject;
    }

    public static JSONObject registerWeatherStationWithoutExtenalIDObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","");
        jsonObject.put("name","Midrand Test Station");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject UpdateWeatherStationWithExternalIDempty() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", 150);

        return jsonObject;
    }
}

