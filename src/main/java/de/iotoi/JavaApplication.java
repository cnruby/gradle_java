package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {
    @Value("${web.app.name}")
    String webAppName;

    @Bean
    public CommandLineRunner init(
            @Value("${web.app.name}")
                    String appName
    ) {
        return args -> {
            System.out.println(appName + " from init()!");
            System.out.println(webAppName + " from init()!!");
        };
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(JavaApplication.class, args);

        HelloService helloService = (HelloService) ctx.getBean("helloService");
        System.out.println(helloService.getHello());

        HelloComponent helloComponent = (HelloComponent) ctx.getBean("helloComponent");
        System.out.println(helloComponent.getHello());
    }
}
