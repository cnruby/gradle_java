package de.iotoi;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HelloServiceTests {
	@Autowired
	HelloService helloService;

	@Value("${web.app.name}")
	String webAppName;

	@DisplayName("Test Spring @Autowired Integration")
	@Test
	public void testAnnotationGetHello() {
		assertEquals(webAppName, "Hello JUnit 5");
		assertEquals(webAppName + "!!\n", helloService.getHello());
	}
}