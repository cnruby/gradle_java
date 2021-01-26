package de.iotoi.impl;

import de.iotoi.HelloPropertyValues;
import de.iotoi.PropertyValues;
import org.springframework.beans.factory.annotation.Value;

public class HelloService implements HelloServiceable {
    @Value(HelloPropertyValues.WEB_APP_NAME)
    private String webAppName;

    @Override
    public String getHello() {
      return webAppName + "!\n";
    }
}