package de.iotoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    String webAppName;

//    @Autowired
    private HelloService helloService;
    HelloRestController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/api/value")
    public String helloJavaValue() {
        return webAppName + "!\n";
    }

    @RequestMapping("/api/service")
    public String helloJavaService() {
        return helloService.getHello();
    }

    @RequestMapping("/api/str")
    public String  helloString() {
        return helloService.getStringHello();
    }

    @RequestMapping(path="/api/resp", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> helloResponseEntity() {
        JSONObject jsonResp  = helloService.getJSONObjectHello();
        return new ResponseEntity<String>(jsonResp.toString(), HttpStatus.OK);
    }    

    @RequestMapping("/api/map")
    public ResponseEntity<String> helloMap() {
        JSONObject jsonMap = new JSONObject();

        Map<String, String> map = helloService.getMapHello();
        map.entrySet().stream().forEach (
            m -> { jsonMap.put( m.getKey(), m.getValue());
        });

        return new ResponseEntity<String>(jsonMap.toString(), HttpStatus.OK);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = {"/api/cmd", "/"}
    )
    public String helloCommand(
        @RequestBody
        String strJSON
    ) {
        JSONObject jsonObj = new JSONObject(strJSON);
        String value = jsonObj.getString("cmd") + ": we have received this value";
        jsonObj.put("cmd", value);
        return jsonObj.toString();
    }
}
