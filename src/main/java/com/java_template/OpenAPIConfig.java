package com.java_template;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {

    @Value("${template.openapi.dev-url}")
    private String devUrl;

    @Value("${template.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Production environment");

        Contact contact = new Contact();
        contact.setEmail("java_swagger@example.com");
        contact.setName("java_swagger");
        contact.setUrl("https://blank_url.com.br/");

        License mitLicense = new License().name("MIT License").url("https://blank_url.com/licenses/mit/");

        Info info = new Info()
                .title("Java Swagger template")
                .version("1.0")
                .contact(contact)
                .description("Template to use as base for create X application with java.").termsOfService("https://www.blank_url.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}