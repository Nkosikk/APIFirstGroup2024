package Common;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PayloadBuilder {

    public static JSONObject createUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Nkosi");
        jsonObject.put("job","tester");

        return jsonObject;
    }
    public static JSONObject updateUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Letho");
        jsonObject.put("job","tester");
        jsonObject.put("Address","34 Aberdeen road");

        return jsonObject;
    }

    public static JSONObject patchUserObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Letho");
        jsonObject.put("job","tester");

        return jsonObject;
    }

    public static JSONObject registerSuccessfullyObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("email","eve.holt@reqres.in");
        jsonObject.put("password","pistol");

        return jsonObject;
    }

    public static JSONObject registerUnSuccessfullyObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("email","sydney@fife");

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


    ///***WEATHER STARTS HERE
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

    public static JSONObject registerNewWeatherStationWithMissingFieldObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject registerNewWeatherStationWithMissingExternalIDFieldObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject registerNewWeatherStationWithLongitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude","SAD");
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject registerNewWeatherStationWithLatitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude","HAPPY");
        jsonObject.put("longitude",-122.43);
        jsonObject.put("altitude",150);

        return jsonObject;
    }

    public static JSONObject registerNewWeatherStationWithAltitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.34);
        jsonObject.put("altitude","OKAY");

        return jsonObject;
    }

    public static JSONObject verifyTheResponseIs405Object(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id","MD_Testing01");
        jsonObject.put("latitude",37.76);
        jsonObject.put("longitude",-122.34);
        jsonObject.put("altitude","150");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithInvalidLongitudeValuesObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", 200.50);
        jsonObject.put ("altitude", "150");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithAltitudeAsStringObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", "ABC");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithLatitudeAsStringObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", "TEST");
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", "150");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithMissingFieldNameObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("latitude", "TEST");
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", "150");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithMissingFieldExternalIDObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", "TEST");
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", "150");

        return jsonObject;
    }

    public static JSONObject updateWeatherStationWithLongitudeAsStringObject() {
        JSONObject jsonObject = new JSONObject ();
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", "TEST");
        jsonObject.put ("longitude", "ASAMBE");
        jsonObject.put ("altitude", "150");

        return jsonObject;
    }

}

