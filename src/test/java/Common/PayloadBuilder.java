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

}
