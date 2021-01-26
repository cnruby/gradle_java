package de.iotoi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
  info = @Info(
    title = "Java Spring Boot REST API",
    version = "v1.0.0",
    description = "This app provides REST APIs for get and post information",
    contact = @Contact(name = "Gudao LUO", email = "gudao.luo@gmail.de", url = "http://iotoi.de")
  )
)
public class OpenApiConfig {}
