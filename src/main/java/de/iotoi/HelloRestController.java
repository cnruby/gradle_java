package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.iotoi.impl.HelloServiceable;
import de.iotoi.impl.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RestController
public class HelloRestController {
    @Value(PropertyValues.WEB_APP_NAME)
    String webAppName;

    @RequestMapping(HelloPropertyValues.HELLO_API)
    public String helloJava() {
        return webAppName + "!!!\n";
    }

    @RequestMapping("/")
    public String helloServiceKotlin() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        HelloService objHelloService = (HelloService) context.getBean(HelloServiceable.class);

        return objHelloService.getHello();
    }
}
