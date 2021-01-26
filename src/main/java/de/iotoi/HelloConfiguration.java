package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import de.iotoi.impl.HelloService;
import org.springframework.context.annotation.Bean;

@Configuration
@PropertySource("classpath:/hello.properties")
public class HelloConfiguration {

    @Bean()
    public HelloService getHelloServiceObject() {
        return new HelloService();
    }
}