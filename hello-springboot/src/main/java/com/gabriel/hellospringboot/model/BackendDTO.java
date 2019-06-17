package com.gabriel.hellospringboot.model;

import java.io.Serializable;

public class BackendDTO implements Serializable {

    private static final long serialVersionUID = -5930904419691645745L;

    private String greeting;
    private long time;
    private String ip;

    public BackendDTO() {
    }

    public BackendDTO(String greeting, long time, String ip) {
        this.greeting = greeting;
        this.time = time;
        this.ip = ip;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
