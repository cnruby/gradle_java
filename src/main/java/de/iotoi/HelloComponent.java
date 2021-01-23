package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class HelloComponent {
    @Value("${web.app.name}")
    String webAppName;

    public String getHello() {
        return webAppName + " from class HelloComponent!\n";
    }
}