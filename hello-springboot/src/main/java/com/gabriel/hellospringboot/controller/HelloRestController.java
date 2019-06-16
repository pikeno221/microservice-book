package com.gabriel.hellospringboot.controller;

import org.springframework.boot.context.properties.*;
import org.springframework.web.bind.annotation.*;

import java.net.*;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix="helloapp")
public class HelloRestController {


    private String saying;

    @GetMapping(value = "/hello")
    public String hello() {
        String hostname = null;

        try {
            hostname = InetAddress.getLocalHost()
                    .getHostAddress();

        } catch (Exception e) {
            hostname = "unknown";
        }

        return saying + " " + hostname;
    }


    public void setSaying(String saying) {
        this.saying = saying;
    }
}