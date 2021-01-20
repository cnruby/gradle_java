package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    String webAppName;

    @RequestMapping("/api")
    public String helloJava() {
        return webAppName + "!!!\n";
    }
}
