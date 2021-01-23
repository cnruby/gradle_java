package de.iotoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    String webAppName;

//    @Autowired
    private HelloService helloService;
    private HelloComponent helloComponent;
    HelloRestController(HelloService helloService, HelloComponent helloComponent) {
        this.helloService = helloService;
        this.helloComponent = helloComponent;
    }

    @RequestMapping("/api/value")
    public String helloJavaValue() {
        return webAppName + "!\n";
    }

    @RequestMapping("/api/service")
    public String helloJavaService() {
        return helloService.getHello();
    }

    @RequestMapping("/api/component")
    public String helloJavaComponent() {
        return helloComponent.getHello();
    }
}
