package com.gabriel.com;

import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.util.toolbox.AggregationStrategies;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
@ConfigurationProperties(prefix="gateway")
public class MySpringBootRouter extends RouteBuilder {

    private String springbootsvcurl;

    private String microprofilesvcurl;

    private static final String REST_ENDPOINT=
            "http4:%s/api/greeting?httpClient.connectTimeout=1000&bridgeEndpoint=true&copyHeaders=true&connectionClose=true";

    @Override
    public void configure() throws IOException {
        restConfiguration()
                .enableCORS(true)
                .bindingMode(RestBindingMode.json);

        from("direct:microprofile").streamCaching()
                .to(String.format(REST_ENDPOINT, microprofilesvcurl))
                .log("Response from Microprofile microservice: ${body}")
                .convertBodyTo(String.class)
                .end();

        from("direct:springboot").streamCaching()
                .to(String.format(REST_ENDPOINT, springbootsvcurl))
                .log("Response from Spring Boot microservice: ${body}")
                .convertBodyTo(String.class)
                .end();

        rest()
                .get("/gateway")
                .consumes("application/json").produces("application/json")
                .route()
                .multicast(AggregationStrategies.flexible().accumulateInCollection(ArrayList.class))
                .parallelProcessing()
                .to("direct:microprofile")
                .to("direct:springboot")
                .end()
                .marshal().json(JsonLibrary.Jackson)
                .convertBodyTo(String.class)
                .endRest();
    }

    public void setMicroprofilesvcurl(String microprofilesvcurl) {
        this.microprofilesvcurl = microprofilesvcurl;
    }

    public void setSpringbootsvcurl(String springbootsvcurl) {
        this.springbootsvcurl = springbootsvcurl;
    }
}
