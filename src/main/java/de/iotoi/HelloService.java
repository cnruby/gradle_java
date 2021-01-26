package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import java.util.Map;
import java.util.HashMap;

@Service()
public class HelloService {
    @Value("${web.app.name}")
    String webAppName;

    public String getHello() {
        System.out.println(webAppName);
        return webAppName + "!!\n";
    }

    public String getStringHello() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("String", webAppName);
        return jsonObj.toString();
    }    

    public JSONObject getJSONObjectHello()  {
        JSONObject jsonEntity = new JSONObject();
        jsonEntity.put("ResponseEntity", webAppName);
        return jsonEntity;
    }

    public Map<String, String> getMapHello() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Map", webAppName);
        return map;
    }
}
