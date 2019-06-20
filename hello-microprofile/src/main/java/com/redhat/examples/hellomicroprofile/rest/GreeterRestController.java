package com.redhat.examples.hellomicroprofile.rest;

import io.opentracing.*;
import io.opentracing.Scope;
import io.opentracing.contrib.jaxrs2.client.*;
import io.opentracing.contrib.tracerresolver.*;
import io.opentracing.propagation.*;
import org.eclipse.microprofile.config.inject.*;
import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.opentracing.*;

import javax.inject.*;
import javax.ws.rs.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;
import java.net.*;
import java.util.*;
@Path("/api")
public class GreeterRestController {

    @Inject
    @ConfigProperty(name="greeting.saying", defaultValue = "Hello")
    private String saying;

    @Inject
    @ConfigProperty(name = "greeting.backendServiceHost",  defaultValue = "localhost")
    private String backendServiceHost;

    @Inject
    @ConfigProperty(name = "greeting.backendServicePort", defaultValue = "8080")
    private int backendServicePort;

    @GET
    @Produces("text/plain")
    @Path("greeting")
    public String greeting() throws MalformedURLException {
        String backendServiceUrl = String.format("http://%s:%d",
                backendServiceHost,backendServicePort);

        System.out.println("Sending to: " + backendServiceUrl);

        Client client = ClientBuilder.newClient();
        BackendDTO backendDTO = client.target(backendServiceUrl)
                .path("api")
                .path("backend")
                .queryParam("greeting", saying)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(BackendDTO.class);

        return backendDTO.getGreeting()
                + " at host: " + backendDTO.getIp();
    }

}
