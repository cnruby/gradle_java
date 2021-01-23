package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service()
public class HelloService {
    @Value("${web.app.name}")
    String webAppName;

    public String getHello() {
        System.out.println(webAppName);
        return webAppName + "!!\n";
    }
}