package com.hendisantika.springbootdddbank.rest;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-ddd-bank
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 05/03/20
 * Time: 06.46
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private WebSecurityConfig webSecurityConfig;

    public SwaggerConfig(final WebSecurityConfig webSecurityConfig) {
        this.webSecurityConfig = webSecurityConfig;
    }

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.or(
                        PathSelectors.regex("/bank.*"),
                        PathSelectors.regex("/client.*")
                ))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Arrays.asList(new BasicAuth("basicAuth")));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring DDD Bank REST Webservice",
                "<p>A sample project following Domain Driven Design with Spring Data JPA</p>" +
                        "<p>Usernames are predefined. The banker's username is <b>bank</b></p>" +
                        "<p>Client usernames are <b>" + _clientUsernames() + "</b></p>" +
                        "<p>Each user's password is equal to the username. </p>" +
                        "<p>URIs under <b>/bank/</b> are for bankers, under <b>/client/</b> are for clients.</p>" +
                        "<p>Keep in mind to login via the <b>Authorize</b> button before calling API methods.</p>" +
                        "<p>Click on <b>application-controller</b> in order to see the API methods.</p>" +
                        "",
                null,
                null,
                new Contact(
                        "Christoph Knabe", "http://public.beuth-hochschule.de/~knabe/", null
                ),
                null,
                null,
                Collections.emptyList()
        );
    }
}
