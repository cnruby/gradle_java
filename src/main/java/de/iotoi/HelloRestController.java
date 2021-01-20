package de.iotoi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @RequestMapping("/api")
    public String helloJava() {
        return "Hello @devtools!\n";
    }
}
