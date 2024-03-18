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
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", 200.50);
        jsonObject.put ("altitude", "150");

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

    public static JSONObject updateWeatherStationWithAltitudeAsStringObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put ("external_id", "MD_UpdTesting01");
        jsonObject.put ("name", "Midrand Test Updated Station");
        jsonObject.put ("latitude", 37.76);
        jsonObject.put ("longitude", -122.43);
        jsonObject.put ("altitude", "TEST");

        return jsonObject;
    }


}

